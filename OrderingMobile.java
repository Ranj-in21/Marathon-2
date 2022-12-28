package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class OrderingMobile {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get(" https://dev57553.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("5$dJ*EFdhhW0");
		driver.findElement(By.id("sysverb_login")).click();
		Shadow dom = new Shadow(driver);
		dom.setImplicitWait(30);
		WebElement all = dom.findElementByXPath("//div[@id='all']");
		all.click();
		dom.setImplicitWait(30);
		WebElement filter = dom.findElementByXPath("//span[text()='Service Catalog']");
		filter.click();
		WebElement frame = dom.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(frame);
		
		driver.findElement(By.xpath("//h2[contains(text(),'Mobiles')]")).click();
		driver.findElement(By.xpath("//a/strong[text()='iPhone 6s']")).click();
		WebElement color = driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[1]"));
		Select colordrop = new Select(color);
		colordrop.selectByValue("gold");
		
		WebElement gigs = driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[2]"));
		Select gigsdrop = new Select(gigs);
		gigsdrop.selectByValue("onehudred_twentyeight");
		
		driver.findElement(By.xpath("//button[@id='oi_order_now_button']")).click();
		
		System.out.println(driver.getTitle());
	
		

	}

}
