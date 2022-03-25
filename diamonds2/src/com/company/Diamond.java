package com.company;

public class Diamond {
    private final int id;
    private final double carat;
    private final String cut;
    private final String color;
    private final String clarity;
    private final double depth;
    private final double table;
    private final int price;
    private final double x;
    private final double y;
    private final double z;

    public Diamond(int id, double carat, String cut, String color, String clarity, double depth, double table, int price, double x, double y, double z) {
        this.id = id;
        this.carat = carat;
        this.cut = cut;
        this.color = color;
        this.clarity = clarity;
        this.depth = depth;
        this.table = table;
        this.price = price;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getId() {
        return id;
    }

    public double getCarat() {
        return carat;
    }

    public String getCut() {
        return cut;
    }

    public String getColor() {
        return color;
    }

    public String getClarity() {
        return clarity;
    }

    public double getDepth() {
        return depth;
    }

    public double getTable() {
        return table;
    }

    public int getPrice() {
        return price;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
}
