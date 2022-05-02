package com.zonner.RandomActivityApp.repository;

import com.zonner.RandomActivityApp.models.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findByKey(String key);
}
