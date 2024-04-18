package com.nagarro.remotelearning;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.List;

public class Main {
    private static final EventManagementApp eventManager = new EventManagementApp();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Event Management Application");
            System.out.println("1. Add Event");
            System.out.println("2. List Events Next Weekend");
            System.out.println("3. List Events on Date");
            System.out.println("4. List Events by Interval");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addEvent();
                    break;
                case 2:
                    listEventsNextWeekend();
                    break;
                case 3:
                    listEventsOnDate();
                    break;
                case 4:
                    listEventsByInterval();
                    break;
                case 5:
                    System.out.println("Exiting the application...");
                    scanner.close();
                    return; // exit the method and terminate the program
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    private static void addEvent() {
        System.out.println("Add Event");
        System.out.print("Enter event summary: ");
        String summary = scanner.nextLine();
        System.out.print("Enter event location (optional): ");
        String location = scanner.nextLine();
        System.out.print("Enter start date and time (yyyy-MM-dd HH:mm): ");
        LocalDateTime startDateTime = LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        System.out.print("Enter end date and time (yyyy-MM-dd HH:mm): ");
        LocalDateTime endDateTime = LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        Event event = new Event(summary, location, startDateTime, endDateTime);
        eventManager.addEvent(event);
        System.out.println("Event added successfully!");
    }

    private static void listEventsNextWeekend() {
        System.out.println("Events Next Weekend");
        for (Event event : eventManager.listEventsNextWeekend()) {
            System.out.println(event);
        }
    }

    private static void listEventsOnDate() {
        System.out.print("Enter date (yyyy-MM-dd): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());
        System.out.print("Enter target time zone (e.g., America/New_York): ");
        ZoneId targetZone = ZoneId.of(scanner.nextLine());

        System.out.println("Events on " + date + " adjusted to " + targetZone + ":");
        for (Event event : eventManager.getEventsOnDateAdjusted(date, targetZone)) {
            System.out.println(event);
        }
    }

    private static void listEventsByInterval() {
        System.out.print("Enter start date and time of the interval (yyyy-MM-dd HH:mm): ");
        LocalDateTime startDateTime = LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        System.out.print("Enter end date and time of the interval (yyyy-MM-dd HH:mm): ");
        LocalDateTime endDateTime = LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        List<Event> eventsInInterval = eventManager.listEventsByInterval(startDateTime, endDateTime);

        System.out.println("Events within the interval:");
        for (Event event : eventsInInterval) {
            System.out.println(event);
        }
    }
}
