package com.hyoretsu.rental.entities;

import java.util.ArrayList;
import java.util.List;

public class Client extends User {
    private List<Rental> rentals = new ArrayList<Rental>();

    public Client(String name) {
        super(name);
    }

    public void addRental(Rental Rent) {
        rentals.add(Rent);
    }

    public List<Rental> getRentals() {
        return rentals;
    }
}
