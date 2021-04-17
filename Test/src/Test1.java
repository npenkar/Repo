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
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.CharMatcher;

public class Test1 {

	public static void main(String[] args) throws InterruptedException, AWTException, Exception {
		long start = System.currentTimeMillis();
		System.setProperty("webdriver.chrome.driver", "C:\\Np\\Dev\\Eclipse\\Workspace\\Test\\src\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//		WebDriverWait wait = new WebDriverWait(driver, 60);
		
		File alert = new File("C:\\Np\\Dev\\Eclipse\\Workspace\\Test\\src\\alert03.wav");
		AudioInputStream audiois1 = AudioSystem.getAudioInputStream(alert);
		AudioFormat format = audiois1.getFormat();
		
		File success = new File("C:\\Np\\Dev\\Eclipse\\Workspace\\Test\\src\\success01.wav");
		AudioInputStream audiois2 = AudioSystem.getAudioInputStream(success);
		
		DataLine.Info info = new DataLine.Info(Clip.class, format);
		Clip audioClip = (Clip) AudioSystem.getLine(info);
		
		String login = "https://sso.gem.gov.in/ARXSSO/oauth/doLogin";
		String addnewproduct = "https://admin-mkp.gem.gov.in/admin/cat/catalog/angular_catalog/#!/catalog/new?bnid=home_offi_offi_prin_comp";
		String search = "https://mkp.gem.gov.in/home/search?q=";

		driver.manage().window().maximize();
		driver.get(login);
		driver.findElement(By.id("loginid")).sendKeys("Murji@12");
		Thread.sleep(100);
		driver.findElement(By.id("captcha_math")).click();
		audioClip.open(audiois1);
		audioClip.start();
		Thread.sleep(10000);
		driver.findElement(By.cssSelector("#loginFrm>div.row>div:nth-child(2)>button")).click();
		Thread.sleep(300);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("Mgela@12");
		Thread.sleep(300);
		driver.findElement(By.cssSelector("#loginFrm>div.row>div:nth-child(1)>button")).click();
		Thread.sleep(300);
		audioClip.close();
		audiois1.close();
		
//		Read ProductID from Excel
		File src = new File("C:\\Np\\Dev\\Eclipse\\Workspace\\Test\\MIX.xlsx");
		FileInputStream fis = new FileInputStream(src);
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheetAt(0);
		int rowcount = ws.getLastRowNum();

		System.out.println("roe count: " + rowcount);
//		for loop start
		for (int i = 0; i < rowcount; ) 
		{
			XSSFCell cell = ws.getRow(i).getCell(0);
			String ProductID = cell.getStringCellValue();
			System.out.println("Row data: " + ProductID);
			System.out.println("PRODUCTS ADDED COUNT: " + i);
			fis.close();

			Robot robot = new Robot();
//			driver.switchTo().window(tabs.get(1));

			driver.get(search + ProductID);
			Thread.sleep(1000);
			String Make = driver.findElement(By.xpath("//*[@id=\'feature_groups\']/table/tbody/tr[3]/td[2]")).getText();
			String Model = driver.findElement(By.xpath("//*[@id=\'feature_groups\']/table/tbody/tr[4]/td[2]")).getText();
			String Part = driver.findElement(By.xpath("//*[@id=\'feature_groups\']/table/tbody/tr[5]/td[2]")).getText();
			String OEMBrand = driver.findElement(By.xpath("//*[@id=\'feature_groups\']/table/tbody/tr[6]/td[2]")).getText();
			String OEMModel = driver.findElement(By.xpath("//*[@id=\'feature_groups\']/table/tbody/tr[7]/td[2]")).getText();
			String PrinterModel = driver.findElement(By.xpath("//*[@id=\'feature_groups\']/table/tbody/tr[8]/td[2]")).getText();
			String Yield = driver.findElement(By.xpath("//*[@id=\'feature_groups\']/table/tbody/tr[9]/td[2]")).getText();
			Thread.sleep(500);
			
			driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/ul/li[1]/a/img")).click();
			WebElement img1a = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/div[1]/div[1]/div/div/div/div/div[2]/span/span[3]/img"));
			String img1 = img1a.getAttribute("src");
			Thread.sleep(500);

			driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/ul/li[2]/a/img")).click();
			WebElement img2l = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/div[1]/div[1]/div/div/div/div/div[3]/span/span[3]/img"));
			String img2 = img2l.getAttribute("src");
			
//			driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/ul/li[3]/a/img")).click();
			Thread.sleep(500);
			WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/ul/li[3]/a/img"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			WebElement img3l = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/div[1]/div[1]/div/div/div/div/div[4]/span/span[3]/img"));
			String img3 = img3l.getAttribute("src");
			
//			images save
			URL img0URL = new URL(img1);
		    BufferedImage saveImage00 = ImageIO.read(img0URL);
		    ImageIO.write(saveImage00, "png", new File("img0.png"));
			
			URL img1URL = new URL(img1);
		    BufferedImage saveImage01 = ImageIO.read(img1URL);
		    ImageIO.write(saveImage01, "png", new File("img1.png"));
			
			URL img2URL = new URL(img2);
		    BufferedImage saveImage02 = ImageIO.read(img2URL);
		    ImageIO.write(saveImage02, "png", new File("img2.png"));
		    
			URL img3URL = new URL(img3);
		    BufferedImage saveImage03 = ImageIO.read(img3URL);
		    ImageIO.write(saveImage03, "png", new File("img3.png"));
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
			int SellPriceLowRate = TempSellPriceLowRate - 10;
			String FinalSellPrice = String.valueOf(SellPriceLowRate);
			String FinalMRP = String.valueOf(MRPIntNew);
			
			int x = random.nextInt(999);
			int y = random.nextInt(999);
			int z = random.nextInt(999);
			String ModelNew;
			if ((Model.length() > 15)) {
				ModelNew = Model.substring(0, 15) + " " + x;
			} else {
				ModelNew = Model + " " + x;
			}
			String PartNew;
			if ((Part.length() > 15)) {
				PartNew = Part.substring(0, 15) + " " + y;
			} else {
				PartNew = Part + " " + y;
			}
			String OEMModelNew;
			if ((OEMModel.length() > 15)) {
				OEMModelNew = OEMModel.substring(0, 15) + " " + z;
			} else {
				OEMModelNew = OEMModel;
			}
			System.out.println(Make);
			System.out.println(Model);
			System.out.println(ModelNew);
			System.out.println(Part);
			System.out.println(PartNew);
			System.out.println(OEMBrand);
			System.out.println(OEMModel);
			System.out.println(PrinterModel);
			System.out.println(Yield);
			System.out.println(img1);
			System.out.println(img2);
			System.out.println(img3);
			System.out.println(MRPIntNew);
			System.out.println(SellPriceIntNew);
			System.out.println(SellPriceLowRate);
			System.out.println("String Price: " + FinalSellPrice);
//			driver.switchTo().window(tabs.get(0));
			driver.get(addnewproduct);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//img[@id='floxChatCloseImage']")).click();
			driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[1]/div[1]/div[2]/div[1]/fieldset[1]/div[3]/div[2]/select[1]")).sendKeys("MB Cartridge");
			driver.findElement(By.name("copy_catalog_id")).sendKeys(ProductID);
			Thread.sleep(500);
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[1]/div[1]/div[2]/div[1]/fieldset[1]/div[5]/div[3]/button[1]")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/button[2]")).click();
			Thread.sleep(700);
			driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[1]/div[1]/div[2]/div[1]/fieldset[1]/div[7]/div[2]/input[1]")).click();
			Thread.sleep(700);
			driver.findElement(By.xpath("//button[contains(text(),'Proceed with new item')]")).click();
			Thread.sleep(2000);

			driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[2]/div[1]/div[2]/div[1]/fieldset[1]/div[1]/div[2]/input[1]")).sendKeys(OEMModelNew);
			Thread.sleep(500);
			driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[2]/div[1]/div[2]/div[1]/fieldset[1]/div[2]/div[2]/input[1]")).sendKeys(OEMBrand + " " + OEMModelNew);
			Thread.sleep(500);
			
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[2]/div/div[2]/div/fieldset/div[6]/div[2]/label[2]/input")).click();
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'SAVE / PROCEED')]")));
			driver.findElement(By.xpath("//button[contains(text(),'SAVE / PROCEED')]")).click();
			Thread.sleep(3000);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			StringSelection img0 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Workspace\\Test\\img0.png");
			clipboard.setContents(img0, null);
		
