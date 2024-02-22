package com.nagarro.remotelearning.util;

import java.util.Calendar;
import java.util.Date;

enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

enum Month {
    JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
}

public class DateConverter {

    public  void printDateInfo(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int year = calendar.get(Calendar.YEAR);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int monthOfYear = calendar.get(Calendar.MONTH);

        Day dayEnum = Day.values()[dayOfWeek - 1];
        Month monthEnum = Month.values()[monthOfYear];

        System.out.println("Day: " + dayEnum);
        System.out.println("Month: " + monthEnum);
        System.out.println("Year: " + year);
    }
}
