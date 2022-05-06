package com.zonner.RandomActivityApp.controller;

import com.zonner.RandomActivityApp.models.entity.Activity;
import com.zonner.RandomActivityApp.service.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class ActivityController {
    private final ActivityService activityService;

    @GetMapping("/activity")
    public ResponseEntity<Activity> getActivity() {
        return activityService.getActivity();
    }

    @GetMapping("/activities")
    public ResponseEntity<List<Activity>> getAllActivities() {
        return activityService.getAllActivities();
    }

    @PostMapping("/activities")
    public ResponseEntity<Activity> createActivity(@RequestBody Activity activity) {
        return activityService.createActivity(activity);
    }
}
