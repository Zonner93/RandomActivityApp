package com.zonner.RandomActivityApp.service;

import com.zonner.RandomActivityApp.models.entity.ActivityEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ResponseService {
    private final RestTemplate restTemplate;
    private final String ACTIVITY_URL = "https://www.boredapi.com/api/activity";

    public ResponseEntity<ActivityEntity> getActivity() {
        ResponseEntity<ActivityEntity> activity = restTemplate.getForEntity(ACTIVITY_URL, ActivityEntity.class);
        return activity;
    }
}
