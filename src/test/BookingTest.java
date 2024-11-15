package test;

import models.Booking;
import models.Room;
import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith({MockitoExtension.class})
public class BookingTest {

    @InjectMocks
    private static User user;

    @BeforeEach
    void setUp() {
        user = mock(User.class);
    }

    @Test
    void testBookingCreation() {
        Room room = mock(Room.class);
        Booking booking = mock(Booking.class);
        booking.setUser(user);
        when(booking.getRoom()).thenReturn(room);

        assertEquals(booking.getRoom(), room);
        assertNull(booking.getUser());

        verify(booking).setUser(user);
    }
}

