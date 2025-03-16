package org.tel.ran._2025_03_14.summary07;

public enum OrderStatus {
    NEW,
    PROCESSING,
    SHIPPED,
    DELIVERED,
    CANCELED;

    public OrderStatus next(){
        return switch (this){
            case NEW -> PROCESSING;
            case PROCESSING -> SHIPPED;
            case SHIPPED -> DELIVERED;
            default ->  this;
        };
    }


}
