package registrationflows;

import org.testng.annotations.Test;

import common.SuperTestScript;
import pages.FamilySubscription;
import pages.HomePage;
import pages.KontoDetails;
import pages.LoginPage;
import pages.SubscriptionDetails;
import pages.SubscriptionPage;

public class DowndradeSubscriptions extends SuperTestScript{
	public static String email;
	public static String password;
	public DowndradeSubscriptions() {
		
		loginrequired = true;
		logoutrequired = true;
	}
	
	@Test(enabled = true,priority = 1,groups = {"DowngradeSubscription","All"})
	public void DowngradeSubscriptioPositive() {
		
	 
		//String email=Excel.getCellValue(INPUT_PATH,"ExistingEmail",1 , 1);
		  //String pwd = Excel.getCellValue(INPUT_PATH,"ExistingEmail", 1, 2);
		  
		String email="test_oct2018_16034@test.se";
		String pwd="khhwcy";
		HomePage hm=new HomePage(driver);
		hm.clickToacceptCookies();
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
	
     if(sub.getSubscriptionDetails().trim().equals("Familj 4 personer")||sub.getSubscriptionDetails().trim().equals("Perhe 4")||sub.getSubscriptionDetails().trim().equals("Familie 4")) {
    	 sub.clickToChangeSub();
			subs.clickToContinue();
			famSub.clickforFamily3();
			famSub.clickToContinue();
			subs.clickOnMyAccount();
			log.info("Downgrades to Family3");
			
          }
             
		else if(sub.getSubscriptionDetails().trim().equals("Familj 3 personer")||sub.getSubscriptionDetails().trim().equals("Perhe 3")||sub.getSubscriptionDetails().trim().equals("Familie 3")) {
		
			sub.clickToChangeSub();
			subs.clickToContinue();
			famSub.clickforFamily2();
			famSub.clickToContinue();
			subs.clickOnMyAccount();
			log.info("Downgrades to Family2");
			
	
		}
	else if (sub.getSubscriptionDetails().trim().equals("Familj 2 personer")||sub.getSubscriptionDetails().trim().equals("Perhe 2")||sub.getSubscriptionDetails().trim().equals("Familie 2")) {
		sub.clickToChangeSub();
		//subs.clickToContinue();
		subs.clickforGold();
		subs.clickToContinue();
		subs.clickOnMyAccount();
		log.info("Downgraded to Gold");
	    }
	
	else if(sub.getSubscriptionDetails().trim().equals("Guld")||sub.getSubscriptionDetails().trim().equals("Kulta")||sub.getSubscriptionDetails().trim().equals("Gold")) {
		 
		sub.clickToChangeSub();
		//subs.clickToContinue();
		subs.clickforSilver();
		subs.clickToContinue();
		subs.clickOnMyAccount();
		log.info("Downgraded to Siver");
       }
	else if (sub.getSubscriptionDetails().trim().equals("Silver")||sub.getSubscriptionDetails().trim().equals("Hopea")||sub.getSubscriptionDetails().trim().equals("Silber")) {
		
		log.info("Current subscription is :"  + sub.getSubscriptionDetails() + " And "+ sub.getSubscriptionDetails() + " can not be downgraded");
		konto.clickOnmenu();
	}
	else {
		log.info("Unable to find any subscription");
	}
     konto.clickToLogOut();
	
	
	}
}
