package by.htp.belavia.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {
	
	private final String BASE_URL = "https://en.belavia.by";
	
	@FindBy(id = "OriginLocation_Combobox")
	WebElement locationCombox;
	
	@FindBy(xpath = "//div[@class=\"wrapper ui-trigger-input\"]/a[@class=\"trigger\"]")
	List<WebElement> arrows;
	
	@FindBy(xpath = "//ul[@id=\"ui-id-2\"]/li/a")
	List<WebElement> countriesFrom;
	
	@FindBy(xpath = "//ul[@id=\"ui-id-3\"]/li/a")
	List<WebElement> countriesTo;
	
	@FindBy(xpath = "//div[@class=\"col-mb-12\"]/label[@for = \"JourneySpan_Ow\"]")
	WebElement oneWay;
	
	@FindBy(xpath = "//td[@data-month=\"7\"]/a[(text()=\"1\")]")
	WebElement augustFirst;
	
	@FindBy(xpath = "//div[@class=\"col-group form-group\"]//button[@type =\"submit\"]")
	WebElement SearchButton;
	
	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}
	
	public void enterLocationFrom(String location) {
		
		WebElement departureArrow = arrows.get(0);
		departureArrow.click();
		
		for(WebElement element : countriesFrom) {
			if(element.getText().contains(location)) {
				element.click();
			}
		}
	}
	
	public void enterLocationTo(String location) {
		
		WebElement departureArrow = arrows.get(1);
		departureArrow.click();
		
		for(WebElement element : countriesTo) {
			if(element.getText().contains(location)) {
				element.click();
			}
		}
	}
	
	public void selectOneWay() {
		oneWay.click();
	}
	
	// it would be better to add check if calendar is already opened or no
	public void enterDepartureDate() {
		augustFirst.click();	
	}
	
	public void clickSearch() {
		SearchButton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
