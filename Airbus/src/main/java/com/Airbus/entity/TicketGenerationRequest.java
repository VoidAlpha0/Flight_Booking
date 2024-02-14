package com.Airbus.entity;
import java.util.Optional;
import java.util.Set;
import java.util.*;
public class TicketGenerationRequest {
	 private LinkedHashSet<Optional<Passengers>> passengers;
	    private LinkedHashSet<Optional<Ticket>> tempseats;
		public LinkedHashSet<Optional<Passengers>> getPassengers() {
			return passengers;
		}
		public void setPassengers(LinkedHashSet<Optional<Passengers>> passengers) {
			this.passengers = passengers;
		}
		public LinkedHashSet<Optional<Ticket>> getTempseats() {
			return tempseats;
		}
		public void setTempseats(LinkedHashSet<Optional<Ticket>> tempseats) {
			this.tempseats = tempseats;
		}

}
