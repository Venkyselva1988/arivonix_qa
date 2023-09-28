package Nallas.Nallas_demoproject.TestBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;

public class common_function extends testbase

{
	
	public common_function()
	{
		
	}
	
	 
	  
	  public static void LaunchWebsite(String data,String xpath) throws InterruptedException
	  {
		      driver.get(data);
	        
	         driver.manage().window().maximize();
	         log.info("Open Website"+data);
	         Thread.sleep(3000);
	        
			  if(Screenshot_required.equalsIgnoreCase("yes"))
			  {
				 
				  logMessage_withScreenshot(teststep_description);
			  }
	         
	  }
	  
	  public static void Click(String data, String xpath)
		{
	       try
	       {
		  WebElement elemt = driver.findElement(By.xpath(xpath));
		  elemt.click();
		  log.info(teststep_description);
	       }
	       catch(Exception e)
	       {
	    	   Error_withScreenshot(e.toString());
		    	log.info(e.toString());
	       }
	       if(Screenshot_required.equalsIgnoreCase("yes"))
			  {
				 
				  logMessage_withScreenshot(teststep_description);
			  }
		}
	  
	  public static void ActionClick(String data, String xpath)
		{
	      try
	      {
		  WebElement elemt = driver.findElement(By.xpath(xpath));
		  Actions actn = new Actions(driver);
		  actn.click(elemt).perform();
		  log.info(teststep_description);
	      }
	      catch(Exception e)
	       {
	    	   Error_withScreenshot(e.toString());
		    	log.info(e.toString());
	       }
	      if(Screenshot_required.equalsIgnoreCase("yes"))
		  {
			 
			  logMessage_withScreenshot(teststep_description);
		  }
		}
	  
	  public static void JavaScriptClick(String data, String xpath)
			{
		      try
		      {
			  WebElement elemt = driver.findElement(By.xpath(xpath));
			  JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", elemt);
				log.info(teststep_description);
		      }
		      catch(Exception e)
		       {
		    	   Error_withScreenshot(e.toString());
			    	log.info(e.toString());
		       }
		      if(Screenshot_required.equalsIgnoreCase("yes"))
			  {
				 
				  logMessage_withScreenshot(teststep_description);
			  }
			}
	  
	  
	  public static void VerifyText_Equal(String data, String xpath)
		{
	    try
	    {
		  WebElement elemt = driver.findElement(By.xpath(xpath));
		  String actualvalue = elemt.getText();
		  if(actualvalue.equalsIgnoreCase(data))
		  {
			  System.out.println("value matched");
			  logMessage_withScreenshot(teststep_description);
			  log.info(teststep_description);
		  }
		  else
		  {
			  Failure_withScreenshot(teststep_description);
			  log.info(teststep_description+"Failed");
		  }
	    }
	    catch(Exception e)
	    {
	    	Error_withScreenshot(e.toString());
	    	log.info(e.toString());
	    }
	    
	    if(Screenshot_required.equalsIgnoreCase("yes"))
		  {
			 
			  logMessage_withScreenshot(teststep_description);
		  }
		}
	  
	  
	  public static void VerifyText_NotEqual(String data, String xpath)
		{
	    try
	    {
		  WebElement elemt = driver.findElement(By.xpath(xpath));
		  String actualvalue = elemt.getText();
		  if(!actualvalue.equalsIgnoreCase(data))
		  {
			  System.out.println("value matched");
			  logMessage_withScreenshot(teststep_description);
			  log.info(teststep_description);
		  }
		  else
		  {
			  Failure_withScreenshot(teststep_description);
			  log.info(teststep_description+"Failed");
		  }
	    }
	    catch(Exception e)
	    {
	    	Error_withScreenshot(e.toString());
	    	log.info(e.toString());
	    }
	    
	    if(Screenshot_required.equalsIgnoreCase("yes"))
		  {
			 
			  logMessage_withScreenshot(teststep_description);
		  }
		}
	  
	  
	  
