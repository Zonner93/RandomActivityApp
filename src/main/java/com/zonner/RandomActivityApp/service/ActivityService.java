package com.zonner.RandomActivityApp.service;

import com.zonner.RandomActivityApp.models.entity.ActivityEntity;
import com.zonner.RandomActivityApp.repository.ActivityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ActivityService {
    private final ResponseService responseService;
    private final ActivityRepository activityRepository;

    public ActivityEntity getActivity() {
        ActivityEntity activityEntity = responseService.getActivity().getBody();
        return activityEntity;
    }
}
