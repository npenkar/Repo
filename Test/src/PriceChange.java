import java.awt.AWTException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.google.common.base.CharMatcher;

public class PriceChange 
{
	public static void main(String[] args) throws InterruptedException, AWTException, Exception 
	{
		long start = System.currentTimeMillis();
		Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
		Runtime.getRuntime().exec("taskkill /F /IM Chrome.exe");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Np\\Dev\\Eclipse\\Repo\\Test\\jars\\chromedriver92.exe");
//		no change
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String login = "https://sso.gem.gov.in/ARXSSO/oauth/doLogin";
		String url1 = "https://admin-mkp.gem.gov.in/#!/catalog/new?id=";
		String url2 = "-cat&bnid=home_offi_offi_prin_oemr";
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
		
		File src = new File("C:\\Np\\Dev\\Eclipse\\CatalogueID.xlsx"); 
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
			Thread.sleep(3000);

			String CurrentStringPrice = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/div[14]/div[2]/input[1]")).getAttribute("value"); 
			System.out.println("Current String Price :: " + CurrentStringPrice);
			String StringCurrentPrice = CharMatcher.inRange('0', '9').retainFrom(CurrentStringPrice);
			int CurrentIntPrice = Integer.parseInt(StringCurrentPrice.replaceAll("[^0-9]", ""));
			int UpdatedIntPrice = CurrentIntPrice - 2;
			String UpdatedStringPrice = String.valueOf(UpdatedIntPrice);
			System.out.println("Updated String Price :: " + UpdatedStringPrice);
			
			String CurrentStringPercentage = driver.findElement(By.xpath("//tbody/tr[1]/td[4]/input[1]")).getAttribute("value"); 
			System.out.println("Current String Percentage :: " + CurrentStringPercentage);
			float CurrentFloatPercentage = Float.parseFloat(CurrentStringPercentage);	
			double PercentaddDouble = CurrentFloatPercentage + 0.22;
			String PercentageFloat = String.format("%.2f", PercentaddDouble);
			String StringFloatPrecent=String.valueOf(PercentageFloat);
			System.out.println("Updated String Float Percentage :: " + StringFloatPrecent);
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/div[14]/div[2]/input[1]")).clear();
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/div[14]/div[2]/input[1]")).sendKeys(UpdatedStringPrice);
			Thread.sleep(1000);

			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			if(driver.findElements(By.xpath("//a[contains(text(),'+Add Slab')]")).size() != 0)
			{
				driver.findElement(By.xpath("//a[contains(text(),'+Add Slab')]")).click();
				Thread.sleep(600);
				driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]")).clear();
				driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]")).sendKeys("2");
				Thread.sleep(600);
				driver.findElement(By.xpath("//tbody/tr[1]/td[3]/input[1]")).clear();
				driver.findElement(By.xpath("//tbody/tr[1]/td[3]/input[1]")).sendKeys("200");
				Thread.sleep(600);
				driver.findElement(By.xpath("//tbody/tr[1]/td[4]/input[1]")).clear();
				driver.findElement(By.xpath("//tbody/tr[1]/td[4]/input[1]")).sendKeys(StringFloatPrecent);
				Thread.sleep(600);
				
				driver.findElement(By.xpath("//button[contains(text(),'Update Stock')]")).click();
				Thread.sleep(3000);
			}
			else
			{
			Thread.sleep(600);
			driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]")).clear();
			driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]")).sendKeys("2");
			Thread.sleep(600);
			driver.findElement(By.xpath("//tbody/tr[1]/td[3]/input[1]")).clear();
			driver.findElement(By.xpath("//tbody/tr[1]/td[3]/input[1]")).sendKeys("200");
			Thread.sleep(600);
			driver.findElement(By.xpath("//tbody/tr[1]/td[4]/input[1]")).clear();
			driver.findElement(By.xpath("//tbody/tr[1]/td[4]/input[1]")).sendKeys(StringFloatPrecent);
			Thread.sleep(600);
			
			driver.findElement(By.xpath("//button[contains(text(),'Update Stock')]")).click();
			Thread.sleep(3000);
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
