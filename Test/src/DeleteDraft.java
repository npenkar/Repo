
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DeleteDraft {

	public static void main(String[] args) throws Exception{
		long start = System.currentTimeMillis(); 
		Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver99.exe");
		Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Np\\Dev\\Eclipse\\Repo\\Test\\jars\\chromedriver99.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    String login = "https://sso.gem.gov.in/ARXSSO/oauth/doLogin";
		String draft = "https://admin-mkp.gem.gov.in/admin/cat/catalog/angular_catalog/#!/catalog/index";
		
		String uname = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\DeleteDraft.txt")).get(0);
		String pwd = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\DeleteDraft.txt")).get(1);
		System.out.println("	Reading Username and Password from file... ");
		System.out.println(" username : "+ uname);
		System.out.println(" password : "+ pwd);
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
		Thread.sleep(4000); 
		driver.findElement(By.xpath(".//span[contains(text(),'More')]")).click();
		
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[contains(text(),'Draft products')]")).click();
		Thread.sleep(5000);
	     
		int count = 0;
		for(int i=0; i<10000; i++)
		{	
//			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/index-component/div[2]/div/ul/li[3]/a")).click();
//			Thread.sleep(2000);
//			
			for(int j=1; j<=10; j++)
			{
				
//                WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/index-component/div[2]/div/div[4]/table/tbody/tr[8]/td[12]/span[3]/a"));                        
//                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
////                driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/index-component/div[2]/div/ul/li[3]/a")).click(); // PAGE5
//                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////                Thread.sleep(3000);
//                driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/index-component/div[2]/div/div[4]/table/tbody/tr[10]/td[12]/span[3]/a")).click();
//                Thread.sleep(500);
//                driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
//                Thread.sleep(5000);
                
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//				WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/index-component/div[2]/div/div[4]/table/tbody/tr["+j+"]/td[12]/span[3]"));
				WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/index-component/div[2]/div/div[4]/table/tbody/tr[1]/td[12]/span[3]/a"));
//				Thread.sleep(500);
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", element);
//				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
				Thread.sleep(500);
				driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
				Thread.sleep(5000);
				
				count++;
				long ExecutionTime = (System.currentTimeMillis() - start);
				long ETS = ExecutionTime/1000 ;
				System.out.println(" ====>  "+count+" : Stock DELETED in " + ETS +" seconds");
			}
		
		}
	}
}	