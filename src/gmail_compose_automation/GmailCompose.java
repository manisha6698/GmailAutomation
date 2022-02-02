package gmail_compose_automation;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GmailCompose {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "F:\\testing\\Data\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		//visit gmail website
	    driver.get("http://www.gmail.com");
	    
	    //login to gmail account
	    driver.findElement(By.id("identifierId")).sendKeys("testselenium653@gmail.com");
	    driver.findElement(By.xpath("//button//span[contains(.,'Next')]")).click();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    WebDriverWait wait1 = new WebDriverWait(driver, 10);
	    WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='password']/div/div/div/input")));
	    element1.click();
	    driver.findElement(By.xpath("//div[@id='password']/div/div/div/input")).sendKeys("Test@selenium653");
	    WebElement element2 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button//span[contains(.,'Next')]")));
	    element2.click();

	    //When user click on compose button , Then pop up for compose button should be open
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//div[.='Compose']")).click();
	    if(driver.findElement(By.xpath("//span[contains(.,'New Message')]")).isDisplayed()){
	    	System.out.println("Text is present");
	    }else{
	    	System.out.println("Text is absent");
	    }	    
	    
	    //when user click on send button without add recipient, subject and body error pop up will display
	    WebElement sendemail = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[4]/table/tbody/tr/td/div/div[2]/div")));
	    sendemail.click();
	    boolean errortext = driver.findElement(By.xpath("//span[contains(.,'Error')]")).isDisplayed();
	    if(errortext) {
	    	System.out.println("element found");
	    }
	    driver.findElement(By.name("ok")).click();
	    
	    //send an email with body and subject
	    String body = "Automation QA test for Incubyte";
	    String subject = "Incubyte";
	    String emailid = "hello@incubyte.co";
	    
	    driver.findElement(By.name("to")).sendKeys(emailid);
	    driver.findElement(By.name("subjectbox")).sendKeys(subject);
	    driver.findElement(By.xpath("//td[2]/div[2]/div")).sendKeys(body);
	    WebElement send = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[4]/table/tbody/tr/td/div/div[2]/div")));
	    send.click();
	    

	}

}
