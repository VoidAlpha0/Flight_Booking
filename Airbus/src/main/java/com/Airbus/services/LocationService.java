package com.Airbus.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Airbus.Dao.LocationDao;
import com.Airbus.Dao.UserDao;
import com.Airbus.entity.Location;
import com.Airbus.entity.User;

@Service
@Transactional
public class LocationService {
	
	@Autowired
	LocationDao locationdao;
	
	public Location addLocation(Location location) {
	    
	    	return locationdao.save(location);
	}


	public List<Location> findAllLocations() {
	    return locationdao.findAll();
	}
	
	public Location findLocationbyID(Integer id) {
		Optional<Location> loc= locationdao.findById(id);
		Location location= loc.get();
		return location;
	}
	

}
