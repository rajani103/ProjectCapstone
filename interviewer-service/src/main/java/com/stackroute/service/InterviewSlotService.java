package com.stackroute.service;

import com.stackroute.exception.ResourceNotFoundException;
import com.stackroute.model.InterviewSlot;

import java.util.List;

public interface InterviewSlotService {

     InterviewSlot creatingNewAvailableSlot(InterviewSlot interviewSlot);
     InterviewSlot updateAvailableSlot(InterviewSlot interviewSlot);

     List<InterviewSlot> getSlotByEmailId(String interviewerEmail);

     List<InterviewSlot> getSlotByDate(String date);

     InterviewSlot editSlotStatus(String slotId, String slotStatus);

     InterviewSlot removeSlot(String slotId) throws ResourceNotFoundException;
}
