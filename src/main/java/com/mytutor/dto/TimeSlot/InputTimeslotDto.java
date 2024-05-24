package com.mytutor.dto.TimeSlot;

import lombok.Data;

import java.sql.Time;

/**
 * @author vothimaihoa
 *
 */
@Data
public class InputTimeslotDto {
    private Time startTime;

    private Time endTime;

    private Integer dayOfWeek;

}