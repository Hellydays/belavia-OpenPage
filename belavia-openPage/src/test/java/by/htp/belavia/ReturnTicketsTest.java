package by.htp.belavia;

import org.testng.annotations.Test;

import by.htp.belavia.pages.MainPage;
import by.htp.belavia.pages.ResultsPage;

public class ReturnTicketsTest extends BaseTest {
	
	String locationFrom = "Minsk";
	String locationTo = "Riga";

	@Test
	public void TwoWayTicketsLog() {
		MainPage mainPage = steps.enterCriteriaForReturn(locationFrom, locationTo);
		ResultsPage resultsPage = steps.getSearchResultsWithReturn();
	}
	
}
