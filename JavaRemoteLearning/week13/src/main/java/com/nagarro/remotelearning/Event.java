package com.nagarro.remotelearning;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event {
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String summary;
    private String location;


    public Event(String summary, String location, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        if (startDateTime.isAfter(endDateTime)) {
            throw new IllegalArgumentException("Start time cannot be after end time");
        }

        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.summary = summary;
        this.location = location;
    }

    public String getSummary() {
        return summary;
    }

    public String getLocation() {
        return location;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    @Override
    public String toString() {
        String locationStr = location != null ? "Location: " + location + "\n" : "";
        return "Summary: " + summary + "\n" +
                "Start: " + startDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n" +
                "End: " + endDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n"+
                locationStr ;
    }
}
