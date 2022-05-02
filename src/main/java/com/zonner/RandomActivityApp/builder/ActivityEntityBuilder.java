package com.zonner.RandomActivityApp.builder;

import com.zonner.RandomActivityApp.models.entity.ActivityEntity;

public class ActivityEntityBuilder {
    private String activity;
    private String type;
    private int participants;
    private double price;
    private String link;
    private String key;
    private double accessibility;

    public ActivityEntityBuilder withActivity(String activity) {
        this.activity = activity;
        return this;
    }

    public ActivityEntityBuilder withType(String type) {
        this.type = type;
        return this;
    }

    public ActivityEntityBuilder withParticipants(int participants) {
        this.participants = participants;
        return this;
    }

    public ActivityEntityBuilder withPrice(double price) {
        this.price = price;
        return this;
    }

    public ActivityEntityBuilder withLink(String link) {
        this.link = link;
        return this;
    }

    public ActivityEntityBuilder withKey(String key) {
        this.key = key;
        return this;
    }

    public ActivityEntityBuilder withAccessibility(double accessibility) {
        this.accessibility = accessibility;
        return this;
    }

    public ActivityEntity build() {
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setActivity(activity);
        activityEntity.setType(type);
        activityEntity.setParticipants(participants);
        activityEntity.setPrice(price);
        activityEntity.setLink(link);
        activityEntity.setKey(key);
        activityEntity.setAccessibility(accessibility);
        return activityEntity;
    }
}
