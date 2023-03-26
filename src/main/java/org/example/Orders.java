package org.example;

import java.time.Duration;
import java.time.LocalTime;

public class Orders {
    private String orderId;
    private String orderValue;
    private Duration pickingTime;
    private LocalTime completeBy;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(String orderValue) {
        this.orderValue = orderValue;
    }

    public Duration getPickingTime() {
        return pickingTime;
    }

    public void setPickingTime(Duration pickingTime) {
        this.pickingTime = pickingTime;
    }

    public LocalTime getCompleteBy() {
        return completeBy;
    }

    public void setCompleteBy(LocalTime completeBy) {
        this.completeBy = completeBy;
    }
//    public Duration getDut(){
//        return Duration.parse(pickingTime);
//    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId='" + orderId + '\'' +
                ", orderValue='" + orderValue + '\'' +
                ", pickingTime='"  + pickingTime + '\'' +
                ", completeBy='" + completeBy + '\''  +
                '}'+ '\n';
    }
}
