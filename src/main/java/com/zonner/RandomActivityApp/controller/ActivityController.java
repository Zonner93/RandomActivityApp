package com.zonner.RandomActivityApp.controller;

import com.zonner.RandomActivityApp.models.entity.Activity;
import com.zonner.RandomActivityApp.repository.ActivityRepository;
import com.zonner.RandomActivityApp.service.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class ActivityController {
    private final ActivityRepository activityRepository;
    private final ActivityService activityService;

    @GetMapping("/activity")
    public Activity getActivity(){
        return activityService.getActivity();
    }

    @GetMapping("/activities")
    public ResponseEntity<List<Activity>> getAllActivities(@RequestParam(required = false) String key) {
        try {
            List<Activity> activityList = new ArrayList<>();
            if (key == null) {
                activityList.addAll(activityRepository.findAll());
            } else {
                activityList.addAll(activityRepository.findByKey(key));
            }
            if (activityList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(activityList, HttpStatus.OK);


        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/activities")
    public ResponseEntity<Activity> createActivity(@RequestBody Activity activity) {
        try {
            Activity activityEntity = activityRepository.save(new Activity(
                    activity.getActivity(), activity.getType(), activity.getParticipants(),
                    activity.getPrice(), activity.getLink(), activity.getKey(),
                    activity.getAccessibility()
            ));
            return new ResponseEntity<>(activityEntity, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
