package marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.sukgu.Shadow;

public class AdministratorCertifications {

	public static void main(String[] args) throws IOException {
	
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Testleaf$321");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//span[text()='Learn More']")).click(); 
		Set<String> winSet = driver.getWindowHandles();
		List<String> listOfWindows = new ArrayList<String>(winSet);
		driver.switchTo().window(listOfWindows.get(1));
		driver.findElement(By.xpath("(//button[contains(@class,'slds-button slds')])[2]")).click();
		Shadow dom = new Shadow(driver);
		dom.setImplicitWait(20);
		WebElement ele = dom.findElementByXPath("//span[text()='Learning']");
		ele.click();
		WebElement trailhead = dom.findElementByXPath("//span[text()='Learning on Trailhead']");
		Actions builder = new Actions(driver);
		builder.moveToElement(trailhead).perform();
		builder.scrollToElement(trailhead).perform();
		WebElement certificate = dom.findElementByXPath("//h4/a[text()='Salesforce Certification']");
		driver.executeScript("arguments[0].click();", certificate);
		driver.findElement(By.xpath("//a[text()='Administrator']")).click();
		Set<String> newWin = driver.getWindowHandles();
		List<String> adminWin = new ArrayList<String>(newWin);
		driver.switchTo().window(adminWin.get(1));
		 WebElement scroll = driver.findElement(By.xpath("//h1[text()='Earn your Credential']"));
         builder.scrollToElement(scroll).perform();
		 File source = driver.getScreenshotAs(OutputType.FILE);
		 File dest = new File("./screenshot/snap.jpg");
		 FileUtils.copyFile(source, dest);
		
		
		
		
	}

}
