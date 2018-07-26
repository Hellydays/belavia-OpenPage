package by.htp.belavia.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.htp.belavia.entity.Ticket;

public class ResultsPage extends AbstractPage {

	@FindBy(xpath = "//div[@class=\"row\"]/div[@class=\"departure\"]/strong")
	WebElement departureData;

	@FindBy(linkText = "Fare calendar")
	WebElement fareCalendar;

	@FindBy(xpath = "//div[@class=\"price\"]//input")
	List<WebElement> datesList;

	@FindBy(xpath = "//div[@class = \"nav-right\"]//i")
	WebElement next;

	public ResultsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {

	}

	public void getTickets() {

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

				System.out.println(ticket.toString());

			}
			
			WebElement next = driver.findElement(By.xpath("//i[@class='icon-right-open']"));
			wait.until(ExpectedConditions.visibilityOf(next));

			next.click();

		} while (checkIfLast(tickets, ticket));

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
}