	  public static void VerifyText_Contains(String data, String xpath)
		{
	    try
	    {
		  WebElement elemt = driver.findElement(By.xpath(xpath));
		  String actualvalue = elemt.getText();
		  if(actualvalue.contains(data))
		  {
			  System.out.println("value matched");
			  logMessage_withScreenshot(teststep_description);
			  log.info(teststep_description);
		  }
		  else
		  {
			  Failure_withScreenshot(teststep_description);
			  log.info(teststep_description+"Failed");
		  }
	    }
	    catch(Exception e)
	    {
	    	Error_withScreenshot(e.toString());
	    	log.info(e.toString());
	    }
	    
	    if(Screenshot_required.equalsIgnoreCase("yes"))
		  {
			 
			  logMessage_withScreenshot(teststep_description);
		  }
		}
	  
	  
	  public static void VerifyText_NotContains(String data, String xpath)
		{
	    try
	    {
		  WebElement elemt = driver.findElement(By.xpath(xpath));
		  String actualvalue = elemt.getText();
		  if(!actualvalue.contains(data))
		  {
			  System.out.println("value matched");
			  logMessage_withScreenshot(teststep_description);
			  log.info(teststep_description);
		  }
		  else
		  {
			  Failure_withScreenshot(teststep_description);
			  log.info(teststep_description+"Failed");
		  }
	    }
	    catch(Exception e)
	    {
	    	Error_withScreenshot(e.toString());
	    	log.info(e.toString());
	    }
	    
	    if(Screenshot_required.equalsIgnoreCase("yes"))
		  {
			 
			  logMessage_withScreenshot(teststep_description);
		  }
		}
	  
	  
	  
	  
	  public static void WaitforElement_Clickable(String data, String xpat)
		{
	      try
	      {
		  int waittime = Integer.parseInt(data);
		  WebDriverWait wait = new WebDriverWait(driver, waittime); 
		  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpat)));
	      if(element.isDisplayed())
	      {
	    	  log.info(teststep_description);
	      }
	      else
	      {
	    	  Failure_withScreenshot(teststep_description);
			  log.info(teststep_description+"Failed");
	      }
	      
	      }
	      catch(Exception e)
	       {
	    	   Error_withScreenshot(e.toString());
		    	log.info(e.toString());
	       }
	      if(Screenshot_required.equalsIgnoreCase("yes"))
		  {
			 
			  logMessage_withScreenshot(teststep_description);
		  }
		}
	  
	  public static void WaitforElement_Visible(String data, String xpat)
		{
	      try
	      {
		  int waittime = Integer.parseInt(data);
		  WebDriverWait wait = new WebDriverWait(driver, waittime); 
		  WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpat)));
		  if(element.isDisplayed())
	      {
	    	  log.info(teststep_description);
	      }
	      else
	      {
	    	  Failure_withScreenshot(teststep_description);
			  log.info(teststep_description+"Failed");
	      }
	      }
	      catch(Exception e)
	       {
	    	   Error_withScreenshot(e.toString());
		    	log.info(e.toString());
	       }
	      if(Screenshot_required.equalsIgnoreCase("yes"))
		  {
			 
			  logMessage_withScreenshot(teststep_description);
		  }
	      }
	  
	  public static void MoveNextTab (String data, String xpath)
	  {
		  String parent_window = driver.getWindowHandle();
		  Set<String> allWindowHandles = driver.getWindowHandles();
		  for(String actual: allWindowHandles)
		  {
		  if(!actual.equalsIgnoreCase(parent_window)) 
		  {
			//Switch to the opened tab
			driver.switchTo().window(actual);
			 logMessage_withScreenshot(teststep_description);
			 log.info(teststep_description);
		  }
		  }		
		  if(Screenshot_required.equalsIgnoreCase("yes"))
		  {
			 
			  logMessage_withScreenshot(teststep_description);
		  }
	  }
	  
	  public static void MoveTabBasedOnIndex (String data, String xpath)
	  {
		  int index = Integer.parseInt(data);
		  Set<String> windowHandles = driver.getWindowHandles();
		    List<String> windowStrings = new ArrayList<>(windowHandles);
		    String reqWindow = windowStrings.get(index);
		    driver.switchTo().window(reqWindow);		
		    log.info(teststep_description);
		    if(Screenshot_required.equalsIgnoreCase("yes"))
			  {
				 
				  logMessage_withScreenshot(teststep_description);
			  }
	  }
	  
	  
	  
	  public static void ActionSendkeys(String data, String xpath)
		{
			try
			{
			
			Actions actn = new Actions(driver);
			System.out.println(data);
			 WebElement elemt = driver.findElement(By.xpath(xpath));
			actn.sendKeys(elemt, data).build().perform();
			 log.info(teststep_description);
			
		   }
		   catch (Exception e)
		    {
			Error_withScreenshot(e.toString());
			log.info(e.toString());
		     }
			 if(Screenshot_required.equalsIgnoreCase("yes"))
			  {
				 
				  logMessage_withScreenshot(teststep_description);
			  }
		}
	  
	  public static void ElementSendkeys(String data, String xpath)
		{
			try
			{
		
			 WebElement elemt = driver.findElement(By.xpath(xpath));
			 elemt.sendKeys(data);
			 log.info(teststep_description);
			
		   }
		   catch (Exception e)
		    {
			Error_withScreenshot(e.toString());
			log.info(e.toString());
		     }
			 if(Screenshot_required.equalsIgnoreCase("yes"))
			  {
				 
				  logMessage_withScreenshot(teststep_description);
			  }
		}
	  
	  
	  public static void JavaScriptSetText(String data, String xpath)
		{
			try
			{
		
			 WebElement elemt = driver.findElement(By.xpath(xpath));
			 JavascriptExecutor js = (JavascriptExecutor)driver;
			 js.executeScript("arguments[0].value='"+data+"';", elemt);
			 log.info(teststep_description);
			
		   }
		   catch (Exception e)
		    {
			Error_withScreenshot(e.toString());
			log.info(e.toString());
		     }
			 if(Screenshot_required.equalsIgnoreCase("yes"))
			  {
				 
				  logMessage_withScreenshot(teststep_description);
			  }
		}
	  
	  public static void GetAttributeValue(String data, String xpath)
		{
			try
			{
		
			 WebElement elemt = driver.findElement(By.xpath(xpath));
			
			 temp_value=elemt.getAttribute(data);
			
			 log.info(teststep_description);
			
		   }
		   catch (Exception e)
		    {
			Error_withScreenshot(e.toString());
			log.info(e.toString());
		     }
			 if(Screenshot_required.equalsIgnoreCase("yes"))
			  {
				 
				  logMessage_withScreenshot(teststep_description);
			  }
		}
	  
	  
	  public static void AttributeValueComparison_equal(String data, String xpath)
		{
			try
			{
		    String[] val = data.split("~");
			 WebElement elemt = driver.findElement(By.xpath(xpath));
			
			 temp_value=elemt.getAttribute(val[0]);
			
			 if(temp_value.equalsIgnoreCase(val[1]))
			 {
				 
				  logMessage_withScreenshot(teststep_description);
				  log.info(teststep_description);
			  }
			  else
			  {
				  Failure_withScreenshot(teststep_description);
				  log.info(teststep_description+"Failed");
			  }
			 if(Screenshot_required.equalsIgnoreCase("yes"))
			  {
				 
				  logMessage_withScreenshot(teststep_description);
			  }
			
		   }
		   catch (Exception e)
		    {
			Error_withScreenshot(e.toString());
			log.info(e.toString());
		     }
		}
	  
	  
	  public static void AttributeValueComparison_contains(String data, String xpath)
		{
			try
			{
		    String[] val = data.split("~");
			 WebElement elemt = driver.findElement(By.xpath(xpath));
			
			 temp_value=elemt.getAttribute(val[0]);
			
			 if(temp_value.contains(val[1]))
			 {
				 
				  logMessage_withScreenshot(teststep_description);
				  log.info(teststep_description);
			  }
			  else
			  {
				  Failure_withScreenshot(teststep_description);
				  log.info(teststep_description+"Failed");
			  }
			
			
		   }
		   catch (Exception e)
		    {
			Error_withScreenshot(e.toString());
			log.info(e.toString());
		     }
			 if(Screenshot_required.equalsIgnoreCase("yes"))
			  {
				 
				  logMessage_withScreenshot(teststep_description);
			  }
		}
	  
	  
	  public static void AttributeComparison_notequal(String data, String xpath)
		{
			try
			{
		    String[] val = data.split("~");
			 WebElement elemt = driver.findElement(By.xpath(xpath));
			
			 temp_value=elemt.getAttribute(val[0]);
			
			 if(!temp_value.equalsIgnoreCase(val[1]))
			 {
				 
				  logMessage_withScreenshot(teststep_description);
				  log.info(teststep_description);
			  }
			  else
			  {
				  Failure_withScreenshot(teststep_description);
				  log.info(teststep_description+"Failed");
			  }
			
			
		   }
		   catch (Exception e)
		    {
			Error_withScreenshot(e.toString());
			log.info(e.toString());
		     }
			 if(Screenshot_required.equalsIgnoreCase("yes"))
			  {
				 
				  logMessage_withScreenshot(teststep_description);
			  }
		}
	  
	  
	  public static void AttributeComparison_notcontains(String data, String xpath)
		{
			try
			{
		    String[] val = data.split("~");
			 WebElement elemt = driver.findElement(By.xpath(xpath));
			
			 temp_value=elemt.getAttribute(val[0]);
			
			 if(!temp_value.contains(val[1]))
			 {
				 
				  logMessage_withScreenshot(teststep_description);
				  log.info(teststep_description);
			  }
			  else
			  {
				  Failure_withScreenshot(teststep_description);
				  log.info(teststep_description+"Failed");
			  }
			
			
		   }
		   catch (Exception e)
		    {
			Error_withScreenshot(e.toString());
			log.info(e.toString());
		     }
			 if(Screenshot_required.equalsIgnoreCase("yes"))
			  {
				 
				  logMessage_withScreenshot(teststep_description);
			  }
		}
	  
	  
	  
	  public static void GetCssValue(String data, String xpath)
		{
			try
			{
		
			 WebElement elemt = driver.findElement(By.xpath(xpath));
			
			 temp_value=elemt.getCssValue(data);
			
			 log.info(teststep_description);
			
		   }
		   catch (Exception e)
		    {
			Error_withScreenshot(e.toString());
			log.info(e.toString());
		     }
			 if(Screenshot_required.equalsIgnoreCase("yes"))
			  {
				 
				  logMessage_withScreenshot(teststep_description);
			  }
		}
	  
	  public static void CssValueCompare_equal(String data, String xpath)
		{
			try
			{
		    String[] val = data.split("~");
			 WebElement elemt = driver.findElement(By.xpath(xpath));
			
			 temp_value=elemt.getCssValue(val[0]);
			
			 if(temp_value.equalsIgnoreCase(val[1]))
			 {
				 
				  logMessage_withScreenshot(teststep_description);
				  log.info(teststep_description);
			  }
			  else
			  {
				  Failure_withScreenshot(teststep_description);
				  log.info(teststep_description+"Failed");
			  }
			
			
		   }
		   catch (Exception e)
		    {
			Error_withScreenshot(e.toString());
			log.info(e.toString());
		     }
			 if(Screenshot_required.equalsIgnoreCase("yes"))
			  {
				 
				  logMessage_withScreenshot(teststep_description);
			  }
		}
	  
	  
	  public static void CssValueCompare_contains(String data, String xpath)
		{
			try
			{
		    String[] val = data.split("~");
			 WebElement elemt = driver.findElement(By.xpath(xpath));
			
			 temp_value=elemt.getCssValue(val[0]);
			
			 if(temp_value.contains(val[1]))
			 {
				 
				  logMessage_withScreenshot(teststep_description);
				  log.info(teststep_description);
			  }
			  else
			  {
				  Failure_withScreenshot(teststep_description);
				  log.info(teststep_description+"Failed");
			  }
			 if(Screenshot_required.equalsIgnoreCase("yes"))
			  {
				 
				  logMessage_withScreenshot(teststep_description);
			  }
			
		   }
		   catch (Exception e)
		    {
			Error_withScreenshot(e.toString());
			log.info(e.toString());
		     }
		}
	  
	  public static void CssValueCompare_notequal(String data, String xpath)
		{
			try
			{
		    String[] val = data.split("~");
			 WebElement elemt = driver.findElement(By.xpath(xpath));
			
			 temp_value=elemt.getCssValue(val[0]);
			
			 if(!temp_value.equalsIgnoreCase(val[1]))
			 {
				 
				  logMessage_withScreenshot(teststep_description);
				  log.info(teststep_description);
			  }
			  else
			  {
				  Failure_withScreenshot(teststep_description);
				  log.info(teststep_description+"Failed");
			  }
			
			
		   }
		   catch (Exception e)
		    {
			Error_withScreenshot(e.toString());
			log.info(e.toString());
		     }
			 if(Screenshot_required.equalsIgnoreCase("yes"))
			  {
				 
				  logMessage_withScreenshot(teststep_description);
			  }
		}
	  
	  
	  public static void CssValueCompare_notcontains(String data, String xpath)
		{
			try
			{
		    String[] val = data.split("~");
			 WebElement elemt = driver.findElement(By.xpath(xpath));
			
			 temp_value=elemt.getCssValue(val[0]);
			
			 if(!temp_value.contains(val[1]))
			 {
				 
				  logMessage_withScreenshot(teststep_description);
				  log.info(teststep_description);
			  }
			  else
			  {
				  Failure_withScreenshot(teststep_description);
				  log.info(teststep_description+"Failed");
			  }
			
			
		   }
		   catch (Exception e)
		    {
			Error_withScreenshot(e.toString());
			log.info(e.toString());
		     }
			 if(Screenshot_required.equalsIgnoreCase("yes"))
			  {
				 
				  logMessage_withScreenshot(teststep_description);
			  }
		}
	  
	  
	
	  
	  
	  
	  public static void int_compare_jsclick(String data, String xpath)
		{
		  if(!data.contains("ancestor"))
		  {
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  List<WebElement> elemt = driver.findElements(By.xpath(xpath));
		  for(WebElement ele : elemt)
		  {
			  
		        //use executeScript() method and pass the arguments
		        //Here i pass values based on css style. Yellow background color with solid red color border.
				js.executeScript("arguments[0].scrollIntoView();", ele);
				Actions actn = new Actions(driver);
				actn.moveToElement(ele);
			  String Ele_text = ele.getText();
			  Ele_text = Ele_text.replace(",", "");
			  System.out.println("element Text"+Ele_text);
			  int val = Integer.parseInt(Ele_text);
			  int data_int = Integer.parseInt(data);
			  if(val<data_int)
			  {
				  JavascriptExecutor executor = (JavascriptExecutor)driver;
					executor.executeScript("arguments[0].click();", ele);
					break;
			  }
		  }
		  }
		  else
		  {
			  String[] xpthstr = data.split("ancestor");
			  JavascriptExecutor js = (JavascriptExecutor) driver;
			  List<WebElement> elemt = driver.findElements(By.xpath(xpthstr[0]));
			  for(WebElement ele : elemt)
			  {
				  
			        //use executeScript() method and pass the arguments
			        //Here i pass values based on css style. Yellow background color with solid red color border.
					js.executeScript("arguments[0].scrollIntoView();", ele);
					Actions actn = new Actions(driver);
					actn.moveToElement(ele);
				  String Ele_text = ele.getText();
				  Ele_text = Ele_text.replace(",", "");
				  System.out.println("element Text"+Ele_text);
				  int val = Integer.parseInt(Ele_text);
				  int data_int = Integer.parseInt(data);
				  if(val<data_int)
				  {
					  WebElement elem = ele.findElement(By.xpath(xpthstr[1]));
					  js.executeScript("arguments[0].scrollIntoView();", elem);
					  JavascriptExecutor executor = (JavascriptExecutor)driver;
						executor.executeScript("arguments[0].click();", elem);
						break;
				  }
			  }
		  }
		  if(Screenshot_required.equalsIgnoreCase("yes"))
		  {
			 
			  logMessage_withScreenshot(teststep_description);
		  }
		 
		}
	  
	  
	  public static void SelectAll_Delete(String data, String xpath) throws InterruptedException
		{
		  try
		  {		  
			  
			  WebElement elemt = driver.findElement(By.xpath(xpath));  
		Actions action = new Actions(driver); 
		Thread.sleep(4000);
		elemt.click();
		action.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		action.sendKeys(Keys.chord(Keys.DELETE));
		elemt.click();
		  }
		  catch (Exception e)
		    {
			Error_withScreenshot(e.toString());
			log.info(e.toString());
		     }
			 if(Screenshot_required.equalsIgnoreCase("yes"))
			  {
				 
				  logMessage_withScreenshot(teststep_description);
			  }
		  
		} 
	  
	  
	
	public static void Sendkeys_onebyone(String value, String xpath)
	{
		try
		{
	       WebElement elemt = driver.findElement(By.xpath(xpath));
			 elemt.click();
		Actions actn = new Actions(driver);
		System.out.println(value);
		int length = value.length();
		
		for (int a =0; a<length;a++)
		{
			char val = value.charAt(a);
			String val_str = Character.toString(val);
			actn.sendKeys(val_str).perform();
			Thread.sleep(1000);
		}
		
		 log.info(teststep_description);
		
	   }
	   catch (Exception e)
	    {
		Error_withScreenshot(e.toString());
		log.info(e.toString());
	     }
		if(Screenshot_required.equalsIgnoreCase("yes"))
		  {
			 
			  logMessage_withScreenshot(teststep_description);
		  }
		
	}
	
	
	public static void SelectByIndex(String value, String xpath)
	{
		try
		{
			WebElement element = driver.findElement(By.xpath(xpath));
		Actions action = new Actions(driver);
		
		Select Select_element = new Select(element);
		int val = Integer.parseInt(value);	
		action.moveToElement(element).perform();
		Select_element.selectByIndex(val);
		 log.info(teststep_description);
	    }
	   catch (Exception e)
	    {
		Error_withScreenshot(e.toString());
		log.info(e.toString());
	     }
		if(Screenshot_required.equalsIgnoreCase("yes"))
		  {
			 
			  logMessage_withScreenshot(teststep_description);
		  }
		
	}
	
	public static void SelectByValue(String value, String xpath)
	{
		try
		{
			WebElement element = driver.findElement(By.xpath(xpath));
		Actions action = new Actions(driver);
		
		Select Select_element = new Select(element);
		
		action.moveToElement(element).perform();
		Select_element.selectByValue(value);
		 log.info(teststep_description);
	    }
	   catch (Exception e)
	    {
		Error_withScreenshot(e.toString());
		log.info(e.toString());
	     }
		if(Screenshot_required.equalsIgnoreCase("yes"))
		  {
			 
			  logMessage_withScreenshot(teststep_description);
		  }
		
	} 
	
	public static void SelectByText(String value, String xpath)
	{
		try
		{
			WebElement element = driver.findElement(By.xpath(xpath));
		Actions action = new Actions(driver);
		
		Select Select_element = new Select(element);
		
		action.moveToElement(element).perform();
		Select_element.selectByVisibleText(value);
		 log.info(teststep_description);
	    }
	   catch (Exception e)
	    {
		Error_withScreenshot(e.toString());
		log.info(e.toString());
	     }
		if(Screenshot_required.equalsIgnoreCase("yes"))
		  {
			 
			  logMessage_withScreenshot(teststep_description);
		  }
		
	} 
	
	public static void ScrollToWebElement(String value, String xpath)
	{
		
		try
		{
		WebElement element = driver.findElement(By.xpath(xpath));
		JavascriptExecutor js = (JavascriptExecutor) driver;
        //use executeScript() method and pass the arguments
        //Here i pass values based on css style. Yellow background color with solid red color border.
		js.executeScript("arguments[0].scrollIntoView();", element);
		}
		catch (Exception e)
		    {
			Error_withScreenshot(e.toString());
			log.info(e.toString());
		     }
			if(Screenshot_required.equalsIgnoreCase("yes"))
			  {
				 
				  logMessage_withScreenshot(teststep_description);
			  }
		
	}
	
	
	

	public static void elementclick_withclear(String value, String xpath) throws InterruptedException
	{
		try
		{
			WebElement element = driver.findElement(By.xpath(xpath));
		
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();	
		element.clear();
		element.click();
		element.clear();
		log.info(teststep_description);
		}
		catch (Exception e)
		{
			Error_withScreenshot(e.toString());
			log.info(e.toString());
		}
		
		if(Screenshot_required.equalsIgnoreCase("yes"))
		  {
			 
			  logMessage_withScreenshot(teststep_description);
		  }
	}
	
	
	public static void VerifyText(String Expected_value, String Actual_value )
	{
		if(Expected_value.equalsIgnoreCase(Actual_value)|| Expected_value.contains(Actual_value)||Actual_value.contains(Expected_value)) 
		{
			System.out.println("Expected value displayed in Webelement");
			logMessage_withScreenshot("Expected Value Verification: Success"+"Ex.value: "+Expected_value+ "Act.value :"+Actual_value);
			 log.info(teststep_description);		
		}
		else
		{
			Error_withScreenshot("Expected Value Verification: Failed"+"Ex.value: "+Expected_value+ "Act.value :"+Actual_value);
			 log.info(teststep_description+"Failed");
		}
		
	}
	
	
	
	
	
	public static void elementclick(WebElement element, String text) throws InterruptedException
	{
		try
		{
		Wait_elementclickable(element);
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		
		webelement_hightlight(element);
		logMessage_withScreenshot(text);
		
		element.click();
		log.info(text);
		}
		catch (Exception e)
		{
			Error_withScreenshot(e.toString());
			log.info(e.toString());
		}
	}
	
	public static void elementclick_centerposition(WebElement element, String text) throws InterruptedException
	{
		try
		{
		int wid =	element.getSize().width/2;
		int hig	= element.getSize().height/2;
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		
		//webelement_hightlight(element);
		new Actions(driver).moveToElement(element, wid, hig).click().build().perform();
		logMessage_withScreenshot(text);
		
		log.info(text);
		}
		catch (Exception e)
		{
			Error_withScreenshot(e.toString());
			log.info(e.toString());
		}
	}
	
	public static void elementclick_cssselector(String css, String text) throws InterruptedException
	{
		try
		{
		WebElement element = driver.findElement(By.cssSelector(css));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		//webelement_hightlight(element);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		
		log.info(text);
		}
		catch (Exception e)
		{
			Error_withScreenshot(e.toString());
			log.info(e.toString());
		}
	}
	
	
	
	
	
	public static void elementclick_JS(WebElement element, String text) throws InterruptedException
	{
		
		try
		{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		log.info(teststep_description);
        logMessage_withScreenshot(teststep_description);
		}
		catch(Exception e)
		{
			Error_withScreenshot(e.toString());
			log.info(e.toString());
		}
		
		
	}
	

	public static void elementclick_action(WebElement element, String text) throws InterruptedException
	{
		
		try
		{
		 Actions a = new Actions(driver);
	      a.moveToElement(element).
	      click().build().perform();
	      logMessage_withScreenshot(teststep_description);
		log.info(teststep_description);
		}
		catch(Exception e)
		{
			Error_withScreenshot(e.toString());
			log.info(e.toString());
		}
	}
	
	public static void elementclick_basedoncoordinate(WebElement element, String text) throws InterruptedException
	{
		
		Point location = element.getLocation();
		int xcord = location.getX();
		int ycord = location.getY();
		Rectangle rect = element.getRect();

		int px = rect.getX();

		int py = rect.getY();

		int h = rect.getHeight();

		int w = rect.getWidth();
		
	   System.out.println( xcord+ycord);
		 Actions actions = new Actions(driver);
		 webelement_hightlight(element);
		 actions.moveToElement(element,0,0).click().build().perform();
		 actions.moveToElement(element, px, py).click().build().perform();
			//actions.moveByOffset(xcord, ycord).click().perform();
	      logMessage_withScreenshot(text);
		log.info(text);
	}
	
	
	public static void Scroll_to_Bottom()
	{
		try
		{
		JavascriptExecutor js = (JavascriptExecutor) driver;
	     js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	     logMessage_withScreenshot(teststep_description);
			log.info(teststep_description);
		}
		catch(Exception e)
		{
			Error_withScreenshot(e.toString());
			log.info(e.toString());
		}
		
	}

	public static String get_attribute_value(WebElement ele, String attribute)
	{
		String value = ele.getAttribute(attribute);
		System.out.println("Element attribute : "+attribute+ "-"+ value);
		return value;
	}
	
	public static WebElement find_element_from_index(String xpath, int index)
	{
		List<WebElement> element_list = driver.findElements(By.xpath(xpath));
		
		WebElement finalelement = element_list.get(index);
		return finalelement;
		
	}

	
	public static String db_connection() throws ClassNotFoundException, SQLException
	{
		String dbstr = null;
		try
		
		{
		String url="jdbc:jtds:sqlserver://DESKTOP-FG7QG1S//MSSQLSERVER01;"+ "databaseName=demo_database;";
		
		//Database Username		
		String username = "Venkateshwaran";	
        
		//Database Password		
		String password = "123456";
		String query ="select *  from demo_table;"; 
		
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		 Connection con = DriverManager.getConnection(url,username,password);
		 Statement stmt = con.createStatement();					
	       
			// Execute the SQL Query. Store results in ResultSet		
  		ResultSet rs= stmt.executeQuery(query);							
  
  		// While Loop to iterate through all data and print results		
  		
			while (rs.next())
			{
				
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			log.info(e.toString());
		}
		return dbstr;
		
	}
	
	
	
	public int find_array_index( int[] int_array, int sum) throws SQLException 
	{
	
		 int sum_array = 0;
		 int find_endindex=0;
		 
		for(int a= 0; a<int_array.length;  a++)
		{
			 sum_array +=int_array[a];
			 
			 if(sum_array==sum)
			 {
				 find_endindex = a+1;
				 break;
			 }
			 
			 else
			 {
				 continue;
			 }
			
		}
		
		return find_endindex;
		
	}
	
	public static void webelement_hightlight(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
        //use executeScript() method and pass the arguments
        //Here i pass values based on css style. Yellow background color with solid red color border.
       js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	}
	
	public static void Wait_elementclickable(WebElement element) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	
	
	public static void webelement_Scrollview(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
        //use executeScript() method and pass the arguments
        //Here i pass values based on css style. Yellow background color with solid red color border.
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public static void webelement_setnull(WebElement element) throws InterruptedException
	{
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		element.click();
        //use executeScript() method and pass the arguments
        //Here i pass values based on css style. Yellow background color with solid red color border.
		js.executeScript("arguments[0].value ='';", element);
		Thread.sleep(4000);
		log.info("Text field set null");
	}
	
	public static void webelement_settext(WebElement element, String value) throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		element.click();
        //use executeScript() method and pass the arguments
        //Here i pass values based on css style. Yellow background color with solid red color border.
		js.executeScript("arguments[0].setAttribute('value', '" + value +"')", element);
		
		Thread.sleep(4000);
		log.info("Text field set value"+value);
	}
	
	
	
	
	
	
}
