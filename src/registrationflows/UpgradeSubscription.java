package registrationflows;


import org.testng.annotations.Test;

import common.SuperTestScript;
import generics.Excel;
import pages.FamilySubscription;
import pages.HomePage;
import pages.KontoDetails;
import pages.LoginPage;
import pages.SubscriptionDetails;
import pages.SubscriptionPage;

public class UpgradeSubscription  extends SuperTestScript{
	public static String email;
	public static String password;
	public UpgradeSubscription() {
		
		loginrequired = true;
		logoutrequired = true;
	}
	
	@Test(enabled = true,priority = 1,groups = {"UpgradeSubscription","All"})
	public void UpgradeSubscriptioPositive() {
		
	 
		//String email=Excel.getCellValue(INPUT_PATH,"ExistingEmail",1 , 1);
		  //String pwd = Excel.getCellValue(INPUT_PATH,"ExistingEmail", 1, 2);
		  
		String email="test_oct2018_586708@test.se";
		String pwd="vmlmym";
		HomePage hm=new HomePage(driver);
		LoginPage login=new LoginPage(driver);
		hm.clickToLogin();
		
		login.enterEmail(email);
		login.enterPassword(pwd);
		login.clickOnSingIn();

		KontoDetails konto=new KontoDetails(driver);
		
		
		SubscriptionDetails sub = new SubscriptionDetails(driver);
		SubscriptionPage subs = new SubscriptionPage(driver);
		FamilySubscription famSub=new FamilySubscription(driver);
		
		sub.clickToGetSubDetails();
		if(sub.getSubscriptionDetails().trim().equals("Silver")||sub.getSubscriptionDetails().trim().equals("Hopea")||sub.getSubscriptionDetails().trim().equals("Silber")) {
			log.info("Current Subscription for the customer is: "+sub.getSubscriptionDetails());
			sub.clickToChangeSub();
			log.info("Upgrading to Gold Subscription.........");
			subs.clickforGold();
			subs.clickToContinue();
			subs.clickOnMyAccount();
			hm.clickToSearch();
			sub.clickToGetSubDetails();
			//log.info("After Upgrade Subscription is: "+sub.getSubscriptionDetails().trim());
		}
		else if(sub.getSubscriptionDetails().trim().equals("Guld")||sub.getSubscriptionDetails().trim().equals("Kulta")||sub.getSubscriptionDetails().trim().equals("Gold")) {
			log.info("Current Subscription for the customer is: "+sub.getSubscriptionDetails());
			sub.clickToChangeSub();
			log.info("Upgrading to Family2 Subscription.........");
			subs.clickToContinue();
			famSub.clickforFamily2();
			famSub.clickToContinue();
			subs.clickOnMyAccount();
			//log.info("After Upgrade Subscription is: "+sub.getSubscriptionDetails().trim());
		
		
	}
		else if(sub.getSubscriptionDetails().trim().equals("Familj 2 personer")||sub.getSubscriptionDetails().trim().equals("Perhe 2")||sub.getSubscriptionDetails().trim().equals("Familie 2")) {
			log.info("Current Subscription for the customer is: "+sub.getSubscriptionDetails());
			sub.clickToChangeSub();
			log.info("Upgrading to Family3 Subscription.........");
			subs.clickToContinue();
			famSub.clickforFamily3();
			famSub.clickToContinue();
			subs.clickOnMyAccount();
			//log.info("After Upgrade Subscription is: "+sub.getSubscriptionDetails().trim());
		}
		else if(sub.getSubscriptionDetails().trim().equals("Familj 3 personer")||sub.getSubscriptionDetails().trim().equals("Perhe 3")||sub.getSubscriptionDetails().trim().equals("Familie 3")) {
			log.info("Current Subscription for the customer is: "+sub.getSubscriptionDetails());
			sub.clickToChangeSub();
			log.info("Upgrading to Family4 Subscription.........");
			subs.clickToContinue();
			famSub.clickToContinue();
			subs.clickOnMyAccount();
			//log.info("After Upgrade Subscription is: "+sub.getSubscriptionDetails().trim());
		}
		
		else if(sub.getSubscriptionDetails().trim().equals("Familj 4 personer")||sub.getSubscriptionDetails().trim().equals("Perhe 4")||sub.getSubscriptionDetails().trim().equals("Familie 4")) {
			log.info("Current subscription is :"  + sub.getSubscriptionDetails() + " And "+ sub.getSubscriptionDetails() + " can not be Upgraded");
			konto.clickOnmenu();
		
		}
		else {
			log.info("Unable to find any subscriptions");
		}
 	
		konto.clickToLogOut();
		
}
	
	
	
}
	
	
	
	
	
	
	
