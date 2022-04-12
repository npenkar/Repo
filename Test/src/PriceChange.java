import java.awt.Robot;
import java.util.Scanner;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.CharMatcher;

import net.sourceforge.tess4j.Tesseract;

public class PriceChange {

	public static void main(String[] args) throws Exception{
		
		String uname;
		String pwd;
		String str;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("   :: Stock update for Pooja/ Yash/ Kantado/ Eshani ::");
		System.out.println("==> Enter P = Pooja || Enter Y = Yash || K = Kantado || E = Eshani || V = Vision ");
	    str = in.next();
	    Thread.sleep(500);
	    if(str.contentEquals("p") || str.contains("P") || str.contains("pooja"))
	    {
	    	Thread.sleep(500);
	    	System.out.println("==> Pooja ID PriceChange selected ::: ");
	    	uname = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\PoojaID.txt")).get(0);
			pwd = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\PoojaID.txt")).get(1);
			System.out.println("...	Reading Username and Password from file ...	");
			System.out.println("Username  : " +uname);
			System.out.println("Password : " +pwd);
	    }else if (str.contentEquals("y") || str.contains("Y") || str.contains("yash"))
	    {
	    	Thread.sleep(500);
	    	System.out.println("==> Yash ID PriceChange selected ::: ");
	    	uname = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\YashID.txt")).get(0);
			pwd = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\YashID.txt")).get(1);
			System.out.println("...	Reading Username and Password from file ...	");
			System.out.println("Username  : " +uname);
			System.out.println("Password : " +pwd);
	    }
	    else if (str.contentEquals("KT") || str.contains("kt") || str.contains("K") ||  str.contains("k"))
	    {
	    	Thread.sleep(500);
	    	System.out.println("==> Kantado ID PriceChange selected ::: ");
	    	uname = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\KantadoID.txt")).get(0);
			pwd = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\KantadoID.txt")).get(1);
			System.out.println("...	Reading Username and Password from file ...	");
			System.out.println("Username  : " +uname);
			System.out.println("Password : " +pwd);
			
	    }
	    else

	    	if(str.contentEquals("ES") || str.contains("es") || str.contains("E") || str.contains("e"))
	    {
	    	Thread.sleep(500);
	    	System.out.println("==> Eshani ID PriceChange selected ::: ");
	    	uname = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\EshaniID.txt")).get(0);
			pwd = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\EshaniID.txt")).get(1);
			System.out.println("...	Reading Username and Password from file ...	");
			System.out.println("Username  : " +uname);
			System.out.println("Password : " +pwd);
	    }
	    else // if(str.contentEquals("VS") || str.contains("vs") || str.contains("vision") || str.contains("V"))
	    {
	    	Thread.sleep(500);
	    	System.out.println("==> Vision ID PriceChange selected ::: ");
	    	uname = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\VisionID.txt")).get(0);
			pwd = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\VisionID.txt")).get(1);
			System.out.println("...	Reading Username and Password from file ...	");
			System.out.println("Username  : " +uname);
			System.out.println("Password : " +pwd);
	    }

	    long start = System.currentTimeMillis(); 
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver99.exe");
		Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Np\\Dev\\Eclipse\\Repo\\Test\\jars\\ChromeDriver99.exe");
//		no change
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String login = "https://sso.gem.gov.in/ARXSSO/oauth/doLogin";
		String url1 = "https://admin-mkp.gem.gov.in/#!/catalog/new?id=";
		String url2 = "-cat&bnid=home_offi_offi_prin_comp";
		
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
		Thread.sleep(600);
		
		File src = new File("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\PriceChange.xlsx");
		
		FileInputStream fis = new FileInputStream(src);
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheetAt(0);
		int rowcount = ws.getLastRowNum();
		int count = 0;
		System.out.println("Total Product  ::  " + rowcount);
		
//		for loop start
		for (int i = 0; i < rowcount; ) 
		{
			XSSFCell cell = ws.getRow(i).getCell(0);
			String CatalogueID = cell.getStringCellValue();
			System.out.println("Catalogue ID :: " + CatalogueID);
			fis.close();
			String GoToProduct = url1 + CatalogueID + url2;
			
			driver.get(GoToProduct);
			Thread.sleep(5000);
			
			String CurrentStringPrice = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[16]/div[2]/input")).getAttribute("value"); 
			System.out.println("Current String Price :: " + CurrentStringPrice);
			String StringCurrentPrice = CharMatcher.inRange('0', '9').retainFrom(CurrentStringPrice);
			int CurrentIntPrice = Integer.parseInt(StringCurrentPrice.replaceAll("[^0-9]", ""));
			int UpdatedIntPrice = CurrentIntPrice - 50;
			String UpdatedStringPrice = String.valueOf(UpdatedIntPrice);
			System.out.println("Updated String Price :: " + UpdatedStringPrice);
			
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[16]/div[2]/input")).clear();
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[16]/div[2]/input")).sendKeys(UpdatedStringPrice);
			Thread.sleep(1000);

			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			

//			captcha check start here
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[21]/div[2]/button")).click();	
			Thread.sleep(1000);
			do {
			if(( driver.getPageSource().contains("Invalid captcha") ||( driver.getPageSource().contains("Please enter captcha")) || ( driver.getPageSource().contains("Catalogue already uploaded by you"))))
			
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[21]/div[2]/show-captcha/div/div[1]/i")).click();
			Thread.sleep(1000);	
			WebElement captchaElement = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[21]/div[2]/show-captcha/div/div[1]/img"));
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
				
			driver.findElement(By.xpath("//input[@id='captcha-text']")).clear();
			driver.findElement(By.xpath("//input[@id='captcha-text']")).sendKeys(CapitalCaptcha);
			Thread.sleep(1000);
		
					//				============= Tess4J CAPTCHA Tweak end =============
			
			driver.findElement(By.xpath("//span[contains(text(),'Update Stock')]")).click();
			Thread.sleep(2000);
					
			if (driver.getPageSource().contains("Stock Updated Successfully"))
			{
				break;
			}
			else {
				continue;
			}
//			Thread.sleep(4000);	
			}while( ( driver.getPageSource().contains("Invalid captcha") ||( driver.getPageSource().contains("Please enter captcha"))));
//			
					
				 Thread.sleep(5000);
					
					
				 if (str.contentEquals("P") || str.contains("p"))
				 { 
					FileOutputStream fio = new FileOutputStream(src);
					ws.removeRow(ws.getRow(0));
					int lastrow = ws.getLastRowNum();
					ws.shiftRows(i+1, lastrow, -1);
					wb.write(fio);
					fio.flush();
					fio.close();
					System.out.println("		इसका  " +CatalogueID+ "  लिस्टिंग हो गया 🔥🔥🔥 ");
				}else if (str.contentEquals("Y") || str.contains("y"))
				{
					FileOutputStream fio = new FileOutputStream(src);
					ws.removeRow(ws.getRow(0));
					int lastrow = ws.getLastRowNum();
					ws.shiftRows(i+1, lastrow, -1);
					wb.write(fio);
					fio.flush();
					fio.close();
					System.out.println("		इसका  " +CatalogueID+ "  लिस्टिंग हो गया 🔥🔥🔥 ");
				}else if (str.contentEquals("K") || str.contains("k"))
				{
					FileOutputStream fio = new FileOutputStream(src);
					ws.removeRow(ws.getRow(0));
					int lastrow = ws.getLastRowNum();
					ws.shiftRows(i+1, lastrow, -1);
					wb.write(fio);
					fio.flush();
					fio.close();
					System.out.println("		इसका  " +CatalogueID+ "  लिस्टिंग हो गया 🔥🔥🔥 ");
				}else if (str.contentEquals("E") || str.contains("e"))
				{
					FileOutputStream fio = new FileOutputStream(src);
					ws.removeRow(ws.getRow(0));
					int lastrow = ws.getLastRowNum();
					ws.shiftRows(i+1, lastrow, -1);
					wb.write(fio);
					fio.flush();
					fio.close();
					System.out.println("		इसका  " +CatalogueID+ "  लिस्टिंग हो गया 🔥🔥🔥 ");
				}
		
			
//			WRITE AND FILE CLOSED
			FileOutputStream fio = new FileOutputStream(src);
			ws.removeRow(ws.getRow(0));
			int lastrow = ws.getLastRowNum();
			ws.shiftRows(i+1, lastrow, -1);
		
			wb.write(fio);
			fio.flush();
			fio.close();
			
			System.out.println(CatalogueID+" :: CatalogueID updated Successfully...");
	    	count++;
	    	System.out.println("Total CatalogueID updated :: "+count);
	    	System.out.println("==:+:==:+:==:+:==:+:==:+:==:+:==:+:==:+:==:+:==");

	    	
			long ExecutionTime = (System.currentTimeMillis() - start);
			long ETS = ExecutionTime / 1000;
			System.out.println("Execution time: " + ETS + " seconds");
	    	System.out.println("================================================");			
			Thread.sleep(500);
		}
		
	}		
}
