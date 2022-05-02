package com.zonner.RandomActivityApp.mapper;

import com.zonner.RandomActivityApp.builder.ActivityDtoOutputBuilder;
import com.zonner.RandomActivityApp.builder.ActivityEntityBuilder;
import com.zonner.RandomActivityApp.models.entity.ActivityEntity;
import com.zonner.RandomActivityApp.models.entity.dto.ActivityDtoInput;
import com.zonner.RandomActivityApp.models.entity.dto.ActivityDtoOutput;

import java.util.Objects;

public class ActivityMapper {
    public ActivityEntity dtoToEntity(ActivityDtoInput activityDtoInput) {
        if (activityDtoInput == null) {
            return null;
        }
        ActivityEntityBuilder activityEntityBuilder = new ActivityEntityBuilder();

        if (Objects.nonNull(activityDtoInput.getActivity())) {
            activityEntityBuilder.withActivity(activityDtoInput.getActivity());
        }
        if (Objects.nonNull(activityDtoInput.getType())) {
            activityEntityBuilder.withType(activityDtoInput.getType());
        }
        if (Objects.nonNull(activityDtoInput.getParticipants())) {
            activityEntityBuilder.withParticipants(activityDtoInput.getParticipants());
        }
        if (Objects.nonNull(activityDtoInput.getPrice())) {
            activityEntityBuilder.withPrice(activityDtoInput.getPrice());
        }
        if (Objects.nonNull(activityDtoInput.getLink())) {
            activityEntityBuilder.withLink(activityDtoInput.getLink());
        }
        if (Objects.nonNull(activityDtoInput.getKey())) {
            activityEntityBuilder.withKey(activityDtoInput.getKey());
        }
        if (Objects.nonNull(activityDtoInput.getAccessibility())) {
            activityEntityBuilder.withAccessibility(activityDtoInput.getAccessibility());
        }
        return activityEntityBuilder.build();
    }

    public ActivityDtoOutput entityToDto(ActivityEntity activityEntity) {
        if (activityEntity == null) {
            return null;
        }
        ActivityDtoOutputBuilder activityDtoOutputBuilder = new ActivityDtoOutputBuilder();

        if (Objects.nonNull(activityEntity.getActivity())) {
            activityDtoOutputBuilder.withActivity(activityEntity.getActivity());
        }
        if (Objects.nonNull(activityEntity.getType())) {
            activityDtoOutputBuilder.withType(activityEntity.getType());
        }
        if (Objects.nonNull(activityEntity.getParticipants())) {
            activityDtoOutputBuilder.withParticipants(activityEntity.getParticipants());
        }
        if (Objects.nonNull(activityEntity.getPrice())) {
            activityDtoOutputBuilder.withPrice(activityEntity.getPrice());
        }
        if (Objects.nonNull(activityEntity.getLink())) {
            activityDtoOutputBuilder.withLink(activityEntity.getLink());
        }
        if (Objects.nonNull(activityEntity.getKey())) {
            activityDtoOutputBuilder.withKey(activityEntity.getKey());
        }
        if (Objects.nonNull(activityEntity.getAccessibility())) {
            activityDtoOutputBuilder.withAccessibility(activityEntity.getAccessibility());
        }
        return activityDtoOutputBuilder.build();
    }
}
