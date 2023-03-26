package org.example;

import java.time.LocalTime;

public class Pickers {
    private String name;
    private LocalTime actualTime;


    public Pickers(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getActualTime() {
        return actualTime;
    }

    public void setActualTime(LocalTime actualTime) {
        this.actualTime = actualTime;
    }

    @Override
    public String toString() {
        return  name;
    }
}
