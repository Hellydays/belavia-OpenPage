package by.htp.belavia.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultsPage extends AbstractPage {
	
	@FindBy(xpath = "//div[@class=\"row\"]/div[@class=\"departure\"]/strong")
	WebElement departureData;

	public ResultsPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void openPage() {
		
	}

}
