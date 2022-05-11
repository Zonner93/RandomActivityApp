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
public class Activity {

    //TODO some of these variables might require some validation in setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //TODO why is this an Object? wouldn't long be enough? wouldn't int be enough?
    private Long id;
    private String activity;
    private String type;
    private int participants;
    private double price;
    private String link;
    private String key;
    private double accessibility;

    public Activity(String activity, String type, int participants, double price, String link, String key, double accessibility) {
        this.activity = activity;
        this.type = type;
        this.participants = participants;
        this.price = price;
        this.link = link;
        this.key = key;
        this.accessibility = accessibility;
    }
}
