import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;



public class ReadExcelFile 
{
	

		public static void main(String[]args)  throws Exception{
			System.setProperty("webdriver.chrome.driver", "C:\\Np\\Dev\\Eclipse\\Repo\\Test\\jars\\chromedriver94.exe");

			WebDriver driver = new ChromeDriver();
//			WebDriverWait wait = new WebDriverWait(driver, 30);
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			String search = "https://mkp.gem.gov.in/home/search?q=";

			
	File src = new File("C:\\MIX.xlsx");
	FileInputStream fis = new FileInputStream(src);
	@SuppressWarnings("resource")
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	XSSFSheet sh1= wb.getSheetAt(0);	
	int rowcount = sh1.getLastRowNum();
	System.out.println("roe count: "+ rowcount);
	for(int i=0; i<rowcount; i++)
	{
		String ProductID = sh1.getRow(i).getCell(0).getStringCellValue();
		System.out.println("Row data: "+ ProductID);
		System.out.println("PRODUCTS ADDED COUNT: "+ i);
		driver.get(search + ProductID);
		 if ( driver.getPageSource().contains("An error occurred.") || driver.getPageSource().contains("Bad Request"))
		 {
			 driver.navigate().refresh();
			 System.out.println("Error on page ......., refreshing ... for " + ProductID);
		 }
		 else {
		if(driver.getCurrentUrl() == search + ProductID)
		{
			driver.navigate().refresh();
			System.out.println("page not loaded, refreshing ... " + ProductID);
		}
		else 
		{
			String MRP = driver.findElement(By.xpath("//body/div[@id='page']/div[@id='bd']/div[@id='product-detail-page']/div[2]/div[1]/div[2]/div[3]/div[3]/span[1]/span[1]")).getText();
			System.out.println(MRP);
		}
		}
		

//		XSSFCell op = sh1.getRow(i).createCell(1);
//	     //check if confirmation message is displayed
//	     if (Make.contains("Samsung")) {
//	         // if the message is displayed , write PASS in the excel sheet
//	         op.setCellValue("PASS");
//	         
//	     } else {
//	         //if the message is not displayed , write FAIL in the excel sheet
//	         op.setCellValue("FAIL");
//	     }
	     
	     // Write the data back in the Excel file
//	     FileOutputStream outputStream = new FileOutputStream("D:\\List1.xlsx");
//	     wb.write(outputStream);
		
	}	

	
	fis.close();
		}
	}


//System.out.println("Row data: "+ rowdata);
//String rowdata = null; 
//String getRowAndColumn = sh1.getRow(0).getCell(0).getStringCellValue();