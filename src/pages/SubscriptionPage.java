package pages;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.BasePage;

public class SubscriptionPage extends BasePage{

	public SubscriptionPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class = 'subscriptionTable__header']/div[1]/div[2]/div")
	private WebElement Silversub;
	
	@FindBy(xpath = "//div[@class = 'subscriptionTable__header']/div[2]/div[2]/div")
	private WebElement Goldsub;
	
	@FindBy(xpath = "//div[@class = 'subscriptionTable__header']/div[3]/div[2]/div")
	private WebElement Familysub;
	
	@FindBy(xpath="//a[@class='btn btn--secondary']")
	private WebElement MyAccount;
	
	@FindBy(xpath = "//a[@class='btn btn--primary btn--arrow']")
	private WebElement Forsatt;
	
	@FindBy(xpath="//a[@class='btn btn--primary']")
	private WebElement ContinueTab;
	
	
	
	@FindBy(xpath = "(//div[@class = 'subscriptionTable__row'])[1]/div[1]")
	private WebElement TrailDays;
	
	@FindBy(xpath = "(//div[@class = 'subscriptionTable__row'])[1]/div[2]/div[@class = 'subscriptionTable__item subscriptionTable__item--active']")
	private WebElement subsPrice;
	
	@FindBy(xpath = "(//div[@class = 'subscriptionTable__row'])[2]/div[2]/div[@class = 'subscriptionTable__item subscriptionTable__item--active']")
	private WebElement profileNum;
	
	public void clickforSilver() {
		
		waitTillElementIsVisible(Silversub);
		waitTillElementIsClickable(Silversub);
		Silversub.click();
	}
	
	public void clickforGold() {
		
		waitTillElementIsVisible(Goldsub);
		waitTillElementIsClickable(Goldsub);
		Goldsub.click();
	}
	
	public void clickUpgrade(int rank) {
		
		if(rank==1)
		{
			clickforGold();
		}
		else if(rank ==2)
		{
			clickforFamily();
		}
	}
	
	public void clickforFamily() {
		
		waitTillElementIsVisible(Familysub);
		waitTillElementIsClickable(Familysub);
		Familysub.click();
	}
	
	public void clickToContinue() {
		
		waitTillElementIsVisible(Forsatt);
		waitTillElementIsClickable(Forsatt);
		//scrollToMaximum();
		//Forsatt.click();
		//scrollToClick(Forsatt);
		Forsatt.click();
	}
	
	
	public void clickToContinueTab() {
		waitTillElementIsVisible(ContinueTab);
		waitTillElementIsClickable(ContinueTab);
		ContinueTab.click();
		}
	
	
	public void clickOnMyAccount() {
		waitTillElementIsVisible(MyAccount);
		waitTillElementIsClickable(MyAccount);
		MyAccount.click();
		
	}
	public String getTrailDate() {
		
		waitTillElementIsVisible(TrailDays);
		return TrailDays.getText();
	}
	
	public String getSubsciptionPrice() {
		
		waitTillElementIsVisible(subsPrice);
		return subsPrice.getText();
	}
	
	public String getProfileNum() {
		
		waitTillElementIsVisible(profileNum);
		return profileNum.getText();
	}
	
}
