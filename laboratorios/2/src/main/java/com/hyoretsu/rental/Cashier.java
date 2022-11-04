package com.hyoretsu.rental;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hyoretsu.rental.entities.Client;
import com.hyoretsu.rental.entities.Rental;
import com.hyoretsu.rental.interfaces.ICashier;
import com.hyoretsu.rental.utils.Category;

public class Cashier implements ICashier {
    private Map<String, Double> details = new HashMap<String, Double>();
    private List<Client> clients = new ArrayList<Client>();

    public void addClient(Client client) {
        this.clients.add(client);
    }

    public Integer calculateLoyaltyPoints(List<Rental> rentals) {
        Integer loyaltyPoints = rentals.size();

        // Adiciona bônus para aluguel de um lançamento por pelo menos 2 dias
        for (Rental rental : rentals) {
            if (rental.getItem().getCategory() == Category.NEW && rental.getDays() >= 2) {
                loyaltyPoints += 1;
            }
        }

        return loyaltyPoints;
    }

    public Double calculateTotal(List<Rental> rentals) {
        Double totalValue = 0.0;

        for (Rental rental : rentals) {
            Double value = rental.getItem().calculatePrice(rental.getDays());

            this.details.put(rental.getItem().getTitle(), value);
            totalValue += value;
        }

        return totalValue;
    }

    public String extract(String name) {
        Client client = this.clients.stream().filter(c -> c.getName().equals(name)).findFirst().get();
        List<Rental> rentals = client.getRentals();

        String eol = System.getProperty("line.separator");

        String extract = "Registro de aluguéis de " + name + eol;
        for (Map.Entry<String, Double> entry : this.details.entrySet()) {
            // Add movie name and price
            extract += "\t" + entry.getKey() + "\t" + entry.getValue() + eol;
        }
        extract += "Valor total devido: " + this.calculateTotal(rentals) + eol;
        extract += "Você acumulou " + this.calculateLoyaltyPoints(rentals) + " pontos de alugador frequente";

        return extract;
    }
}
