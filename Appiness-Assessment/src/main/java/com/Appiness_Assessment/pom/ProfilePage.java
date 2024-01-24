package com.Appiness_Assessment.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
	
	public static WebDriver driver;
	
	@FindBy(xpath ="//i[@class='fa fa-camera']")
	private WebElement camIcon;
	
	@FindBy(id = "nationality")
	private WebElement nationality;

	public ProfilePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getCamIcon() {
		return camIcon;
	}
	
	public WebElement getNationality() {
		return nationality;
	}

}
