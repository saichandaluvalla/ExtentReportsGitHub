package Practice;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class GenerateRequestReports {

	public static void main(String[] args) throws Exception {


		 ExtentReports extent = new ExtentReports();
	     //   ExtentSparkReporter sparkReporter_AllTests = new ExtentSparkReporter("C:\\Testing\\Automation\\ExtentReportsMaven\\reports\\AllTest.html");
	        ExtentSparkReporter sparkReporter_FailedTests = new ExtentSparkReporter("C:\\Testing\\Automation\\ExtentReportsMaven\\reports\\FailedTests.html");
	     //   ExtentSparkReporter sparkReporter_SkipandWarningTests = new ExtentSparkReporter("C:\\Testing\\Automation\\ExtentReportsMaven\\reports\\SkipandWarningTests.html");

	        //To attach the report   
	        extent.attachReporter( sparkReporter_FailedTests); 
	        
	        //For Faild Testcases generates 
	        sparkReporter_FailedTests.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();  
	        
	        //For SkipandWarning Testcases generates
//	        sparkReporter_SkipandWarningTests.filter().statusFilter().as(new Status[] {
//	        		
//               Status.SKIP,
//               Status.WARNING }).apply(); 
	        
	        //Add testcases here 
	        ExtentTest test1 =  extent.createTest("Test 1"); 
	        test1.pass("This is Passed");  
	          
	        ExtentTest test2 =  extent.createTest("Test 2"); 
	        test2.fail("This is Failed");
	         
	        ExtentTest test3 =  extent.createTest("Test 3"); 
	        test3.skip("This is Skipped");   
	        
	        
	        //Log levels in extent reports
	        extent.createTest("Testing Log")
	        
	     //   .log(Status.PASS, "pass");
	   //     .log(Status.INFO, "info") 
	   //     .log(Status.FAIL, "fail")
	    //    .log(Status.SKIP, "skip")
	        .log(Status.WARNING, "warning"); 
	        
	        
	        //log formats
	        
	        extent.createTest("Bold Itelic test")
	        .log(Status.INFO, "info1") 
	        .log(Status.INFO, "<b>info2</b>") 
	        .log(Status.INFO, "<i>info3</i>")
	        .log(Status.INFO, "<b><i>info4</b></i>"); 
	        
	        extent.createTest("Test Attribute 1", "This is Test Attribute for extent reports")
			.fail("This is Test Attribute2")
			.assignAuthor("Saichand2")
			.assignCategory("Smoke")
			.assignDevice("Chrome992");
			
			
			extent.createTest("Test Attribute 2", "This is Test Attribute for extent reports")
			.fail("This is Test Attribute3")
			.assignAuthor("Saichand")
			.assignAuthor("Saichand2")

			.assignCategory("Smoke")
			.assignCategory("Regression")
			.assignCategory("Sanity") 

			.assignDevice("Chrome993")
			.assignDevice("Chrome994")
			.assignDevice("Chrome995");
	        

	        //Exception 
	        Throwable throwexception = new Throwable("This is customized exception");

	        extent.createTest("Customized exception")
	         .fail(throwexception); 
	         
	        try {
	     	   int i=5/0; 
	        } catch (Exception e) {
	     	   extent.createTest("This is exception")
	     	   .fail(e); 
	        }
	        
	        

	         extent.flush(); 
	         
	         //To open the automate reports
	        // Desktop.getDesktop().browse(new File("C:\\Testing\\Automation\\ExtentReportsMaven\\reports\\AllTest.html").toURI()) ;  
	         Desktop.getDesktop().browse(new File("C:\\Testing\\Automation\\ExtentReportsMaven\\reports\\FailedTests.html").toURI()) ;  
	        // Desktop.getDesktop().browse(new File("C:\\Testing\\Automation\\ExtentReportsMaven\\reports\\SkipandWarningTests.html").toURI()) ;  


	}

}
