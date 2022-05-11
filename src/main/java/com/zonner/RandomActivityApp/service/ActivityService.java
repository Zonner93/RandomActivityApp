package com.zonner.RandomActivityApp.service;

import com.zonner.RandomActivityApp.exceptions.Activity.ActivityError;
import com.zonner.RandomActivityApp.exceptions.Activity.ActivityException;
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
        //FIXME activity could be null, and getKey might throw NPE
        checkIfActivityAlreadyExists(activity.getKey());
        return createActivity(activity);
    }

    public ResponseEntity<Activity> createActivity(Activity activity) {
        try {
            Activity activityEntity = activityRepository.save(new Activity(
                    activity.getActivity(), activity.getType(), activity.getParticipants(),
                    activity.getPrice(), activity.getLink(), activity.getKey(),
                    activity.getAccessibility()
            ));
            return new ResponseEntity<>(activityEntity, HttpStatus.CREATED);
            //FIXME it is bad practice to catch Exception - you should know what kind of exception can be thrown and catch only that
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Activity>> getAllActivities(){
        try {
            List<Activity> activityList = activityRepository.findAll();
            if (activityList.isEmpty()) {
                throw new ActivityException(ActivityError.ACTIVITY_EMPTY_LIST);
            }
            return new ResponseEntity<>(activityList, HttpStatus.OK);
//FIXME it is bad practice to catch Exception - you should know what kind of exception can be thrown and catch only that
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private List<Activity> getActivityListByKey(String key) {
        return activityRepository.findByKey(key);
    }

    private void checkIfActivityAlreadyExists(String key) {
        List<Activity> activityList = getActivityListByKey(key);
        if (!activityList.isEmpty()) {
            throw new ActivityException(ActivityError.ACTIVITY_ALREADY_EXISTS);
        }
    }

}
