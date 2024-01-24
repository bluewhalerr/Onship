package com.Appiness_Assessment.stepDefinition;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Appiness_Assessment.baseClass.BaseClass;
import com.Appiness_Assessment.pom.HomePage;
import com.Appiness_Assessment.pom.LoginPage;
import com.Appiness_Assessment.pom.ProfilePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProfileSteps extends BaseClass {
	
	public static WebDriver driver;
	public static LoginPage lp;
	public static HomePage hp;
	public static ProfilePage pp;
	
	@Given("User launch the application")
	public void user_launch_the_application() throws Throwable {
		driver = launchBrowser("chrome");
		driver = getUrl("https://onship.app/onship");
	}
	
	@When("User is on the loginpage logs in with valid credentials")
	public void user_is_on_the_loginpage_logs_in_with_valid_credentials() {
		lp = new LoginPage(driver);
		userInput(lp.getEmail(), "sushmaanth.r@gmail.com");
		userInput(lp.getPassword(), "Sush$1203");
		eclick(lp.getLoginBtn());
	}
	
	@When("User is on the homepage clicks on the My Profile redirected to My Profile screen")
	public void user_is_on_the_homepage_clicks_on_the_my_profile_redirected_to_my_profile_screen() throws InterruptedException {
		hp = new HomePage(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		Thread.sleep(5000);
		try {
		waitInvisibleElement(25, driver.findElement(By.xpath("//div[@class='circularBarComponent']//child::div//child::div/div[contains(text(),'Loading')]")));
		}
		catch (NoSuchElementException e) {
			System.out.println("Element is not displayed");
			// TODO: handle exception
		}
//		waituntilElementVisibility(30, hp.getProfileIcon());
//		waituntilElementClickable(30, hp.getProfileIcon());
		eclick(hp.getProfileIcon());
		waituntilElementVisibility(30, hp.getProfile());
		waituntilElementClickable(30, hp.getProfile());
		eclick(hp.getProfile());
	}
	
	@When("User Upload or Modify Profile Picture")
	public void user_upload_or_modify_profile_picture() throws IOException, InterruptedException {
		pp = new ProfilePage(driver);
		
		WebDriverWait wb = new WebDriverWait(driver, Duration.ofSeconds(30));
		wb.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='fa fa-camera']")));
		try {
			waitInvisibleElement(25, driver.findElement(By.xpath("//div[@class='circularBarComponent']//child::div//child::div/div[contains(text(),'Loading')]")));
			}
			catch (NoSuchElementException e) {
				System.out.println("Element is not displayed");
				// TODO: handle exception
			}
		eclick(pp.getCamIcon());
		Thread.sleep(5000);
		Runtime.getRuntime().exec("src\\test\\resources\\AutoIT\\ProfilePic.exe");
		Thread.sleep(5000);
		//waituntilElementVisibility(30, pp.getNationality());
		dropDown(pp.getNationality(), "byVisibleText", "Indian");
	  
	}
}
