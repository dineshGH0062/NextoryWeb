package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.BasePage;

public class ChangeSubscriptionPage  extends BasePage{
	
	//http://104.155.208.232:82/konto/prenumeration/Byta (Account/subscription/Change)
	
	@FindBy(xpath="(//div[@class='subscriptionTable__checkbox'])[1]")
	//private String[] Subsctription1= {"Silver","Hopea","Silber"};
     private WebElement Base;
	
	@FindBy(xpath="(//div[@class='subscriptionTable__checkbox'])[2]")
	//private String[] Subsctription2= {"Guld","Kulta","Silber"};
	 private WebElement Standard;
	
	
	@FindBy(xpath="(//div[@class='subscriptionTable__checkbox'])[3]")
	//private String[] Subsctription3= {"Familj","Perhe","Familie"};
	 private WebElement Premium;
	
	@FindBy(xpath="//a[@class='btn btn--primary']")
	private WebElement ContinueTab;
	
	@FindBy(xpath="(//div[@class =  'checkbox'])[1]")
	private WebElement Family2;
	
	@FindBy(xpath="(//div[@class =  'checkbox'])[2]")
	private WebElement Family3;
	
	@FindBy(xpath="(//div[@class =  'checkbox'])[3]")
	private WebElement Family4;
	
	@FindBy(xpath="//a[@class='btn btn--primary']")
	private WebElement MyAccount;
	
	
	
	public ChangeSubscriptionPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void ClickForBaseSubscription() {
		
		waitTillElementIsVisible(Base);
		waitTillElementIsClickable(Base);
		Base.click();
	}
	
	public void ClickForStandardSubscription() {
	
	waitTillElementIsVisible(Standard);
	waitTillElementIsClickable(Standard);
	Standard.click();

	}
	public void ClickForPremiumSubscription() {
	
	waitTillElementIsVisible(Premium);
	waitTillElementIsClickable(Premium);
	Premium.click();
	
	}
	public void ClickToContinueTab() {
	waitTillElementIsVisible(ContinueTab);
	waitTillElementIsClickable(ContinueTab);
	ContinueTab.click();
	}
	
	public  String VerifyBaseSub()
	{
		waitTillElementIsVisible(Base);
		return Base.getText();
	}
	
	public  String VerifyStandardSub()
	{
		waitTillElementIsVisible(Standard);
		return Standard.getText();
	}
	
	public  String VerifyPremiumSub()
	{
		waitTillElementIsVisible(Premium);
		return Premium.getText();
	}
	
	public void ClickOnMyAccount() {
		waitTillElementIsVisible(MyAccount);
		waitTillElementIsClickable(MyAccount);
		MyAccount.click();
	}
	
	public void ClickToFamily2() {
		waitTillElementIsVisible(Family2);
		waitTillElementIsClickable(Family2);
		Family2.click();
	}
	
	public void ClickToFamily3() {
		waitTillElementIsVisible(Family3);
		waitTillElementIsClickable(Family3);
		Family3.click();
	}
	
	public void ClickToFamily4() {
		waitTillElementIsVisible(Family4);
		waitTillElementIsClickable(Family4);
	}
	
	
}