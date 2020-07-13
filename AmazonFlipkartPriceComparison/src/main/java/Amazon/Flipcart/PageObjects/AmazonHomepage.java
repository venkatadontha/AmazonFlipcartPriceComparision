package Amazon.Flipcart.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonHomepage
{
	WebDriver driver;
	By search = By.xpath("//input[@id='twotabsearchtextbox']");
	By button = By.xpath("//input[@type='submit']");
	By Img = By.className("s-image");

	public AmazonHomepage(WebDriver driver) {

		this.driver = driver;
	}

	public void typePhone() {
		driver.findElement(search).sendKeys("Apple iPhone XR (64GB) - White");
	}

	public void clickSearch() {
		driver.findElement(button).click();
	}

	public void clickImg() {
		driver.findElement(Img).click();
	}


}
