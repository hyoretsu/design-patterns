package com.hyoretsu.rental.entities;

import com.hyoretsu.rental.utils.Category;
import com.hyoretsu.rental.utils.Type;

public class Tape extends Item {
    public Tape(String title) {
        super(title, Type.TAPE);
    }

    public Tape(String title, Integer category) {
        super(title, category, Type.TAPE);
    }

    public Double calculatePrice(Integer rentedDays) {
        double currentValue = 0.0;

        switch (this.category) {
            case Category.NORMAL:
                currentValue += 2;
                if (rentedDays > 2) {
                    currentValue += (rentedDays - 2) * 1.5;
                }

                break;
            case Category.NEW:
                currentValue += rentedDays * 3;

                break;
            case Category.CHILDREN:
                currentValue += 1.5;
                if (rentedDays > 3) {
                    currentValue += (rentedDays - 3) * 1.5;
                }

                break;
        }

        return currentValue;
    }
}
