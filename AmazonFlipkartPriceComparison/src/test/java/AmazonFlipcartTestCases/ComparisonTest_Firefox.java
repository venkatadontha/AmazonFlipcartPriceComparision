package AmazonFlipcartTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Amazon.Flipcart.PageObjects.AmazonHomepage;
import Amazon.Flipcart.PageObjects.FlipkartHomePage;
import Amazon.Flipcart.PageObjects.PriceFromAmaz;
import Amazon.Flipcart.PageObjects.PriceFromFlip;

public class ComparisonTest_Firefox 
{
	public static String priceFromAmazon;
	public static String priceFromFlipkart;
	static WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\admin\\Desktop\\GIT Projects\\ZestMoneyAssignment-master\\AmazonFlipkartPriceComparison\\Drivers\\geckodriver.exe");
		System.out.println("Firefox Browser");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test (priority=1)
	public void getPriceFromAmazon() throws InterruptedException
	{
		driver.get("https://www.amazon.in");
		AmazonHomepage az=new AmazonHomepage(driver);
		az.typePhone();
		az.clickSearch();
		PriceFromAmaz paz=new PriceFromAmaz(driver);
		Thread.sleep(2500);
		priceFromAmazon=paz.getPrice();
		
		System.out.println("Price of Apple iPhone XR (64GB) - White in amazon is  - Before " +priceFromAmazon);
		priceFromAmazon = priceFromAmazon.replace(",", "");
		System.out.println("Price of Apple iPhone XR (64GB) - White in amazon is  - After" +priceFromAmazon);
	}
	
	@Test (priority=2)
	public void getPriceFromFlipkart() throws InterruptedException
	{
		driver.get("https://www.flipkart.com/");
		Actions a=new Actions(driver);
		a.sendKeys(Keys.ESCAPE).build().perform();
		FlipkartHomePage fh=new FlipkartHomePage(driver);
		fh.typePhone();
		fh.clickSubmit();
		PriceFromFlip paf= new PriceFromFlip(driver);
		Thread.sleep(2500);
		 priceFromFlipkart= paf.getPrice();
		 System.out.println("Price of Apple iPhone XR (64GB) - White in Flipkart is - Before " +priceFromFlipkart);
		 priceFromFlipkart=priceFromFlipkart.replace(",", "");
		 System.out.println("Price of Apple iPhone XR (64GB) - White in Flipkart is - After " +priceFromFlipkart);
	}
	
	@AfterTest 
	public void comparePrices()
	{
		int amazon = Integer.parseInt(priceFromAmazon);
		int flipkart = Integer.parseInt(priceFromFlipkart);
         
		if (amazon==flipkart) 
		{
			System.out.println("Price of Apple iPhone XR (64GB) - White is same in both websites");
		} 
		else if (amazon>flipkart) 
		{
			System.out.println("Price of Apple iPhone XR (64GB) - White in Flipkart website is less");
		}
		else 
		{
			System.out.println("Price of Apple iPhone XR (64GB) - White in Amazon website is less");
		}
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
	
	
