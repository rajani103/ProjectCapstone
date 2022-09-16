package com.stackroute.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "TagTeam")
public class BookedSlot {

    @Transient
    public  static final String SEQUENCE_NAME="users_sequence";

    @Id
    private String bookedSlotId;
    private String tagTeamName;
    private String tagTeamEmail;
    private String techTrack;
    private String interviewTopic;
    private String description;
    private String emailOfInterviewer;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String availableDate;
    @JsonFormat(pattern = "hh:mm a")
    private String startTime;
    @JsonFormat(pattern = "hh:mm a")
    private String endTime;
    private String slotId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String bookedDate;
    private SlotStatus slotStatus;
}
