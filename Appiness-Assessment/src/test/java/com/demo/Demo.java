package com.demo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	public static WebDriver driver;
	public static WebDriverWait wait;

	public static void main(String[] args) throws IOException, AWTException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://onship.app/onship");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions actions = new Actions(driver);

		// LoginPage
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
		email.sendKeys("sushmaanth.r@gmail.com");

		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("Sush#1203");

		WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		loginBtn.click();

		// HomePage
		Thread.sleep(40000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		profileMenu();

		// Profile page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// profilepic
//		WebElement camIcon = driver.findElement(By.xpath("//i[@class='fa fa-camera']"));
//		camIcon.click();

//		Robot r = new Robot();
//		   String filePath = "C:\\Users\\User\\Downloads\\ship.png";
//           StringSelection str = new StringSelection(filePath);
//           Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
//           r.keyPress(KeyEvent.VK_CONTROL);
//           r.keyPress(KeyEvent.VK_V);
//      	r.keyRelease(KeyEvent.VK_CONTROL);
//           r.keyRelease(KeyEvent.VK_V);		
//		r.keyPress(KeyEvent.VK_ENTER);
//        r.keyRelease(KeyEvent.VK_ENTER);

		// Profile details
		// nationality
//				WebElement profileUpdateText = driver.findElement(By.xpath("//div[@class=\"d-flex align-items-center justify-content-between\"]"));
//				wait.until(ExpectedConditions.visibilityOf(profileUpdateText));

		profileMenu();

		WebElement nationality = driver.findElement(By.xpath("(//div[@id='nationality'])[@role='button']"));
		nationality.click();

		WebElement container = driver.findElement(By.xpath("//ul[@aria-labelledby='nationality']"));
		WebElement option = driver.findElement(By.xpath("//li[@data-value='Indian']"));
		js.executeScript("arguments[0].scrollTop = arguments[1].offsetTop;", container, option);
		option.click();

		// city
		WebElement cityInput = driver.findElement(By.xpath(
				"//div[@class='regional-details']/child::form/child::div/following-sibling::div/following-sibling::div/following::div/child::div/following::div/input[@id='cityBill']"));
		WebElement city = wait.until(ExpectedConditions.elementToBeClickable(cityInput));
		cityInput.click();
		cityInput.clear();
		cityInput.sendKeys("chennai");

		// save
		WebElement saveProfile = driver.findElement(By.xpath("//button[@type='button'][contains(text(),'Save')]"));
		saveProfile.click();

		// add the profile
		
		
		profileWait();
		profileMenu();
		
		WebElement addPosition = driver.findElement(By.xpath("//button[contains(text(),'Add your position or role')]"));
		addPosition.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body']")));

		WebElement yesRadioBtn = driver
				.findElement(By.xpath("(//input[@name='radio-buttons-group'])[@value='Yes'][1]"));
		yesRadioBtn.click();

		WebElement dropdownType = driver.findElement(By.xpath("//div[@id='select-role']"));
		actions.moveToElement(dropdownType).click().build().perform();

		WebElement optionType = driver.findElement(By.xpath("//li[@data-value='Engine']"));
		actions.moveToElement(optionType).click().build().perform();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement dropdownRank = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='select-rank']")));
		actions.moveToElement(dropdownRank).click().build().perform();
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebElement optionRank = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@data-value='Chief Engineer']")));
		actions.moveToElement(optionRank).click().build().perform();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement saveRole = driver.findElement(By.xpath("(//button[@type='button'])[text()='Save'][2]"));
		saveRole.click();

		// change password
//		WebElement cross = driver.findElement(By.xpath("//i[@class='icon-cross']"));
//		cross.click();
		
		//profileMenu();
		
		WebElement p = driver.findElement(By.xpath("//div[contains(@class,'dropdown dropstart')]//child::button"));
		actions.moveToElement(p).click().build().perform();
		
		WebElement mp = driver.findElement(By.linkText("My Profile"));
		actions.moveToElement(mp).click().build().perform();

		WebElement changePassword = driver.findElement(By.linkText("Change Password"));
		actions.moveToElement(changePassword).click().build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']")));

		WebElement currentPassword = driver.findElement(By.id("inputCP"));
		currentPassword.sendKeys("Sush#1203");

		WebElement newPassword = driver.findElement(By.id("inputPassword"));
		newPassword.sendKeys("Sush$1203");

		WebElement confirmPassword = driver.findElement(By.id("inputConfirmPassword"));
		confirmPassword.sendKeys("Sush#1203");

		WebElement submitBtn = driver.findElement(By.xpath("//button[text()='Submit']"));
		submitBtn.click();

//		
//		//chat bot
//		driver.navigate().back();
//		
//		WebElement emmaCatalogue = driver.findElement(By.xpath("(//div[@class=\"catalog-card\"])[1]"));
//		emmaCatalogue.click();
//		
//		WebElement emmaInput = driver.findElement(By.id("div-input-editable"));
//		emmaInput.sendKeys("Can you provide tips for improving productivity at sea?");
//		
//		WebElement sendIcon = driver.findElement(By.xpath("//span[@class='pointer']"));
//		sendIcon.click();
//		
//		

		// driver.quit();

		// waitInvisibleElement(25,
		// driver.findElement(By.xpath("//div[@class='circularBarComponent']//child::div//child::div/div[contains(text(),'Loading')]")));
	}

	public static void profileMenu() {
		WebElement profileMenu = driver
				.findElement(By.xpath("//div[contains(@class,'dropdown dropstart')]//child::button"));
		profileMenu.click();

		WebElement myProfile = driver.findElement(By.linkText("My Profile"));
		myProfile.click();

	}
	
	public static void profileWait() {
		WebElement profileUpdateText = driver.findElement(By.xpath("//div[@class=\"d-flex align-items-center justify-content-between\"]"));
		wait.until(ExpectedConditions.visibilityOf(profileUpdateText));
	}

}
