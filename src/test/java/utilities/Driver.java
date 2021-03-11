package utilities;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {   
	
	private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>(); // driver pool
	
	private Driver() {}
	
	
	
	public static WebDriver getDriver(String browser) {
		
		if(drivers.get() == null) {
			
			if(browser == null) {
				browser = ConfigReader.getProperty("browser").toLowerCase();
			}
			
			
			
			switch (browser) {

//			case "remote":
//
//
//				ChromeOptions chromeOptions = new ChromeOptions();
//				chromeOptions.setHeadless(true);
////				FirefoxOptions firefoxOptions = new FirefoxOptions();
////				EdgeOptions edgeOptions = new EdgeOptions();
////				OperaOptions operaOptions = new OperaOptions();
//
////				DesiredCapabilities capabilities = new DesiredCapabilities();
////				capabilities.setBrowserName("chrome");
//
//
//
//
//				try {
//					drivers.set(new RemoteWebDriver(new URL(ConfigReader.getProperty("remoteGridURL")), chromeOptions));
//				} catch (MalformedURLException e) {
//					e.printStackTrace();
////				}
//
//				break;


			case "chrome":
				WebDriverManager.chromedriver().setup();
				drivers.set(new ChromeDriver());
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				drivers.set(new EdgeDriver());
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				drivers.set(new FirefoxDriver());
				break;
			case "opera":
				WebDriverManager.operadriver().setup();
				drivers.set(new OperaDriver());
				break;
			case "ie":
				WebDriverManager.iedriver().setup();
				drivers.set(new InternetExplorerDriver());
				break;
			case "headlesschrome":
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("--disable-gpu"); // option that must be added only for Windows systems
				drivers.set(new ChromeDriver(options));
				break;	
			case "headlessfirefox":
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions foptions = new FirefoxOptions();
	            foptions.addArguments("--headless");
	            drivers.set(new FirefoxDriver(foptions));
				break;	
			case "phantomjs":
				WebDriverManager.phantomjs().setup();
				drivers.set(new PhantomJSDriver());
				break;		
			case "htmlunit":
				drivers.set(new HtmlUnitDriver(true)); //true --> enables JavaScript
				break;		
				
			default:
				System.out.println("Wrong driver");
				break;
			}
			
			
			
			
		}
		
		
		
		return drivers.get();
		
	}
	
	
	
	public static WebDriver getDriver()  {
		return getDriver(null);
	}
	
	
	
	public static  void quit() {

		
		if(drivers.get() != null) {
			drivers.get().quit();
			drivers.remove();
		}
		
		
	}


	

}
