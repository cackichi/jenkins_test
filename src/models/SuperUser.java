package models;

import java.util.List;

public class SuperUser extends User{
    public SuperUser(String name) {
        super(name);
    }

    public void addRoom(List<Room> rooms, Room room) {
        rooms.add(room);
        System.out.println("Номер " + room.getName() + " добавлен.");
    }

    public void editRoom(Room room, String newName, double newPrice) {
        room.setName(newName);
        room.setPrice(newPrice);
        System.out.println("Информация о номере обновлена: " + room);
    }
}
