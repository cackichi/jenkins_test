package models;

import java.util.List;
import java.util.stream.Collectors;

@reflection.Administrator
public class Administrator extends SuperUser{
    public Administrator(String name) {
        super(name);
    }

    public void cancelBooking(List<Booking> bookings, int bookingId) {
        bookings.stream().filter(booking -> booking.getId() == bookingId)
                .forEach(booking -> booking.getRoom().setReservation(false));
        bookings.removeIf(booking -> booking.getId() == bookingId);
        System.out.println("Бронирование с ID " + bookingId + " отменено.");
    }

    public void deleteAccount(List<User> users, List<Booking> bookings, String username) {
        List<Booking> bookingsToRemove = bookings.stream()
                .filter(booking -> booking.getUser().getName().equals(username))
                .collect(Collectors.toList());

        for (Booking booking : bookingsToRemove) {
            booking.getRoom().setReservation(false);
            bookings.remove(booking);
        }
        users.removeIf(user -> user.getName().equals(username));
        System.out.println("Учетная запись " + username + " удалена.");
    }

    public void viewAllBookings(List<Booking> bookings) {
        System.out.println("Просмотр всех бронирований:");
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }

    public void editSession(User user, String newUsername){
        user.setName(newUsername);
        System.out.println("Имя пользователя заменено на - " + newUsername);
    }
}
