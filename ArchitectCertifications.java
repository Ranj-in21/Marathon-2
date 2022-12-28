package marathon;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.sukgu.Shadow;

public class ArchitectCertifications {

	public static void main(String[] args) throws InterruptedException {
	 
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("https://login.salesforce.com/");
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
		driver.findElement(By.xpath("(//a[@class='roleMenu_no-underline'])[2]")).click();
		System.out.println(driver.getCurrentUrl());
		String summary = driver.findElement(By.xpath("//div[contains(@class,'cert-site_text slds-text-align')]")).getText();
		System.out.println("Summary Report: " +summary); 
		List<WebElement> certificationsList = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		int size = certificationsList.size();
		System.out.println("No. of certifications: " +size);
		for (int i = 0; i < size; i++) {
			
			System.out.println(certificationsList.get(i).getText());
			
		}
		
		driver.findElement(By.xpath("(//div[@class='credentials-card_title']/a)[1]")).click();
		
		List<WebElement> ArchitectCertificates = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));		
		int size2 = ArchitectCertificates.size();
		System.out.println("No. of Application Architect certifications: " +size2);
		for (int j = 0; j < size2; j++) {
			
			System.out.println(ArchitectCertificates.get(j).getText());
		}
		
		
		
		
	}

}
