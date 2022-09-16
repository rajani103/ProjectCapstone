//package com.stackroute.controller;
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.model.Interview;
//import com.stackroute.model.InterviewSlot;
//import com.stackroute.model.SlotStatus;
//import com.stackroute.service.InterviewSlotService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import java.util.ArrayList;
//import java.util.List;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//
//@ExtendWith(MockitoExtension.class)
//public class InterviewerControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Mock
//    private InterviewSlotService interviewSlotService;
//    private InterviewSlot getSlot;
//    private List<InterviewSlot> interviewList;
//
//    @InjectMocks
//    private InterviewSlotController interviewSlotController;
//
//
//    @BeforeEach
//    public void setUp()  {
//        getSlot = new InterviewSlot();
//        getSlot = new InterviewSlot();
//        getSlot.setInterviewerEmail("rabindra@gmail.com");
//        getSlot.setInterviewerName("Rabindra");
//        getSlot.setTechTrack("Java Full Stack Developers");
//        getSlot.setDate("2022:09:22");
//        getSlot.setSlots(new Interview("12:00 PM","01:00 PM"));
//        getSlot.setSlotStatus(SlotStatus.AVAILABLE);
//        interviewList = new ArrayList<>();
//        interviewList.add(getSlot);
//        mockMvc = MockMvcBuilders.standaloneSetup(interviewSlotController).build();
//    }
//
//
//    @Test
//    public void getAllSlotsByInterviewerEmailThenShouldReturnListOfAllSlots() throws Exception {
//        lenient().when(interviewSlotService.getSlotByEmailId(getSlot.getInterviewerEmail())).thenReturn(interviewList);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/int/getSlotByInterviewerEmail/rabindra@gmail.com")
//                        .contentType(MediaType.APPLICATION_JSON).content(asJsonString(getSlot)))
//                .andDo(MockMvcResultHandlers.print());
//        verify(interviewSlotService, times(1)).getSlotByEmailId(any());
//    }
//
//
//    @Test
//    public void givenInterviewerToUpdateThenShouldReturnUpdatedUser() throws Exception {
//        when(interviewSlotService.updateAvailableSlot(any())).thenReturn(getSlot);
//        mockMvc.perform(put("/api/v1/int/update/101")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(asJsonString(getSlot)));
//        verify(interviewSlotService, times(1)).updateAvailableSlot(any());
//    }
//
//
//    public static String asJsonString(final Object obj){
//        try{
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//
//
//}
