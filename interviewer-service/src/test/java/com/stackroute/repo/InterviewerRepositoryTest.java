//package com.stackroute.repo;
//
//
//import com.stackroute.model.Interview;
//import com.stackroute.model.InterviewSlot;
//import com.stackroute.model.SlotStatus;
//import com.stackroute.repository.InterviewerSlotsRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.text.ParseException;
//import java.util.List;
//
//@ExtendWith(SpringExtension.class)
//@DataMongoTest
//public class InterviewerRepositoryTest {
//
//    @Autowired
//    private InterviewerSlotsRepository interviewerSlotsRepository;
//
//    private InterviewSlot getSlot;
//
//    @BeforeEach
//    void setUp() throws ParseException {
//        getSlot = new InterviewSlot();
//        getSlot.setInterviewerEmail("rabindra@gmail.com");
//        getSlot.setInterviewerName("Rabindra");
//        getSlot.setTechTrack("Java Full Stack Developers");
//        getSlot.setDate("2022:09:22");
//        getSlot.setSlots(new Interview("12:00 PM","01:00 PM"));
//        getSlot.setSlotStatus(SlotStatus.AVAILABLE);
//
//    }
//
//
//    @AfterEach
//    void tearDown() {
//        interviewerSlotsRepository.deleteAll();
//        getSlot = null;
//    }
//
//    @Test
//    public void givenSlotToSaveShouldReturnSavedSlot(){
//        interviewerSlotsRepository.save(getSlot);
//        InterviewSlot interviewSlot = interviewerSlotsRepository.findById(getSlot.getSlotId()).get();
//        Assertions.assertEquals(interviewSlot.getSlotId(),getSlot.getSlotId());
//    }
//
//
//    @Test
//    public void givenInterviewerEmailThenShouldReturnListOfAllSlots(){
//        InterviewSlot interviewSlot = interviewerSlotsRepository.save(getSlot);
//        List<InterviewSlot> interviewList = interviewerSlotsRepository.findByInterviewerEmail(interviewSlot.getInterviewerEmail());
//        Assertions.assertEquals(getSlot.getSlotId(),interviewList.get(0).getSlotId());
//        Assertions.assertEquals(getSlot.getInterviewerEmail(),interviewList.get(0).getInterviewerEmail());
//        Assertions.assertEquals(getSlot.getInterviewerName(),interviewList.get(0).getInterviewerName());
//
//    }
////    @Test
////    public void givenTechTrackThenShouldReturnListOfAllSlots(){
////        InterviewSlot interview = interviewerSlotsRepository.save(getSlot);
////        List<InterviewSlot> interviewList = interviewerSlotsRepository.findByTechTrack(interview.getTechTrack());
////        Assertions.assertEquals(getSlot.getSlotId(),interviewList.get(0).getSlotId());
////        Assertions.assertEquals(getSlot.getTechTrack(),interviewList.get(0).getTechTrack());
////        Assertions.assertEquals(getSlot.getInterviewerName(),interviewList.get(0).getInterviewerName());
////
////    }
//
//    @Test
//    public void givenSlotIdToDeleteThenShouldReturnDeleteSlot(){
//        interviewerSlotsRepository.save(getSlot);
//        interviewerSlotsRepository.delete(getSlot);
//        InterviewSlot optional = interviewerSlotsRepository.findBySlotId(getSlot.getSlotId());
//        Assertions.assertEquals(null, optional);
//    }
//
//
//
//}
