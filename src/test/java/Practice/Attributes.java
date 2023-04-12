package Practice;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager; 

public class Attributes {  

	public static void main(String[] args) throws Exception {
            
		//Webdriver launch
		WebDriverManager.chromedriver().setup(); 
		WebDriver driver =new ChromeDriver(); 
		
		Capabilities capabilities= ((RemoteWebDriver) driver).getCapabilities(); 
		
		
		ExtentReports extent=new ExtentReports();
		
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter("C:\\Testing\\Automation\\ExtentReportsMaven\\reports\\Attributes.html");
		extent.attachReporter(sparkReporter);
		
		 
		//Extent report configuration using Java
//		sparkReporter.config().setTheme(Theme.DARK);
//		sparkReporter.config().setReportName("Saichand Aluvala"); 
//		sparkReporter.config().setTimeStampFormat("dd-MM-YYYY hh:mm:ss");
//		sparkReporter.config().setDocumentTitle("Extent Reports for Login details of the application");
//		sparkReporter.config().setCss(".badge-success {background-color:#d82466}");
//		sparkReporter.config().setJs("document.getElementsByClassName('logo')[0].style.display='none';\r\n"
//				+ ""); 
//		
		
		//Extent report configuration using JSON
		
	//	File jsonfile=new File("C:\\Testing\\Automation\\ExtentReportsMaven\\src\\ExtentReportsJSON.json"); 
	//	sparkReporter.loadJSONConfig(jsonfile); 
		
		
     //System/Envirnoment details in extent reports		
		extent.setSystemInfo("OS Name ", System.getProperty("os.name"));
		extent.setSystemInfo("OS Version ", System.getProperty("os.version"));
		extent.setSystemInfo("Java Version ", System.getProperty("java.version"));
		extent.setSystemInfo("Browser and Version", capabilities.getBrowserName() + ""+ capabilities.getBrowserVersion());

		
		extent.setSystemInfo("URL", "https://www.google.com");
		extent.setSystemInfo("User name", "saichand@gmail.com");
		extent.setSystemInfo("Password", "Sai@12345");



		//Extent report configuration using XML
		File xmlfile=new File("C:\\Testing\\Automation\\ExtentReportsMaven\\src\\ExtentReportsXML.xml");
		sparkReporter.loadXMLConfig(xmlfile); 
		
		
		//Add testcases here
		extent.createTest("Test Attribute 1", "This is Test Attribute for extent reports")
		.info("This is Test Attribute")
		.assignAuthor("Saichand")
		.assignCategory("Smoke") 
		.assignDevice("Chrome99");
		
		
		 
		extent.createTest("Test Attribute 2", "This is Test Attribute for extent reports")
		.fail("This is Test Attribute2")
		.assignAuthor("Saichand2")
		.assignCategory("Smoke")
		.assignDevice("Chrome992");
		
		
		extent.createTest("Test Attribute 3", "This is Test Attribute for extent reports")
		.fail("This is Test Attribute3")
		.assignAuthor("Saichand")
		.assignAuthor("Saichand2")

		.assignCategory("Smoke")
		.assignCategory("Regression")
		.assignCategory("Sanity") 

		.assignDevice("Chrome993")
		.assignDevice("Chrome994")
		.assignDevice("Chrome995");
		
		
		
		extent.createTest("Test Attribute 4", "This is Test Attribute for extent reports")
		.pass("This is Test Attribute4")
		.assignAuthor("Saichand2", "John" , "Rebecca")
		.assignCategory("Smoke", "Regression", "Sanity")
		.assignDevice("Chrome992", "Firefor107");

		
		
		
		extent.flush();
		Desktop.getDesktop().browse(new File("C:\\Testing\\Automation\\ExtentReportsMaven\\reports\\Attributes.html").toURI()); 
		
		
		driver.quit(); 
	}

}
