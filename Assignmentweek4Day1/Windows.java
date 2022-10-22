package assignment.Week4.Day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windows {
	   

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
        driver.get("https://leafground.com/window.xhtml");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only mr-2 mb-2']")).click();
        Set<String>windowHandles=driver.getWindowHandles();
        List<String>listHandles=new ArrayList<String>(windowHandles);
        driver.switchTo().window(listHandles.get(1));
        String dashboard=driver.getTitle();
        String mandashboard="Dashboard";
        if(dashboard.equals(mandashboard))
        {
        	System.out.println(dashboard +": " +"New window opens");
        }
        else{
        	System.out.println(dashboard + ": "+"New window not opens");
        }
        driver.close();
        driver.switchTo().window(listHandles.get(0));
        String Firstwindow=driver.getWindowHandle();
        driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
        Set<String>windowHandles1=driver.getWindowHandles();
        for(String Mwindow:windowHandles1)
        {
        	if(!Mwindow.equals(Firstwindow))
        	{
        		driver.switchTo().window(Mwindow);
        		driver.close();
        	}
        }
        driver.switchTo().window(listHandles.get(0));
        driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        System.out.println("No. of tabs: " + tabs.size());
        Set<String>windowHandles2=driver.getWindowHandles();
        for(String Mwindow:windowHandles2)
        {
        	if(!Mwindow.equals(Firstwindow))
        	{
        		driver.switchTo().window(Mwindow);
        		driver.close();
        	}
        }
        driver.switchTo().window(listHandles.get(0));
        driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
        WebDriverWait webdwait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element = webdwait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("layout-config-button")));
        if(element.isDisplayed())
        {
        	System.out.println("Waited for 2 new tabs to open");
        }
        else{
        	System.out.println("Not Waited for 2 new tabs to open");
        }
        Set<String>windowHandles3=driver.getWindowHandles();
        for(String Mwindow:windowHandles3)
        {
        	if(!Mwindow.equals(Firstwindow))
        	{
        		driver.switchTo().window(Mwindow);
        		driver.close();
        	}
        }
	}

}
