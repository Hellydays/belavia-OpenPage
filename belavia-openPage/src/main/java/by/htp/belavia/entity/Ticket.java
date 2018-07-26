package by.htp.belavia.entity;

public class Ticket {
	
	private String flightDate;
	private String ticketCost;
	
	public Ticket() {
	}

	public Ticket(String flightDate, String ticketCost) {
		super();
		this.flightDate = flightDate;
		this.ticketCost = ticketCost;
	}

	public String getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}

	public String getTicketCost() {
		return ticketCost;
	}

	public void setTicketCost(String ticketCost) {
		this.ticketCost = ticketCost;
	}

	@Override
	public String toString() {
		return "Ticket [flightDate=" + flightDate + ", ticketCost=" + ticketCost + "]";
	}


}
