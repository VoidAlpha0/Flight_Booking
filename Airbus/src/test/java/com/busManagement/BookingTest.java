package com.busManagement;
import static org.mockito.Mockito.when;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/*import com.Airbus.Dao.BookingDetailsDao;
import com.Airbus.Dao.UserDao;
import com.Airbus.entity.BookingDetails;
import com.Airbus.entity.User;
import com.Airbus.exception.UserDoesnotExistException;
import com.Airbus.service.UserService;*/

@SpringBootTest
public class BookingTest {
 /*   
    @MockBean
    private BookingDetailsDao bookingDetailsDao;

    @MockBean
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Test
    public void testAddBooking() {
        // Mock data
        int userId = 1; 
        BookingDetails booking = new BookingDetails();

        // Mock the repository methods
        when(userDao.findById(userId)).thenReturn(Optional.empty());

        // Verify that the service method throws UserDoesnotExistException
        assertThrows(UserDoesnotExistException.class, () -> userService.addBooking(booking, userId, 123)); 
    }
    
    @Test
    public void testDeleteBooking() {
        // Mock data
        int userId = 1;
        int bookingId = 999; 

        // Mock the repository methods
        User user = new User();
        user.setUserId(userId);
        when(userDao.findById(userId)).thenReturn(Optional.of(user));
        when(bookingDetailsDao.findById(bookingId)).thenReturn(Optional.empty());

        // Verify that the service method throws UserDoesnotExistException
        assertThrows(UserDoesnotExistException.class, () -> userService.deleteBooking(bookingId, userId));
    }*/
}