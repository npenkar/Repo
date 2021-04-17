

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
import org.openqa.selenium.support.ui.WebDriverWait;



public class ReadExcelFile 
{
	

		public static void main(String[]args)  throws Exception{
			System.setProperty("webdriver.chrome.driver", "C:\\Np\\Dev\\Eclipse\\Workspace\\Test\\src\\chromedriver.exe");

			WebDriver driver = new ChromeDriver();
			WebDriverWait wait = new WebDriverWait(driver, 30);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			String search = "https://mkp.gem.gov.in/home/search?q=";

			
	File src = new File("D:\\List1.xlsx");
	FileInputStream fis = new FileInputStream(src);
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
		String Make = driver.findElement(By.xpath("//*[@id=\'feature_groups\']/table/tbody/tr[3]/td[2]")).getText();	
		System.out.println(Make);
		
		
		XSSFCell op = sh1.getRow(i).createCell(1);
	     //check if confirmation message is displayed
	     if (Make.contains("Samsung")) {
	         // if the message is displayed , write PASS in the excel sheet
	         op.setCellValue("PASS");
	         
	     } else {
	         //if the message is not displayed , write FAIL in the excel sheet
	         op.setCellValue("FAIL");
	     }
	     
	     // Write the data back in the Excel file
	     FileOutputStream outputStream = new FileOutputStream("D:\\List1.xlsx");
	     wb.write(outputStream);
		
	}	

	
	fis.close();
		}
	}


//System.out.println("Row data: "+ rowdata);
//String rowdata = null; 
//String getRowAndColumn = sh1.getRow(0).getCell(0).getStringCellValue();