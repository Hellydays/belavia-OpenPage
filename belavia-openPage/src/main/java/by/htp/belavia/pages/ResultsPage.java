package by.htp.belavia.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.htp.belavia.entity.Ticket;
import by.htp.belavia.entity.TicketWithReturn;

public class ResultsPage extends AbstractPage {

	@FindBy(xpath = "//div[@class=\"row\"]/div[@class=\"departure\"]/strong")
	WebElement departureData;

	@FindBy(linkText = "Fare calendar")
	WebElement fareCalendar;

	@FindBy(xpath = "//div[@class=\"price\"]//input")
	List<WebElement> datesList;

	@FindBy(xpath = "//div[@class = \"nav-right\"]//i")
	WebElement next;

	@FindBy(xpath = "//div[@class='price']/div")
	List<WebElement> returnTicketsList;

	public ResultsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {

	}

	public List<Ticket> getTicketsOneWay() {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(fareCalendar));

		fareCalendar.click();

		List<Ticket> tickets = new ArrayList<>();
		Ticket ticket = null;

		do {
			for (WebElement element : datesList) {

				WebElement price = element.findElement(By.xpath("following-sibling::label"));
				String date = element.getAttribute("value");

				ticket = new Ticket();

				ticket.setFlightDate(date);
				ticket.setTicketCost(price.getText());
				tickets.add(ticket);

			}

			WebElement next = driver.findElement(By.xpath("//i[@class='icon-right-open']"));
			wait.until(ExpectedConditions.visibilityOf(next));

			next.click();

		} while (checkIfLast(tickets, ticket));
		
		return tickets;

	}

	public Boolean checkIfLast(List<Ticket> list, Ticket ticket) {

		Boolean shouldClickNext = false;

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");
		LocalDate flagDate = LocalDate.of(2018, 11, 1);
		LocalDate localDate;

		if (ticket != null && list.size() > 0) {

			Ticket lastTicket = list.get(list.size() - 1);

			String flightDate = lastTicket.getFlightDate();
			localDate = LocalDate.parse(flightDate, formatter);
			if (localDate.isBefore(flagDate)) {
				shouldClickNext = true;
			}
		}

		return shouldClickNext;
	}

	public void getTicketsWithReturn() {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		Ticket ticketWithReturn = null;
		List<Ticket> tickets = new ArrayList<>();
		do {
			for (WebElement element : returnTicketsList) {
				ticketWithReturn = new TicketWithReturn();

				WebElement dateElement = element.findElement(By.xpath("input"));
				WebElement priceElement = element.findElement(By.xpath("label"));

				String datesString = dateElement.getAttribute("value");
				String[] datesArr = datesString.split(":");
				String priceString = priceElement.getText();

				ticketWithReturn.setFlightDate(datesArr[0]);
				((TicketWithReturn) ticketWithReturn).setReturnDate(datesArr[1]);
				ticketWithReturn.setTicketCost(priceString);

				tickets.add(ticketWithReturn);
				System.out.println(ticketWithReturn.toString());

			}
			
			WebElement next = driver.findElement(By.xpath("//i[@class='icon-right-open']"));
			wait.until(ExpectedConditions.visibilityOf(next));

			next.click();

		} while (checkIfLast(tickets, ticketWithReturn));

	}
	
	public void sortByPriceAsc(List<Ticket> list) {
		Collections.sort(list);		
	}
	
	public void printListOfTickets(List<Ticket> list) {
		for(Ticket ticket : list) {
			System.out.println(ticket.toString());
		}
	}

}
