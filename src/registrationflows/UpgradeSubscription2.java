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

public class UpgradeSubscription2  extends SuperTestScript{
	public static String email;
	public static String password;
	
	
	enum SUBSCRIPTION_ALL {

		Silver("Silver","SE", 1), 
		Silber("Silber","FI", 1), 
		Hopea("Hopea", "DE",1), 
		Guld("Guld","SE", 2), 
		Gold("Gold", "SE",2), 
		Perhe("Perhe","SE", 2), 
		Familj2("Familj2","SE", 3), 
		Familie2("Familie2","DE", 3),
		Perhe2("Perhe2","FI", 3),
		Familj3("Familj3","SE", 4), 
		Familie3("Familie3","DE", 4),
		Perhe3("Perhe3","FI", 4),
		Familj4("Familj4","SE", 5), 
		Familie4("Familie4","DE", 5),
		Perhe4("Perhe4","FI", 5);
		//IN_ACTIVE("In Active", 2);

	    private final String key;
	    private final Integer value;
	    private final String country;

	    SUBSCRIPTION_ALL(String key, String country, Integer value) {
	        this.key = key;
	        this.value = value;
	        this.country=country;
	    }

	    public String getKey() {
	        return key;
	    }
	    public Integer getValue() {
	        return value;
	    }
	    public String getCountry() {
	        return country;
	    }
	    
	}
	
	
	
	public String getSubscriptionNameBasedOnRank(Integer rank, String country)
    {
    	for(SUBSCRIPTION_ALL data: SUBSCRIPTION_ALL.values())
    	{
    		if(data.getCountry().equalsIgnoreCase(country) && data.getValue().intValue()==rank.intValue())
    			return data.getKey();
    	}
    	
    	return null;
    }
    
    public Integer getRankBasedOnSubscriptionNameAndcountry(String name, String country)
    {
    	for(SUBSCRIPTION_ALL data: SUBSCRIPTION_ALL.values())
    	{
    		if(data.getCountry().equalsIgnoreCase(country) && data.getKey().equalsIgnoreCase(name))
    			return data.getValue();
    	}
    	
    	return null;
    }
	
	public UpgradeSubscription2() {
		
		loginrequired = true;
		logoutrequired = true;
	}
	
	@Test(enabled = true,priority = 1,groups = {"UpgradeSubscription","All"})
	public void UpgradeSubscriptioPositive() {
		
	 
		//String email=Excel.getCellValue(INPUT_PATH,"ExistingEmail",1 , 1);
		  //String pwd = Excel.getCellValue(INPUT_PATH,"ExistingEmail", 1, 2);
		
		String email="test_oct2018_750656@test.se";
		String pwd="password";
		String countrycode="SE";
		
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
		int rank = getRankBasedOnSubscriptionNameAndcountry(sub.getSubscriptionDetails().trim(), countrycode);
		
		sub.clickToGetSubDetails();
		if(getRankBasedOnSubscriptionNameAndcountry(sub.getSubscriptionDetails().trim(), countrycode).intValue()==1) {
		//if(sub.getSubscriptionDetails().trim().equals("Silver")||sub.getSubscriptionDetails().trim().equals("Hopea")||sub.getSubscriptionDetails().trim().equals("Silber")) {
			log.info("Current Subscription for the customer is: "+sub.getSubscriptionDetails());
			
			subs.clickUpgrade(rank);
			
			
			sub.clickToChangeSub();
			log.info("Upgrading to Gold Subscription.........");
			subs.clickforGold();
			subs.clickToContinue();
			subs.clickOnMyAccount();
			hm.clickToSearch();
			sub.clickToGetSubDetails();
			log.info("After Upgrade Subscription is: "+sub.getSubscriptionDetails().trim());
		}
		else if(getRankBasedOnSubscriptionNameAndcountry(sub.getSubscriptionDetails().trim(), countrycode).intValue()==2) {
			//if(sub.getSubscriptionDetails().trim().equals("Guld")||sub.getSubscriptionDetails().trim().equals("Kulta")||sub.getSubscriptionDetails().trim().equals("Gold")) {
		 
			sub.clickToChangeSub();
			subs.clickToContinue();
			famSub.clickforFamily2();
			famSub.clickToContinue();
			subs.clickOnMyAccount();
		
		
	}
		else if(getRankBasedOnSubscriptionNameAndcountry(sub.getSubscriptionDetails().trim(), countrycode).intValue()==3) {
		//else if(sub.getSubscriptionDetails().trim().equals("Familj 2 personer")||sub.getSubscriptionDetails().trim().equals("Perhe 2")||sub.getSubscriptionDetails().trim().equals("Familie 2")) {
			sub.clickToChangeSub();
			subs.clickToContinue();
			famSub.clickforFamily3();
			famSub.clickToContinue();
			subs.clickOnMyAccount();
			
		}
		else if(getRankBasedOnSubscriptionNameAndcountry(sub.getSubscriptionDetails().trim(), countrycode).intValue()==4) {
		//else if(sub.getSubscriptionDetails().trim().equals("Familj 3 personer")||sub.getSubscriptionDetails().trim().equals("Perhe 3")||sub.getSubscriptionDetails().trim().equals("Familie 3")) {
		
			sub.clickToChangeSub();
			subs.clickToContinue();
			famSub.clickToContinue();
			subs.clickOnMyAccount();
		}
		
		else if(getRankBasedOnSubscriptionNameAndcountry(sub.getSubscriptionDetails().trim(), countrycode).intValue()==5) {
		//else if(sub.getSubscriptionDetails().trim().equals("Familj 4 personer")||sub.getSubscriptionDetails().trim().equals("Perhe 4")||sub.getSubscriptionDetails().trim().equals("Familie 4")) {
		
			konto.clickOnmenu();
		log.info("Family 4 Can't upgrade Thank you");
		}
 	
		konto.clickToLogOut();
		
}
	
	
	
}
	
	
	
	
	
	
	
