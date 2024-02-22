package com.nagarro.remotelearning.main;

import com.nagarro.remotelearning.util.DateConverter;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {

        Calendar myCalendar = new GregorianCalendar(2014, 3, 11);
        Date date = myCalendar.getTime();

        DateConverter dateConverter = new DateConverter();

        dateConverter.printDateInfo(date);
    }
}