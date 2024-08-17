package ru.trial.assignments.urlshortener.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TimeCheck {

    public static String getTimeStamp() {
        long timeStamp = System.currentTimeMillis();

        String start = String.valueOf(timeStamp);

        int sum = 0;
        for (int i = 0; i < start.length(); i++) {
            sum += Integer.parseInt(String.valueOf(start.charAt(i)));
        }

        return String.valueOf(sum);
    }
}
