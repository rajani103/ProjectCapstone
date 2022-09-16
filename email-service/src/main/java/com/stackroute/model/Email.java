package com.stackroute.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Email {

    String interviewerEmail;

    String tagTeamName;

    String subject;

    String messageText;

    @JsonFormat(pattern = "dd-MM-yyyy")
    String date;

    @JsonFormat(pattern = "hh:mm")
    String startTime;

    @JsonFormat(pattern = "hh:mm")
    String endTime;

    String link;

}
