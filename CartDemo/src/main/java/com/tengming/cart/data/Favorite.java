package com.tengming.cart.data;

public class Favorite {
    String name;
    Long id;
    String level;
    String desc;
    int price;

    public Favorite(String name, Long id, String level, String desc, int price) {
        this.name = name;
        this.id = id;
        this.level = level;
        this.desc = desc;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
