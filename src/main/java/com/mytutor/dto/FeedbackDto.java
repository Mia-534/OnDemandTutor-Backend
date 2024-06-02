/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mytutor.dto;

import com.mytutor.constants.FeedbackType;
import com.mytutor.entities.Feedback;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Nguyen Van Dat
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackDto {

    private int id;
    private int createdBy;
    private int tutorId;
    private Integer rating;
    private String content;
    private String createdAt;
    private String modifiedAt;
    private Boolean isBanned;
    private FeedbackType type;
    private List<ReplyDto> replies = new ArrayList<>();

    public static FeedbackDto mapToDto(Feedback feedback) {
        if (feedback == null) {
            return null;
        }

        FeedbackDto feedbackDto = new FeedbackDto();
        feedbackDto.setId(feedback.getId());
        feedbackDto.setCreatedBy(feedback.getCreatedBy().getId());
        feedbackDto.setTutorId(feedback.getTutor().getId());
        feedbackDto.setRating(feedback.getRating());
        feedbackDto.setContent(feedback.getContent());
        
        // Create a SimpleDateFormat object with the desired format
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        feedbackDto.setCreatedAt(sdf.format(feedback.getCreatedAt()));
        feedbackDto.setModifiedAt(sdf.format(feedback.getModifiedAt()));
        feedbackDto.setIsBanned(feedback.getIsBanned());
        feedbackDto.setType(feedback.getType());
        feedbackDto.setReplies(feedback.getReplies().stream().map(r -> ReplyDto.mapToDto(r)).collect(Collectors.toList()));

        return feedbackDto;
    }
}
