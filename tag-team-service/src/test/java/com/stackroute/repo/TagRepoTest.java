//package com.stackroute.repo;
//
//import com.stackroute.model.BookedSlot;
//import com.stackroute.repository.BookedSlotRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//@ExtendWith(SpringExtension.class)
//@DataMongoTest
//public class TagRepoTest {
//
//    @Autowired
//    private BookedSlotRepository bookedSlotRepository;
//
//    private BookedSlot bookedSlot;
//
//    @BeforeEach
//    void setUp(){
//        bookedSlot = new BookedSlot();
//        bookedSlot = new BookedSlot();
//        bookedSlot.setTagTeamName("BookYourSlot");
//        bookedSlot.setTagTeamEmail("kishore@gmail.com");
//        bookedSlot.setTechTrack("Java");
//        bookedSlot.setInterviewTopic("Java Developer");
//        bookedSlot.setDescription("Interviewed");
//        bookedSlot.setEmailOfInterviewer("mehboob@gmail.com");
//        bookedSlot.setAvailableDate("22 July 2022");
//        bookedSlot.setStartTime("10:30");
//        bookedSlot.setEndTime("11:30");
//        bookedSlot.setBookedDate("22 July 2022");
//    }
//
//    @AfterEach
//    void tearDown(){
//        bookedSlotRepository.deleteAll();
//        bookedSlot = null;
//    }
//
//    @Test
//    public void slotBookingShouldReturnSavedBookedSlot(){
//        bookedSlotRepository.save(bookedSlot);
//        BookedSlot bookedSlot1 = bookedSlotRepository.findById(bookedSlot.getBookedSlotId()).get();
//
//        Assertions.assertEquals(bookedSlot1.getBookedSlotId(),bookedSlot.getBookedSlotId());
//    }
//}
//
