import java.awt.AWTException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
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

public class BoxFileListing 
{
	public static void main(String[] args) throws InterruptedException, AWTException, Exception 
	{
		long start = System.currentTimeMillis();
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver97.exe");
		Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
		
		int count = 0;
		String str = null;
		String Model = null;
		String ProductName = null;
		StringSelection img0 = null;
		StringSelection img1 = null;
		StringSelection img2 = null;
		StringSelection img3 = null;
		int tempMRP;
		int minOfferPrice;
	    int maxOfferPrice;
	    int tempOfferPrice;
	    int minRandomDimension = 100;
	    int maxRandomDimension = 999;
	    String Colour = null;
		String login = "https://sso.gem.gov.in/ARXSSO/oauth/doLogin";
		String addnewproduct = "https://admin-mkp.gem.gov.in/admin/cat/catalog/angular_catalog/#!/catalog/new?bnid=home_offi_offi_fold_boxf";
		String uname = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\BoxFileListingID.txt")).get(0);
		String pwd = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\BoxFileListingID.txt")).get(1);
		System.out.println("	get Username and Password ... ");
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("==> Enter Box File Color: ");
		System.out.println("==> Blue = B | Red = R | Yellow = Y | Green = G | Pink = P | Black = Bk");
		str = in.next();
	    
	    if(str.contentEquals("b") || str.contains("B") || str.contains("Blue"))
		    {
	    	Model = "Blue Box File";
    		ProductName = "Blue Box File";
    		Colour = "Blue";
    		img0 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\BoxFileImages\\BlueFile\\img0.jpg");
    		img1 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\BoxFileImages\\BlueFile\\img1.jpg");
    		img2 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\BoxFileImages\\BlueFile\\img2.jpg");
    		img3 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\BoxFileImages\\BlueFile\\img3.jpg");
	    	Thread.sleep(500);
	    	System.out.println("==> Blue Box File Selected :: OK ");		    
		    }
	    
	    else if(str.contentEquals("r") || str.contains("R") || str.contains("Red"))
			{
	    	Model = "Red Box File";
	    	ProductName = "Red Box File";
	    	Colour = "Red";
    	 	img0 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\BoxFileImages\\RedFile\\img0.jpg");
    		img1 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\BoxFileImages\\RedFile\\img1.jpg");
    		img2 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\BoxFileImages\\RedFile\\img2.jpg");
    		img3 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\BoxFileImages\\RedFile\\img3.jpg");
	    	Thread.sleep(500);
	    	System.out.println("==> Red Box File Selected :: OK ");		    
		    }
	    else if(str.contentEquals("y") || str.contains("Y") || str.contains("Yellow"))
			{
	    	Model = "Yellow Box File";
    		ProductName = "Yellow Box File";
    		Colour = "Yellow";
    		img0 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\BoxFileImages\\YellowFile\\img0.jpg");
    		img1 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\BoxFileImages\\YellowFile\\img1.jpg");
    		img2 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\BoxFileImages\\YellowFile\\img2.jpg");
    		img3 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\BoxFileImages\\YellowFile\\img3.jpg");
	    	Thread.sleep(500);
	    	System.out.println("==> Yellow Box File Selected :: OK ");
			}
	    else if(str.contentEquals("g") || str.contains("G") || str.contains("Green"))
			{
	    	Model = "Green Box File";
    		ProductName = "Green Box File";
    		Colour = "Green";
    		img0 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\BoxFileImages\\GreenFile\\img0.jpg");
    		img1 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\BoxFileImages\\GreenFile\\img1.jpg");
    		img2 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\BoxFileImages\\GreenFile\\img2.jpg");
    		img3 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\BoxFileImages\\GreenFile\\img3.jpg");
	    	Thread.sleep(500);
	    	System.out.println("==> Green Box File Selected :: OK ");
			}
	    else if(str.contentEquals("p") || str.contains("P") || str.contains("Pink"))
			{
	    	Model = "Pink Box File";
    		ProductName = "Pink Box File";
    		Colour = "Any other";
    		img0 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\BoxFileImages\\PinkFile\\img0.jpg");
    		img1 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\BoxFileImages\\PinkFile\\img1.jpg");
    		img2 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\BoxFileImages\\PinkFile\\img2.jpg");
    		img3 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\BoxFileImages\\PinkFile\\img3.jpg");
	    	Thread.sleep(500);
	    	System.out.println("==> Pink Box File Selected :: OK ");
			}
	    else if(str.contentEquals("bk") || str.contains("BK") || str.contains("Black"))
		{
    	Model = "Black Box File";
		ProductName = "Black Box File";
		Colour = "Black";
		img0 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\BoxFileImages\\BlackFile\\img0.jpg");
		img1 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\BoxFileImages\\BlackFile\\img1.jpg");
		img2 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\BoxFileImages\\BlackFile\\img2.jpg");
		img3 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\BoxFileImages\\BlackFile\\img3.jpg");
    	Thread.sleep(500);
    	System.out.println("==> Black Box File Selected :: OK ");
		}
	    

		
		System.setProperty("webdriver.chrome.driver", "C:\\Np\\Dev\\Eclipse\\Repo\\Test\\jars\\chromedriver97.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
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
		driver.findElement(By.cssSelector("#loginFrm>div.row>div:nth-child(1)>button")).click();
		Thread.sleep(300);
		
//for loop start
		for (int i = 0; i < 1000; ) 
		{
		Robot robot = new Robot();
		driver.get(addnewproduct);
		Thread.sleep(600);
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		if ( driver.getPageSource().contains("An error occurred.") || driver.getPageSource().contains("Bad Request") || driver.getPageSource().contains("GeM - Government e Marketplace : Service Unavailable"))
		{
			driver.navigate().refresh();
			System.out.println("Error: page not loaded correctly ......., refreshing ... for " + addnewproduct ); //ProductID
		}
		else
		{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			tempMRP = 250;
			minOfferPrice = 150;
		    maxOfferPrice = 199;
		    tempOfferPrice = (int)Math.floor(Math.random()*(maxOfferPrice-minOfferPrice+1)+minOfferPrice);
		    String MRP = String.valueOf(tempMRP);
		    String OfferPrice = String.valueOf(tempOfferPrice);
		    System.out.println("MRP: "+MRP);
			System.out.println("OfferPrice: "+OfferPrice);
			
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[1]/div/div[2]/div/fieldset/div[3]/div[2]/select")).sendKeys("EXPO");
			Thread.sleep(600);
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[1]/div/div[2]/div/fieldset/div[7]/div[2]/input")).click();
			Thread.sleep(600);
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/div[2]/div/div[3]/button")).click();
			Thread.sleep(1000);
			
//			model and product name
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[2]/div/div[2]/div/fieldset/div[1]/div[2]/input")).sendKeys(Model);
			Thread.sleep(600);
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[2]/div/div[2]/div/fieldset/div[2]/div[2]/input")).sendKeys(ProductName);
			Thread.sleep(600);
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[2]/div/div[2]/div/fieldset/div[7]/div[2]/button")).click();
			Thread.sleep(4000);
						
//			image0 upload
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[15]/div[4]/document-upload/div[1]/fieldset/div[2]/button")).click();					
			clipboard.setContents(img0, null);
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
			
//			Resellers Details
			driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/selling-as[1]/div[1]/div[1]/div[2]/select[1]")).sendKeys("Resellers");
			Thread.sleep(100);
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/div[1]/div[2]/div[1]/div[1]/input[1]")).sendKeys("india");
			Thread.sleep(600);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(100);
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(100);
			
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[2]/div[2]/label[2]/input")).click();
			Thread.sleep(100);
					
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[14]/div[2]/input")).sendKeys(MRP);
			Thread.sleep(100);
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[15]/div[4]/document-upload/div[1]/fieldset/div[2]/select")).sendKeys("Packaging Photo");
			Thread.sleep(100);
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[16]/div[2]/input")).sendKeys(OfferPrice);
			Thread.sleep(600);
			driver.findElement(By.xpath("//tbody/tr[1]/td[1]/input[1]")).click();
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
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[18]/div[5]/div[2]/input")).sendKeys("5000");
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[18]/div[6]/div[2]/input")).sendKeys("12");
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[18]/div[7]/div[2]/input")).sendKeys("5");
			Thread.sleep(100);
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[19]/div[2]/label/input")).click();
			Thread.sleep(100);
			driver.findElement(By.xpath("/html/body")).click();
			Thread.sleep(100);
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[20]/div[2]/button")).click();
			Thread.sleep(4000);
						
//			product specs
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[4]/div/div[2]/div/fieldset/div[2]/div[4]/document-upload/div[1]/fieldset/div[2]/select")).sendKeys("Any Other Documents");
			Thread.sleep(600);	
			
			driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[4]/div[1]/div[2]/div[1]/fieldset[1]/div[2]/div[4]/document-upload[1]/div[1]/fieldset[1]/div[2]/button[1]")).click();
			Thread.sleep(600);
			clipboard.setContents(img1, null);					
			driver.switchTo().activeElement();
			Thread.sleep(600);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			Thread.sleep(600);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			Thread.sleep(600);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		
			Thread.sleep(4000);

//			Material = cardboard
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[4]/div/div[2]/div/fieldset/div[1]/form-builder/div/div[1]/div/fieldset/div[1]/div/div[2]/div/element/div/div/div[1]/span")).click();
			Thread.sleep(300);
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[4]/div/div[2]/div/fieldset/div[1]/form-builder/div/div[1]/div/fieldset/div[1]/div/div[2]/div/element/div/div/input[1]")).sendKeys("Cardboard");
			Thread.sleep(600);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(100);
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(100);
			
//			Document Clamp Included = Yes
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[4]/div/div[2]/div/fieldset/div[1]/form-builder/div/div[1]/div/fieldset/div[2]/div/div[2]/div/element/div/div/div[1]/span")).click();
			Thread.sleep(300);
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[4]/div/div[2]/div/fieldset/div[1]/form-builder/div/div[1]/div/fieldset/div[2]/div/div[2]/div/element/div/div/input[1]")).sendKeys("Yes");
			Thread.sleep(600);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(100);
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(100);
			
//			Document Clamp Type = any other
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[4]/div/div[2]/div/fieldset/div[1]/form-builder/div/div[1]/div/fieldset/div[3]/div/div[2]/div/element/div/div/div[1]/span")).click();
			Thread.sleep(300);
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[4]/div/div[2]/div/fieldset/div[1]/form-builder/div/div[1]/div/fieldset/div[3]/div/div[2]/div/element/div/div/input[1]")).sendKeys("any other");
			Thread.sleep(600);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(100);
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(100);

//			send productName
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[4]/div/div[2]/div/fieldset/div[1]/form-builder/div/div[1]/div/fieldset/div[4]/div/div[2]/div/element/div/input")).sendKeys(ProductName);
			
//			Dimension tweaks
		    int RandomInt1 = (int)Math.floor(Math.random()*(maxRandomDimension-minRandomDimension+1)+minRandomDimension);
		    String StrRandomInt1 = String.valueOf(RandomInt1);
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[4]/div/div[2]/div/fieldset/div[1]/form-builder/div/div[2]/div/fieldset/div[1]/div/div[2]/div/element/div/input")).sendKeys("37."+StrRandomInt1);
			
			int RandomInt2 = (int)Math.floor(Math.random()*(maxRandomDimension-minRandomDimension+1)+minRandomDimension);
			String StrRandomInt2 = String.valueOf(RandomInt2);
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[4]/div/div[2]/div/fieldset/div[1]/form-builder/div/div[2]/div/fieldset/div[2]/div/div[2]/div/element/div/input")).sendKeys("27."+StrRandomInt2);
			
			int RandomInt3 = (int)Math.floor(Math.random()*(maxRandomDimension-minRandomDimension+1)+minRandomDimension);
			String StrRandomInt3 = String.valueOf(RandomInt3);
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[4]/div/div[2]/div/fieldset/div[1]/form-builder/div/div[2]/div/fieldset/div[3]/div/div[2]/div/element/div/input")).sendKeys("12."+StrRandomInt3);
			
//			colour
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[4]/div/div[2]/div/fieldset/div[1]/form-builder/div/div[3]/div/fieldset/div[1]/div/div[2]/div/element/div/div/div[1]/span")).click();
			Thread.sleep(300);
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[4]/div/div[2]/div/fieldset/div[1]/form-builder/div/div[3]/div/fieldset/div[1]/div/div[2]/div/element/div/div/input[1]")).sendKeys(Colour);
			Thread.sleep(600);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(100);
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(100);
			
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[4]/div/div[2]/div/fieldset/div[1]/form-builder/div/div[3]/div/fieldset/div[2]/div/div[2]/div/element/div/input")).sendKeys(Colour);
			Thread.sleep(600);

//			Shape  = Rectangular
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[4]/div/div[2]/div/fieldset/div[1]/form-builder/div/div[3]/div/fieldset/div[3]/div/div[2]/div/element/div/div/div[1]/span")).click();
			Thread.sleep(300);
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[4]/div/div[2]/div/fieldset/div[1]/form-builder/div/div[3]/div/fieldset/div[3]/div/div[2]/div/element/div/div/input[1]")).sendKeys("Rectangular");
			Thread.sleep(600);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(100);
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(100);
			
//			SIZE = Suitable for A4 paper
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[4]/div/div[2]/div/fieldset/div[1]/form-builder/div/div[3]/div/fieldset/div[4]/div/div[2]/div/element/div/div/div[1]/span")).click();
			Thread.sleep(300);
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[4]/div/div[2]/div/fieldset/div[1]/form-builder/div/div[3]/div/fieldset/div[4]/div/div[2]/div/element/div/div/input[1]")).sendKeys("Suitable for A4 paper");
			Thread.sleep(600);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(100);
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(100);
			
//			Capacity
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[4]/div/div[2]/div/fieldset/div[1]/form-builder/div/div[4]/div/fieldset/div/div/div[2]/div/element/div/div/div[1]/span")).click();
			Thread.sleep(300);
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[4]/div/div[2]/div/fieldset/div[1]/form-builder/div/div[4]/div/fieldset/div/div/div[2]/div/element/div/div/input[1]")).sendKeys("80");
			Thread.sleep(600);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(100);
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[4]/div/div[2]/div/fieldset/div[3]/div[2]/button")).click();
			Thread.sleep(4000);
			
//			3 imgs upload
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[5]/div/div[2]/div/fieldset/div[2]/div[1]/div[1]/div/div/button")).click();
			Thread.sleep(600);
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
			
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[5]/div/div[2]/div/fieldset/div[2]/div[1]/div[2]/div/div/button")).click();
			Thread.sleep(600);
			clipboard.setContents(img2, null);					
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
			
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[5]/div/div[2]/div/fieldset/div[2]/div[1]/div[3]/div/div/button")).click();
			Thread.sleep(600);
			clipboard.setContents(img3, null);					
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
			
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[5]/div/div[2]/div/fieldset/div[2]/div[1]/div[3]/div/div/button")).click();
			Thread.sleep(600);
			clipboard.setContents(img0, null);					
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
			
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[5]/div/div[2]/div/fieldset/div[4]/div[2]/input")).click();
			Thread.sleep(600);
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
					
			if (driver.getPageSource().contains("Upload another product") || (driver.getPageSource().contains("Catalogue already uploaded by you:")))
			{
				try {
					driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div[2]/span")).click();
					driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div[2]")).click();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Thread.sleep(500);
				break;
			}
			else {
				continue;
			}	
			}while( ( driver.getPageSource().contains("Invalid captcha") ||( driver.getPageSource().contains("Please enter captcha"))));
//CAPTCHACODE COMPLETED
			 Thread.sleep(2000);
			
			System.out.println("PRODUCT LISTED!!!");
			long ExecutionTime = (System.currentTimeMillis() - start);
			long ETS = ExecutionTime / 1000;
			System.out.println("Execution time: " + ETS + " seconds");
			
		}	
	
			
	}
}
}