//			driver.findElement(By.xpath(".//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/div[14]/div[4]/document-upload[1]/div[1]/fieldset[1]/div[2]/button[1]")).click();
			WebElement MRPImg = driver.findElement(By.xpath("//button[@id='spec-upload-btn']"));
			if(MRPImg.isDisplayed())
		{
			MRPImg.click();
			Thread.sleep(500);
			driver.switchTo().activeElement();
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			Thread.sleep(500);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(4000);
		}else 
		{
			break;
		}
//			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/div[14]/div[4]/document-upload[1]/div[1]/fieldset[1]/div[2]/button[1]/i[1]")));
			
			Thread.sleep(100);
			driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/selling-as[1]/div[1]/div[1]/div[2]/select[1]")).sendKeys("OEM");
			Thread.sleep(100);
			driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/div[1]/div[2]/div[1]/div[1]/input[1]")).sendKeys("JAPAN");
			Thread.sleep(100);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(100);
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(100);
			driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/div[13]/div[2]/input[1]")).sendKeys(FinalMRP);
			Thread.sleep(100);
			driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/div[15]/div[2]/input[1]")).sendKeys(FinalSellPrice);
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
			driver.findElement(By.xpath(".//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/div[17]/div[5]/div[2]/input[1]")).sendKeys("2000");
			driver.findElement(By.xpath(".//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/div[17]/div[6]/div[2]/input[1]")).sendKeys("1");
			driver.findElement(By.xpath(".//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/div[17]/div[7]/div[2]/input[1]")).sendKeys("10");
			driver.findElement(By.xpath(".//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/div[18]/div[2]/button[1]")).click();
			Thread.sleep(3000);
			
