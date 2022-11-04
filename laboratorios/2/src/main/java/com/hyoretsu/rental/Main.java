package com.hyoretsu.rental;

import java.util.Arrays;
import java.util.List;

import com.hyoretsu.rental.entities.Client;
import com.hyoretsu.rental.entities.Rental;
import com.hyoretsu.rental.entities.Tape;
import com.hyoretsu.rental.utils.Category;

public class Main {
    public static void main(String[] args) {
        Client client1 = new Client("Claudisnéia");

        List<Tape> tapes = Arrays.asList(new Tape("O Exorcista                "),
                new Tape("Men in Black                  "),
                new Tape("Jurassic Park III             ", Category.NEW),
                new Tape("Planeta dos Macacos           ", Category.NEW),
                new Tape("Pateta no Planeta dos Macacos ", Category.CHILDREN),
                new Tape("O Rei Leão                    ", Category.CHILDREN));
        List<Integer> rentedDays = Arrays.asList(3, 2, 3, 4, 10, 30);

        for (int i = 0; i < tapes.size(); i++) {
            Rental rental = new Rental(tapes.get(i), rentedDays.get(i));

            client1.addRental(rental);
        }

        Cashier cashier = new Cashier();
        cashier.addClient(client1);

        System.out.println(cashier.extract(client1.getName()));
    }
}
