package com.zonner.RandomActivityApp.controller;

import com.zonner.RandomActivityApp.mapper.ActivityMapper;
import com.zonner.RandomActivityApp.models.entity.ActivityEntity;
import com.zonner.RandomActivityApp.models.entity.dto.ActivityDtoInput;
import com.zonner.RandomActivityApp.models.entity.dto.ActivityDtoOutput;
import com.zonner.RandomActivityApp.repository.ActivityRepository;
import com.zonner.RandomActivityApp.service.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:8080")
@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class ActivityController {
    private final ActivityRepository activityRepository;
    private final ActivityService activityService;
    private final ActivityMapper activityMapper;

    @GetMapping("/activity")
    public ActivityDtoOutput getActivity() {
        return activityService.getActivity();
    }

    @GetMapping("/activities")
    public ResponseEntity<List<ActivityDtoOutput>> getAllActivities(@RequestParam(required = false) String key) {
        try {
            List<ActivityEntity> activityEntityList;
            List<ActivityDtoOutput> activityDtoOutputList;
            if (key == null) {
                activityEntityList = activityRepository.findAll();
            } else {
                activityEntityList = activityRepository.findByKey(key);
            }
            activityDtoOutputList = activityEntityList
                    .stream().map(activityMapper::entityToDto).collect(Collectors.toList());
            if (activityEntityList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(activityDtoOutputList, HttpStatus.OK);


        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/activities")
    public ResponseEntity<ActivityEntity> createActivity(@RequestBody ActivityEntity activity) {
        try {
            ActivityEntity activityEntity = activityRepository.save(new ActivityEntity(
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
