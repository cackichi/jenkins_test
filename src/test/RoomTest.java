package test;
import models.Booking;
import models.Room;
import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith({MockitoExtension.class})
public class RoomTest {

    @InjectMocks
    private static User user;

    @BeforeEach
    void setUp() {
        user = mock(User.class);
    }

    @Test
    void testReservation() {
        Room room = new Room("Room101", 100.0);

        assertFalse(room.isReservation());

        List<Booking> bookings = new ArrayList<>();
        user.bookRoom(bookings, room);

        verify(user).bookRoom(anyList(), eq(room));
        assertTrue(room.isReservation());
    }
}

