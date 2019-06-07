package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.BasePage;

public class LoginPage extends BasePage{
	
	@FindBy(xpath="//a[@href='/medlem/logga-in'])[1]")
	private WebElement LoginButton;
	
	@FindBy(xpath = "//input[@name = 'email']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@name = 'password']")
	private WebElement password;
	
	@FindBy(xpath = "//div[@class = 'sc-iybRtq jFpwru']/a")
	private WebElement ForgotPassword;
	
	@FindBy(xpath = "//button[@class='btn btn--primary ']")
	private WebElement SignIn;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnLogin() {
		waitTillElementIsVisible(LoginButton);
		waitTillElementIsClickable(LoginButton);
		LoginButton.click();
	}
	
	public void enterEmail(String mail) {
		
		waitTillElementIsVisible(email);
		email.clear();
		email.sendKeys(mail);
	}
	
	public void enterPassword(String pwd) {
		
		waitTillElementIsVisible(password);
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void clickOnForgotPassword() {
		
		waitTillElementIsVisible(ForgotPassword);
		waitTillElementIsClickable(ForgotPassword);
		ForgotPassword.click();
	}
	
	public void clickOnSingIn() {
		
		waitTillElementIsVisible(SignIn);
		waitTillElementIsClickable(SignIn);
		if(SignIn.isEnabled())
			SignIn.click();
	}
	
}
