package Amazon.Flipcart.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlipkartHomePage 
{
	WebDriver driver;
	By search = By.xpath("//input[@name='q']");
	By submitbutton = By.xpath("//button[@type='submit']");

	public FlipkartHomePage(WebDriver driver) {

		this.driver = driver;
	}

	

	public void typePhone() {
		driver.findElement(search).sendKeys("Apple iPhone XR (64GB) - White");
	}

	public void clickSubmit() {
		driver.findElement(submitbutton).click();
	}

}
