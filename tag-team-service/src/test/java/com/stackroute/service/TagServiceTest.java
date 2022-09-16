//package com.stackroute.service;
//
//import com.stackroute.model.BookedSlot;
//import com.stackroute.repository.BookedSlotRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//@ExtendWith(MockitoExtension.class)
//public class TagServiceTest {
//
//    @Mock
//    private BookedSlotRepository bookedSlotRepository;
//
//    @InjectMocks
//    private BookedSlotServiceImpl bookedSlotService;
//    private List<BookedSlot> bookedSlotList;
//    private BookedSlot bookedSlot;
//    private Optional optional;
//    private BookedSlot bookedSlot1;
//
//    @BeforeEach
//    public void setUp(){
//        MockitoAnnotations.initMocks(this);
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
//        optional = Optional.of(bookedSlot);
//        bookedSlotList = new ArrayList<>();
//        bookedSlotList.add(bookedSlot);
//    }
//
//}
