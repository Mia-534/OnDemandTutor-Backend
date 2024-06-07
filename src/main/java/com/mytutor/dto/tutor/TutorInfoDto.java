/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mytutor.dto.tutor;

import com.mytutor.constants.DegreeType;
import com.mytutor.entities.Account;
import com.mytutor.entities.Subject;
import com.mytutor.entities.TutorDetail;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Nguyen Van Dat
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TutorInfoDto {

    private int id;

    private String dateOfBirth;

    private String gender; // male: false, female: true

    private String address;

    private String avatarUrl;

    private String email;

    private String fullName;

    private String phoneNumber;

    private Double averageRating;

    private Double teachingPricePerHour;

    private String backgroundDescription;

    private String meetingLink;

    private String videoIntroductionLink;

    private Set<String> subjects;

    private List<TutorEducation> educations;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TutorEducation {

        private String majorName;
        private String specialization;
        private DegreeType degreeType;
    }

    public static TutorInfoDto mapToDto(Account account, TutorDetail tutorDetail) {
        if (account == null || tutorDetail == null) {
            return null;
        }

        return TutorInfoDto.builder()
                .id(account.getId())
                .dateOfBirth(new SimpleDateFormat("yyyy-MM-dd").format(account.getDateOfBirth()))
                .gender(account.getGender() ? "female" : "male")
                .address(account.getAddress())
                .avatarUrl(account.getAvatarUrl())
                .email(account.getEmail())
                .fullName(account.getFullName())
                .phoneNumber(account.getPhoneNumber())
                .teachingPricePerHour(tutorDetail.getTeachingPricePerHour())
                .backgroundDescription(tutorDetail.getBackgroundDescription())
                .meetingLink(tutorDetail.getMeetingLink())
                .videoIntroductionLink(tutorDetail.getVideoIntroductionLink())
                .subjects(account.getSubjects().stream().map(s -> s.getSubjectName()).collect(Collectors.toSet()))
                .build();
    }
}
