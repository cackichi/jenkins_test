package models;

public class Room {
    private static int idCounter = 1;
    private int id;
    private String name;

    private boolean isReservation = false;
    private double price;

    public Room(String name, double price) {
        this.id = idCounter++;
        this.name = name;
        this.price = price;
    }

    public Room() {
    }

    public boolean isReservation() {
        return isReservation;
    }

    public void setReservation(boolean reservation) {
        isReservation = reservation;
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

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room{id=" + id + ", name='" + name + "', price=" + price +  ", reserv = " + isReservation + '}';
    }
}