//			wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(".//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[4]/div[1]/div[2]/div[1]/fieldset[1]/div[2]/div[4]/document-upload[1]/div[1]/fieldset[1]/div[2]/button[1]"))));
			StringSelection copyTM = new StringSelection("C:\\Np\\Dev\\Eclipse\\Workspace\\Test\\TRADMARK_compressed.pdf");
			clipboard.setContents(copyTM, null);
			Thread.sleep(500);
			WebElement trademark =	driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[4]/div/div[2]/div/fieldset/div[2]/div[4]/document-upload/div[1]/fieldset/div[2]/button"));
		if(trademark.isDisplayed())
		{
			trademark.click();
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
		} else
		{
			break;
		}

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
			driver.findElement(By.xpath(".//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[4]/div[1]/div[2]/div[1]/fieldset[1]/div[2]/div[4]/document-upload[1]/div[1]/fieldset[1]/div[2]/select[1]")).sendKeys("OEM Authorization Document");
			Thread.sleep(500);

//			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[4]/div[1]/div[2]/div[1]/fieldset[1]/div[2]/div[4]/document-upload[1]/div[1]/fieldset[1]/div[2]/button[1]")));
			driver.findElement(By.xpath(".//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[4]/div[1]/div[2]/div[1]/fieldset[1]/div[3]/div[2]/button[1]")).click();
			Thread.sleep(3000);

			driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[5]/div[1]/div[2]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]")).click();
			Thread.sleep(600);
			StringSelection img01 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Workspace\\Test\\img1.png");
			clipboard.setContents(img01, null);
			driver.switchTo().activeElement();
			Thread.sleep(400);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			Thread.sleep(400);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			Thread.sleep(400);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
						
			driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[5]/div[1]/div[2]/div[1]/fieldset[1]/div[2]/div[1]/div[2]/div[1]/div[1]/button[1]")).click();
			Thread.sleep(600);
			StringSelection img02 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Workspace\\Test\\img2.png");
			clipboard.setContents(img02, null);
			driver.switchTo().activeElement();
			Thread.sleep(400);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			Thread.sleep(400);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(400);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3000);

			driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[5]/div[1]/div[2]/div[1]/fieldset[1]/div[2]/div[1]/div[3]/div[1]/div[1]/button[1]")).click();
			Thread.sleep(600);
			StringSelection img03 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Workspace\\Test\\img3.png");
			clipboard.setContents(img03, null);
			driver.switchTo().activeElement();
			Thread.sleep(400);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			Thread.sleep(400);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(400);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3000);

			driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[5]/div[1]/div[2]/div[1]/fieldset[1]/div[2]/div[1]/div[3]/div[1]/div[1]/button[1]")).click();
			Thread.sleep(600);
			StringSelection img00 = new StringSelection("C:\\Np\\Dev\\Eclipse\\Workspace\\Test\\img0.png");
			clipboard.setContents(img00, null);
			driver.switchTo().activeElement();
			Thread.sleep(400);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			Thread.sleep(400);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(400);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
			
			driver.findElement(By.xpath(".//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[5]/div[1]/div[2]/div[1]/fieldset[1]/div[4]/div[2]/input[1]")).click();
			Thread.sleep(300);
			driver.findElement(By.xpath(".//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[5]/div[1]/div[2]/div[1]/fieldset[1]/div[5]/div[2]/button[1]")).click();
			Thread.sleep(4000);

