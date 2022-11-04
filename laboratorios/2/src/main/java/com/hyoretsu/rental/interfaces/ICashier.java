package com.hyoretsu.rental.interfaces;

import java.util.List;

import com.hyoretsu.rental.entities.Client;
import com.hyoretsu.rental.entities.Rental;

public interface ICashier {
    void addClient(Client client);

    Integer calculateLoyaltyPoints(List<Rental> rentals);

    Double calculateTotal(List<Rental> rentals);

    String extract(String name);
}
