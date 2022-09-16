//package com.stackroute.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.exception.InterviewerDoesNotHaveSlotBoookedException;
//import com.stackroute.model.BookedSlot;
//import com.stackroute.service.BookedSlotService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class TagTagTeamTagTeamControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Mock
//    private BookedSlotService bookedSlotService;
//    private BookedSlot bookedSlot;
//    private List<BookedSlot> bookedSlotList;
//
//    @InjectMocks
//    private TagTeamController tagTeamController;
//
//    @BeforeEach
//    public void setUp() {
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
//        bookedSlotList.add(bookedSlot);
//        mockMvc = MockMvcBuilders.standaloneSetup(tagTeamController).build();
//
//    }
//
//
//    public void getAllBookedSlotByInterviewerEmailThenShouldReturnListOfAllBookedSlots() throws Exception, InterviewerDoesNotHaveSlotBoookedException {
//        lenient().when(tagTeamController.getAllSlotsByInterviewer(bookedSlot.getEmailOfInterviewer())).thenReturn((ResponseEntity<List<BookedSlot>>) bookedSlotList);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/interview/fetchSlotByInterviewerID/manisha@gmail.com")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(bookedSlot)))
//                .andDo(MockMvcResultHandlers.print());
//
//        verify(tagTeamController, times(1)).getAllSlotsByInterviewer(any());
//    }
//
//    public static String asJsonString(final Object obj){
//        try{
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
