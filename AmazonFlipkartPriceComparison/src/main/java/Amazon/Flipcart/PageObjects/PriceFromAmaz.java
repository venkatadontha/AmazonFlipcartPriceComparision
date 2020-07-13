package Amazon.Flipcart.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PriceFromAmaz 
{
	WebDriver driver;
	
	By price = By.className("a-price-whole");
	By PDPPrice = By.cssSelector("span#priceblock_ourprice");
	
	public PriceFromAmaz(WebDriver driver) {
		this.driver = driver;
	}

	public String getPrice() {
		return driver.findElement(price).getText();
	}
	
	public String getPDPPrice() {
		return driver.findElement(price).getText();
	}

}
