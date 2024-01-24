package com.Appiness_Assessment.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
public static WebDriver driver;
	
	@FindBy(xpath = "//div[@class='dropdown dropstart']")
	private WebElement profileIcon;

	@FindBy(linkText = "My Profile")
	private WebElement profile;
	
	public HomePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}

	public WebElement getProfile() {
		return profile;
	}
	
	public WebElement getProfileIcon() {
		return profileIcon;
	}
}
