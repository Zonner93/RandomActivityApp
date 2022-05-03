package com.zonner.RandomActivityApp.exceptions.Activity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ActivityError {
    ACTIVITY_NOT_FOUND("Activity does not exists"),
    ACTIVITY_ALREADY_EXISTS("Activity does already exists");
    private final String message;
}
