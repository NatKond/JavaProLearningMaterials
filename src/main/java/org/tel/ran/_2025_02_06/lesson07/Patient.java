package org.tel.ran._2025_02_06.lesson07;

import java.time.LocalDateTime;
import java.util.Date;

public class Patient implements Comparable{

    private LocalDateTime timeOfArrival;

    public Patient(LocalDateTime timeOfArrival) {
        this.timeOfArrival = timeOfArrival;
    }

    @Override
    public String toString() {
        return "Patient(" +
                "date: " + timeOfArrival.getDayOfMonth() + " " + timeOfArrival.getMonth().toString().substring(0,3) +
                ", time: "  + timeOfArrival.getHour() + ":" + timeOfArrival.getMinute()+
                ')';
    }

    @Override
    public int compareTo(Object o) {
        Patient that = (Patient) o;
        return this.timeOfArrival.compareTo(that.timeOfArrival);
    }
}
