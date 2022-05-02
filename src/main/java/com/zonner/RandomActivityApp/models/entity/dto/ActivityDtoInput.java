package com.zonner.RandomActivityApp.models.entity.dto;

import lombok.Getter;

@Getter
public class ActivityDtoInput {
    private String activity;
    private String type;
    private int participants;
    private double price;
    private String link;
    private String key;
    private double accessibility;
}
