package com.nagarro.remotelearning;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EventManagementAppTest {

    private EventManagementApp eventApp;

    @Before
    public void setUp() {

        eventApp = new EventManagementApp();
    }

    @Test
    public void testListEventsNextWeekend() {

        LocalDateTime startNextWeekend = LocalDate.now().plusDays(6 - LocalDate.now().getDayOfWeek().getValue())
                .atTime(LocalTime.NOON);
        LocalDateTime endNextWeekend = startNextWeekend.plusHours(1);
        Event event1 = new Event("Meeting 1", "Room 1", startNextWeekend, endNextWeekend);
        eventApp.addEvent(event1);

        List<Event> events = eventApp.listEventsNextWeekend();

        assertEquals(event1, events.get(0));
    }

    @Test
    public void testGetEventsOnDateAdjusted() {

        LocalDateTime startDateTime = LocalDateTime.of(2024, 4, 15, 10, 0);
        LocalDateTime endDateTime = LocalDateTime.of(2024, 4, 15, 11, 0);
        Event event = new Event("Meeting", "Conference Room", startDateTime, endDateTime);
        eventApp.addEvent(event);

        LocalDate date = LocalDate.of(2024, 4, 15);
        ZoneId targetZone = ZoneId.of("America/New_York");
        List<Event> events = eventApp.getEventsOnDateAdjusted(date, targetZone);

        Event adjustedEvent = events.get(0);
        LocalDateTime expectedStartDateTime = LocalDateTime.of(2024, 4, 15, 3, 0);
        LocalDateTime expectedEndDateTime = LocalDateTime.of(2024, 4, 15, 4, 0);

        assertEquals(expectedStartDateTime, adjustedEvent.getStartDateTime());
        assertEquals(expectedEndDateTime, adjustedEvent.getEndDateTime());
    }

    @Test
    public void testListEventsByInterval() {

        LocalDateTime startDateTime = LocalDateTime.of(2024, 4, 20, 10, 0);
        LocalDateTime endDateTime = LocalDateTime.of(2024, 4, 20, 12, 0);
        Event event1 = new Event("Meeting 1", "Room 1", startDateTime, endDateTime);
        eventApp.addEvent(event1);

        LocalDateTime startDateTime2 = LocalDateTime.of(2024, 4, 20, 13, 0);
        LocalDateTime endDateTime2 = LocalDateTime.of(2024, 4, 20, 14, 0);
        Event event2 = new Event("Meeting 2", "Room 2", startDateTime2, endDateTime2);
        eventApp.addEvent(event2);

        LocalDateTime intervalStart = LocalDateTime.of(2024, 4, 20, 9, 0);
        LocalDateTime intervalEnd = LocalDateTime.of(2024, 4, 20, 15, 0);

        List<Event> events = eventApp.listEventsByInterval(intervalStart, intervalEnd);

        assertEquals(events.get(0), event1);
        assertEquals(events.get(1), event2);
    }
}
