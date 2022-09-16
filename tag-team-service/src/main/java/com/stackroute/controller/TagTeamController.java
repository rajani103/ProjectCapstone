package com.stackroute.controller;
import com.stackroute.exception.BookedSlotIDNotFoundForTechTrackException;
import com.stackroute.exception.InterviewerDoesNotHaveSlotBoookedException;
import com.stackroute.exception.NoBookedSlotsExistsException;
import com.stackroute.exception.TagTeamDoesNotHaveSlotBoookedException;
import com.stackroute.model.BookedSlot;
import com.stackroute.service.BookedSlotService;
import com.stackroute.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/tag/api/v1")
public class TagTeamController {

    @Autowired
    private BookedSlotService bookedSlotService;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @PostMapping("/tag/newBookedSlot")
    public ResponseEntity<BookedSlot> newSchedule(@RequestBody BookedSlot bookedSlot) {
        bookedSlot.setBookedSlotId("SCHEDULE_" + sequenceGeneratorService.getSequenceNumber(BookedSlot.SEQUENCE_NAME));
        BookedSlot book = bookedSlotService.newSchedule(bookedSlot);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/tag/getAllBookedSlots")
    public ResponseEntity<List<BookedSlot>> getAllSlots() throws NoBookedSlotsExistsException {
        List<BookedSlot> newList = bookedSlotService.getAllBookedSlots();
        return new ResponseEntity<>(newList, HttpStatus.OK);
    }

    @PutMapping("/tag/updateById/{bookedSlotId}")
    public ResponseEntity<BookedSlot> updateSlot(@PathVariable("bookedSlotId") String bookedSlotId, @RequestBody BookedSlot bookedSlot) {
        bookedSlot.setBookedSlotId(bookedSlotId);
        return ResponseEntity.ok().body(bookedSlotService.updateSlot(bookedSlot));
    }

    @GetMapping("/tag/getAllBookedSlotsFromInterviewer/{emailOfInterviewer}")
    public ResponseEntity<List<BookedSlot>> getAllSlotsByInterviewer(@PathVariable("emailOfInterviewer") String emailOfInterviewer) throws InterviewerDoesNotHaveSlotBoookedException {
        List<BookedSlot> allSlotsByInterviewer = bookedSlotService.getAllSlotsByInterviewer(emailOfInterviewer);
        return new ResponseEntity<>(allSlotsByInterviewer, HttpStatus.ACCEPTED);
    }

    @GetMapping("/tag/getAllBookedSlotsFromTagTeam/{tagTeamEmail}")
    public ResponseEntity<List<BookedSlot>> getAllSlotsByTagTeam(@PathVariable("tagTeamEmail") String tagTeamEmail) throws TagTeamDoesNotHaveSlotBoookedException {
        List<BookedSlot> allSlotsByTagTeam = bookedSlotService.getAllSlotsByTagTeam(tagTeamEmail);
        return new ResponseEntity<>(allSlotsByTagTeam, HttpStatus.OK);
    }

    @GetMapping("/tag/getByTechTrack/{techTrack}")
    public ResponseEntity<List<BookedSlot>> findByTechTrack(@PathVariable("techTrack") String techTrack) throws BookedSlotIDNotFoundForTechTrackException {
        List<BookedSlot> byTechTrack = bookedSlotService.findByTechTrack(techTrack);
        return new ResponseEntity<>(byTechTrack, HttpStatus.OK);
    }

    @DeleteMapping("/tag/deleteByBookedSlotId/{bookedSlotId}")
    public ResponseEntity<BookedSlot> deleteBookedSlot(@PathVariable("bookedSlotId") String bookedSlotId) {
        return new ResponseEntity<>(bookedSlotService.deleteBookedSlot(bookedSlotId), HttpStatus.OK);
    }

    @PutMapping("/tag/slotStatus/{bookedSlotId}/{slotStatus}")
    public ResponseEntity<BookedSlot> updateSlotStatus(@PathVariable("bookedSlotId") String bookedSlotId, @PathVariable("slotStatus") String slotStatus) {
        BookedSlot updateSlot = bookedSlotService.updateSlotStatus(bookedSlotId, slotStatus);
        return new ResponseEntity<>(updateSlot, HttpStatus.ACCEPTED);
    }
}