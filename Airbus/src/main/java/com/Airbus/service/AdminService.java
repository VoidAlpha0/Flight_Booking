package com.Airbus.service;

import java.util.List;

import com.Airbus.entity.Admin;
import com.Airbus.entity.BookingDetails;
import com.Airbus.entity.BusDetails;
import com.Airbus.entity.Passenger;
import com.Airbus.utils.AdminAuth;

public interface AdminService {
	public Admin addAdmin(Admin admin); //adding admin

	public Admin getAdmin(Integer adminId);
	
	public Admin findByadminUName(String adminUname);

	public void deleteAdmin(Integer adminId);

	public Admin adminLogin(AdminAuth auth);

	public List<BusDetails> getAllBusDetails();

	public BusDetails addBusDetails(BusDetails details);

	public void deleteBus(Integer busNumber);

	public BusDetails updateBus(BusDetails details);
	
	public List<Passenger> getAllPassengers();
	
	public List<Passenger> getPassengersByBooking(Integer id);
	
	public List<BookingDetails> getAllBookings();
	
	public BookingDetails updatebooking (BookingDetails details);
	
	public void updatebookingbyid (Integer bookingid);
	
	public BusDetails getBusById(Integer id);

}