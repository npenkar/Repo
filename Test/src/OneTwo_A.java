import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.common.base.CharMatcher;

import net.sourceforge.tess4j.Tesseract;

public class OneTwo_A 
{
	@SuppressWarnings("resource")
	public static void main(String[] args) throws InterruptedException, AWTException, Exception 
	{

		String uname;
		String pwd;
		String str;
		int count = 0;
		
//		String[] ProductIds = {"5116877-38751413363"};
//		String SelectProductId = (ProductIds[new Random().nextInt(ProductIds.length)]);
//		int idx = new Random().nextInt(ProductIds.length);
//		String SelectedProductID = (ProductIds[idx]);
		
		String SelectedProductID = "5116877-38751413363";

		Robot robot = new Robot();
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("   :: Fixed Price for Pooja/ Yash ::");
		System.out.println("==> Enter P = Pooja || Enter Y for Yash : ");
	    str = in.next();
	    Thread.sleep(500);
	    if(str.contentEquals("p") || str.contains("P") || str.contains("pooja"))
	    {
	    	Thread.sleep(500);
	    	System.out.println("==> Pooja ID Stock update selected ::: ");
	    	uname = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\PoojaID.txt")).get(0);
			pwd = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\PoojaID.txt")).get(1);
			System.out.println("...	Reading Username and Password from file ...	");
			System.out.println("Username  : " +uname);
			System.out.println("Password : " +pwd);
			
	    }else
	    {
	    	Thread.sleep(500);
	    	System.out.println("==> Yash ID Stock update selected ::: ");
	    	uname = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\YashID.txt")).get(0);
			pwd = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\YashID.txt")).get(1);
			System.out.println("...	Reading Username and Password from file ...	");
			System.out.println("Username  : " +uname);
			System.out.println("Password : " +pwd);	
	    }

		long start = System.currentTimeMillis();
		Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver96.exe");
		Runtime.getRuntime().exec("taskkill /F /IM Chrome.exe");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Np\\Dev\\Eclipse\\Repo\\Test\\jars\\chromedriver96.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String login = "https://sso.gem.gov.in/ARXSSO/oauth/doLogin";
		String addnewproduct = "https://admin-mkp.gem.gov.in/admin/cat/catalog/angular_catalog/#!/catalog/new?bnid=home_offi_offi_prin_comp";
//		String search = "https://mkp.gem.gov.in/home/search?q=";
		
		driver.manage().window().maximize();
		driver.get(login);
		driver.findElement(By.id("loginid")).sendKeys(uname);
		Thread.sleep(100);
		driver.findElement(By.xpath("/html[1]/body[1]/section[5]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[4]/div[2]/button[1]")).click();
		Thread.sleep(100);
		driver.findElement(By.id("captcha_math")).click();
		Thread.sleep(600);
		driver.findElement(By.xpath("//input[@id='password']")).click();
		driver.findElement(By.xpath("//input[@id='password']")).clear();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
		Thread.sleep(600);
		Thread.sleep(600);
		driver.findElement(By.cssSelector("#loginFrm>div.row>div:nth-child(1)>button")).click();
		Thread.sleep(300);
		
//		for loop start
		for (int i = 0; i < 1000; ) 
		{
			
			String Model = "HP 12A Black Original LaserJet Toner Cartridge";
			String ProductName = "HP 12A Black Original LaserJet Toner Cartridge";									
			String MakeofCompatiblecartridge = "12A HP BLACK";
			String ModelofCompatiblecartridge = "12A";
			String PartNumber = "12A BLACK TONER";
			String MRP = "5999";
			String SellPrice = "2149";
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
						
			driver.get(addnewproduct);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[1]/div[1]/div[2]/div[1]/fieldset[1]/div[3]/div[2]/select[1]")).sendKeys("MB CARTRIDGE");
			driver.findElement(By.name("copy_catalog_id")).sendKeys(SelectedProductID);
			Thread.sleep(500);
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[1]/div[1]/div[2]/div[1]/fieldset[1]/div[5]/div[3]/button[1]")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/button[2]")).click();
			driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[1]/div[1]/div[2]/div[1]/fieldset[1]/div[7]/div[2]/input[1]")).click();
			Thread.sleep(700);
			driver.findElement(By.xpath("//button[contains(text(),'Proceed with new item')]")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[2]/div[1]/div[2]/div[1]/fieldset[1]/div[1]/div[2]/input[1]")).sendKeys(Model); 
			Thread.sleep(500);
			driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[2]/div[1]/div[2]/div[1]/fieldset[1]/div[2]/div[2]/input[1]")).sendKeys(ProductName);
			Thread.sleep(500);
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[2]/div/div[2]/div/fieldset/div[7]/div[2]/button")).click();
			Thread.sleep(3000);
						
//image 0
			driver.findElement(By.xpath("//button[@id='spec-upload-btn']")).click();
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			StringSelection img1 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\12aimages\\12Aimg1.png");					
			clipboard.setContents(img1, null);
			driver.switchTo().activeElement();
			Thread.sleep(600);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			Thread.sleep(100);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			Thread.sleep(100);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
			
		    if(str.contentEquals("p") || str.contains("P") || str.contains("pooja"))
		    {
		    driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/selling-as[1]/div[1]/div[1]/div[2]/select[1]")).sendKeys("OEM");
			Thread.sleep(100);
		    }
		    else
		    {
//Resellers Details
			driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/selling-as[1]/div[1]/div[1]/div[2]/select[1]")).sendKeys("Resellers");
			Thread.sleep(100);
			
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/selling-as[1]/div[1]/fieldset[1]/div[2]/div[2]/input[1]")).sendKeys("12345");
			Thread.sleep(100);
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/selling-as[1]/div[1]/fieldset[1]/div[3]/div[2]/input[1]")).sendKeys("54321");
			Thread.sleep(100);
			
//						DATE TWEEKS
//						Authorization Date*
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/selling-as[1]/div[1]/fieldset[1]/div[4]/div[2]/p[1]/span[1]/button[1]/i[1]")).click();
			Thread.sleep(100);
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/selling-as[1]/div[1]/fieldset[1]/div[4]/div[2]/p[1]/div[1]/ul[1]/li[2]/span[1]/button[1]")).click();
			Thread.sleep(100);
			
//						Authorization Validity*	 From
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/selling-as[1]/div[1]/fieldset[1]/div[5]/div[2]/div[1]/div[2]/p[1]/span[1]/button[1]/i[1]")).click();
			Thread.sleep(100);
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/selling-as[1]/div[1]/fieldset[1]/div[5]/div[2]/div[1]/div[2]/p[1]/div[1]/ul[1]/li[2]/span[1]/button[1]")).click();
			Thread.sleep(100);	
			
//						Authorization Validity*	 To
//						main click 
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/selling-as[1]/div[1]/fieldset[1]/div[5]/div[2]/div[1]/div[4]/p[1]/span[1]/button[1]/i[1]")).click();
			Thread.sleep(100);
//						click month year
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/selling-as[1]/div[1]/fieldset[1]/div[5]/div[2]/div[1]/div[4]/p[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[2]/button[1]/strong[1]")).click();
			Thread.sleep(100);
//						click year
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/selling-as[1]/div[1]/fieldset[1]/div[5]/div[2]/div[1]/div[4]/p[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[2]/button[1]/strong[1]")).click();
			Thread.sleep(100);
//						select year 2026
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/selling-as[1]/div[1]/fieldset[1]/div[5]/div[2]/div[1]/div[4]/p[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/button[1]")).click();
			Thread.sleep(100);
//						select month march
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/selling-as[1]/div[1]/fieldset[1]/div[5]/div[2]/div[1]/div[4]/p[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/button[1]")).click();
			Thread.sleep(100);
//						select date 31
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/selling-as[1]/div[1]/fieldset[1]/div[5]/div[2]/div[1]/div[4]/p[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[5]/td[4]/button[1]/span[1]")).click();
			Thread.sleep(100);
		    }
//rESELLER END
			
			driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/div[1]/div[2]/div[1]/div[1]/input[1]")).sendKeys("JAPAN");
			Thread.sleep(100);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(100);
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(100);
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[14]/div[2]/input")).sendKeys(MRP);
			Thread.sleep(100);
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[16]/div[2]/input")).sendKeys(SellPrice);
			Thread.sleep(400);
			driver.findElement(By.xpath(".//tbody/tr[1]/td[1]/input[1]")).click();
			Thread.sleep(100);
			driver.switchTo().alert().accept();
			Thread.sleep(100);
			driver.findElement(By.xpath("//tbody/tr[2]/td[1]/input[1]")).click();
			Thread.sleep(100);
			driver.switchTo().alert().accept();
			Thread.sleep(100);
			driver.findElement(By.xpath("//tbody/tr[3]/td[1]/input[1]")).click();
			Thread.sleep(100);
			driver.switchTo().alert().accept();
			Thread.sleep(100);
			driver.findElement(By.xpath("//tbody/tr[4]/td[1]/input[1]")).click();
			Thread.sleep(100);
			driver.switchTo().alert().accept();
			Thread.sleep(100);
			driver.findElement(By.xpath("//tbody/tr[5]/td[1]/input[1]")).click();
			Thread.sleep(100);
			driver.switchTo().alert().accept();
			Thread.sleep(100);
			driver.findElement(By.xpath("//tbody/tr[6]/td[1]/input[1]")).click();
			Thread.sleep(100);
			driver.switchTo().alert().accept();
			Thread.sleep(100);
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[18]/div[5]/div[2]/input")).sendKeys("2000");
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[18]/div[6]/div[2]/input")).sendKeys("1");
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[18]/div[7]/div[2]/input")).sendKeys("10");
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[19]/div[2]/button")).click();
			Thread.sleep(5000);
			
//	trademark
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[4]/div/div[2]/div/fieldset/div[2]/div[4]/document-upload/div[1]/fieldset/div[2]/button")).click();;
			StringSelection copyTM01 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\TRADMARK_compressed.pdf");					
			Thread.sleep(500);
			clipboard.setContents(copyTM01, null);
			driver.switchTo().activeElement();
			Thread.sleep(600);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			Thread.sleep(100);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			Thread.sleep(100);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(4000);

			String Strnumber = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\12aimages\\12Anumber.txt")).get(0);
			int Intnumber = Integer.parseInt(Strnumber) +1;
			
			driver.findElement(By.xpath(".//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[4]/div[1]/div[2]/div[1]/fieldset[1]/div[1]/form-builder[1]/div[1]/div[1]/div[1]/fieldset[1]/div[3]/div[1]/div[2]/div[1]/element[1]/div[1]/input[1]")).clear();
			Thread.sleep(100);
			driver.findElement(By.xpath("./html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[4]/div[1]/div[2]/div[1]/fieldset[1]/div[1]/form-builder[1]/div[1]/div[1]/div[1]/fieldset[1]/div[3]/div[1]/div[2]/div[1]/element[1]/div[1]/input[1]")).clear();
			Thread.sleep(100);
			driver.findElement(By.xpath(".//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[4]/div[1]/div[2]/div[1]/fieldset[1]/div[1]/form-builder[1]/div[1]/div[1]/div[1]/fieldset[1]/div[3]/div[1]/div[2]/div[1]/element[1]/div[1]/input[1]")).sendKeys(MakeofCompatiblecartridge);;
			driver.findElement(By.xpath(".//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[4]/div[1]/div[2]/div[1]/fieldset[1]/div[1]/form-builder[1]/div[1]/div[1]/div[1]/fieldset[1]/div[4]/div[1]/div[2]/div[1]/element[1]/div[1]/input[1]")).clear();
			Thread.sleep(100);
			driver.findElement(By.xpath(".//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[4]/div[1]/div[2]/div[1]/fieldset[1]/div[1]/form-builder[1]/div[1]/div[1]/div[1]/fieldset[1]/div[4]/div[1]/div[2]/div[1]/element[1]/div[1]/input[1]")).sendKeys(ModelofCompatiblecartridge+" "+Intnumber);
			driver.findElement(By.xpath(".//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[4]/div[1]/div[2]/div[1]/fieldset[1]/div[1]/form-builder[1]/div[1]/div[1]/div[1]/fieldset[1]/div[5]/div[1]/div[2]/div[1]/element[1]/div[1]/input[1]")).clear();
			driver.findElement(By.xpath(".//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[4]/div[1]/div[2]/div[1]/fieldset[1]/div[1]/form-builder[1]/div[1]/div[1]/div[1]/fieldset[1]/div[5]/div[1]/div[2]/div[1]/element[1]/div[1]/input[1]")).sendKeys(PartNumber);
			driver.findElement(By.xpath(".//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[4]/div[1]/div[2]/div[1]/fieldset[1]/div[2]/div[4]/document-upload[1]/div[1]/fieldset[1]/div[2]/select[1]")).sendKeys("OEM Authorization Document");
			Thread.sleep(1000);
			
			String SIntnumber =String.valueOf(Intnumber);
			FileWriter fw=new FileWriter("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\12aimages\\12Anumber.txt");    
	        fw.write(SIntnumber);    
	        fw.close();  
			
			driver.findElement(By.xpath(".//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[4]/div[1]/div[2]/div[1]/fieldset[1]/div[3]/div[2]/button[1]")).click();
			Thread.sleep(4000);
			
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[5]/div/div[2]/div/fieldset/div[2]/div[1]/div[1]/div/div/button/i")).click();
			Thread.sleep(600);
			StringSelection img01 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\12Aimages\\12Aimg1.png");
			clipboard.setContents(img01, null);
			driver.switchTo().activeElement();
			Thread.sleep(600);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			Thread.sleep(100);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			Thread.sleep(100);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(4000);
					
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[5]/div/div[2]/div/fieldset/div[2]/div[1]/div[2]/div/div/button/i")).click();
			Thread.sleep(600);
			StringSelection img02 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\12Aimages\\12Aimg2.png");
			clipboard.setContents(img02, null);
			driver.switchTo().activeElement();
			Thread.sleep(600);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			Thread.sleep(100);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			Thread.sleep(100);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(4000);

			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[5]/div/div[2]/div/fieldset/div[2]/div[1]/div[3]/div/div/button/i")).click();
			Thread.sleep(600);
			StringSelection img03 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\12Aimages\\12Aimg3.png");
			clipboard.setContents(img03, null);
			driver.switchTo().activeElement();
			Thread.sleep(600);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			Thread.sleep(100);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			Thread.sleep(100);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(4000);
		
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[5]/div/div[2]/div/fieldset/div[4]/div[2]/input")).click();
			Thread.sleep(300);
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[5]/div/div[2]/div/fieldset/div[5]/div[2]/button")).click();
			Thread.sleep(4000);

			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/div[4]/div/a")).click();
			Thread.sleep(1000);
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_2);
			Thread.sleep(500);
			robot.keyRelease(KeyEvent.VK_2);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(500);
			driver.close();
			Thread.sleep(500);
			driver.switchTo().window(tabs.get(0));
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/div[4]/div[2]/input")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/div[4]/div[3]/show-captcha/div/div[2]/input")).click();
			Thread.sleep(1000);
			
//CAPTCHACODE STARTED
			Actions action = new Actions(driver);
			WebElement Submit = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/div[4]/div[3]/input"));
			action.moveToElement(Submit).click().build().perform();

			do {
			if(( driver.getPageSource().contains("Invalid captcha") ||( driver.getPageSource().contains("Please enter captcha")) || ( driver.getPageSource().contains("Catalogue already uploaded by you"))))
							
				Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/div[4]/div[3]/show-captcha/div/div[1]/i")).click();
			WebElement captchaElement = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/div[4]/div[3]/show-captcha[1]/div[1]/div[1]/img[1]"));
			String captcha = captchaElement.getAttribute("src");
			Thread.sleep(600);

			URL CAPTCHAURL = new URL(captcha);
			BufferedImage saveCAPTCHA = ImageIO.read(CAPTCHAURL);
			ImageIO.write(saveCAPTCHA, "png", new File("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\captcha.png"));
					
			Tesseract tesseract = new Tesseract();
			tesseract.setDatapath("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\jars\\OCRlib\\Tess4J");
						// the path of your tess data folder
						// inside the extracted file
			String captchaTotext = tesseract.doOCR(new File("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\captcha.png"));
						// path of your image file
			String CapitalCaptcha = captchaTotext.toUpperCase();
			System.out.print(CapitalCaptcha);
				
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/div[4]/div[3]/show-captcha[1]/div[1]/div[2]/input[1]")).clear();
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/div[4]/div[3]/show-captcha[1]/div[1]/div[2]/input[1]")).sendKeys(CapitalCaptcha);
			Thread.sleep(1000);
					//				============= Tess4J CAPTCHA Tweak end =============
					
			action.moveToElement(Submit).click().build().perform();
			Thread.sleep(500);
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyPress(KeyEvent.VK_ESCAPE);
			Thread.sleep(500);
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyPress(KeyEvent.VK_ESCAPE);
			Thread.sleep(500);
			action.moveToElement(Submit).click().build().perform();
			Thread.sleep(1000);
					
//			if (driver.getPageSource().contains("Upload another product") || (driver.getPageSource().contains("Catalogue already uploaded by you:")))
//			{
//				driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div[2]")).click();
//				Thread.sleep(500);
//				driver.get(addnewproduct);
//				break;
//			}
//			else {
//				continue;
//			}	
			}while( ( driver.getPageSource().contains("Invalid captcha") ||( driver.getPageSource().contains("Please enter captcha"))));
//CAPTCHACODE COMPLETED
			 Thread.sleep(1000);
			
//			driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div[2]")).click();
//			Thread.sleep(500);
			driver.get(addnewproduct);

			count++;
			System.out.println("		कितना लिस्टिंग हुआ बे ????");
	    	System.out.println("		Total " + count +" LISTING हुआ सरकार...");
			}
			Thread.sleep(2000);
			System.out.println("Case Pass!!!");
			long ExecutionTime = (System.currentTimeMillis() - start);
			long ETS = ExecutionTime / 1000;
			System.out.println("Execution time: " + ETS + " seconds");
		}
	}
	