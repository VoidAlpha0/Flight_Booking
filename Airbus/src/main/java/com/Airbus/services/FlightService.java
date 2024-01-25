package com.Airbus.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Airbus.Dao.FlightDao;
import com.Airbus.entity.Flight;



@Service
@Transactional
public class FlightService {
	
	@Autowired
	FlightDao flightdao;
	
	public Flight addFlight(Flight flight) {
	    
    	return flightdao.save(flight);
}


public List<Flight> findAllFlights() {
    return flightdao.findAll();
}

public Flight findFlightbyID(Integer id) {
	Optional<Flight> flgt= flightdao.findById(id);
	Flight flight= flgt.get();
	return flight;
	
}

}
