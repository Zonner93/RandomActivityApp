package com.zonner.RandomActivityApp.service;

import com.zonner.RandomActivityApp.models.entity.Activity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ActivityService {
    private final ResponseService responseService;

    public Activity getActivity() {
        Activity activity = responseService.getActivity().getBody();

        return activity;
    }
}
