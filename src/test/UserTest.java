package test;

import models.Booking;
import models.Room;
import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@ExtendWith({MockitoExtension.class})
public class UserTest {

    @InjectMocks
    private static Room room;

    @BeforeEach
    void setUp() {
        room = mock(Room.class);
    }

    @Test
    void testSearchRooms() {
        User user = new User("TestUser");
        List<Room> rooms = Arrays.asList(room);

        when(room.getPrice()).thenReturn(100.0);

        user.searchRooms(rooms, 150.0);

        verify(room).getPrice();
    }

    @Test
    void testBookRoom() {
        User user = new User("TestUser");
        room = mock(Room.class);

        when(room.getName()).thenReturn("Room101");

        List<Booking> bookings = new ArrayList<>();
        boolean result = user.bookRoom(bookings, room);

        verify(room).setReservation(true);
        assertTrue(result);
    }

    @Test
    void testFreeRooms() {
        User user = new User("TestUser");
        room = mock(Room.class);

        when(room.isReservation()).thenReturn(false);

        List<Room> rooms = Collections.singletonList(room);

        user.freeRooms(rooms);

        verify(room).isReservation();
    }
}
