
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class DeleteDraft {

	public static void main(String[] args) throws Exception{
		long start = System.currentTimeMillis(); 
		Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
		Runtime.getRuntime().exec("taskkill /F /IM Chrome.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Np\\Dev\\Eclipse\\Repo\\Test\\jars\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    String login = "https://sso.gem.gov.in/ARXSSO/oauth/doLogin";
		String draft = "https://admin-mkp.gem.gov.in/admin/cat/catalog/angular_catalog/#!/catalog/index";
		
		String uname = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\reseller-creden.txt")).get(0);
		String pwd = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\reseller-creden.txt")).get(1);
		System.out.println("	Reading Username and Password from file... ");
		driver.manage().window().maximize();
		driver.get(login);
		driver.findElement(By.id("loginid")).sendKeys(uname); 
		driver.findElement(By.id("captcha_math")).click();
		Thread.sleep(500);
		driver.findElement(By.cssSelector("#loginFrm>div.row>div:nth-child(2)>button")).click();
		driver.findElement(By.id("captcha_math")).click();
		Thread.sleep(500);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(pwd);
		Thread.sleep(500);
		driver.findElement(By.cssSelector("#loginFrm>div.row>div:nth-child(1)>button")).click();
		Thread.sleep(500); 

		driver.get(draft);
		Thread.sleep(3000); 
//		driver.findElement(By.xpath("//img[@id='floxChatCloseImage']")).click();
		Thread.sleep(500); 
		driver.findElement(By.xpath(".//span[contains(text(),'More')]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[contains(text(),'Draft products')]")).click();
		Thread.sleep(3000);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(500);
//		driver.findElement(By.xpath("//img[@id='floxChatCloseImage']")).click();

		int count = 0;
for(int i=0; i<10000; i++)
{	
	
//	driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/index-component[1]/div[2]/div[1]/ul[1]/li[3]/a[1]")).click(); // PAGE5

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Thread.sleep(3000);
	if(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/index-component/div[2]/div/div[4]/table/tbody/tr[1]/td[12]/span[3]/a")).isDisplayed())
	{
		Thread.sleep(500);
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/index-component/div[2]/div/div[4]/table/tbody/tr[1]/td[12]/span[3]/a")).click();
	}
	else
	{
		Thread.sleep(500);
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/index-component/div[2]/div/div[4]/table/tbody/tr[1]/td[12]/span[3]/a")).click();
	}
	
//	driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/index-component/div[2]/div/div[4]/table/tbody/tr[1]/td[12]/span[3]/a")).click();
	Thread.sleep(500);
	driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
	Thread.sleep(2000);

		count++;
		long ExecutionTime = (System.currentTimeMillis() - start);
		long ETS = ExecutionTime/1000 ;
		System.out.println(" ====>  "+count+" : Stock DELETED in " + ETS +" seconds");
		
	  }
	}
}	