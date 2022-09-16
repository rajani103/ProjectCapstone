package com.stackroute.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "InterviewSlot")
public class InterviewSlot {

        @Transient
        public  static final String SEQUENCE_NAME="users_sequence";

        @Id
        private String slotId;
        private String interviewerEmail;
        private String interviewerName;
        private String techTrack;
        @JsonFormat(pattern = "yyyy-MM-dd")
        private String date;
        private Interview slots;
        private SlotStatus slotStatus;


    }

