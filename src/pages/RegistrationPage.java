package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.BasePage;

public class RegistrationPage extends BasePage{

	public RegistrationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name = 'email']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@name='confirmemail']")
	private WebElement confirmemail;
	
	@FindBy(xpath = "//input[@name = 'password']")
	private WebElement password;
	
	@FindBy(xpath = "//div[@class='checkbox']")
	private WebElement checkBox;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement Forsatt;
	
	public void enterEmail(String mail) {
		
		waitTillElementIsVisible(email);
		email.sendKeys(mail);
	}
	
	public void confirmMail(String mail) {
		
		waitTillElementIsVisible(confirmemail);
		confirmemail.sendKeys(mail);
	}
	
	public void enterPassword(String pass) {
		
		waitTillElementIsVisible(password);
		password.sendKeys(pass);
	}
	
	public void agreeTerms() {
		
		waitTillElementIsVisible(checkBox);
		waitTillElementIsClickable(checkBox);
		scrollToMaximum();
		checkBox.click();
	}
	
	public void clickToContinue() {
		
		waitTillElementIsVisible(Forsatt);
		waitTillElementIsClickable(Forsatt);
		Forsatt.click();
	}
}
