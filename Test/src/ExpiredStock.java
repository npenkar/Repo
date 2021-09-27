
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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class ExpiredStock {

	public static void main(String[] args) throws Exception{
		long start = System.currentTimeMillis(); 
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver92.exe");
		Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Np\\Dev\\Eclipse\\Repo\\Test\\jars\\chromedriver94.exe");

//		ChromeOptions o= new ChromeOptions();
//	    o.addArguments("--incognito", "--disable-geolocation");
//	    DesiredCapabilities c = DesiredCapabilities.chrome();
//	    c.setCapability(ChromeOptions.CAPABILITY, o);
	    WebDriver driver = new ChromeDriver();
	      
	      
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    String login = "https://sso.gem.gov.in/ARXSSO/oauth/doLogin";
		String draft = "https://admin-mkp.gem.gov.in/admin/cat/catalog/angular_catalog/#!/catalog/index";
		
		String uname = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\creden.txt")).get(0);
		String pwd = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\creden.txt")).get(1);
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
		Thread.sleep(4000); 
		System.out.println("===>> LOGIN SUCCESS...");
		
		driver.get(draft);
		Thread.sleep(20000); 
		System.out.println("===>> 20 SEC WAIT COMPLETED...");
//		driver.findElement(By.xpath("//img[@id='floxChatCloseImage']")).click();
		Thread.sleep(500); 
		driver.findElement(By.xpath(".//span[contains(text(),'More')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//a[contains(text(),'Expired Offerings')]")).click();
		Thread.sleep(10000);
//		driver.findElement(By.xpath("//img[@id='floxChatCloseImage']")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'»')]")).click();
		Thread.sleep(7000);
		int count = 0;
for(int i=0; i<500; i++)
{	
	driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/index-component/div[2]/div/ul/li[5]/a")).click();
	Thread.sleep(7000);
	
//	driver.findElement(By.xpath("//a[contains(text(),'‹')]")).click();
//	Thread.sleep(7000);

	for(int j=1;j<=10;j++)
	{		

		Actions action = new Actions(driver);
		WebElement opennewTAB = driver.findElement(By.xpath("//tbody/tr["+j+"]/td[12]/span[1]/a[1]"));		
		action.moveToElement(opennewTAB).contextClick().build().perform();

		Robot robot = new Robot();
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(200);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		Thread.sleep(3500);

		WebElement country = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/div[1]/div[2]/div[1]/div[1]/input[1]"));
		country.click();
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		robot.keyRelease(KeyEvent.VK_BACK_SPACE);
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		robot.keyRelease(KeyEvent.VK_BACK_SPACE);	
		country.sendKeys("JAPAN");		
		Thread.sleep(100);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(100);
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(100);
		
//		String box2 = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/div[18]/div[2]/label[1]")).getText();
//		System.out.println(box2);
//		WebElement box21 = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/div[18]/div[2]/label[1]"));
//		box21.click();
		Thread.sleep(500);
		
		WebElement UPDATE = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[21]/div[2]/button"));
		JavascriptExecutor CLICK = (JavascriptExecutor) driver;
		CLICK.executeScript("arguments[0].click();", UPDATE);
		Thread.sleep(3500); 
		driver.close();
		driver.switchTo().window(tabs2.get(0));
		count++;
		long ExecutionTime = (System.currentTimeMillis() - start);
		long ETS = ExecutionTime/1000 ;
		System.out.println(" ====>  "+count+" : Stock Updated in " + ETS +" seconds");
		}
	  }
	}
}	