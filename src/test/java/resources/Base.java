package resources;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Base {
	public static WebDriver driver;
	public static WebDriver driver1;
	public String date1;
	public String country1;
	public String date2;
	public String country2;

	@Test(priority=1)
	public void Idmb() {
		System.setProperty("webdriver.chrome.driver", "C:\\SwiggyProject\\WebDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.imdb.com/title/tt9389998/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		country1 = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/section[1]/div/section/div/div[1]/section[9]/div[2]/ul/li[2]/div/ul/li/a")).getText();
		date1 = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/section[1]/div/section/div/div[1]/section[9]/div[2]/ul/li[1]/div/ul/li/a")).getText();
        System.out.println(country1);
        System.out.println(date1);

      }
	@Test (priority=3)
	public void Wiki() {
		System.setProperty("webdriver.chrome.driver", "C:\\SwiggyProject\\WebDriver\\chromedriver.exe");
		driver1=new ChromeDriver();
		driver1.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
		//driver.get("https://paytm.com/");
		driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		country2 = driver1.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[14]/td")).getText();
		date2 = driver1.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[12]/td")).getText();
		System.out.println(country2);
        System.out.println(date2);
       }
	@Test(priority=5)
	public void Validation() {
		Assert.assertEquals(country1, country2);
		System.out.println("Country name is same");
		Assert.assertEquals(date1, date2, "Assertion  failed due to another country release date");
		//assertion will fail due to dates are not same
	}
	
	@Test (priority=2)
	public  void tearDown() {
		driver.close();
	}
	@Test(priority=4)
	public  void tearDown1() {
		driver1.close();
	}
}
