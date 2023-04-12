package Practice;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;


public class PracticeExtentReports {
	public static void main(String [] args) throws Exception {
	   
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("C:\\Testing\\Automation\\ExtentReportsMaven\\reports\\Firstreports.html");
       
        //To attach the report   
        extent.attachReporter(sparkReporter); 
        
        
        
        
        
        //To change the Order/Remove the tabs in extent reports
//        sparkReporter.viewConfigurer().viewOrder().as(new ViewName [] {
//        		ViewName.DASHBOARD, 
//        		ViewName.TEST,
//        		ViewName.EXCEPTION,  
//        		ViewName.CATEGORY  
//
//        		
//        }).apply();
//          
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
       
       
       String xmlData = "<note>\r\n"
       		+ "  <to>Tove</to>\r\n"
       		+ "  <from>Jani</from>\r\n"
       		+ "  <heading>Reminder</heading>\r\n"
       		+ "  <body>Don't forget me this weekend!</body>\r\n"
       		+ "</note>" ;
       
       
       String jsonData = "{\r\n"
       		+ "\"employee\":{\"name\":\"John\", \"age\":30, \"city\":\"New York\"}\r\n"
       		+ "}" ;
       
       extent.createTest("XML data test")
       .log(Status.INFO, MarkupHelper.createCodeBlock(xmlData, CodeLanguage.XML) ); 

       
       extent.createTest("JSON data test") 
       .log(Status.INFO, MarkupHelper.createCodeBlock(jsonData, CodeLanguage.JSON)); 

       
       //Collection Data( List, Set and Map) 
       
       ArrayList<String> listData = new ArrayList<String>();
       listData.add("Saichand");  
       listData.add("Aluvala");
       listData.add("Shirisha");
       
       HashMap<Integer, String> mapData= new HashMap<Integer, String>();
       mapData.put(101, "Prabhas");
       mapData.put(102, "Prabhas2");
       mapData.put(103, "Prabhas3");  

       
       Set<Integer> setData = mapData.keySet(); 
       
       extent.createTest("ListData Test")
       .log(Status.INFO, MarkupHelper.createOrderedList(listData))
       .log(Status.INFO, MarkupHelper.createUnorderedList(listData)); 
       
       extent.createTest("mapData Test")
       .log(Status.INFO, MarkupHelper.createOrderedList(mapData))
       .log(Status.INFO, MarkupHelper.createUnorderedList(mapData)); 
       
       extent.createTest("setData Test")  
       .log(Status.INFO, MarkupHelper.createOrderedList(setData))
       .log(Status.INFO, MarkupHelper.createUnorderedList(setData)); 
       
       //Highlighted message with yellow colour
       extent.createTest("Highlighted the message")
       .log(Status.INFO, "This is not highlighted message")
       .log(Status.INFO, MarkupHelper.createLabel("This is highlighted the message", ExtentColor.YELLOW)); 
       
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
        Desktop.getDesktop().browse(new File("C:\\Testing\\Automation\\ExtentReportsMaven\\reports\\Firstreports.html").toURI()) ;  


   }
}