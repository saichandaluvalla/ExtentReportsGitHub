package Practice;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.observer.entity.MediaEntity;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshots {
	
   static WebDriver driver;  

	public static void main(String [] args) throws Exception {
	 ExtentReports extent = new ExtentReports();
     ExtentSparkReporter sparkReporter = new ExtentSparkReporter("C:\\Testing\\Automation\\ExtentReportsMaven\\reports\\Screenshotreports.html");
    
     //To attach the report   
     extent.attachReporter(sparkReporter);   
     
     
     //add testcases here 
     WebDriverManager.chromedriver().setup(); 
     driver = new ChromeDriver();  
     
     driver.get("https://www.google.com/"); 
     
     String path= capturescreenshot("Google.png"); 
     
     //Screenshot in Test Level
     extent.createTest("Google Test", "This is test based Google Test in test level")
     .info("This is Test Google Test") 
     .addScreenCaptureFromPath(path, "Google Homepage1")
     .addScreenCaptureFromPath(path, "Google Homepage2")
     .addScreenCaptureFromPath(path, "Google Homepage3")
     .addScreenCaptureFromPath(path, "Google Homepage4")
     .addScreenCaptureFromPath(path, "Google Homepage5");

     
     //Screenshot in Log level
     extent.createTest("Google Test in log test", "This is test bases Google in Log level")
     .info("This is Log Google Test")
     .fail(MediaEntityBuilder.createScreenCaptureFromPath(path, "Google Homepage in log level1").build())
     .fail(MediaEntityBuilder.createScreenCaptureFromPath(path, "Google Homepage in log level2").build()) 
     .fail(MediaEntityBuilder.createScreenCaptureFromPath(path, "Google Homepage in log level3").build()) 
     .fail(MediaEntityBuilder.createScreenCaptureFromPath(path, "Google Homepage in log level4").build()) 
     .fail(MediaEntityBuilder.createScreenCaptureFromPath(path, "Google Homepage in log level5").build()); 

     
        
     extent.flush();  
     //To open the automate reports
     Desktop.getDesktop().browse(new File("C:\\Testing\\Automation\\ExtentReportsMaven\\reports\\Screenshotreports.html").toURI()) ;
     driver.quit(); 
     
	}
     
 	public static String capturescreenshot(String filename) {
     
 	    //Screenshot of the failed test cases
 			File f= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
 			
 			try {
 				FileHandler.copy(f, new File ("./screenshots"  + filename));
 			} catch (IOException e) { 
 				e.printStackTrace(); 
 			}
 	     	System.out.println("Screenshot  saved successfully");
			return filename; 
 		}


 }
 