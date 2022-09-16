package com.stackroute.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Interview {

    @JsonFormat(pattern = "HH:mm")
    private String startTime;
    @JsonFormat(pattern = "HH:mm")
    private String endTime;

}
