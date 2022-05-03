package com.zonner.RandomActivityApp.service;

import com.zonner.RandomActivityApp.models.entity.Activity;
import com.zonner.RandomActivityApp.repository.ActivityRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ActivityService {
    private final ResponseService responseService;
    private final ActivityRepository activityRepository;

    public ResponseEntity<Activity> getActivity() {
        Activity activity = responseService.getActivity().getBody();
        if (isActivityInDatabase(activity.getKey())) {
            getActivity();
        }

        return createActivity(activity);
    }

    private boolean isActivityInDatabase(String activityKey) {
        List<Activity> activityList = activityRepository.findByKey(activityKey);
        if (activityList.isEmpty()) {
            return false;
        }
        return true;
    }

    public List<Activity> getActivityListByKey(String key) {
        return activityRepository.findByKey(key);
    }

    public ResponseEntity<Activity> createActivity(Activity activity) {
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
