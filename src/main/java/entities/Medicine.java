package entities;

import java.time.LocalDate;

public class Medicine {
    private int id;
    private double price;
    private String name;
    private LocalDate expiration;
    private String manufac;

    public Medicine() {}

    public Medicine(String name, double price, LocalDate expiration, String manufac) {
        this.name = name;
        this.price = price;
        this.expiration = expiration;
        this.manufac = manufac;
    }

    public Medicine(int id, String name, double price, LocalDate expiration, String manufac) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.expiration = expiration;
        this.manufac = manufac;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) { this.price = price; }

    public LocalDate getExpiration() { return expiration; }

    public void setExpiration(LocalDate expiration) { this.expiration = expiration; }

    public String getManufac() { return manufac; }

    public void setManufac(String manufac) { this.manufac = manufac; }

    @Override
    public String toString() {
        return "Medicine{num =" + this.id + ", cash =" + this.price + ", name ='" + this.name + "', expiration =" + this.expiration + ", manufacture ='" + this.manufac + "'}";
    }
}
