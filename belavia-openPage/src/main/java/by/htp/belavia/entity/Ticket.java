package by.htp.belavia.entity;

public class Ticket implements Comparable<Ticket> {
	
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flightDate == null) ? 0 : flightDate.hashCode());
		result = prime * result + ((ticketCost == null) ? 0 : ticketCost.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (flightDate == null) {
			if (other.flightDate != null)
				return false;
		} else if (!flightDate.equals(other.flightDate))
			return false;
		if (ticketCost == null) {
			if (other.ticketCost != null)
				return false;
		} else if (!ticketCost.equals(other.ticketCost))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Ticket [flightDate=" + flightDate + ", ticketCost=" + ticketCost + "]";
	}

	@Override
	public int compareTo(Ticket o) {
		String thisCostString = this.ticketCost.replaceAll("[^0-9]","");
		int cost = Integer.parseInt(thisCostString);
		
		String comparedToCostString = o.getTicketCost().replaceAll("[^0-9]","");
		int comparedCost = Integer.parseInt(comparedToCostString);
		if(cost > comparedCost) {
			return 1;
		} else if( cost < comparedCost) {
			return -1;
		} else {
			return 0;
		}
		
		//@Override
//		public int compare(Ticket o1, Ticket o2) {
//			
//			String o1cost = o1.getTicketCost().replaceAll("[^0-9]","");
//			int cost1 = Integer.parseInt(o1cost);
//			
//			String o2cost = o2.getTicketCost().replaceAll("[^0-9]","");
//			int cost2 = Integer.parseInt(o2cost);	
//			
//			if(cost1 > cost2) {
//				return 1;
//			} else if(cost1 > cost2) {
//				return -1;
//			} else {
//				return 0;
//			}
//			
//		}
	}
	
}
