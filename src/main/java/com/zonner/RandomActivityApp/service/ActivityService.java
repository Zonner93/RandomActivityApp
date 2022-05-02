package com.zonner.RandomActivityApp.service;

import com.zonner.RandomActivityApp.mapper.ActivityMapper;
import com.zonner.RandomActivityApp.models.entity.ActivityEntity;
import com.zonner.RandomActivityApp.models.entity.dto.ActivityDtoInput;
import com.zonner.RandomActivityApp.models.entity.dto.ActivityDtoOutput;
import com.zonner.RandomActivityApp.repository.ActivityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ActivityService {
    private final ResponseService responseService;
    private final ActivityRepository activityRepository;
    private final ActivityMapper activityMapper;

    public ActivityDtoOutput getActivity() {
        ActivityEntity activityEntity = responseService.getActivity().getBody();

//        return activityMapper.dtoToEntity(activityDtoInput);
        return activityMapper.entityToDto(activityEntity);
    }
}
