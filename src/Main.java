import models.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        List<Room> rooms = new ArrayList<>();
        List<Booking> bookings = new ArrayList<>();

        Administrator admin = new Administrator("Adminchik");
        SuperUser superUser = new SuperUser("SuperUser");
        User user1 = new User("User1");
        User user2 = new User("User2");

        users.add(admin);
        users.add(superUser);
        users.add(user1);
        users.add(user2);

        for (User user : users) {
            String name;
            Class<?> clazz = user.getClass();
            if(clazz.isAnnotationPresent(reflection.Administrator.class)){
                try {
                    Field field = User.class.getDeclaredField("name");
                    field.setAccessible(true);
                    name = (String) field.get(user);
                } catch (NoSuchFieldException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Пользователь с именем " + name + " является Администратором");
                System.out.println();
            };
        }

        superUser.addRoom(rooms, new Room("Deluxe Room", 150.0));
        superUser.addRoom(rooms, new Room("Standard Room", 100.0));
        superUser.addRoom(rooms, new Room("Suite Room", 200.0));

        user1.bookRoom(bookings, rooms.get(0));

        user1.freeRooms(rooms);

        user2.bookRoom(bookings, rooms.get(1));

        admin.viewAllBookings(bookings);

        admin.cancelBooking(bookings, 2);

        admin.deleteAccount(users, bookings, "User1");

        superUser.editRoom(rooms.get(2), "Presidential Suite", 250.0);

        System.out.println("\nСписок всех пользователей:");
        for (User user : users) {
            System.out.println(user.getName());
        }

        System.out.println("\nСписок всех номеров:");
        for (Room room : rooms) {
            System.out.println(room);
        }
    }
}