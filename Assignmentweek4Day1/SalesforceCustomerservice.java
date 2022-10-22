package assignment.Week4.Day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceCustomerservice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://login.salesforce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@class='input r4 wide mb16 mt8 username']")).sendKeys("ramkumar.ramaiah@testleaf.com");
        driver.findElement(By.xpath("//input[@class='input r4 wide mb16 mt8 password']")).sendKeys("Password#123");
        driver.findElement(By.xpath("//input[@class='button r4 wide primary']")).click();
        driver.findElement(By.xpath("(//span[@class=' label bBody'])[2]")).click();
        Set<String>windowHandles=driver.getWindowHandles();
        List<String>listHandles=new ArrayList<String>(windowHandles);
        driver.switchTo().window(listHandles.get(1));
        driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
        String confirmtitle=driver.getTitle();
        System.out.println("Title is:"+" "+confirmtitle);
        driver.switchTo().window(listHandles.get(0));
        driver.close();
        
	}

}
