package by.htp.belavia;

import org.testng.annotations.Test;

import by.htp.belavia.pages.MainPage;
import by.htp.belavia.pages.ResultsPage;

public class OneWayTicketsTest extends BaseTest {
	
	String locationFrom = "Minsk";
	String locationTo = "Riga";
	String day = "1";
	
	@Test
	public void OneWayTicketsLog() {
		MainPage mainPage = steps.enterCriteriaForOneWay(locationFrom, locationTo);
		ResultsPage resultsPage = steps.getSearchResultsOneWay();
	}
}
