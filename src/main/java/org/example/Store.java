package org.example;

import java.time.LocalTime;
import java.util.LinkedList;

public class Store {

    LinkedList< Pickers > pickers = new LinkedList < > ();
    private LocalTime pickingStartTime;
    private LocalTime pickingEndTime;

    public LinkedList<Pickers> getPickers() {
        return pickers;
    }

    public void setPickers(LinkedList<Pickers> pickers) {
        this.pickers = pickers;
    }

    public LocalTime getPickingStartTime() {
        return pickingStartTime;
    }

    public void setPickingStartTime(LocalTime pickingStartTime) {
        this.pickingStartTime = pickingStartTime;
    }

    public LocalTime getPickingEndTime() {
        return pickingEndTime;
    }

    public void setPickingEndTime(LocalTime pickingEndTime) {
        this.pickingEndTime = pickingEndTime;
    }

    @Override
    public String toString() {
        return "Store{" +
                "pickers=" + pickers +
                ", pickingStartTime='" + pickingStartTime + '\'' +
                ", pickingEndTime='" + pickingEndTime + '\'' +
                '}';
    }
}
