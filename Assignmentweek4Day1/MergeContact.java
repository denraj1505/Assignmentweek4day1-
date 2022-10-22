package assignment.Week4.Day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.get("http://leaftaps.com/opentaps/control/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement username= driver.findElement(By.id("username"));
        username.sendKeys("Demosalesmanager");
        WebElement password= driver.findElement(By.id("password"));
        password.sendKeys("crmsfa");
        WebElement click= driver.findElement(By.className("decorativeSubmit"));
        click.click();
        WebElement link= driver.findElement(By.linkText("CRM/SFA"));
        link.click();
        driver.findElement(By.xpath("//a[text()='Contacts']")).click();
        driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
        driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
        Set<String>windowHandles=driver.getWindowHandles();
        List<String>listHandles=new ArrayList<String>(windowHandles);
        driver.switchTo().window(listHandles.get(1));
        driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
        driver.switchTo().window(listHandles.get(0));
        driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
        Set<String>windowHandles1=driver.getWindowHandles();
        List<String>listHandles1=new ArrayList<String>(windowHandles1);
        driver.switchTo().window(listHandles1.get(1));
        driver.findElement(By.xpath("(//a[@class='linktext'])[5]")).click();
        driver.switchTo().window(listHandles1.get(0));
        driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
        Alert alert= driver.switchTo().alert();
        alert.accept();
        String view=driver.getTitle();
        System.out.println(view);
        String manualview="View Contact | opentaps CRM";
        if(view.contains(manualview))
        {
        	System.out.println("Title of the page:"+" " +view);
        }
        else{
        	System.out.println("Title of the page is not:"+" " +view);
        }
        
	}

}
