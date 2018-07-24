package by.htp.belavia.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {
	
	private final String BASE_URL = "https://en.belavia.by";
	
	@FindBy(id = "OriginLocation_Combobox")
	WebElement locationCombox;

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}
	
	public void enterLocation() {
	}

}
