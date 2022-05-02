package com.zonner.RandomActivityApp.models.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
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

    public ActivityEntity(String activity, String activityType, int participants, double price, String link, String activityKey, double accessibility) {
        this.activity = activity;
        this.activityType = activityType;
        this.participants = participants;
        this.price = price;
        this.link = link;
        this.activityKey = activityKey;
        this.accessibility = accessibility;
    }
}
