package com.zonner.RandomActivityApp.builder;

import com.zonner.RandomActivityApp.models.entity.dto.ActivityDtoOutput;

public class ActivityDtoOutputBuilder {
    private String activity;
    private String type;
    private int participants;
    private double price;
    private String link;
    private String key;
    private double accessibility;

    public ActivityDtoOutputBuilder withActivity(String activity) {
        this.activity = activity;
        return this;
    }

    public ActivityDtoOutputBuilder withType(String type) {
        this.type = type;
        return this;
    }

    public ActivityDtoOutputBuilder withParticipants(int participants) {
        this.participants = participants;
        return this;
    }

    public ActivityDtoOutputBuilder withPrice(double price) {
        this.price = price;
        return this;
    }

    public ActivityDtoOutputBuilder withLink(String link) {
        this.link = link;
        return this;
    }

    public ActivityDtoOutputBuilder withKey(String key) {
        this.key = key;
        return this;
    }

    public ActivityDtoOutputBuilder withAccessibility(double accessibility) {
        this.accessibility = accessibility;
        return this;
    }

    public ActivityDtoOutput build() {
        ActivityDtoOutput activityDtoOutput = new ActivityDtoOutput();
        activityDtoOutput.setActivity(activity);
        activityDtoOutput.setType(type);
        activityDtoOutput.setParticipants(participants);
        activityDtoOutput.setPrice(price);
        activityDtoOutput.setLink(link);
        activityDtoOutput.setKey(key);
        activityDtoOutput.setAccessibility(accessibility);
        return activityDtoOutput;
    }
}
