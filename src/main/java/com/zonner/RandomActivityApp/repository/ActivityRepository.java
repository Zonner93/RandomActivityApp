package com.zonner.RandomActivityApp.repository;

import com.zonner.RandomActivityApp.models.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findByKey(String key);
}
