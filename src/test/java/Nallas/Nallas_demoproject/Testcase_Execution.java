package Nallas.Nallas_demoproject;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.AccessDeniedException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.monte.media.Format;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
import org.zaproxy.clientapi.core.ApiResponseElement;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;
import org.zaproxy.zap.extension.api.ApiResponse;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import Nallas.Nallas_demoproject.Testcase;
import Nallas.Nallas_demoproject.TestBase.testbase;
import net.continuumsecurity.proxy.Spider;
import net.continuumsecurity.proxy.ZAProxyScanner;



public class Testcase_Execution extends testbase
{
	
	// Change the value to run in different browser: firefox, edge
	private static String  browser_name = "Chrome";
	private static ClientApi api;
	
	@BeforeClass
	public void beforesuite() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, InterruptedException, FilloException, IOException{
	
		String date = returnTodayDateTime("ddMMYYYY-hhmmss");
   	     extent = new ExtentReports(System.getProperty("user.dir")+"\\Output_Report\\Execution_Report\\Execution_report-"+date+".html");
   	  Fillo fillo = new Fillo();
		System.out.println("Size: " + "test");
		inputfilelocation = System.getProperty("user.dir")+"\\Input\\Automation_input.xlsx";
		Connection connection = fillo.getConnection(inputfilelocation);
		Recordset recordset = connection.executeQuery("SELECT * FROM Configuration");
		
		scanstatus = recordset.getField("Security_scan"); 
		
		if(scanstatus.equalsIgnoreCase("Yes"))
		{
				
		int i = 0;
		ArrayList<String> newobj = new ArrayList<String>();
		//String[] newobj = new String[numberOfRows];
	
		while (recordset.next()) 
		{
			api_key = recordset.getField("APIKEY");
			zap_loc = recordset.getField("ZAPTOOL_Location");
		}		
		try
		{
			
			File filePath=new File(zap_loc);
			String dir= filePath.getParent();
			String filename = filePath.getName();
			
			 System.out.println("folder name"+dir);
			 System.out.println("file name name"+filename);
			//open zap application
			 File dir1 = new File(dir);
		     ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/C", "Start",filename);
		     pb.directory(dir1);
		     Process p = pb.start();
			Thread.sleep(20000);
			 System.out.println("test");
			 Projectname ="Verisk";
			 Testcase_Type = "Regression";
			 Executed_by = "Venkat";
			  TC_currentdate = new SimpleDateFormat("ddMMyyyy").format(Calendar.getInstance().getTime());
			 
			
		}
		
		catch(Exception e)
		{
			System.out.println("errr"+e.toString());
		}
		}
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
	public void setProxy_Zap(Method method) throws Exception 
	
		 {
		if(scanstatus.equalsIgnoreCase("yes"))
		{
		String ZAP_PROXY_ADDRESS = "localhost";
		int ZAP_PROXY_PORT = 8080;
		String ZAP_API_KEY = api_key;
	    

		   api = new ClientApi(ZAP_PROXY_ADDRESS, ZAP_PROXY_PORT, ZAP_API_KEY);
	
		 }
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
	
	
	
	

	
	@Test (dataProvider = "TCList")
	public static void TC(String list) throws Exception
	{
		
		String[] listinfo = list.split("~");
		System.out.println("testcase test"+listinfo[0]);
		String timeStamp_start = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		test_start_time = timeStamp_start;
		testid = listinfo[0];
		testcase_id = listinfo[0];
		  	try
		  	{
		  	//System.out.println("testcase"+list);
			System.out.println("testcase"+listinfo[3]);
			invoke_browser(listinfo[3]);
			test = extent.startTest(listinfo[0]);
			ScreenRecorderUtil.startRecord("TestExecution"+testcase_id);
			
			if(listinfo[2].toLowerCase().equalsIgnoreCase("yes"))
			{
				System.out.println("Test Run");
				testcase_execution();
				teststatus = "Pass";
				
				test.log(LogStatus.PASS, "Testcase ID: "+listinfo[0]+" completed  -Status: Pass");
			}
			else
			{
				teststatus = "Skip";
				test.log(LogStatus.SKIP, "Testcase ID: "+listinfo[0]+" completed  -Status: Skip");
			}
			
		  	}
		  	catch(Exception e)
		  	{
		  		teststatus = "Failed";
		  		test.log(LogStatus.FAIL, "Testcase ID: "+listinfo[0]+" completed  -Status: Failed");
		  	}
		  	
		  	ScreenRecorderUtil.stopRecord();
	}
	
	@AfterMethod
	public void stoprecord() throws Exception 
		 {
		String timeStamp_end = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		test_end_time =   timeStamp_end;
		
		driver.quit();
		     
		     teamsmessage+= "<tr><td>"+testid+"</td><td>"+teststatus+"</td><td>"+test_start_time+"</td><td>"+test_end_time+"</td></tr>";
		  
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
		
		if(scanstatus.equalsIgnoreCase("Yes"))
		{
		
		if (api != null) { 
			 
			 String date = returnTodayDateTime("ddMMYYYY-hhmmss");
			 System.out.println("date"+date);
		      String title = "POC ZAP Selenium_Report-"+ date ; 
		      String template = "traditional-html"; 
		      String description = "This is a ZAP test report"; 
		      String reportfilename = "Security Test_Report-"+date+".html"; 
		      String targetFolder = System.getProperty("user.dir"); 
		      try { 
		    	  Thread.sleep(10000);
		         org.zaproxy.clientapi.core.ApiResponse res = api.reports.generate(title, template, null, 
		         description, null, null, null,null, null, reportfilename,null, 
		         targetFolder,null); 
		         System.out.println("ZAP report generated here: " + res.toString());
		      } catch (ClientApiException ex) { 
		         throw new Exception(ex);
		      } 
		   }
		}
		
		driver.quit();
		//close zap application
		Runtime.getRuntime().exec("taskkill /F /IM java.exe");
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
		Runtime.getRuntime().exec("taskkill /f /im cmd.exe") ;
		dynamicvalue = "";
		Sendnotification();
	}


public static void Sendnotification() {
	
	String message = "TestCase Executed";
	 String payload1 = "{\"type\":\"message\",\"attachments\":[{\"contentType\":\"application/vnd.microsoft.card.adaptive\",\"contentUrl\":null,\"content\":{\"$schema\":\"http://adaptivecards.io/schemas/adaptive-card.json\", \"type\":\"AdaptiveCard\", \"version\":\"1.2\",\"body\":[{\"type\": \"TextBlock\",\"themeColor\":\"E81123\",\"text\":\"" + message + "\"}] }}]}";
	 String payload2 = "{\"type\":\"message\",\"attachments\":[{\"contentType\":\"application/vnd.microsoft.card.adaptive\",\"contentUrl\":null,\r\n \"content\":{\"$schema\":\"http://adaptivecards.io/schemas/adaptive-card.json\", \"type\":\"AdaptiveCard\", \"version\":\"1.2\",\r\n \"body\":[\r\n {\r\n \"type\": \"TextBlock\",\"text\":\"" + message + "\",\"weight\":\"bolder\",\"size\":\"large\"}] }}]}";
	String payload ="{\"@type\":\"MessageCard\",\"@context\":\"http://schema.org/extensions\",\"themeColor\":\"0076D7\",\"summary\":\"TestExecution\",\"sections\":[{\"activityTitle\":\"Project Name: "+Projectname+ "\",\"activitySubtitle\":\"\",\"activityImage\":\"\",\"facts\":[{\"name\":\"Testcase Type\",\"value\":\" "+Testcase_Type+"\"},{\"name\":\"Executed By\",\"value\":\""+Executed_by+"\"},{\"name\":\"Execution Date\",\"value\":\""+TC_currentdate+"\"}],\"markdown\":true},{\"startGroup\":true,\"text\":\"<table bordercolor='black' border= '2'><thead><tr style = 'background-color : Teal; color: White'><th>Testcase_ID</th><th>Status</th><th>Start Time</th><th>End Time</th></tr></thead></thead><tbody >"+teamsmessage+"</tbody></table>\"}]}";
	 // String payload = "{\"contentType\":\"application/vnd.microsoft.card.adaptive\",\"content\":{\"$schema\":\"http://adaptivecards.io/schemas/adaptive-card.json\",\"type\":\"AdaptiveCard\",\"version\":\"1.0\",\"body\":[{\"type\":\"Container\",\"items\":[{\"type\":\"TextBlock\",\"text\":\"Publish Adaptive Card schema\",\"weight\":\"bolder\",\"size\":\"medium\"},{\"type\":\"ColumnSet\",\"columns\":[{\"type\":\"Column\",\"width\":\"auto\",\"items\":[{\"type\":\"Image\",\"url\":\"https://nallas.keka.com/files/90a329d1-cb53-441c-80f5-57291eb1f481/200x200/profileimage/32e2c538d2034993b3b2ea68ef908a67.jpg\",\"size\":\"small\",\"style\":\"person\"}]}]}]}]}}";
	 String URL = "https://nallascorp.webhook.office.com/webhookb2/d9124108-8202-4deb-85e4-eead0debce8e@832ebef3-7cc8-484d-90fa-3a367f861f4c/IncomingWebhook/fad18c364a3c418faff60b1e2accb274/a2b31ed7-7fe4-45dc-a52b-82a8267da97a";
	//String rawData = "id=10";
	
	
	
	
	HttpClient httpClient = HttpClientBuilder.create().build();

	try {
	    HttpPost request = new HttpPost(URL);
	    StringEntity params =new StringEntity(payload);
	    request.addHeader("content-type", "application/json");
	    request.addHeader("Accept","application/json");
	    
	    request.setEntity(params);
	    HttpResponse response = httpClient.execute(request);
        System.out.println("Test Execution Status: Pass"+response.getStatusLine());
	    // handle response here...
	}catch (Exception ex) {
	    // handle exception here
	}
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
