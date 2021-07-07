import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest {
	public String baseurl = "https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=13&ct=1625588040&rver=7.0.6737.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26RpsCsrfState%3d81a26aa6-1dd2-2774-3885-c4b8974e85c5&id=292841&aadredir=1&whr=hotmail.com&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=90015";
	
	String driverPath = "src//chromedriver_win32 (1)//chromedriver.exe";
	public WebDriver driver;
	
  @Test(enabled = true)
  public void verifyComposeMailFunctionality() {
	  //open chrome browser
	  System.out.println("Launching chrome browser");
	  System.setProperty("webdriver.chrome.driver", driverPath);
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get(baseurl);
	  
	  //Enter email and password
	  driver.findElement(By.xpath("//input[@id='i0116']")).sendKeys("popebykyga@hotmail.com");
	  driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
	  
	  driver.findElement(By.xpath("//input[@id='i0118']")).sendKeys("p1U5qP2uQ0DYXON");
	  driver.findElement(By.xpath("/html/body/div/form[1]/div/div/div[2]/div[1]/div/div/div/div/div/div[3]/div/div[2]/div/div[3]/div[2]/div/div/div/div/input")).click();
	  
	  //Click the New Message button
	  driver.findElement(By.xpath("//span[@id='id__7']")).click();
	  
	  //Enter email details
	  driver.findElement(By.xpath("//*[@id=\"ReadingPaneContainerId\"]/div/div/div/div[1]/div[1]/div[1]/div/div[1]/div/div/div/div/div[1]/div/div/input")).sendKeys("popebykyga@hotmail.com");
	  driver.findElement(By.xpath("//*[@id=\"sug-header-item2\"]/div")).click();
	  driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div/div[3]/div[2]/div/div[3]/div[1]/div/div/div/div[1]/div[1]/div[2]/div[2]/div/div/div/input")).sendKeys("Test Email");
	  driver.findElement(By.xpath("//*[@id=\"ReadingPaneContainerId\"]/div/div/div/div[1]/div[2]/div[1]")).click();
	  driver.findElement(By.xpath("//*[@id=\"ReadingPaneContainerId\"]/div/div/div/div[1]/div[2]/div[1]")).sendKeys("Lorem ipsum dolor sit amet");
	  
	  //click send button
	  driver.findElement(By.xpath("//*[@id=\"ReadingPaneContainerId\"]/div/div/div/div[1]/div[3]/div[2]/div[1]/div/span/button[1]/span")).click();
	  
	  //Click on Sent Items
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[1]/div/div/div[1]/div[2]/div/div[1]/div/div[1]/div[2]/div[2]/div")).click();
	  
	  //Verify sent email address
      String expected = "popebykyga@hotmail.com";
      String original = driver.findElement(By.xpath("//*[@id=\"AQAAAAAAAQABAAAAAAAiVgAAAAA=\"]/div/div/div/div[2]/div[1]/div[1]/span")).getText();
      Assert.assertEquals(original, expected);
      
      driver.close();
  }
  
  @Test(enabled = true)
  public void verifyInboxFunctionality() {
	  //open chrome browser
	  System.out.println("Launching chrome browser");
	  System.setProperty("webdriver.chrome.driver", driverPath);
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get(baseurl);
	  
	  //Enter email and password
	  driver.findElement(By.xpath("//input[@id='i0116']")).sendKeys("popebykyga@hotmail.com");
	  driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
	  
	  driver.findElement(By.xpath("//input[@id='i0118']")).sendKeys("p1U5qP2uQ0DYXON");
	  driver.findElement(By.xpath("/html/body/div/form[1]/div/div/div[2]/div[1]/div/div/div/div/div/div[3]/div/div[2]/div/div[3]/div[2]/div/div/div/div/input")).click();
	  
	  //open email in inbox
	  driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]")).click();
      
	  //Verify email sender name
	  String expected = "Leilani Adkins";
      String original = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/span[1]/div[1]/span[1]")).getText();
      Assert.assertEquals(original, expected);
      
      driver.close();
  }

}
