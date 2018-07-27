package by.htp.belavia.entity;

public class TicketWithReturn extends Ticket implements Comparable<Ticket> {

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
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((returnDate == null) ? 0 : returnDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TicketWithReturn other = (TicketWithReturn) obj;
		if (returnDate == null) {
			if (other.returnDate != null)
				return false;
		} else if (!returnDate.equals(other.returnDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TicketWithReturn [returnDate=" + returnDate + " " + super.toString() + "]";
	}

}
