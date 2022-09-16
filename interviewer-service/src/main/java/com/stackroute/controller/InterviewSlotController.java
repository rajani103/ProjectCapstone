package com.stackroute.controller;

import com.stackroute.model.InterviewSlot;
import com.stackroute.service.InterviewSlotService;
import com.stackroute.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/v1")
public class InterviewSlotController {

    @Autowired
    private InterviewSlotService interviewSlotService;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    /** This API is used to add new slot for Interview.*/
    @PostMapping("/int/addSlot")
    public ResponseEntity<InterviewSlot> saveNewAvailableSlot(@RequestBody InterviewSlot interviewSlot){
        interviewSlot.setSlotId("SLOT"+String.valueOf(sequenceGeneratorService.getSequenceNumber(InterviewSlot.SEQUENCE_NAME)));
        return new ResponseEntity<>(interviewSlotService.creatingNewAvailableSlot(interviewSlot), HttpStatus.CREATED);
    }

    /** This API is used to update existing slot for Interview.*/
    @PutMapping("/int/update/{slotId}")
    public ResponseEntity<InterviewSlot> updateSlotById(@PathVariable("slotId") String slotId, @RequestBody  InterviewSlot interviewSlot){
        interviewSlot.setSlotId(slotId);
        return ResponseEntity.ok().body(interviewSlotService.updateAvailableSlot(interviewSlot));
    }

    /** This API is used to find  slot based on interviewer email.*/
    @GetMapping("/int/getSlotByInterviewerEmail/{interviewerEmail}")
    public ResponseEntity<List<InterviewSlot>> getSlotByInterviewerEmail(@PathVariable("interviewerEmail") String interviewerEmail){
        List<InterviewSlot> slotByEmailId = interviewSlotService.getSlotByEmailId(interviewerEmail);
        return new ResponseEntity<>(slotByEmailId,HttpStatus.OK);
    }

    /** This API is used to find  slot based on date.*/
    @GetMapping("/int/getSlotByDate/{date}")
    public ResponseEntity<List<InterviewSlot>> getSlotByDate(@PathVariable("date") String date){
        List<InterviewSlot> slotByDate = interviewSlotService.getSlotByDate(date);
        return new ResponseEntity<>(slotByDate,HttpStatus.IM_USED);
    }

    /** This API is used to Update  slotStatus based on slotId.*/
    @PutMapping("/int/updateSlotStatus/{slotId}/{slotStatus}")
    public ResponseEntity<InterviewSlot> updateSlotStatus(@PathVariable("slotId") String slotId,@PathVariable("slotStatus") String slotStatus){
        InterviewSlot updateStatus = interviewSlotService.editSlotStatus(slotId, slotStatus);
        return new ResponseEntity<>(updateStatus,HttpStatus.ACCEPTED);
    }
    /** This API is used to delete slot based on slotId.*/
    @DeleteMapping("/int/deleteSlotById/{slotId}")
    public ResponseEntity<InterviewSlot> deleteSlotById(@PathVariable("slotId") String slotId){
        InterviewSlot interviewSlot = interviewSlotService.removeSlot(slotId);
        return new ResponseEntity<>(interviewSlot,HttpStatus.GONE);
    }

}
