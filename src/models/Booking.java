package models;

public class Booking {
    private static int idCounter = 1;
    private int id;
    private User user;
    private Room room;

    public Booking() {
    }

    public Booking(Room room) {
        this.id = idCounter++;
        this.room = room;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public Room getRoom() {
        return room;
    }

    @Override
    public String toString() {
        return "Booking{id=" + id + ", room=" + room + ", user= " + user + '}';
    }
}
