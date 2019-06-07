package registrationflows;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import common.SuperTestScript;
import generics.AddDate;
import pages.FamilySubscription;
import pages.HomePage;
import pages.KontoDetails;
import pages.OrderDetails;
import pages.PaymentPage;
import pages.RegistrationPage;
import pages.SubscriptionDetails;
import pages.SubscriptionPage;
import pages.UpdateCardDetails;
import pages.UserDetails;

public class FreeTrialFlow_AllCountries extends SuperTestScript{
	
	public static String newEmail;
	public static String confirm;
	public static String newPwd;
	public static String CardNumber;
	public static String cvc;
		
	@Test(enabled = true,priority = 1, groups = { "FreeTrialFlow_SE", "All" },dataProvider="userData_SE",
			dataProviderClass=common.DataProviderComponent.class)
	public void FreeTrialFlow_SE(String subs,String email,String password,String gateway,String CardNumber,String cvc,String month,String year,
			String bankName,String personnum) {
		
		HomePage home = new HomePage(driver);
		home.clickToacceptCookies();
		home.clickToRegister();
		driver.findElement(By.xpath("//a[@class='btn btn--primary btn--arrow']")).click();
		
		SubscriptionPage sub = new SubscriptionPage(driver);
		FamilySubscription fam = new FamilySubscription(driver);
		Reporter.log("Registration for FreeTrailFlow in Swedish Country site Starts......");
		log.info("Validating the FreeTrailPeriod for 14 Days.....");
		Assert.assertTrue(sub.getTrailDate().trim().contains(AddDate.addingDays(14).toString().trim()));
		log.info("Validation of FreeTrailPeriod is completed.");
		if(subs.equals("Silver")) {
			Reporter.log("Free Trail Flow For "+subs+"Subscription Starts........");
			log.info("FreeTrialFlow Continues for Subscription"+subs+"........");
			sub.clickforSilver();
			log.info("Validating the Subscription Price.....");
			log.info(subs+":"+sub.getSubsciptionPrice().trim());
			Assert.assertEquals(sub.getSubsciptionPrice().trim(), "139 kr");
			log.info("Validation of Subscription Price is Completed.");
			log.info("Validating the allowed number of profiles for the subscription....");
			log.info("Profiles allowed for "+subs+":"+sub.getProfileNum().trim());
			Assert.assertEquals(sub.getProfileNum().trim(), "1");
			log.info("Validation of max allowed profiles is completed");
			sub.clickToContinue();
		}else if(subs.equals("Guld")) {
			Reporter.log("Free Trail Flow For "+subs+"Subscription Starts........");
			log.info("FreeTrialFlow Continues for Subscription"+subs+"........");
			sub.clickforGold();
			log.info("Validating the Subscription Price.....");
			log.info(subs+":"+sub.getSubsciptionPrice().trim());
			Assert.assertEquals(sub.getSubsciptionPrice().trim(), "169 kr");
			log.info("Validation of Subscription Price is Completed.");
			log.info("Validating the allowed number of profiles for the subscription....");
			log.info("Profiles allowed for "+subs+":"+sub.getProfileNum().trim());
			Assert.assertEquals(sub.getProfileNum().trim(), "1");
			log.info("Validation of max allowed profiles is completed");
			sub.clickToContinue();
		}else {
			
			if(subs.equals("Familj 2")) {
				Reporter.log("Free Trail Flow For "+subs+"Subscription Starts.....");
				log.info("FreeTrialFlow Continues for Subscription"+subs+"......");
				sub.clickforFamily();
				Assert.assertEquals(sub.getProfileNum().trim(), "2-4");
				sub.clickToContinue();
				fam.clickforFamily2();
				log.info("Validation of number of profiles for "+subs+" subscription.......");
				log.info("No. of profiles for "+subs+": "+fam.getFamily2Text(0));
				log.info("Validation of max allowed profiles is completed");
				log.info("Validation of subscription price starts.....");
				log.info("Subscription price for "+subs+":"+fam.getFamily2Text(2));
				Assert.assertTrue(fam.getFamily2Text(2).trim().contains("199 kr"));
				log.info("Validation of Subscription Price is completed.");
				fam.clickToContinue();
			}else if(subs.equals("Familj 3")) {
				Reporter.log("Free Trail Flow For "+subs+"Subscription Starts.....");
				log.info("FreeTrialFlow Continues for Subscription"+subs+"......");
				sub.clickforFamily();
				Assert.assertEquals(sub.getProfileNum().trim(), "2-4");
				sub.clickToContinue();
				fam.clickforFamily3();
				log.info("Validation of number of profiles for "+subs+" subscription.......");
				log.info("No. of profiles for "+subs+": "+fam.getFamily3Text(0));
				log.info("Validation of max allowed profiles is completed");
				log.info("Validation of subscription price starts.....");
				log.info("Subscription price for "+subs+":"+fam.getFamily3Text(2));
				Assert.assertTrue(fam.getFamily3Text(2).trim().contains("239 kr"));
				log.info("Validation of Subscription Price is completed.");
				fam.clickToContinue();
			}else {
				Reporter.log("Free Trail Flow For "+subs+"Subscription Starts.....");
				log.info("FreeTrialFlow Continues for Subscription"+subs+"......");
				sub.clickforFamily();
				Assert.assertEquals(sub.getProfileNum().trim(), "2-4");
				sub.clickToContinue();
				fam.clickforFamily4();
				log.info("Validation of number of profiles for "+subs+" subscription.......");
				log.info("No. of profiles for "+subs+": "+fam.getFamily4Text(0));
				log.info("Validation of max allowed profiles is completed");
				log.info("Validation of subscription price starts.....");
				log.info("Subscription price for "+subs+":"+fam.getFamily4Text(2));
				Assert.assertTrue(fam.getFamily4Text(2).trim().contains("279 kr"));
				log.info("Validation of Subscription Price is completed.");
				fam.clickToContinue();
			}
		}
		
		driver.findElement(By.xpath("//a[@class='btn btn--primary btn--arrow']")).click();
		
		RegistrationPage reg = new RegistrationPage(driver);
		reg.enterEmail(email);
		reg.confirmMail(email);
		reg.enterPassword(password);
		reg.agreeTerms();
		reg.clickToContinue();
		
		Reporter.log("Payment Flow Starts for "+subs+"subscription....");
		log.info("Payment Starts.....");
		PaymentPage pay = new PaymentPage(driver);
		if(gateway.equals("Adyen")) {
			
			pay.adyenDropDown();
			log.info("Validation of payment Summary text in "+gateway);
			if(subs.equals("Silver")) {
				Assert.assertTrue(pay.getPaymentSummary(0).trim().contains("Silver"));
				Assert.assertTrue(pay.getPaymentSummary(1).trim().contains("14"));
				Assert.assertTrue(pay.getPaymentSummary(2).trim().contains("139 kr"));
				Assert.assertTrue(pay.getPaymentSummary(2).trim().contains(AddDate.addingDays(14).toString().trim()));
			}else if(subs.equals("Guld")) {
				Assert.assertTrue(pay.getPaymentSummary(0).trim().contains("Guld"));
				Assert.assertTrue(pay.getPaymentSummary(1).trim().contains("14"));
				Assert.assertTrue(pay.getPaymentSummary(2).trim().contains("169 kr"));
				Assert.assertTrue(pay.getPaymentSummary(2).trim().contains(AddDate.addingDays(14).toString().trim()));
			}else {
				if(subs.equals("Familj 2")) {
					Assert.assertTrue(pay.getPaymentSummary(0).trim().contains("Familj, 2"));
					Assert.assertTrue(pay.getPaymentSummary(1).trim().contains("14"));
					Assert.assertTrue(pay.getPaymentSummary(2).trim().contains("199 kr"));
					Assert.assertTrue(pay.getPaymentSummary(2).trim().contains(AddDate.addingDays(14).toString().trim()));
				}else if(subs.equals("Familj 3")) {
					Assert.assertTrue(pay.getPaymentSummary(0).trim().contains("Familj, 3"));
					Assert.assertTrue(pay.getPaymentSummary(1).trim().contains("14"));
					Assert.assertTrue(pay.getPaymentSummary(2).trim().contains("239 kr"));
					Assert.assertTrue(pay.getPaymentSummary(2).trim().contains(AddDate.addingDays(14).toString().trim()));
				}else {
					Assert.assertTrue(pay.getPaymentSummary(0).trim().contains("Familj, 4"));
					Assert.assertTrue(pay.getPaymentSummary(1).trim().contains("14"));
					Assert.assertTrue(pay.getPaymentSummary(2).trim().contains("279 kr"));
					Assert.assertTrue(pay.getPaymentSummary(2).trim().contains(AddDate.addingDays(14).toString().trim()));
				}
			}
			
			WebDriverWait wait = new WebDriverWait(driver,40);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
			pay.enterCardNumber(CardNumber);
			driver.switchTo().defaultContent();
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(1));
			pay.enterexpiryDate(month+year);
			driver.switchTo().defaultContent();
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(2));
			pay.entercvv(cvc);
			driver.switchTo().defaultContent();
			pay.clickOnSubmit();
		}else if(gateway.equals("Trustly")) {
			
			pay.trustlyDropDown();
			log.info("Validation of payment Summary text in "+gateway);
			if(subs.equals("Silver")) {
				Assert.assertTrue(pay.getPaymentSummary(0).trim().contains("Silver"));
				Assert.assertTrue(pay.getPaymentSummary(1).trim().contains("14"));
				Assert.assertTrue(pay.getPaymentSummary(2).trim().contains("139 kr"));
				Assert.assertTrue(pay.getPaymentSummary(2).trim().contains(AddDate.addingDays(14).toString().trim()));
			}else if(subs.equals("Guld")) {
				Assert.assertTrue(pay.getPaymentSummary(0).trim().contains("Guld"));
				Assert.assertTrue(pay.getPaymentSummary(1).trim().contains("14"));
				Assert.assertTrue(pay.getPaymentSummary(2).trim().contains("169 kr"));
				Assert.assertTrue(pay.getPaymentSummary(2).trim().contains(AddDate.addingDays(14).toString().trim()));
			}else {
				if(subs.equals("Familj 2")) {
					Assert.assertTrue(pay.getPaymentSummary(0).trim().contains("Familj, 2"));
					Assert.assertTrue(pay.getPaymentSummary(1).trim().contains("14"));
					Assert.assertTrue(pay.getPaymentSummary(2).trim().contains("199 kr"));
					Assert.assertTrue(pay.getPaymentSummary(2).trim().contains(AddDate.addingDays(14).toString().trim()));
				}else if(subs.equals("Familj 3")) {
					Assert.assertTrue(pay.getPaymentSummary(0).trim().contains("Familj, 3"));
					Assert.assertTrue(pay.getPaymentSummary(1).trim().contains("14"));
					Assert.assertTrue(pay.getPaymentSummary(2).trim().contains("239 kr"));
					Assert.assertTrue(pay.getPaymentSummary(2).trim().contains(AddDate.addingDays(14).toString().trim()));
				}else {
					Assert.assertTrue(pay.getPaymentSummary(0).trim().contains("Familj, 4"));
					Assert.assertTrue(pay.getPaymentSummary(1).trim().contains("14"));
					Assert.assertTrue(pay.getPaymentSummary(2).trim().contains("279 kr"));
					Assert.assertTrue(pay.getPaymentSummary(2).trim().contains(AddDate.addingDays(14).toString().trim()));
				}
			}
			pay.clickOnSubmit();
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("iframe")));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
			pay.selectTrustlyBank(bankName);
			pay.clickToContinueTrustly();
			pay.enterAccountNumber(personnum);
			pay.clickToContinueTrustly();
			String s = pay.getOtp();
			pay.enterOtp(s.trim());
			pay.clickToContinueTrustly();
			pay.clickToCompletePayment();
		}
		
		Reporter.log("Payment flow is Completed for" +subs);
		log.info("Entry of first Name and last Name by the user");
		UserDetails ud = new UserDetails(driver);
		ud.enterFirstName();
		ud.enterLastname();
		ud.enterPhoneNumber();
		ud.clickToContinue();
		ud.clickOnMittKonto();
		
		Reporter.log("Validation of Konto Details Started...");
		KontoDetails konto = new KontoDetails(driver);
		konto.clickForKonto();
		//String mail = konto.getEmail();
		log.info("Validation of email...");
		Assert.assertEquals(konto.getEmail().trim(),email);
		//konto.setEmail("testmar1802@test.se");
		log.info("Validation of email Details completed");
		konto.setFirstName("test");
		konto.setLastName("test");
		konto.setAddress("Marathalli");
		konto.setPhNo("9846584659");
		konto.setzipCode("560043");
		konto.setCity("Bangalore");
		konto.clickToSave();
		
		home.clickToSearch();
		
		SubscriptionDetails suba = new SubscriptionDetails(driver);
		suba.clickToGetSubDetails();
		log.info("Validation of Subscription in Konto....");
		Assert.assertTrue(suba.getSubscriptionDetails().trim().contains(subs.trim()));
		log.info("Validation of NextRunDate in Konto");
		Assert.assertTrue(suba.getAccountText().trim().contains(AddDate.addingDays(14).toString().trim()));
		
		home.clickToSearch();
		
		UpdateCardDetails card = new UpdateCardDetails(driver);
		card.clickToGetCardDetails();
		Assert.assertTrue(suba.getAccountText().trim().contains(AddDate.addingDays(14).toString().trim()));
		
		home.clickToSearch();
		
		OrderDetails order = new OrderDetails(driver);
		order.clickTogetOrderDetails();
		order.clickOnFakutra();
		order.GoBackOrderHist();
		
		home.clickToSearch();
		konto.clickToLogOut();
	}
	
	@Test
	public void FreeTrailFlowSE_RegistrationPage_EmptyEmailPassword() {
		
		newEmail = "";
		confirm = "";
		newPwd = "";
		
	}
}
