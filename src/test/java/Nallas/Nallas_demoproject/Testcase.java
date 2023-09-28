package Nallas.Nallas_demoproject;

import java.sql.SQLException;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Nallas.Nallas_demoproject.TestBase.testbase;


import com.relevantcodes.extentreports.LogStatus;
import Nallas.Nallas_demoproject.TestBase.common_function;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class Testcase extends testbase
{

	@FindBy(xpath="//p[@class='copyRight']")
	public static WebElement copyright;
	
	private final static Logger logger = Logger.getLogger(Testcase.class);
	
	
	public Testcase()
	{
			
			PageFactory.initElements(driver, this);
			//String root = System.getProperty("user.dir");
			//System.out.println(root+"\\src\\test\\java\\resource\\log4j.properties");
			//PropertyConfigurator.configure(root+"\\src\\test\\java\\resource\\log4j.properties");
	}
	
	
	//Testcase implementation 
	@SuppressWarnings("static-access")
	public static void TC_01(int[] inputarray, int sum_value) throws InterruptedException, ClassNotFoundException, SQLException
	{
		try
		{
			
			
		common_function cmfn = new common_function();
		
		//Return index value from matched array. There is no match it will return 0;
		
		int find_index = cmfn.find_array_index(inputarray,sum_value);
		logMessage_text("Input Array"+ Arrays.toString(inputarray));
		
		logMessage_text("Compare value"+ sum_value);
		
		if(find_index!=0)
		{
			String output = "Sum of the element from 1st position to "+find_index+"th position is "+sum_value;
			System.out.println("Sum of the element from 1st position to "+find_index+"th position is"+sum_value);
			logMessage_text(output);
			log.info(output);
		}
		else
		{
			String output = "Matching array not found : Default value"+"-1";
			logMessage_text(output);
			System.out.println("-1");
			log.info(output);
		}
		}
		catch(Exception e)
		{
			log.info(e.toString());
		}
	}
	
	
	
	
	
	
}
