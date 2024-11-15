package models;

import java.util.Collections;
import java.util.List;

public class User {
    protected String name;

    public void searchRooms(List<Room> rooms, double maxPrice) {
        System.out.println("Доступные номера по заданным критериям:");
        for (Room room : rooms) {
            if (room.getPrice() <= maxPrice) {
                System.out.println(room);
            }
        }
    }

    public boolean bookRoom(List<Booking> bookings, Room room) {
        Booking booking = new Booking(room);
        booking.setUser(this);
        room.setReservation(true);
        bookings.addAll(Collections.singletonList(booking));
        System.out.println("Номер " + room.getName() + " забронирован.");
        return true;
    }

    public void freeRooms(List<Room> rooms){
        System.out.println("Свободные комнаты:");
        rooms.stream().filter(room -> !room.isReservation()).forEach(System.out::println);
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
