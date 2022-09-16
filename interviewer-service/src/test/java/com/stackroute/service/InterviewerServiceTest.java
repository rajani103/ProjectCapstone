//package com.stackroute.service;
//
//import com.stackroute.exception.InterviewSlotAlreadyExistException;
//import com.stackroute.model.Interview;
//import com.stackroute.model.InterviewSlot;
//import com.stackroute.model.SlotStatus;
//import com.stackroute.repository.InterviewerSlotsRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.text.ParseException;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class InterviewerServiceTest {
//    @Mock
//    private InterviewerSlotsRepository interviewerSlotsRepository;
//
//    @InjectMocks
//    private InterviewSlotServiceImpl interviewSlotServiceImpl;
//    private List<InterviewSlot> interviewSlot;
//    private InterviewSlot interviewSlot1;
//    private Optional optional;
//
//    private InterviewSlot getSlot;
//
//    @BeforeEach
//    public void setUp() throws ParseException {
//        MockitoAnnotations.initMocks(this);
//        getSlot = new InterviewSlot();
//        getSlot.setInterviewerEmail("rabindra@gmail.com");
//        getSlot.setInterviewerName("Rabindra");
//        getSlot.setTechTrack("Java Full Stack Developers");
//        getSlot.setDate("2022:09:22");
//        getSlot.setSlots(new Interview("12:00 PM","01:00 PM"));
//        getSlot.setSlotStatus(SlotStatus.AVAILABLE);
//        optional = Optional.of(getSlot);
//        interviewSlot = new ArrayList<>();
//        interviewSlot.add(getSlot);
//    }
//
//    @AfterEach
//    public void tearDown(){
//        getSlot= null;
//    }
//
//    @Test
//    public void givenSlotToSaveShouldReturnSavedSlot() throws InterviewSlotAlreadyExistException {
//        when(interviewerSlotsRepository.save(getSlot)).thenReturn(getSlot);
//        Assertions.assertEquals(getSlot,interviewSlotServiceImpl.creatingNewAvailableSlot(getSlot));
//        verify(interviewerSlotsRepository,times(1)).save(any());
//    }
//    @Test
//    public void givenSlotToUpdateThenShouldReturnUpdatedSlot() {
//        when(interviewerSlotsRepository.findById(getSlot.getSlotId())).thenReturn(optional);
//        getSlot.setInterviewerEmail("rabindra@gmail.com");
//        getSlot.setInterviewerName("Rabindra");
//        InterviewSlot updatedSlot = interviewSlotServiceImpl.updateAvailableSlot(getSlot);
//        assertEquals(getSlot, updatedSlot);
//    }
//
//
//
//    @Test
//    public void givenInterviewerEmailIdToGetSlotByEmailIdThenReturnSlots() throws  ParseException{
//        interviewSlotServiceImpl.creatingNewAvailableSlot(getSlot);
//        interviewerSlotsRepository.save(getSlot);
//        when(interviewerSlotsRepository.findByInterviewerEmail("rabindra@gmail.com")).thenReturn(interviewSlot);
//        List<InterviewSlot> interview = interviewSlotServiceImpl.getSlotByEmailId("rabindra@gmail.com");
//        assertEquals(interviewSlot, interview);
//
//    }
//
//
//    @Test
//    public void givenSlotIdToDeleteThenShouldDeleteRespectiveSlot() {
//        when(interviewerSlotsRepository.findBySlotId(getSlot.getSlotId())).thenReturn(getSlot);
//        InterviewSlot slotDel = interviewSlotServiceImpl.removeSlot(getSlot.getSlotId());
//        assertEquals(getSlot, slotDel);
//    }
//
//
//}
