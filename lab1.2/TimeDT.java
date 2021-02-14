package com.company;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeDT {
    private int hours;
    private int minutes;
    private int seconds;

    public TimeDT() {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }

    public TimeDT(int hours, int minutes, int seconds) {
        if (hours >= 0 && hours < 24) {
            this.hours = hours;
        } else if (minutes >= 0 && minutes < 60) {
            this.minutes = minutes;
        } else if (seconds >= 0 && seconds < 60) {
            this.seconds = seconds;
        } else {
            throw new IllegalArgumentException("Incorrect time input");
        }
    }

    public TimeDT(Date date) {
        if (date != null) {
            this.hours = date.getHours();
            this.minutes = date.getMinutes();
            this.seconds = date.getSeconds();
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss aa");
        Date date = null;
        try {
            date = dateFormat.parse(String.valueOf(dateFormat));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dateFormat.format(date);
    }

    public static TimeDT summation(TimeDT tm) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(calendar.getTime());
        calendar.add(Calendar.HOUR, tm.getHours());
        calendar.add(Calendar.MINUTE, tm.getMinutes());
        calendar.add(Calendar.SECOND, tm.getSeconds());
        return new TimeDT(calendar.getTime());
    }

    public TimeDT negation(TimeDT tm) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(calendar.getTime());
        calendar.add(Calendar.HOUR, -tm.getHours());
        calendar.add(Calendar.MINUTE, -tm.getMinutes());
        calendar.add(Calendar.SECOND, -tm.getSeconds());
        return new TimeDT(calendar.getTime());
    }

    public TimeDT retSum(TimeDT tm1, TimeDT tm2) {
        return tm1.summation(tm2);
    }

    public TimeDT retNeg(TimeDT tm1, TimeDT tm2) {
        return tm1.negation(tm2);
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
}
