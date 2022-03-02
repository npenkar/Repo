import java.awt.AWTException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.google.common.base.CharMatcher;

public class YashResellerNew 
{
	public static void main(String[] args) throws InterruptedException, AWTException, Exception 
	{
		long start = System.currentTimeMillis();
		Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver92.exe");
		Runtime.getRuntime().exec("taskkill /F /IM Chrome.exe");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Np\\Dev\\Eclipse\\Repo\\Test\\jars\\chromedriver98.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String login = "https://sso.gem.gov.in/ARXSSO/oauth/doLogin";
		String search = "https://mkp.gem.gov.in/home/search?q=";

		String uname = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\reseller-creden.txt")).get(0);
		String pwd = Files.readAllLines(Paths.get("C:\\Np\\Dev\\Eclipse\\Repo\\Test\\resource\\reseller-creden.txt")).get(1);
		System.out.println("	Reading Username and Password from file... ");
		
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
		
//		Read ProductID from Excel
		File src = new File("C:\\Np\\Dev\\Eclipse\\YashReseller.xlsx"); 
		FileInputStream fis = new FileInputStream(src);
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheetAt(0);
		int rowcount = ws.getLastRowNum();
		int count = 0;
		System.out.println("		à¤•à¤¿à¤¤à¤¨à¥‡ Product ID à¤¹à¥‡ à¤°à¥‡ à¤¸à¤¾à¤‚à¤­à¤¾ ????" + rowcount);
		System.out.println("		à¤¸à¤°à¤•à¤¾à¤° "+rowcount+" ID à¤¹à¥‡ Excel à¤®à¥‡à¤‚" );
		
//		for loop start
		for (int i = 0; i < rowcount; ) 
		{
			XSSFCell cell = ws.getRow(i).getCell(0);
			String ProductID = cell.getStringCellValue();
			System.out.println("		Excel à¤•à¤¾ ID : " + ProductID);
			fis.close();
			String ProductSearch =search + ProductID;
			Robot robot = new Robot();
			driver.get(ProductSearch);
			Thread.sleep(600);
			
			if(!(driver.getPageSource().contains("Gupta") || driver.getPageSource().contains("Rajput") || driver.getPageSource().contains("Solanki") ||  driver.getPageSource().contains("Dinesh Chaudhari") || driver.getPageSource().contains("Velabhai Gohil") ||driver.getPageSource().contains("Rajesh Bhai Magha Bari") ))
			{
			driver.findElement(By.xpath("//body/div[@id='page']/div[@id='hd']/div[2]/div[1]/section[3]/section[1]/div[1]/div[1]/div[2]/ul[1]/li[2]")).click();
			Thread.sleep(600);
			}
			else
			{
			
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			 if ( driver.getPageSource().contains("An error occurred.") || driver.getPageSource().contains("Bad Request") || driver.getPageSource().contains("category is not available"))
			 {
				 driver.navigate().refresh();
				 System.out.println("Error: page not loaded correctly ......., refreshing ... for " + ProductID);
			 }
			 else {
			if(driver.getPageSource().contains("category is not available"))
			{
				ws.removeRow(ws.getRow(0));
				int lastrow = ws.getLastRowNum();
				ws.shiftRows(i+1, lastrow, -1);
				System.out.println("CATEGORY Hi Uda diye he be ...");
			}
			else 
			{
				System.out.println("ID à¤¸à¤¹à¥€ à¤¹à¥ˆ à¤¬à¥‡ âœ…âœ…âœ…");
				WebElement NA = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/div[2]/div[3]/div[1]/div[1]/span/span"));
				String sNA = NA.getText();
				System.out.println(">"+sNA+"<");
				String PNA = "Price Not Available";
	
				if (sNA.equalsIgnoreCase(PNA)) 
				{
				ws.removeRow(ws.getRow(0));
				int lastrow = ws.getLastRowNum();
				ws.shiftRows(i+1, lastrow, -1);
				System.out.println("MRP NOT AVAILABLE ...");
				} 
				else 
					{
					String Make = driver.findElement(By.xpath("//*[@id=\'feature_groups\']/table/tbody/tr[3]/td[2]")).getText();
					String Model = driver.findElement(By.xpath("//*[@id=\'feature_groups\']/table/tbody/tr[4]/td[2]")).getText();
					String Part = driver.findElement(By.xpath("//*[@id=\'feature_groups\']/table/tbody/tr[5]/td[2]")).getText();
					String OEMBrand = driver.findElement(By.xpath("//*[@id=\'feature_groups\']/table/tbody/tr[6]/td[2]")).getText();
					String OEMModel = driver.findElement(By.xpath("//*[@id=\'feature_groups\']/table/tbody/tr[7]/td[2]")).getText();
					String PrinterModel = driver.findElement(By.xpath("//*[@id=\'feature_groups\']/table/tbody/tr[8]/td[2]")).getText();
					String Yield = driver.findElement(By.xpath("//*[@id=\'feature_groups\']/table/tbody/tr[9]/td[2]")).getText();
					Thread.sleep(600);
				
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

						String MRP = driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='product-detail-page']/div[2]/div[1]/div[2]/div[3]/div[3]/span[1]/span[1]")).getText();
						String SellPrice = driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='product-detail-page']/div[2]/div[1]/div[2]/div[3]/div[4]/span[1]/span[1]")).getText();
						String MRPNew = CharMatcher.inRange('0', '9').retainFrom(MRP);
						String SellPriceNew = CharMatcher.inRange('0', '9').retainFrom(SellPrice);
						Random random = new Random();
						float flt = (float) (0.5 + random.nextFloat() * (0.2 - 0.5));
						int MRPInt = Integer.parseInt(MRPNew.replaceAll("[^0-9]", ""));
						int SellPriceInt = Integer.parseInt(SellPriceNew.replaceAll("[^0-9]", ""));
						int MRPIntNew = MRPInt / 100;
						int SellPriceIntNew = SellPriceInt / 100;
						int TempRate = (int) (SellPriceInt * flt / 100);
						int TempSellPriceLowRate = (SellPriceInt - TempRate) / 100;
						int SellPriceLowRate = 0;
						if(TempSellPriceLowRate > 16000)
						{
							TempSellPriceLowRate = 16000;
						}
						else
						{
							SellPriceLowRate = TempSellPriceLowRate - 10;
						}
						String SellPriceString = String.valueOf(SellPriceIntNew);
						String FinalSellPrice = String.valueOf(SellPriceLowRate);

						System.out.println(Make);
						System.out.println(Model);
						System.out.println(Part);
						System.out.println(OEMBrand);
						System.out.println(OEMModel);
						System.out.println(PrinterModel);
						System.out.println(Yield);
						System.out.println(MRPIntNew);
						System.out.println(SellPriceIntNew);
						System.out.println(SellPriceLowRate);
						System.out.println("String Price: " + FinalSellPrice);
						Thread.sleep(500);
						
						if(!driver.getPageSource().contains("Sell this item"))
						{
						ws.removeRow(ws.getRow(0));
						int lastrow = ws.getLastRowNum();
						ws.shiftRows(i+1, lastrow, -1);
						System.out.println("SELL NOT PRESENT...");
						} 
						else 
						{
							robot.keyPress(KeyEvent.VK_SPACE);
							robot.keyRelease(KeyEvent.VK_SPACE);
							Thread.sleep(500);
							
						driver.findElement(By.xpath("//a[contains(text(),'Sell this item')]")).click();	
						Thread.sleep(6000);
						
						ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
						driver.switchTo().window(tabs.get(1));
						Thread.sleep(600);
						driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
						Thread.sleep(6000);
		
//						Resellers Details
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

						driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/div[1]/div[2]/div[1]/div[1]/input[1]")).sendKeys("JAPAN");
						Thread.sleep(600);
						robot.keyPress(KeyEvent.VK_ENTER);
						robot.keyRelease(KeyEvent.VK_ENTER);
						Thread.sleep(100);
						robot.keyPress(KeyEvent.VK_ESCAPE);
						robot.keyRelease(KeyEvent.VK_ESCAPE);
						Thread.sleep(100);
//						driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/div[13]/div[2]/input[1]")).sendKeys(FinalMRP);
						Thread.sleep(100);
//						driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/div[14]/div[4]/document-upload[1]/div[1]/fieldset[1]/div[2]/select[1]")).sendKeys("Packaging Photo");
						Thread.sleep(100);
						driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/div[14]/div[2]/input[1]")).sendKeys(SellPriceString);
						Thread.sleep(600);
// add stab
						driver.findElement(By.xpath("//a[contains(text(),'+Add Slab')]")).click();
						Thread.sleep(600);
						driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]")).clear();
						driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]")).sendKeys("2");
						Thread.sleep(600);
						driver.findElement(By.xpath("//tbody/tr[1]/td[3]/input[1]")).clear();
						driver.findElement(By.xpath("//tbody/tr[1]/td[3]/input[1]")).sendKeys("200");
						Thread.sleep(600);
						driver.findElement(By.xpath("//tbody/tr[1]/td[4]/input[1]")).clear();
						driver.findElement(By.xpath("//tbody/tr[1]/td[4]/input[1]")).sendKeys("5");
						Thread.sleep(600);
						
//	Select all state region 					
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
						driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/div[16]/div[5]/div[2]/input[1]")).sendKeys("2000");
						driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/div[16]/div[6]/div[2]/input[1]")).sendKeys("1");
						driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/div[16]/div[7]/div[2]/input[1]")).sendKeys("10");
						Thread.sleep(100);
					
//						checkbox tweaks
						
						if(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[17]/div[2]/label/input")).getAttribute("disabled") != "disabled");
							{
								driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[17]/div[2]/label/input")).click();
								Thread.sleep(200);
								driver.findElement(By.xpath("/html/body/div[1]")).click();
								Thread.sleep(200);
							}
						
						Thread.sleep(3000);
						driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[3]/div/div[2]/div/fieldset/div[18]/div[2]/button")).click();
						Thread.sleep(6000);
						driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/div[4]/div/a")).click();
						Thread.sleep(6000);
						robot.keyPress(KeyEvent.VK_CONTROL);
						robot.keyPress(KeyEvent.VK_W);
						Thread.sleep(100);
						robot.keyRelease(KeyEvent.VK_W);
						robot.keyRelease(KeyEvent.VK_CONTROL);
						Thread.sleep(600);
						
						driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/div[4]/div[2]/input[1]")).click();
						Thread.sleep(600);
						
						WebElement publish = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/div[4]/div[3]/input[1]"));
						JavascriptExecutor clickpublish = (JavascriptExecutor) driver;
						clickpublish.executeScript("arguments[0].click();", publish);
						Thread.sleep(600);
						clickpublish.executeScript("arguments[0].click();", publish);
						Thread.sleep(6000);
//						driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div[1]")).click();
						Thread.sleep(600);
					
						robot.keyPress(KeyEvent.VK_CONTROL);
						robot.keyPress(KeyEvent.VK_W);
						Thread.sleep(100);
						robot.keyRelease(KeyEvent.VK_W);
						robot.keyRelease(KeyEvent.VK_CONTROL);
						Thread.sleep(600);
						driver.switchTo().window(tabs.get(0));
						
						FileOutputStream fio = new FileOutputStream(src);
						
							ws.removeRow(ws.getRow(0));
							int lastrow = ws.getLastRowNum();
							ws.shiftRows(i+1, lastrow, -1);
						
						wb.write(fio);
						fio.flush();
						fio.close();
							
							System.out.println("		à¤‡à¤¸à¤•à¤¾  " +ProductID+ " à¤²à¤¿à¤¸à¥�à¤Ÿà¤¿à¤‚à¤— à¤¹à¥‹ à¤—à¤¯à¤¾ ðŸ”¥ðŸ”¥ðŸ”¥");
					    	count++;
					    	System.out.println("		à¤•à¤¿à¤¤à¤¨à¤¾ à¤²à¤¿à¤¸à¥�à¤Ÿà¤¿à¤‚à¤— à¤¹à¥�à¤† à¤¬à¥‡ ????");
					    	System.out.println("		Total " + count +" LISTING à¤¹à¥�à¤† à¤¸à¤°à¤•à¤¾à¤°...");
					}
					Thread.sleep(600);
					System.out.println("Case Pass!!!");
					long ExecutionTime = (System.currentTimeMillis() - start);
					long ETS = ExecutionTime / 1000;
					System.out.println("Execution time: " + ETS + " seconds");
					}	
					}
			 }
			 }
		}driver.close();
	}	}


