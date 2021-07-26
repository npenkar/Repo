import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sample1 {
	/**
	 * @param args
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public static void main(String[] args) throws InterruptedException, AWTException {
	System.setProperty("webdriver.chrome.driver", "C:\\Np\\Dev\\Eclipse\\Workspace\\Test\\src\\chromedriver92.exe");
	long start = System.currentTimeMillis(); 
	WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, 30);
	driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	String login = "https://sso.gem.gov.in/ARXSSO/oauth/doLogin";
	String URL = "https://admin-mkp.gem.gov.in/#!/catalog/new?id=4153684-4152069419-cat&bnid=home_offi_offi_prin_comp";
	//	String brandname = "MB Cartridge";
	 
	driver.manage().window().maximize();
	driver.get(login);
	driver.findElement(By.id("loginid")).sendKeys("RAMA@12"); 
	driver.findElement(By.id("captcha_math")).click();
	Thread.sleep(8000);
	driver.findElement(By.cssSelector("#loginFrm>div.row>div:nth-child(2)>button")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("password")).clear();
	driver.findElement(By.id("password")).sendKeys("Rnc@12345");
	driver.findElement(By.cssSelector("#loginFrm>div.row>div:nth-child(1)>button")).click();
	Thread.sleep(2000);
	driver.get(URL);
	Thread.sleep(4000);
	driver.findElement(By.xpath("//img[@id='floxChatCloseImage']")).click();
	
	String img1 = "https://assets-mkpbg.gem.gov.in/img/othe/3681551/66/05/1a.jpg.78b6af6605.999x420x420.jpg";
	String img2 = "https://assets-mkpbg.gem.gov.in/img/othe/3681551/55/af/2a.jpg.f59e2255af.999x420x420.jpg";
	String img3 = "https://assets-mkpbg.gem.gov.in/img/othe/3681551/19/34/test.jpg.e5d3e81934.999x420x420.jpg";
	String jpg =  ".jpg";
	Robot robot = new Robot(); 
	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	
	
//	Image Upload loop	//	
	WebElement IMGUP01 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[5]/div/div[2]/div/fieldset/div[2]/div[2]/div[1]/img"));
	WebElement IMGUP01TXT = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[5]/div[1]/div[2]/div[1]/fieldset[1]/div[2]/div[3]/div[1]/label[1]"));
	
	WebElement IMGUP02 = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[5]/div[1]/div[2]/div[1]/fieldset[1]/div[2]/div[2]/div[2]/img[1]"));
	WebElement IMGUP02TXT = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[5]/div[1]/div[2]/div[1]/fieldset[1]/div[2]/div[3]/div[2]/label[1]"));
	
	WebElement IMGUP03 = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[5]/div[1]/div[2]/div[1]/fieldset[1]/div[2]/div[2]/div[3]/img[1]"));



//	UPLOAD IMAGE-1    //
//	do //do while loop START
	{	
	driver.findElement(By.xpath(".//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[5]/div[1]/div[2]/div[1]/fieldset[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]")).click();
	Thread.sleep(600);
	StringSelection img01 = new StringSelection(img1);
	clipboard.setContents(img01, null);
	driver.switchTo().activeElement();
	Thread.sleep(1500);
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	Thread.sleep(600);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.keyRelease(KeyEvent.VK_V);
	Thread.sleep(1500);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
//	Thread.sleep(13000);
//	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//	IMGUP01TXT = wait.until(ExpectedConditions.(IMGUP01TXT, jpg));
//	WebElement IMGUP01 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/new-component/div/form/uib-accordion/div/ng-form[5]/div/div[2]/div/fieldset/div[2]/div[2]/div[1]/img"));
	IMGUP01 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[5]/div[1]/div[2]/div[1]/fieldset[1]/div[2]/div[2]/div[1]/img[1]")));
	
	}

//	while(IMGUP01.isDisplayed() == true ) ;
//	 || IMGUP01TXT.getText().contains(".jpg")
	
	
//		UPLOAD IMAGE-2    //
	do //do while loop START
	{
	driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[5]/div[1]/div[2]/div[1]/fieldset[1]/div[2]/div[1]/div[2]/div[1]/div[1]/button[1]")).click();
	Thread.sleep(600);
	StringSelection img02 = new StringSelection(img2);
	clipboard.setContents(img02, null);
	driver.switchTo().activeElement();
	Thread.sleep(1500);
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	Thread.sleep(600);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.keyRelease(KeyEvent.VK_V);
	Thread.sleep(1500);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
//	Thread.sleep(13000);
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	while(IMGUP02.isDisplayed() == true && IMGUP02TXT.getText().contains(".jpg"));
	
	do //do while loop START
//		UPLOAD IMAGE-3   	 //
	{
	driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[5]/div[1]/div[2]/div[1]/fieldset[1]/div[2]/div[1]/div[3]/div[1]/div[1]/button[1]")).click();
	Thread.sleep(600);
//	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	StringSelection img03 = new StringSelection(img3);
	driver.switchTo().activeElement();
	Thread.sleep(1500);
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	Thread.sleep(600);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.keyRelease(KeyEvent.VK_V);
	Thread.sleep(1500);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
//	Thread.sleep(13000);
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	WebElement guru99seleniumlink;
	guru99seleniumlink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/section/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/div/a/i")));
	
	}	
	while(IMGUP02.isDisplayed() == true && IMGUP02TXT.getText().contains(".jpg"));
	// DO WHILE STOP
	driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[5]/div[1]/div[2]/div[1]/fieldset[1]/div[4]/div[2]/input[1]")).click();
	
	Thread.sleep(1000);
//	driver.switchTo().activeElement();
//	Thread.sleep(1000);
//	Robot robot = new Robot();
//	robot.keyPress(KeyEvent.VK_CONTROL);
//	robot.keyPress(KeyEvent.VK_V);
//	Thread.sleep(600);
//	robot.keyRelease(KeyEvent.VK_CONTROL);
//	robot.keyRelease(KeyEvent.VK_V);
//	Thread.sleep(1000);
//	robot.keyRelease(KeyEvent.VK_CONTROL);
//	robot.keyRelease(KeyEvent.VK_V);
//	robot.keyPress(KeyEvent.VK_ENTER);
//	robot.keyRelease(KeyEvent.VK_ENTER);
//	Thread.sleep(5000);
	
	
	


	long ExecutionTime = (System.currentTimeMillis() - start);
	long ETS = ExecutionTime/1000 ;
	System.out.println("Execution time:" + ETS +"seconds");
//	driver.close();
	
	}

	private static Function ExpectedConditions(By by, String jpg) {
		// TODO Auto-generated method stub
		return null;
	}

}


//**************upload bUTTON*****************//

//a.keyDown(Upload, img);
//Upload.sendKeys(Keys.CONTROL);

//driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/div[14]/div[4]/document-upload[1]/div[1]/fieldset[1]/div[2]/select[1]")).sendKeys("Packaging Photo");

//WebElement MRPDocs = driver.findElement(By.xpath(".//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/div[14]/div[4]/document-upload[1]/div[1]/fieldset[1]/div[2]/button[1]"));
//MRPDocs.sendKeys("https://assets-mkpbg.gem.gov.in/img/othe/3681551/71/ea/1a.jpg.5a89e571ea.999x120x120.jpg");
//driver.wait(3);

//driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[3]/div[1]/div[2]/div[1]/fieldset[1]/div[18]/div[2]/button[1]")).click();
//Thread.sleep(2000);
//
//driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[4]/div[1]/div[2]/div[1]/fieldset[1]/div[1]/form-builder[1]/div[1]/div[1]/div[1]/fieldset[1]/div[3]/div[1]/div[2]/div[1]/element[1]/div[1]/input[1]")).clear();
//driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[4]/div[1]/div[2]/div[1]/fieldset[1]/div[1]/form-builder[1]/div[1]/div[1]/div[1]/fieldset[1]/div[3]/div[1]/div[2]/div[1]/element[1]/div[1]/input[1]")).sendKeys(brandname);
//
//driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[4]/div[1]/div[2]/div[1]/fieldset[1]/div[1]/form-builder[1]/div[1]/div[1]/div[1]/fieldset[1]/div[4]/div[1]/div[2]/div[1]/element[1]/div[1]/input[1]")).clear();
//driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[4]/div[1]/div[2]/div[1]/fieldset[1]/div[1]/form-builder[1]/div[1]/div[1]/div[1]/fieldset[1]/div[4]/div[1]/div[2]/div[1]/element[1]/div[1]/input[1]")).sendKeys("Make of Compatible cartridge");
//
//driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[4]/div[1]/div[2]/div[1]/fieldset[1]/div[1]/form-builder[1]/div[1]/div[1]/div[1]/fieldset[1]/div[5]/div[1]/div[2]/div[1]/element[1]/div[1]/input[1]")).clear();
//driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='content-slot']/div[1]/div[1]/new-component[1]/div[1]/form[1]/uib-accordion[1]/div[1]/ng-form[4]/div[1]/div[2]/div[1]/fieldset[1]/div[1]/form-builder[1]/div[1]/div[1]/div[1]/fieldset[1]/div[5]/div[1]/div[2]/div[1]/element[1]/div[1]/input[1]")).sendKeys("Corresponding Part number");

//Thread.sleep(2000);

//*******************************





//*********************PRICE CALCULATE**************//

//String MRP = driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='product-detail-page']/div[2]/div[1]/div[2]/div[3]/div[3]/span[1]/span[1]")).getText();
//String SellPrice = driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='product-detail-page']/div[2]/div[1]/div[2]/div[3]/div[4]/span[1]/span[1]")).getText();

//String MRP1 = CharMatcher.inRange('0','9').retainFrom(MRP);
//String SellPrice1 = CharMatcher.inRange('0','9').retainFrom(SellPrice);	
//String SellPrice1= SellPrice.replaceAll("[^0-9]", "");

//int MRRPInt = Integer.parseInt(MRP1.replaceAll("[^0-9]", ""));
//int SellPriceInt = Integer.parseInt(SellPrice1.replaceAll("[^0-9]", ""));
//
//System.out.println("MRRPInt: " + MRRPInt/100);
//System.out.println("SellPriceInt: "+ SellPriceInt/100);

//int TempRate = (int) (SellPriceInt * 0.4/100);
//int SellPriceLowRate = (SellPriceInt - TempRate)/100;
//System.out.println("SellPriceLowRate: " +SellPriceLowRate);

//********************************************
	