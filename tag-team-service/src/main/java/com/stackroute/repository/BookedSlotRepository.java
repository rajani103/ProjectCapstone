package com.stackroute.repository;
import com.stackroute.model.BookedSlot;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookedSlotRepository extends MongoRepository<BookedSlot, String> {

    List<BookedSlot> findByEmailOfInterviewer(String emailOfInterviewer);

    List<BookedSlot> findByTagTeamEmail(String tagTeamEmail);

    List<BookedSlot> findByTechTrack(String techTrack);

    BookedSlot findByBookedSlotId(String bookedSlotId);
}
