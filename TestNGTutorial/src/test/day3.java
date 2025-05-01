package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day3 {
	
	@Parameters({"URL", "APIKey/username"})
	@Test
	public void WebloginCarLoan(String urlname, String key) {
		//selenium
		System.out.println("WebloginCar");
		System.out.println(urlname);
		System.out.println(key);
	}
	
	@BeforeMethod
	public void beforeeveryone() {
		System.out.println("I will execute before every test method in day 3 class");
	}
	
	@AfterMethod
	public void aftereveryone() {
		System.out.println("I will execute after every test method in day 3 class");
	}
	
	@BeforeClass
	public void beforeclass() {
		System.out.println("before executing any methods in the class");
	}
	
	@AfterClass
	public void afterclass() {
		System.out.println("after executing any methods in the class");
	}

	@Test(groups = {"Smoke"})
	public void MobileLoginCarLoan() {
		//Appium
		System.out.println("MobileloginCar");
	}
	
	@BeforeSuite
	public void Bfsuite() {
		System.out.println("I am no 1");
	}
	
	@Test(enabled = false)
	public void MobileSignInCarLoan() {
		//Appium
		System.out.println("Mobile SIGN IN");
	}

	@Test(dataProvider = "getData")
	public void MobileSignoutCarLoan(String username, String password) {
		//Appium
		System.out.println("Mobile SIGN OUT");
		System.out.println(username);
		System.out.println(password);
	}


	@Test(dependsOnMethods = {"WebloginCarLoan", "MobileSignoutCarLoan"})
	public void APICarLoan() {
		//REST API automation
		System.out.println("APILoginCar");
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][2];
		//1st set
		data[0][0] = "firstsetusername";
		data[0][1] = "firstpassword";
		//2nd set
		data[1][0] = "secondsetusername";
		data[1][1] = "secondpassword";
		//3rd set
		data[2][0] = "thirdsetusername";
		data[2][1] = "thirdpassword";
		
		return data;
		
	}

}
