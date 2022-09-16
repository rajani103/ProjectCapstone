package com.stackroute.service;

import com.stackroute.exception.InterviewSlotAlreadyExistException;
import com.stackroute.exception.ResourceNotFoundException;
import com.stackroute.model.InterviewSlot;
import com.stackroute.model.SlotStatus;
import com.stackroute.repository.InterviewerSlotsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterviewSlotServiceImpl implements InterviewSlotService{

    @Autowired
    private InterviewerSlotsRepository interviewerSlotsRepository;

    @Override
    public InterviewSlot creatingNewAvailableSlot(InterviewSlot interviewSlot) {
        InterviewSlot objDb = this.interviewerSlotsRepository.findBySlotId(interviewSlot.getSlotId());
        if (objDb!=null){
            throw new InterviewSlotAlreadyExistException("Record already exists with id : " + interviewSlot.getSlotId());
        }
        else {
            return interviewerSlotsRepository.save(interviewSlot);
        }
    }

    @Override
    public InterviewSlot updateAvailableSlot(InterviewSlot interviewSlot) {
        Optional<InterviewSlot> interviewerData = interviewerSlotsRepository.findById(interviewSlot.getSlotId());
        if (interviewerData.isPresent()) {
            InterviewSlot slotUpdate=interviewerData.get();
            slotUpdate.setSlotId(interviewSlot.getSlotId());
            slotUpdate.setInterviewerName(interviewSlot.getInterviewerName());
            slotUpdate.setTechTrack(interviewSlot.getTechTrack());
            slotUpdate.setDate(interviewSlot.getDate());
            slotUpdate.setInterviewerEmail(interviewSlot.getInterviewerEmail());
            slotUpdate.setSlotStatus(interviewSlot.getSlotStatus());
            slotUpdate.setSlots(interviewSlot.getSlots());
            interviewerSlotsRepository.save(slotUpdate);
            return slotUpdate;
        }
        else{
            throw new RuntimeException("Data not available to update InterviewSlot of this slotId: "+interviewSlot.getSlotId());
        }
    }

    @Override
    public List<InterviewSlot> getSlotByEmailId(String interviewerEmail) {
        return interviewerSlotsRepository.findByInterviewerEmailAndSlotStatus(interviewerEmail,SlotStatus.AVAILABLE);
    }

    @Override
    public List<InterviewSlot> getSlotByDate(String date) {
        return interviewerSlotsRepository.findSlotByDate(date);
    }

    @Override
    public InterviewSlot editSlotStatus(String slotId, String slotStatus) {
        Optional<InterviewSlot> interviewSlotData = interviewerSlotsRepository.findById(slotId);
        if(interviewSlotData.isPresent()){
            InterviewSlot updateStatus=interviewSlotData.get();
            updateStatus.setSlotStatus(SlotStatus.valueOf(slotStatus));
            interviewerSlotsRepository.save(updateStatus);
            return updateStatus;
        }
        else{
            throw new RuntimeException("Data is not available to update slotStatus of given slotId "+ slotId);
        }
    }

    @Override
    public InterviewSlot removeSlot(String slotId) throws ResourceNotFoundException {
       try {
           InterviewSlot bySlotId = interviewerSlotsRepository.findBySlotId(slotId);
           if(bySlotId!=null){
               interviewerSlotsRepository.deleteById(slotId);
               return bySlotId;
           }
           else {
               throw new RuntimeException("Slot is not available with slotId "+ slotId);
           }
       }catch (Exception exception){
           throw new ResourceNotFoundException("slot not exists with slotId "+slotId);
       }
    }
}
