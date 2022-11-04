package com.hyoretsu.rental.entities;

import com.hyoretsu.rental.utils.Category;

public abstract class Item {
    protected Integer category;
    protected String title;
    protected String type;

    public Item(String title, String type) {
        this.category = Category.NORMAL;
        this.title = title;
        this.type = type;
    }

    public Item(String title, Integer category, String type) {
        this.category = category;
        this.title = title;
        this.type = type;
    }

    public Integer getCategory() {
        return this.category;
    }

    public String getTitle() {
        return this.title;
    }

    public String getType() {
        return this.type;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public abstract Double calculatePrice(Integer rentedDays);
}
