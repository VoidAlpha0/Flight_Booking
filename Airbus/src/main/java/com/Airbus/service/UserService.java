package com.Airbus.service;

import java.util.List;

import com.Airbus.entity.BookingDetails;
import com.Airbus.entity.BusDetails;
import com.Airbus.entity.Passenger;
import com.Airbus.entity.User;
import com.Airbus.utils.UserAuth;

public interface UserService {
	public User addUser(User user);

	public void updateUser(User user);

	public User getUser(Integer userId);

	public void deleteUser(Integer userId);

	public User userLogin(UserAuth auth);

	public BookingDetails addBooking(BookingDetails booking, Integer userId, Integer busNumber);

	public void deleteBooking(Integer bookingId, Integer userId);

	public List<BookingDetails> getBookingByUserId(Integer userId);

	public BusDetails findByRouteAndDate(String arrivalBusstop, String departureBusstop, String date);
	
	public BusDetails getBusByBusNumber(Integer busNumber);
	
	public Passenger updatePassenger(Passenger passenger);

	List<User> getAllUsers();
	
	public User getUserByuname(String uname);

	public User userLoginByuname(UserAuth auth);

}
