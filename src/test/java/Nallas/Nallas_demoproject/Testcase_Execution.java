package Nallas.Nallas_demoproject;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.AccessDeniedException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.monte.media.Format;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import Nallas.Nallas_demoproject.Testcase;
import Nallas.Nallas_demoproject.TestBase.testbase;



public class Testcase_Execution extends testbase
{
	
	// Change the value to run in different browser: firefox, edge
	private static String  browser_name = "Chrome";
	
	@BeforeClass
	public void beforesuite() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, InterruptedException{
	
		String date = returnTodayDateTime("ddMMYYYY-hhmmss");
   	     extent = new ExtentReports(System.getProperty("user.dir")+"\\Output_Report\\Execution_Report\\Execution_report-"+date+".html");
		
		
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) 
	{
		
 	
	    TestListenerAdapter tla = new TestListenerAdapter();
	    TestNG testng = new TestNG();
	    testng.setTestClasses(new Class[] { Testcase_Execution.class });
	    testng.addListener(tla);
	    testng.run();
	} 
	
	
	
	@BeforeMethod
	public void readExcel(Method method) throws Exception 
		 {
		
		
		  
		 }
	
	
	@DataProvider(name = "TCList")
	public Object[] Testcaselist() throws FilloException 
	{
		
		Fillo fillo = new Fillo();
		System.out.println("Size: " + "test");
		inputfilelocation = System.getProperty("user.dir")+"\\Input\\Automation_input.xlsx";
		Connection connection = fillo.getConnection(inputfilelocation);
		Recordset recordset = connection.executeQuery("SELECT * FROM Execution");
		int numberOfRows = recordset.getCount();
		System.out.println("Size: " + numberOfRows);
		int i = 0;
		ArrayList<String> newobj = new ArrayList<String>();
		//String[] newobj = new String[numberOfRows];
		Object data[]= new Object[numberOfRows];
		while (recordset.next()) 
		{
			
			testcase_id = recordset.getField("TestcaseId");
			testcase_description = recordset.getField("Description");
			testcase_Execution = recordset.getField("Execution_Status");
			 browser =recordset.getField("Browser");
			String finalstring = testcase_id+"~"+testcase_description+"~"+testcase_Execution+"~"+browser;
		   data[i] = finalstring;
		   i++;
			System.out.println(finalstring);		  
						
		}		
		return data;
	}
	
	
	
	
	/// To find array index which matched for given integer
	@SuppressWarnings("static-access")
	
	@Test (dataProvider = "TCList")
	public static void TC(String list) throws Exception
	{
		
		String[] listinfo = list.split("~");
		System.out.println("testcase test"+listinfo[0]);
		
		testcase_id = listinfo[0];
		  	try
		  	{
		  	//System.out.println("testcase"+list);
			System.out.println("testcase"+listinfo[3]);
			invoke_browser(listinfo[3]);
			test = extent.startTest(listinfo[0]);
			ScreenRecorderUtil.startRecord("testExecutionfinal");
			
			if(listinfo[2].toLowerCase().equalsIgnoreCase("yes"))
			{
				System.out.println("Test Run");
				testcase_execution();
				
				
				test.log(LogStatus.PASS, "Testcase ID: "+listinfo[0]+" completed  -Status: Pass");
			}
			else
			{
				test.log(LogStatus.SKIP, "Testcase ID: "+listinfo[0]+" completed  -Status: Skip");
			}
			
		  	}
		  	catch(Exception e)
		  	{
		  		test.log(LogStatus.FAIL, "Testcase ID: "+listinfo[0]+" completed  -Status: Failed");
		  	}
		  	
		  	
	}
	
	@AfterMethod
	public void stoprecord() throws Exception 
		 {
		
		ScreenRecorderUtil.stopRecord();
		  
		 }
	
	
	
	

	public void getResult(ITestResult result) throws Exception {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, result.getThrowable());
			test.log(LogStatus.FAIL, "Test failed");
		}

		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, "Test Pass");
		}

		if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test Skip");
		}
		
	}

@AfterTest
	public void endtest() throws Exception {
		extent.endTest(test);
		extent.flush();
	
		 
		dynamicvalue = "";
	}

public static int[] system_resolution()
{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screenSize.getWidth();
		
		int height = (int)screenSize.getHeight();
		int[] val = {width,height};
		return val;
		
}
}
