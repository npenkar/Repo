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

public class KantadoReseller 
{
	@SuppressWarnings("resource")
	public static void main(String[] args) throws InterruptedException, AWTException, Exception 
	{

		String uname;
		String pwd;
		String str;
		int rowcount;
		FileInputStream fis;
		XSSFWorkbook wb;
		XSSFSheet ws;
		int count = 0;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("   ::Model Number for Pooja/Yash/Kantado ::");
		System.out.println("==> Enter PJ = Pooja || Enter VS = VISION || KT = Kantado ");
	    str = in.next();
	    Thread.sleep(500);
	    if(str.contentEquals("pj") || str.contains("PJ"))
	    {
	    	Thread.sleep(500);
	    	System.out.println("==> Pooja ID Reseller Listing in KANTADO Brand ::: ");
	    	uname = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\PoojaID.txt")).get(0);
			pwd = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\PoojaID.txt")).get(1);
			System.out.println("...	Reading Username and Password from file ...	");
			System.out.println("Username  : " +uname);
			System.out.println("Password : " +pwd);
			
			File src = new File("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\PoojaModelNumber.xlsx"); 
			fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
			ws = wb.getSheetAt(0);
			rowcount = ws.getLastRowNum();
			System.out.println("		कितने Product ID हे रे सांभा ????" + rowcount);
			System.out.println("		सरकार "+rowcount+" ID हे Excel में" );
			
	    }else if(str.contentEquals("VS") || str.contains("vs"))
	    {
	    	Thread.sleep(500);
	    	System.out.println("==> Vision ID Reseller Listing in KANTADO Brand ::: ");
	    	uname = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\VisionID.txt")).get(0);
			pwd = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\VisionID.txt")).get(1);
			System.out.println("...	Reading Username and Password from file ...	");
			System.out.println("Username  : " +uname);
			System.out.println("Password : " +pwd);
			
			File src = new File("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\VisionModelNumber.xlsx"); 
			fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
			ws = wb.getSheetAt(0);
			rowcount = ws.getLastRowNum();
			System.out.println("		कितने Product ID हे रे सांभा ????" + rowcount);
			System.out.println("		सरकार "+rowcount+" ID हे Excel में" );
			
//			fio = new FileOutputStream(src);
	    }
	    else  //if (str.contentEquals("KT") || (str.contentEquals("kt")))
	    {
	    	Thread.sleep(500);
	    	System.out.println("==> Kantado ID Stock update selected ::: ");
	    	uname = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\KantadoID.txt")).get(0);
			pwd = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\KantadoID.txt")).get(1);
			System.out.println("...	Reading Username and Password from file ...	");
			System.out.println("Username  : " +uname);
			System.out.println("Password : " +pwd);
			
			File src = new File("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\KantadoProductID.xlsx"); 
			fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
			ws = wb.getSheetAt(0);
			rowcount = ws.getLastRowNum();
			System.out.println("		कितने Product ID हे रे सांभा ????" + rowcount);
			System.out.println("		सरकार "+rowcount+" ID हे Excel में" );
	    }
//	    else  //if (str.contentEquals("ES") || str.contains("es"))
//	    {
//	    	Thread.sleep(500);
//	    	System.out.println("==> Eshani ID Stock update selected ::: ");
//	    	uname = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\EshaniID.txt")).get(0);
//			pwd = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\EshaniID.txt")).get(1);
//			System.out.println("...	Reading Username and Password from file ...	");
//			System.out.println("Username  : " +uname);
//			System.out.println("Password : " +pwd);
//			
//			File src = new File("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\EshaniProductID.xlsx"); 
//			fis = new FileInputStream(src);
//			wb = new XSSFWorkbook(fis);
//			ws = wb.getSheetAt(0);
//			rowcount = ws.getLastRowNum();
//			System.out.println("		कितने Product ID हे रे सांभा ????" + rowcount);
//			System.out.println("		सरकार "+rowcount+" ID हे Excel में" );
//	    }
	    
		
		long start = System.currentTimeMillis();
		Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver99.exe");
		Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Np\\Dev\\Eclipse\\Repo\\Test\\jars\\ChromeDriver99.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String login = "https://sso.gem.gov.in/ARXSSO/oauth/doLogin";
		String addnewproduct = "https://admin-mkp.gem.gov.in/admin/cat/catalog/angular_catalog/#!/catalog/new?bnid=home_offi_offi_prin_comp";
		String search = "https://mkp.gem.gov.in/home/search?q=";
		
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
			
//		for loop start
		for (int i = 0; i < rowcount; ) 
		{
			XSSFCell cell = ws.getRow(i).getCell(0);
			String ProductID = cell.getStringCellValue();
			System.out.println("		Excel à¤•à¤¾ ID : " + ProductID);
			fis.close();
			Robot robot = new Robot();
			driver.get(search + ProductID);
			Thread.sleep(1000);
			
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			 if ( driver.getPageSource().contains("An error occurred.") || driver.getPageSource().contains("Bad Request") || driver.getPageSource().contains("Looking for something?"))
			 {
				 driver.navigate().refresh();
				 System.out.println("Error: page not loaded correctly ......., refreshing ... for " + ProductID);
			 }
			 else {
			if(driver.getCurrentUrl() == search + ProductID)
			{
				driver.navigate().refresh();
				System.out.println("Error: Url not loaded, refreshing ... " + ProductID);
			}
			else 
			{
			if(driver.findElements(By.xpath("//div[contains(text(),'SEARCH :')]")).size() != 0)
			{
				System.out.println("		😠😠😠 गलत ID निकला बे गांडू 😠😠😠");
				ws.removeRow(ws.getRow(0));
				int lastrow = ws.getLastRowNum();
				ws.shiftRows(i+1, lastrow, -1);
				System.out.println("		गलत था इसीलिए डिलीट कर दिया : "+ProductID);
			}
			else
				{
				System.out.println("ID सही है बे ✅✅✅");
				WebElement NA = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/div[2]/div[3]/div[1]/div[1]/span/span"));
				String sNA = NA.getText();
				System.out.println(">"+sNA+"<");
				String PNA = "Price Not Available";
	
				if (sNA.equalsIgnoreCase(PNA)) 
				{
				ws.removeRow(ws.getRow(0));
				int lastrow = ws.getLastRowNum();
				ws.shiftRows(i+1, lastrow, -1);
				System.out.println("MRP नहीं मिला तो डिलीट कर दिया ...");
				} 
				else 
					{
					String Title = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/h1[1]")).getText();
					Title = Title.split("\n")[0];
					String TempNewModel = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/h1[1]/span[1]")).getText();
					String withoutFirstCharacter = TempNewModel.substring(1);
					String NewModel = withoutFirstCharacter.substring(0, withoutFirstCharacter.length() - 1);					
					
					String Make = driver.findElement(By.xpath("//*[@id=\'feature_groups\']/table/tbody/tr[3]/td[2]")).getText();
					String Model = driver.findElement(By.xpath("//*[@id=\'feature_groups\']/table/tbody/tr[4]/td[2]")).getText();
					String Part = driver.findElement(By.xpath("//*[@id=\'feature_groups\']/table/tbody/tr[5]/td[2]")).getText();
					String OEMBrand = driver.findElement(By.xpath("//*[@id=\'feature_groups\']/table/tbody/tr[6]/td[2]")).getText();
					String OEMModel = driver.findElement(By.xpath("//*[@id=\'feature_groups\']/table/tbody/tr[7]/td[2]")).getText();
					String PrinterModel = driver.findElement(By.xpath("//*[@id=\'feature_groups\']/table/tbody/tr[8]/td[2]")).getText();
					String Yield = driver.findElement(By.xpath("//*[@id=\'feature_groups\']/table/tbody/tr[9]/td[2]")).getText();
//					String Yield = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[3]/div/div[2]/table/tbody/tr[8]/td[2]")).getText();
					Thread.sleep(500);
				
//					String FakeString = "1010/1012/1015/1018/1020/1022";
//					if (Model.contains(FakeString) || OEMModel.contains(FakeString)) 
//					{
//					ws.removeRow(ws.getRow(0));
//					int lastrow = ws.getLastRowNum();
//					ws.shiftRows(i+1, lastrow, -1);
//					System.out.println("====> Model à¤—à¤²à¤¤ à¤¡à¤¾à¤²à¤¾ à¤¬à¥‡ à¤‡à¤¸à¤¨à¥‡ : "+Model+" " +OEMModel);
//					} 
//					else
						{
						driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
						
						WebElement element1 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/ul/li[1]/a/img"));
						JavascriptExecutor executor1 = (JavascriptExecutor) driver;
						executor1.executeScript("arguments[0].click();", element1);
						WebElement img1a = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/div[1]/div[1]/div/div/div/div/div[2]/span/span[3]/img"));
						String img1 = img1a.getAttribute("src");
						Thread.sleep(600);
		
//						WebElement element2 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/ul/li[2]/a/img"));
//						JavascriptExecutor executor2 = (JavascriptExecutor) driver;
//						executor2.executeScript("arguments[0].click();", element2);
//						WebElement img2l = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/div[1]/div[1]/div/div/div/div/div[3]/span/span[3]/img"));
//						String img2 = img2l.getAttribute("src");
//					
//						Thread.sleep(600);
//						WebElement element3 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/ul/li[3]/a/img"));
//						JavascriptExecutor executor3 = (JavascriptExecutor) driver;
//						executor3.executeScript("arguments[0].click();", element3);
//						WebElement img3l = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/div[1]/div[1]/div/div/div/div/div[4]/span/span[3]/img"));
//						String img3 = img3l.getAttribute("src");
					
		//			images save
						URL img0URL = new URL(img1);
						BufferedImage saveImage00 = ImageIO.read(img0URL);
						ImageIO.write(saveImage00, "png", new File("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\img0.png"));
					
						URL img1URL = new URL(img1);
						BufferedImage saveImage01 = ImageIO.read(img1URL);
						ImageIO.write(saveImage01, "png", new File("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\img1.png"));
					
						URL img2URL = new URL(img1);
						BufferedImage saveImage02 = ImageIO.read(img2URL);
						ImageIO.write(saveImage02, "png", new File("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\img2.png"));
				    
						URL img3URL = new URL(img1);
						BufferedImage saveImage03 = ImageIO.read(img3URL);
						ImageIO.write(saveImage03, "png", new File("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\img3.png"));
		//		    images saved on local
				   
						String MRP = driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='product-detail-page']/div[2]/div[1]/div[2]/div[3]/div[3]/span[1]/span[1]")).getText();
						String SellPrice = driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='product-detail-page']/div[2]/div[1]/div[2]/div[3]/div[4]/span[1]/span[1]")).getText();
						String MRPNew = CharMatcher.inRange('0', '9').retainFrom(MRP);
						String SellPriceNew = CharMatcher.inRange('0', '9').retainFrom(SellPrice);
						Random random = new Random();
						float flt = (float) (0.5 + random.nextFloat() * (0.5 - 0.9));
						int MRPInt = Integer.parseInt(MRPNew.replaceAll("[^0-9]", ""));
						int SellPriceInt = Integer.parseInt(SellPriceNew.replaceAll("[^0-9]", ""));
						int MRPIntNew = MRPInt / 100;
						int SellPriceIntNew = SellPriceInt / 100;
						int TempRate = (int) (SellPriceInt * flt / 100);
						int TempSellPriceLowRate = (SellPriceInt - TempRate) / 100;
						int SellPriceLowRate = 0;
						if(TempSellPriceLowRate > 20000)
						{
							TempSellPriceLowRate = 20000;
						}
						else
						{
							SellPriceLowRate = TempSellPriceLowRate - 10;
						}
						String FinalSellPrice = String.valueOf(SellPriceLowRate);
						String FinalMRP = String.valueOf(MRPIntNew);
		//				int x = random.nextInt(999);
						int y = random.nextInt(999);
		//				int z = random.nextInt(999);
						String ModelNew;
						if ((Model.length() > 19)) 
						{
							ModelNew = Model.substring(0, 19); // + " " + x;
						} 
						else 
						{
							ModelNew = Model; // + " " + x;
						}
						String PartNew;
						if ((Part.length() > 16)) 
						{
							PartNew = Part.substring(0, 16) + " " + y;
						} 
						else 
						{
							PartNew = Part + " " + y;
						}
						String TitleNew;
						if ((Title.length() > 95)) 
						{
							TitleNew = Title.substring(0, 95); //+ " " + z;
						} 
						else 
						{
							TitleNew = Title;
						}
						System.out.println("===========================================");
						System.out.println("Title ye hai : "+Title);
						System.out.println("===========================================" + '\n');
						System.out.println("Trimmed Title he ye : "+TitleNew+ '\n');
						System.out.println("NewModel ye hai : "+NewModel);
						System.out.println("===========================================" + '\n');
						System.out.println("Make: "+Make);
						System.out.println("Model: "+Model);
						System.out.println("ModelNew :"+ModelNew);
						System.out.println("Part :"+Part);
						System.out.println("PartNew :"+PartNew);
						System.out.println("OEMBrand :"+OEMBrand);
						System.out.println("OEMModel :"+OEMModel);
						System.out.println("PrinterModel :"+PrinterModel);
						System.out.println("Yield :"+Yield);
						System.out.println("img1 :"+img1);
//						System.out.println(img2);
//						System.out.println(img3);
						System.out.println("MRPIntNew: "+MRPIntNew);
						System.out.println("SellPriceIntNew: "+SellPriceIntNew);
						System.out.println("SellPriceLowRate: "+SellPriceLowRate);
						System.out.println("String Price: " + FinalSellPrice);
						
						driver.get(addnewproduct);
						Thread.sleep(2000);		
						
//						driver.findElement(By.xpath("//img[@id='floxChatCloseImage']")).click();
						if ((str.contentEquals("KT")) || (str.contentEquals("kt")))
						{
						driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[1]/div[1]/div[2]/div[1]/fieldset[1]/div[3]/div[2]/select[1]")).click();	
						Thread.sleep(600);
						driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[1]/div[1]/div[2]/div[1]/fieldset[1]/div[3]/div[2]/select[1]")).sendKeys("KANT");
						Thread.sleep(600);
						}
						else if   ((str.contentEquals("PJ")) || (str.contentEquals("pj")))
					    {
						driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[1]/div[1]/div[2]/div[1]/fieldset[1]/div[3]/div[2]/select[1]")).click();	
						Thread.sleep(600);
						driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[1]/div[1]/div[2]/div[1]/fieldset[1]/div[3]/div[2]/select[1]")).sendKeys("KANT");	
						Thread.sleep(600);
					    }
						else if  ((str.contentEquals("VS")) || (str.contentEquals("vs")))
					    {
						driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[1]/div[1]/div[2]/div[1]/fieldset[1]/div[3]/div[2]/select[1]")).click();	
						Thread.sleep(600);
						driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[1]/div[1]/div[2]/div[1]/fieldset[1]/div[3]/div[2]/select[1]")).sendKeys("KANT");	
						Thread.sleep(600);
					    }
//						else if  ((str.contentEquals("ES")) || (str.contentEquals("es")))
//						{
//						driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[1]/div[1]/div[2]/div[1]/fieldset[1]/div[3]/div[2]/select[1]")).click();	
//						Thread.sleep(600);
//						driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[1]/div[1]/div[2]/div[1]/fieldset[1]/div[3]/div[2]/select[1]")).sendKeys("ESHA");	
//						Thread.sleep(600);
//					    }
						
						
						driver.findElement(By.name("copy_catalog_id")).sendKeys(ProductID);
						Thread.sleep(500);
						
						driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[1]/div[1]/div[2]/div[1]/fieldset[1]/div[5]/div[3]/button[1]")).click();
						Thread.sleep(500);
						driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/button[2]")).click();
//						Thread.sleep(700);
//						driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[1]/div[1]/div[2]/div[1]/fieldset[1]/div[6]/div[2]/form-builder[1]/div[1]/div[1]/div[1]/fieldset[1]/div[7]/div[1]/div[2]/div[1]/element[1]/div[1]/input[1]")).clear();
//						Thread.sleep(500);
//						driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[1]/div[1]/div[2]/div[1]/fieldset[1]/div[6]/div[2]/form-builder[1]/div[1]/div[1]/div[1]/fieldset[1]/div[7]/div[1]/div[2]/div[1]/element[1]/div[1]/input[1]")).sendKeys("MB CARTRIDGE");
						Thread.sleep(500);
						driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[1]/div[1]/div[2]/div[1]/fieldset[1]/div[7]/div[2]/input[1]")).click();
						Thread.sleep(700);
						driver.findElement(By.xpath("//button[contains(text(),'Proceed with new item')]")).click();
						Thread.sleep(500);
						driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[2]/div[1]/div[2]/div[1]/fieldset[1]/div[1]/div[2]/input[1]")).sendKeys(NewModel); 
						Thread.sleep(500);
						driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[2]/div[1]/div[2]/div[1]/fieldset[1]/div[2]/div[2]/input[1]")).sendKeys(Title);
						Thread.sleep(500);
						driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[2]/div/div[2]/div/fieldset/div[7]/div[2]/button")).click();
						Thread.sleep(5000);
						
//image 0
						driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[15]/div[4]/document-upload/div[1]/fieldset/div[2]/button")).click();
						Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
						StringSelection img0 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\img0.png");					
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
						Thread.sleep(5000);
		
					    if(str.contentEquals("KT") || str.contains("kt") )
					    { System.out.println("OEM Me aya...");
					    driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/selling-as[1]/div[1]/div[1]/div[2]/select[1]")).sendKeys("OEM");
						Thread.sleep(100);
					    }
					    else if (str.contentEquals("pj") || str.contains("PJ") || str.contentEquals("VS") || str.contains("vs"))
					    { System.out.println("Reseller Me aya...");
//Resellers Details
						driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/selling-as[1]/div[1]/div[1]/div[2]/select[1]")).sendKeys("Resellers");
						Thread.sleep(100);
						
						driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/selling-as/div/fieldset/div[2]/div[2]/input")).sendKeys("12345");
						Thread.sleep(100);
						driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/selling-as/div/fieldset/div[3]/div[2]/input")).sendKeys("54321");
						Thread.sleep(100);
						
//						DATE TWEEKS
//						Authorization Date*
						driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/selling-as/div/fieldset/div[4]/div[2]/p/span/button")).click();
						Thread.sleep(100);
						driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/selling-as/div/fieldset/div[4]/div[2]/p/div/ul/li[2]/span/button[1]")).click();
						Thread.sleep(100);
						
//						Authorization Validity*	 From
						driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/selling-as/div/fieldset/div[5]/div[2]/div/div[2]/p/span/button")).click();
						Thread.sleep(100);
						driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/selling-as/div/fieldset/div[5]/div[2]/div/div[2]/p/div/ul/li[2]/span/button[1]")).click();
						Thread.sleep(100);	
						
//						Authorization Validity*	 To
//						main click 
						driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/selling-as/div/fieldset/div[5]/div[2]/div/div[4]/p/span/button")).click();
						Thread.sleep(100);
//						click month year
						driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/selling-as/div/fieldset/div[5]/div[2]/div/div[4]/p/div/ul/li[1]/div/div/div/table/thead/tr[1]/th[2]/button/strong")).click();
						Thread.sleep(100);
//						click year
						driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/selling-as/div/fieldset/div[5]/div[2]/div/div[4]/p/div/ul/li[1]/div/div/div/table/thead/tr/th[2]/button")).click();
						Thread.sleep(100);
//						select year 2026
						driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/selling-as/div/fieldset/div[5]/div[2]/div/div[4]/p/div/ul/li[1]/div/div/div/table/tbody/tr[2]/td[1]/button")).click();
						Thread.sleep(100);
//						select month march
						driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/selling-as/div/fieldset/div[5]/div[2]/div/div[4]/p/div/ul/li[1]/div/div/div/table/tbody/tr[1]/td[3]/button")).click();
						Thread.sleep(100);
//						select date 31
						driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/selling-as/div/fieldset/div[5]/div[2]/div/div[4]/p/div/ul/li[1]/div/div/div/table/tbody/tr[5]/td[4]/button/span")).click();
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
						driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[14]/div[2]/input")).sendKeys(FinalMRP);
						Thread.sleep(100);
						driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[16]/div[2]/input")).sendKeys(FinalSellPrice);
						Thread.sleep(600);
						driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[18]/div[3]/div/location-picker/div/uib-accordion/div/div[1]/div[2]/div/zone-location-picker/table/tbody/tr[1]/td[1]/input")).click();
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
						driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[4]/div/div[2]/div/fieldset/div[2]/div[4]/document-upload/div[1]/fieldset/div[2]/select")).sendKeys("Any Other");	
						Thread.sleep(1000);
						driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[4]/div/div[2]/div/fieldset/div[2]/div[4]/document-upload/div[1]/fieldset/div[2]/button/i[1]")).click();				
						Thread.sleep(500);
						clipboard.setContents(img0, null);
						Thread.sleep(500);
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
						Thread.sleep(5000);
						
		
						driver.findElement(By.xpath(".//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[4]/div[1]/div[2]/div[1]/fieldset[1]/div[1]/form-builder[1]/div[1]/div[1]/div[1]/fieldset[1]/div[3]/div[1]/div[2]/div[1]/element[1]/div[1]/input[1]")).clear();
						Thread.sleep(100);
						driver.findElement(By.xpath("./html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[4]/div[1]/div[2]/div[1]/fieldset[1]/div[1]/form-builder[1]/div[1]/div[1]/div[1]/fieldset[1]/div[3]/div[1]/div[2]/div[1]/element[1]/div[1]/input[1]")).clear();
						Thread.sleep(100);
						driver.findElement(By.xpath(".//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[4]/div[1]/div[2]/div[1]/fieldset[1]/div[1]/form-builder[1]/div[1]/div[1]/div[1]/fieldset[1]/div[3]/div[1]/div[2]/div[1]/element[1]/div[1]/input[1]")).sendKeys(OEMBrand);
						driver.findElement(By.xpath(".//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[4]/div[1]/div[2]/div[1]/fieldset[1]/div[1]/form-builder[1]/div[1]/div[1]/div[1]/fieldset[1]/div[4]/div[1]/div[2]/div[1]/element[1]/div[1]/input[1]")).clear();
						Thread.sleep(100);
						driver.findElement(By.xpath(".//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[4]/div[1]/div[2]/div[1]/fieldset[1]/div[1]/form-builder[1]/div[1]/div[1]/div[1]/fieldset[1]/div[4]/div[1]/div[2]/div[1]/element[1]/div[1]/input[1]")).sendKeys(ModelNew);
						driver.findElement(By.xpath(".//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[4]/div[1]/div[2]/div[1]/fieldset[1]/div[1]/form-builder[1]/div[1]/div[1]/div[1]/fieldset[1]/div[5]/div[1]/div[2]/div[1]/element[1]/div[1]/input[1]")).clear();
						driver.findElement(By.xpath(".//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[4]/div[1]/div[2]/div[1]/fieldset[1]/div[1]/form-builder[1]/div[1]/div[1]/div[1]/fieldset[1]/div[5]/div[1]/div[2]/div[1]/element[1]/div[1]/input[1]")).sendKeys(PartNew);
						Thread.sleep(1000);
						driver.findElement(By.xpath(".//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[4]/div[1]/div[2]/div[1]/fieldset[1]/div[3]/div[2]/button[1]")).click();
						Thread.sleep(5000);
						
						driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[5]/div/div[2]/div/fieldset/div[2]/div[1]/div[1]/div/div/button/i")).click();
						Thread.sleep(600);
						StringSelection img01 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\img1.png");
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
						Thread.sleep(5000);
								
						driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[5]/div/div[2]/div/fieldset/div[2]/div[1]/div[2]/div/div/button/i")).click();
						Thread.sleep(600);
						StringSelection img02 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\img2.png");
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
						Thread.sleep(5000);
		
						driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[5]/div/div[2]/div/fieldset/div[2]/div[1]/div[3]/div/div/button/i")).click();
						Thread.sleep(600);
						StringSelection img03 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\img3.png");
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
						Thread.sleep(5000);
						
						driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[5]/div/div[2]/div/fieldset/div[2]/div[1]/div[3]/div/div/button/i")).click();
						Thread.sleep(600);
						StringSelection img00 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\img0.png");
						clipboard.setContents(img00, null);
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
						Thread.sleep(5000);

						driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[5]/div/div[2]/div/fieldset/div[4]/div[2]/input")).click();
						Thread.sleep(300);
						driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[5]/div/div[2]/div/fieldset/div[5]/div[2]/button")).click();
						Thread.sleep(5000);
		
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
										
						Thread.sleep(1500);
						driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/div[4]/div[3]/show-captcha/div/div[1]/i")).click();
						Thread.sleep(500);
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
//							driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div[2]")).click();
							break;
						}
						else {
							continue;
						}	
						}while( ( driver.getPageSource().contains("Invalid captcha") ||( driver.getPageSource().contains("Please enter captcha"))));
//CAPTCHACODE COMPLETED
						 Thread.sleep(5000);
						
					
					 if (str.contentEquals("PJ") || str.contains("pj"))
					 {
						File src = new File("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\PoojaModelNumber.xlsx"); 
						FileOutputStream fio = new FileOutputStream(src);
						ws.removeRow(ws.getRow(0));
						int lastrow = ws.getLastRowNum();
						ws.shiftRows(i+1, lastrow, -1);
						wb.write(fio);
						fio.flush();
						fio.close();
						System.out.println("		इसका  " +ProductID+ "  लिस्टिंग हो गया 🔥🔥🔥 ");
					}else if (str.contentEquals("VS") || str.contains("vs"))
					{
						File src = new File("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\VisionModelNumber.xlsx"); 
						FileOutputStream fio = new FileOutputStream(src);
						ws.removeRow(ws.getRow(0));
						int lastrow = ws.getLastRowNum();
						ws.shiftRows(i+1, lastrow, -1);
						wb.write(fio);
						fio.flush();
						fio.close();
						System.out.println("		इसका  " +ProductID+ "  लिस्टिंग हो गया 🔥🔥🔥 ");
					}else if (str.contentEquals("KT") || str.contains("kt"))
					{
						File src = new File("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\KantadoProductID.xlsx"); 
						FileOutputStream fio = new FileOutputStream(src);
						ws.removeRow(ws.getRow(0));
						int lastrow = ws.getLastRowNum();
						ws.shiftRows(i+1, lastrow, -1);
						wb.write(fio);
						fio.flush();
						fio.close();
						System.out.println("		इसका  " +ProductID+ "  लिस्टिंग हो गया 🔥🔥🔥 ");
					}
//					else if (str.contentEquals("ES") || str.contains("es"))
//					{
//						File src = new File("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\EshaniProductID.xlsx"); 
//						FileOutputStream fio = new FileOutputStream(src);
//						ws.removeRow(ws.getRow(0));
//						int lastrow = ws.getLastRowNum();
//						ws.shiftRows(i+1, lastrow, -1);
//						wb.write(fio);
//						fio.flush();
//						fio.close();
//						System.out.println("		इसका  " +ProductID+ "  लिस्टिंग हो गया 🔥🔥🔥 ");
//					}
					 
					 
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
		}
		}
		}
		}
	}

	