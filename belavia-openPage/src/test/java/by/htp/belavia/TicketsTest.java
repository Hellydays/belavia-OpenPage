package by.htp.belavia;

import org.testng.annotations.Test;

import by.htp.belavia.pages.MainPage;

public class TicketsTest extends BaseTest {
	
	String locationFrom = "Minsk";
	String locationTo = "Riga";
	String day = "1";
	
	@Test
	public void sysout() {
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		
		mainPage.enterLocationFrom(locationFrom);
		mainPage.enterLocationTo(locationTo);
		
		mainPage.enterDepartureDate();
		mainPage.selectOneWay();
		mainPage.clickSearch();
	}

}
