package com.Airbus.entity;
import java.util.Optional;
import java.util.Set;
public class TicketGenerationRequest {
	 private Set<Optional<Passengers>> passengers;
	    private Set<Optional<Ticket>> tempseats;
		public Set<Optional<Passengers>> getPassengers() {
			return passengers;
		}
		public void setPassengers(Set<Optional<Passengers>> passengers) {
			this.passengers = passengers;
		}
		public Set<Optional<Ticket>> getTempseats() {
			return tempseats;
		}
		public void setTempseats(Set<Optional<Ticket>> tempseats) {
			this.tempseats = tempseats;
		}

}
