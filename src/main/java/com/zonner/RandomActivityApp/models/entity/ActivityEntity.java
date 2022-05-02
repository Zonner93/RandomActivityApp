package com.zonner.RandomActivityApp.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "activities")
public class ActivityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String activity;
    private String activityType;
    private int participants;
    private double price;
    private String link;
    private String activityKey;
    private double accessibility;
}
