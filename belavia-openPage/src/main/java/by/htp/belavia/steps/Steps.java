package by.htp.belavia.steps;

import java.util.List;

import org.openqa.selenium.WebDriver;

import by.htp.belavia.entity.Ticket;
import by.htp.belavia.pages.MainPage;
import by.htp.belavia.pages.ResultsPage;

public class Steps {

	WebDriver driver;

	public Steps(WebDriver driver) {
		this.driver = driver;
	}

	public MainPage enterCriteriaForOneWay(String locationFrom, String locationTo) {

		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();

		mainPage.enterLocationFrom(locationFrom);
		mainPage.enterLocationTo(locationTo);
		mainPage.enterDepartureDate();
		mainPage.selectOneWay();
		mainPage.clickSearch();

		return mainPage;

	}

	public MainPage enterCriteriaForReturn(String locationFrom, String locationTo) {

		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();

		mainPage.enterLocationFrom(locationFrom);
		mainPage.enterLocationTo(locationTo);
		mainPage.enterDepartureDate();
		mainPage.enterReturnDate();
		mainPage.clickSearch();

		return mainPage;
	}

	public ResultsPage getSearchResultsOneWay() {
		ResultsPage resultsPage = new ResultsPage(driver);
		List<Ticket> tickets = resultsPage.getTicketsOneWay();
		resultsPage.sortByPriceAsc(tickets);
		resultsPage.printListOfTickets(tickets);
		return resultsPage;
	}

	public ResultsPage getSearchResultsWithReturn() {
		ResultsPage resultsPage = new ResultsPage(driver);
		List<Ticket> tickets = resultsPage.getTicketsWithReturn();
		resultsPage.sortByCloserFlightDate(tickets);
		resultsPage.printListOfTickets(tickets);
		return resultsPage;
	}

}
