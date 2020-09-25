package com.bjpowernode.domain;

public class Goods {
    private Integer id;
    private String name;
    private Integer amount;
    private Float price;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAmount() {
        return amount;
    }

    public Float getPrice() {
        return price;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
