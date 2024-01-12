package com.Airbus.serviceImpl;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Airbus.Dao.LocationDao;
import com.Airbus.entity.Admin;
import com.Airbus.entity.Location;
import com.Airbus.exception.AdminDoesnotExistException;
import com.Airbus.exception.NullAdminException;
import com.Airbus.exception.NullBusDetailsException;
import com.Airbus.exception.NullUserException;
@Service
public class LocationServiceImpl {
	
	@Autowired
	LocationDao serve;
	public Location addLocation(@Valid Location loc) {
		if (loc == null)
			throw new NullUserException("Please Enter Data");
		else {
			serve.save(loc);
			System.out.println("user Added Successfully");
			return loc;
		}
	}
	public Location updateLocation(@Valid Location loc,long id) {
		if(serve.findById(id).isPresent()) {
			Location oldLoc = serve.findById(id).get();
			oldLoc.setTerminal(loc.getTerminal());
			oldLoc.setCity(loc.getCity());
			oldLoc.setState(loc.getState());
			return serve.save(oldLoc);
		}
		else {
		return null;
		}
	}
	public List<Location> getAllLocations() {
		return serve.findAll();
	}
	
	public void deleteLocation(Long id) {
			if ( id == null )
				throw new NullBusDetailsException("Please Enter Data");
			else if(serve.findById(id).isPresent() != true) {
				throw new NullPointerException("Location Details Not Found");
			}
			else {
				serve.deleteById(id);
			}
		}
	public Location getLocation(Long id) {
		
		if (id == null)
			throw new NullAdminException("Please Enter Data");
		Optional<Location> loc = serve.findById(id);
		if (!loc.isPresent()) {
			throw new AdminDoesnotExistException("admin does not exist ");
		}
		return loc.get();
	}
}