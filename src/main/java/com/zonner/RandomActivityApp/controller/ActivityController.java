package com.zonner.RandomActivityApp.controller;

import com.zonner.RandomActivityApp.models.entity.ActivityEntity;
import com.zonner.RandomActivityApp.repository.ActivityRepository;
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

    @GetMapping("/activities")
    public ResponseEntity<List<ActivityEntity>> getAllActivities(@RequestParam(required = false) String activity) {
        try {
            List<ActivityEntity> activityEntityList = new ArrayList<>();
            if (activity == null) {
                activityEntityList.addAll(activityRepository.findAll());
            }
            else {
                activityEntityList.addAll(activityRepository.findByActivity(activity));
            }
            if(activityEntityList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(activityEntityList, HttpStatus.OK);


        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
