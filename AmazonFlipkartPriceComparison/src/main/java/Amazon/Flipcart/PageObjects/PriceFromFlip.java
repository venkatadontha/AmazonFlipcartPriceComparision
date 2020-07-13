package Amazon.Flipcart.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PriceFromFlip
{
	WebDriver driver;

	By price = By.xpath("//div[text()='Apple iPhone XR (White, 64 GB)']/../../div[2]/div[1]/div[1]");

	public PriceFromFlip(WebDriver driver) {
		this.driver = driver;
	}

	public String getPrice() {
		return driver.findElement(price).getText().substring(1);
	}


}
