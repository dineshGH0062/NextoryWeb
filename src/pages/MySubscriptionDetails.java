package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.BasePage;

public class MySubscriptionDetails extends BasePage{

	
	
	//@FindBy(xpath = "//font[contains(text(),'My subscription')]")
	//private WebElement MySubscription;
	
	@FindBy(xpath="//div/h2[@class='accountInfo__heading']")
	private WebElement currentSubscription;
	
	@FindBy(xpath="//div[@class='boxWrapper__content'] ")
	private WebElement SubcriptionText;
	
	
	@FindBy(xpath="//a[@class='btn btn--primary']")
	private WebElement changeSubscription;
	
	
	
	public MySubscriptionDetails(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(driver, this);
		
	}

	public void VerifySubcriptionText() {
		
		waitTillElementIsVisible(SubcriptionText);
		waitTillElementIsClickable(SubcriptionText);
		SubcriptionText.click();
}
	
	/*public String verifycurrentSubscription() {
		waitTillElementIsVisible(currentSubscription);
		return currentSubscription.getAttribute("value").trim();
	}*/
	
	
	public String verifycurrentSubscription() {
		waitTillElementIsVisible(currentSubscription);
		return currentSubscription.getText();
		
	}
	public void clickOnchangeSubscription() {
		waitTillElementIsVisible(changeSubscription);
		waitTillElementIsClickable(changeSubscription);
		changeSubscription.click();
	}
	
	
	
}
