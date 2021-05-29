import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Oprations {

	public static void main(String[] args) throws Exception {
		Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
//		Runtime.getRuntime().exec("taskkill /F /IM Chrome.exe");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Np\\Dev\\Eclipse\\Repo\\Test\\jars\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars"); //"--headless",  "--window-size=1920,1200" , 
		
		WebDriver driver = new ChromeDriver(options);
//		options.setHeadless(true);
		System.out.println("	Chrome Chalu hua... ");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String login = "https://sso.gem.gov.in/ARXSSO/oauth/doLogin";
		
		String addnewproduct = "https://admin-mkp.gem.gov.in/admin/cat/catalog/angular_catalog/#!/catalog/new?bnid=home_offi_offi_prin_comp";
//		String addnewproduct = "https://admin-mkp.gem.gov.in/#!/catalog/new?id=4153684-23347374817-cat&bnid=home_offi_offi_prin_comp";

		String uname = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\creden.txt")).get(0);
		String pwd = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\creden.txt")).get(1);
		System.out.println("	Reading Username and Password from file... ");
		
		driver.manage().window().maximize();
		driver.get(login);
		System.out.println("	Login page Open hua... ");
		driver.findElement(By.id("loginid")).sendKeys(uname);
		Thread.sleep(100);
		driver.findElement(By.xpath("/html[1]/body[1]/section[5]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[4]/div[2]/button[1]")).click();
		Thread.sleep(100);
		driver.findElement(By.id("captcha_math")).click();
		System.out.println("	Time To Enter Captcha here ... ");
		
//		Tess4j OCR
		
		
		
		Thread.sleep(600);
		driver.findElement(By.xpath("//input[@id='password']")).click();
		driver.findElement(By.xpath("//input[@id='password']")).clear();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
		Thread.sleep(600);
		Thread.sleep(600);
		driver.findElement(By.cssSelector("#loginFrm>div.row>div:nth-child(1)>button")).click();
		Thread.sleep(600);
		options.setHeadless(true);
		driver.get(addnewproduct);
		System.out.println("	addnewproduct Open hua abhi... ");
	
//		for(int i = 0; i<1000 ; i++)
//		{
//		driver.get(addnewproduct);
////		Thread.sleep(600);
//		driver.findElement(By.xpath("//img[@id='floxChatCloseImage']")).click();
////		WebElement accordion = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[1]/div/div[1]/h4/a/span/div/div[2]"));
////		String getAttribute = accordion.getAttribute("class");
////		System.out.println("	getAttribute: " + getAttribute);
//		
//		String acc = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form/div")).getAttribute("class"); //uib-accordion-group
//		if(acc.contentEquals("panel-default ng-isolate-scope panel"))
//		{
//			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form/div")).click();
//			System.out.println("acc:  "+acc);
//			System.out.println(" ::::::::   acc OPEN KIYA BHAI ");
//		}
//		else {
//			System.out.println("acc:  "+acc);
//			System.out.println("acc already open hai ::::::: ");
//		}
//	
//	
//	}

	}
}