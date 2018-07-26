package by.htp.belavia.steps;

import org.openqa.selenium.WebDriver;

import by.htp.belavia.pages.MainPage;
import by.htp.belavia.pages.ResultsPage;

public class Steps {
	
	WebDriver driver;

	public Steps(WebDriver driver) {
		this.driver = driver;
	}
	
	public MainPage enterCriteria(String locationFrom, String locationTo) {
		
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		
		mainPage.enterLocationFrom(locationFrom);
		mainPage.enterLocationTo(locationTo);
		
		mainPage.enterDepartureDate();
		mainPage.selectOneWay();
		mainPage.clickSearch();
		
		return mainPage;

	}
	
	public ResultsPage getSearchResults() {
		ResultsPage rp = new ResultsPage(driver);
		rp.getTickets();
		return rp;
	}

}
