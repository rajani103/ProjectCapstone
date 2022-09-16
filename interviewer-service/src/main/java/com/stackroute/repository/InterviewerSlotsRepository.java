package com.stackroute.repository;
import com.stackroute.model.InterviewSlot;
import com.stackroute.model.SlotStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewerSlotsRepository extends MongoRepository<InterviewSlot,String> {

    InterviewSlot findBySlotId(String slotId);

    List<InterviewSlot> findByInterviewerEmailAndSlotStatus(String interviewerEmail, SlotStatus slotStatus);

    List<InterviewSlot> findSlotByDate(String date);
}
