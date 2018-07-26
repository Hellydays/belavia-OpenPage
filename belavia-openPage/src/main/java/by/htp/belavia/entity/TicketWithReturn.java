package by.htp.belavia.entity;

public class TicketWithReturn extends Ticket {
	
	private String returnDate;
	
	public TicketWithReturn() {
		
	}
	
	public TicketWithReturn(String flightDate, String ticketCost) {
		super(flightDate, ticketCost);
	}
	
	public TicketWithReturn(String flightDate, String ticketCost, String returnDate) {
		super(flightDate, ticketCost);
		this.returnDate = returnDate;
	}


	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return "TicketWithReturn [returnDate=" + returnDate + " " + super.toString() + "]";
	}
	
	
	
}
