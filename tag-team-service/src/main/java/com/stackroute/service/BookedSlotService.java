package com.stackroute.service;
import com.stackroute.exception.BookedSlotIDNotFoundForTechTrackException;
import com.stackroute.exception.InterviewerDoesNotHaveSlotBoookedException;
import com.stackroute.exception.NoBookedSlotsExistsException;
import com.stackroute.exception.TagTeamDoesNotHaveSlotBoookedException;
import com.stackroute.model.BookedSlot;
import java.util.List;

public interface BookedSlotService {

     BookedSlot newSchedule(BookedSlot bookedSlot);
     List<BookedSlot> getAllBookedSlots() throws NoBookedSlotsExistsException;
     BookedSlot updateSlot( BookedSlot bookedSlot);
     List<BookedSlot> getAllSlotsByInterviewer(String emailOfInterviewer) throws InterviewerDoesNotHaveSlotBoookedException;
     List<BookedSlot> getAllSlotsByTagTeam( String tagTeamEmail) throws TagTeamDoesNotHaveSlotBoookedException;
     List<BookedSlot> findByTechTrack(String techTrack) throws BookedSlotIDNotFoundForTechTrackException;
     BookedSlot updateSlotStatus(String bookedSlotId, String slotStatus);
     BookedSlot deleteBookedSlot( String bookedSlotId);

}
