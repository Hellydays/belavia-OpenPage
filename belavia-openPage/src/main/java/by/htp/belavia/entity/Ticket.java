package by.htp.belavia.entity;

public class Ticket {
	
	private String flightDate;
	private String flightTime;
	private String flightClass;
	private String ticketCost;
	
	public Ticket() {
	}
	
	public Ticket(String flightDate, String flightTime, String flightClass, String ticketCost) {
		super();
		this.flightDate = flightDate;
		this.flightTime = flightTime;
		this.flightClass = flightClass;
		this.ticketCost = ticketCost;
	}

	public String getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}

	public String getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	public String getTicketCost() {
		return ticketCost;
	}

	public void setTicketCost(String ticketCost) {
		this.ticketCost = ticketCost;
	}	
	

}