//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[contains(text(),'Review Terms and conditions')]")));
			driver.findElement(By.xpath(".//a[contains(text(),'Review Terms and conditions')]")).click();
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
			driver.findElement(By.xpath(".//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/div[4]/div[2]/input[1]")).click();
			Thread.sleep(500);
			WebElement publish = driver.findElement(By.xpath(".//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/div[4]/div[3]/input[1]"));
			JavascriptExecutor clickpublish = (JavascriptExecutor) driver;
			clickpublish.executeScript("arguments[0].click();", publish);
//			driver.findElement(By.xpath(".//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/div[4]/div[3]/input[1]")).click();
			Thread.sleep(2000);
			DataLine.Info info1 = new DataLine.Info(Clip.class, format);
			Clip audioClip1 = (Clip) AudioSystem.getLine(info1);
			driver.findElement(By.xpath(".//div[contains(text(),'Upload Another Product')]")).click();
			audioClip1.open(audiois2);
			audioClip1.start();
			Thread.sleep(3000);
			driver.get(addnewproduct);
			
			FileOutputStream fio = new FileOutputStream(src);
			if (driver.getCurrentUrl() == addnewproduct) 
			{
				ws.removeRow(ws.getRow(0));
				int lastrow = ws.getLastRowNum();
				ws.shiftRows(i+1, lastrow, -1);
			} 
			else 
			{
				ws.removeRow(ws.getRow(0));
				int lastrow = ws.getLastRowNum();
				ws.shiftRows(i+1, lastrow, -1);
			}
				wb.write(fio);
				fio.flush();
				fio.close();
				System.out.println("Listing Completed :====>> " + ProductID);
			audioClip1.close();
			audiois2.close();
			}

//		for loop end
			Thread.sleep(2000);
			System.out.println("Case Pass!!!");
			long ExecutionTime = (System.currentTimeMillis() - start);
			long ETS = ExecutionTime / 1000;
			System.out.println("Execution time: " + ETS + " seconds");
			driver.close();
		}
}
