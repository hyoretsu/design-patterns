package com.hyoretsu.rental.entities;

public class Rental {
    private Integer days;
    private Item item;

    public Rental(Item item, Integer rentedDays) {
        this.item = item;
        this.days = rentedDays;
    }

    public Integer getDays() {
        return days;
    }

    public Item getItem() {
        return item;
    }
}
