package com.zonner.RandomActivityApp.repository;

import com.zonner.RandomActivityApp.models.entity.ActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<ActivityEntity, Long> {
    List<ActivityEntity> findByActivityKey(String activityKey);
}
