package config;


import java.util.concurrent.TimeUnit;
import static executionEngine.DriverScript.OR;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import executionEngine.DriverScript;
import utility.Log;

public class ActionKeywords {
	
		public static WebDriver driver;
			
	public static void openBrowser(String object,String data){		
		Log.info("Opening Browser");
		try{				
			if(data.equals("Mozilla")){
				driver=new FirefoxDriver();
				driver.manage().window().maximize();
				Log.info("Mozilla browser started");				
				}
			else if(data.equals("IE")){
				//Dummy Code, Implement you own code
				driver=new InternetExplorerDriver();
				driver.manage().window().maximize();
				Log.info("IE browser started");
				}
			else if(data.equals("Chrome")){
				//Dummy Code, Implement you own code
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\Hybrid Keyword Driven\\src\\utility\\chromedriver.exe"); 
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				Log.info("Chrome browser started");
				}
			
			int implicitWaitTime=(10);
			driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
		}catch (Exception e){
			Log.info("Not able to open the Browser --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}
	
	public static void navigate(String object, String data){
		try{
			Log.info("Navigating to URL");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(Constants.URL);
		}catch(Exception e){
			Log.info("Not able to navigate --- " + e.getMessage());
			DriverScript.bResult = false;
			}
		}
	
	public static void navigatetoDynamic(String object, String data){
		try{
			Log.info("Navigating to dynamics URL");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(Constants.URL1);
		}catch(Exception e){
			Log.info("Not able to navigate --- " + e.getMessage());
			DriverScript.bResult = false;
			}
		}
	
	public static void navigatetoAPP(String object, String data){
		try{
			Log.info("Navigating to dynamics Application");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.navigate().to(data);
		}catch(Exception e){
			Log.info("Not able to navigate --- " + e.getMessage());
			DriverScript.bResult = false;
			}
		}
	public static void click(String object, String data){
		try{
			Log.info("Clicking on Webelement "+ object);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath(OR.getProperty(object))).click();
		 }catch(Exception e){
 			Log.error("Not able to click --- " + e.getMessage());
 			DriverScript.bResult = false;
         	}
		}
	public static void clickCSS(String object, String data){
		try{
			Log.info("Clicking on Webelement "+ object);
			driver.manage().timeouts().implicitlyWait(18, TimeUnit.SECONDS);
			driver.findElement(By.cssSelector(OR.getProperty(object))).click();
		 }catch(Exception e){
 			Log.error("Not able to click --- " + e.getMessage());
 			DriverScript.bResult = false;
         	}
		}
	
	public static void linkclick(String object, String data){
		try{
			Log.info("Clicking on link txt "+ object);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.partialLinkText(OR.getProperty(object))).click();
		 }catch(Exception e){
 			Log.error("Not able to click --- " + e.getMessage());
 			DriverScript.bResult = false;
         	}
		}
	public static void input(String object, String data){
		try{
			Log.info("Entering the text in " + object);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(data);
			//driver.findElement(By.cssSelector(OR.getProperty(object))).sendKeys(data);
		 }catch(Exception e){
			 Log.error("Not able to Enter UserName --- " + e.getMessage());
			 DriverScript.bResult = false;
		 	}
		}
	
	public static void inputCSS(String object, String data){
		try{
			Log.info("Entering the text in " + object);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			//driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(data);
			driver.findElement(By.cssSelector(OR.getProperty(object))).sendKeys(data);
		 }catch(Exception e){
			 Log.error("Not able to Enter UserName --- " + e.getMessage());
			 DriverScript.bResult = false;
		 	}
		}
	
	
	public static void selectPartyDropDown(String object, String data){
		try{
			Log.info("Entering the text in " + object);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			WebElement web =driver.findElement(By.xpath(OR.getProperty(object)));
			web.click();
			web.sendKeys(data);
			Thread.sleep(5000);
			driver.findElement(By.xpath(("(//ul[contains(@id,'fieldControl-LookupResultsDropdown_eo_partyid')])[1]"))).click();				
		 }catch(Exception e){
			 Log.error("Not able to Select value from Drop Down --- " + e.getMessage());
			 DriverScript.bResult = false;
		 	}
		}
	
	public static void selectPersonDropDown(String object, String data){
		try{
			Log.info("Entering the text in " + object);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			WebElement web =driver.findElement(By.xpath(OR.getProperty(object)));
			web.click();
			web.sendKeys(data);
			Thread.sleep(5000);
			driver.findElement(By.xpath(("(//ul[contains(@id,'fieldControl-LookupResultsDropdown_eo_personid')])[1]"))).click();				
		 }catch(Exception e){
			 Log.error("Not able to Select value from Drop Down --- " + e.getMessage());
			 DriverScript.bResult = false;
		 	}
		}
	
	public static void selectDropDown(String object, String data)
	{
		Log.info("Entering the text in Dropdown" + object);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Select drpCountry = new Select(driver.findElement(By.xpath(OR.getProperty(object))));
		drpCountry.selectByVisibleText(data);
	
	}
	
	
	public static void waitFor(String object, String data) throws Exception{
		try{
			Log.info("Wait for 5 seconds");
			Thread.sleep(10000);
		 }catch(Exception e){
			 Log.error("Not able to Wait --- " + e.getMessage());
			 DriverScript.bResult = false;
         	}
		}

	public static void closeBrowser(String object, String data){
		try{
			Log.info("Closing the browser");
			driver.quit();
		 }catch(Exception e){
			 Log.error("Not able to Close the Browser --- " + e.getMessage());
			 DriverScript.bResult = false;
         	}
		}

	
	public static void get_Text(String object, String data){
		try{
			//Log.info("Fetching the text associated to" + object);
			Constants.APPLICATION_ID= driver.findElement(By.xpath(OR.getProperty(object))).getText();
			Log.info("Fetching the text associated to" + Constants.APPLICATION_ID);
			//driver.quit(); 
		 }catch(Exception e){
			 Log.error("Not able to Fetching the associated text --- " + e.getMessage());
			 DriverScript.bResult = false;
         	}
		}
	}