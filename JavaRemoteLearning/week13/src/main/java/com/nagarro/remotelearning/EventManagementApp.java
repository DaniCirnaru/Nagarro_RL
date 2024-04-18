package com.nagarro.remotelearning;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventManagementApp {

    private final List<Event> eventList=new ArrayList<>();


    public void addEvent(Event event){
        eventList.add(event);
    }

    public List<Event> listEventsNextWeekend() {

        LocalDateTime startNextWeekendDateTime = LocalDate.now()
                .plusDays(6 - LocalDate.now().getDayOfWeek().getValue())
                .atStartOfDay();

        LocalDateTime endNextWeekendDateTime = LocalDate.now()
                .plusDays(6 - LocalDate.now().getDayOfWeek().getValue() + 1)
                .atTime(LocalTime.of(23, 59, 59));

        List<Event> nextWeekendEvents = new ArrayList<>();

        addWeekendEvents(startNextWeekendDateTime, endNextWeekendDateTime, nextWeekendEvents);

        return nextWeekendEvents;
    }

    private void addWeekendEvents(LocalDateTime startNextWeekendDateTime, LocalDateTime endNextWeekendDateTime, List<Event> nextWeekendEvents) {
        for (Event event : eventList) {
            LocalDateTime eventStart = event.getStartDateTime();
            LocalDateTime eventEnd = event.getEndDateTime();

            if (eventOccursInWeekend(startNextWeekendDateTime, endNextWeekendDateTime, eventStart, eventEnd)) {
                nextWeekendEvents.add(event);
            }
        }
    }

    private static boolean eventOccursInWeekend(LocalDateTime startNextWeekendDateTime, LocalDateTime endNextWeekendDateTime, LocalDateTime eventStart, LocalDateTime eventEnd) {
        return (eventStart.isEqual(startNextWeekendDateTime) || eventStart.isAfter(startNextWeekendDateTime)) &&
                (eventEnd.isEqual(endNextWeekendDateTime) || eventEnd.isBefore(endNextWeekendDateTime) ||
                        eventEnd.equals(endNextWeekendDateTime));
    }


    public List<Event> getEventsOnDateAdjusted(LocalDate date, ZoneId targetZone) {
        List<Event> adjustedEvents = new ArrayList<>();
        for (Event event : eventList) {
            // Convert event startDateTime and endDateTime to the given targetZone
            LocalDateTime startDateTime = event.getStartDateTime().atZone(ZoneId.systemDefault()).withZoneSameInstant(targetZone).toLocalDateTime();
            LocalDateTime endDateTime = event.getEndDateTime().atZone(ZoneId.systemDefault()).withZoneSameInstant(targetZone).toLocalDateTime();

            // Check if the date from startDateTime is equal to the provided date
            if (startDateTime.toLocalDate().isEqual(date) || endDateTime.toLocalDate().isEqual(date)) {
                // Create a new Event with adjusted time zone
                Event adjustedEvent = new Event(event.getSummary(),event.getLocation(), startDateTime, endDateTime);
                adjustedEvents.add(adjustedEvent);
            }
        }
        return adjustedEvents;
    }



    public List<Event> listEventsByInterval(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        List<Event> eventsInInterval = new ArrayList<>();
        addEventsInInterval(startDateTime, endDateTime, eventsInInterval);
        return eventsInInterval;
    }

    private void addEventsInInterval(LocalDateTime startDateTime, LocalDateTime endDateTime, List<Event> eventsInInterval) {
        for (Event event : eventList) {
            if ((event.getStartDateTime().isAfter(startDateTime) || event.getStartDateTime().isEqual(startDateTime)) &&
                    (event.getEndDateTime().isBefore(endDateTime) || event.getEndDateTime().isEqual(endDateTime))) {
                eventsInInterval.add(event);
            }
        }
    }


}
