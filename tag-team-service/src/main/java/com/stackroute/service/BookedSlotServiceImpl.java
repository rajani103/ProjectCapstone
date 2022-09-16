package com.stackroute.service;

import com.stackroute.exception.BookedSlotIDNotFoundForTechTrackException;
import com.stackroute.exception.InterviewerDoesNotHaveSlotBoookedException;
import com.stackroute.exception.NoBookedSlotsExistsException;
import com.stackroute.exception.TagTeamDoesNotHaveSlotBoookedException;
import com.stackroute.model.BookedSlot;
import com.stackroute.model.SlotStatus;
import com.stackroute.repository.BookedSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookedSlotServiceImpl implements BookedSlotService {
    @Autowired
    private BookedSlotRepository bookedSlotRepository;

    @Override
    public BookedSlot newSchedule(BookedSlot bookedSlot) {
        return bookedSlotRepository.save(bookedSlot);
    }

    @Override
    public List<BookedSlot> getAllBookedSlots() throws NoBookedSlotsExistsException {
        if(bookedSlotRepository.findAll().isEmpty()){
        throw new NoBookedSlotsExistsException("Zero slots booked !!! ");
    }else {
        return bookedSlotRepository.findAll();
    }
    }

    @Override
    public BookedSlot updateSlot(BookedSlot bookedSlot) {
        Optional<BookedSlot> byId = bookedSlotRepository.findById(bookedSlot.getBookedSlotId());
        if(byId.isPresent()){
            BookedSlot update = byId.get();
            update.setTagTeamName(bookedSlot.getTagTeamName());
            update.setTagTeamEmail(bookedSlot.getTagTeamEmail());
            update.setTechTrack(bookedSlot.getTechTrack());
            update.setInterviewTopic(bookedSlot.getInterviewTopic());
            update.setDescription(bookedSlot.getDescription());
            update.setEmailOfInterviewer(bookedSlot.getEmailOfInterviewer());
            update.setAvailableDate(bookedSlot.getAvailableDate());
            update.setStartTime(bookedSlot.getStartTime());
            update.setEndTime(bookedSlot.getEndTime());
            update.setSlotId(bookedSlot.getSlotId());
            update.setBookedDate(bookedSlot.getBookedDate());
            update.setSlotStatus(bookedSlot.getSlotStatus());
            bookedSlotRepository.save(update);
            return update;
        }else{
            throw new RuntimeException("NO DATA FOUND !");

        }
    }

    @Override
    public List<BookedSlot> getAllSlotsByInterviewer(String emailOfInterviewer) throws InterviewerDoesNotHaveSlotBoookedException {
        if(bookedSlotRepository.findByEmailOfInterviewer(emailOfInterviewer).isEmpty())
            throw new InterviewerDoesNotHaveSlotBoookedException("No booked Slot for "+emailOfInterviewer);
        else
            return (List<BookedSlot>) bookedSlotRepository.findByEmailOfInterviewer(emailOfInterviewer);
    }

    @Override
    public List<BookedSlot> getAllSlotsByTagTeam(String tagTeamEmail) throws TagTeamDoesNotHaveSlotBoookedException {
        if(bookedSlotRepository.findByTagTeamEmail(tagTeamEmail).isEmpty())
        throw new TagTeamDoesNotHaveSlotBoookedException("No booked Slot for "+tagTeamEmail);
    else
        return (List<BookedSlot>) bookedSlotRepository.findByTagTeamEmail(tagTeamEmail);
    }

    @Override
    public List<BookedSlot> findByTechTrack(String techTrack) throws BookedSlotIDNotFoundForTechTrackException {
        if(bookedSlotRepository.findByTechTrack(techTrack).isEmpty())
            throw new BookedSlotIDNotFoundForTechTrackException("BookedSlot Not Found for TechTrack ! ");
        else
            return bookedSlotRepository.findByTechTrack(techTrack);
    }

    @Override
    public BookedSlot updateSlotStatus(String bookedSlotId, String slotStatus) {
        Optional<BookedSlot> byId = bookedSlotRepository.findById(bookedSlotId);
        if(byId.isPresent()) {
            BookedSlot updateStatus = byId.get();
            updateStatus.setSlotStatus(SlotStatus.valueOf(slotStatus));
            bookedSlotRepository.save(updateStatus);
            return updateStatus;
        }else{
            throw new RuntimeException("No Data Found !");
        }

    }

    @Override
    public BookedSlot deleteBookedSlot(String bookedSlotId) {
        BookedSlot byBookedSlotId = bookedSlotRepository.findByBookedSlotId(bookedSlotId);
        if(byBookedSlotId!=null){
            bookedSlotRepository.deleteById(bookedSlotId);
            return byBookedSlotId;
        }else {
            throw new RuntimeException("NO SLOT AVAILABLE");
        }
    }

}
