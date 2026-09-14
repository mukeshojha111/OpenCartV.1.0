package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaseTest.BaseClass;
import BaseTest.BaseClassGrid;
import BaseTest.BaseClassXML;

public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;

	String reportName;

	public void onStart(ITestContext testContext) {
		
		/* simple date format df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		    Date dt = new Date();
		   String currentdatetimestamp = df.format(dt);
		 */
		
		String timeStamp = new SimpleDateFormat("dd-MM-yyyy.HH.mm.ss").format(new Date()); //time stamp
		
		reportName = "OpenCart-Test-Report-" + timeStamp + ".html";
		sparkReporter = new ExtentSparkReporter(".\\reports\\" + reportName); //location of the report
		sparkReporter.config().setDocumentTitle("OpenCart Automation Report"); //Title of report
		sparkReporter.config().setReportName("OpenCart Automation Report"); //name of report
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "OpenCart");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub-Module", "Customers");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Enviroment", "QA");
		
		String os = testContext.getCurrentXmlTest().getParameter("Operating System");
		extent.setSystemInfo("Operating System", os);
		
		String browser = testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		
		List<String> includeGroups = testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includeGroups.isEmpty())
		{
			extent.setSystemInfo("Groups", includeGroups.toString());
		}
	}
    
	public void onTestSuccess(ITestResult result)
	{
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());  //to display groups in report
		test.log(Status.PASS, result.getName()+" got successfully executed");
	}
	
	public void onTestFailure(ITestResult result)
	{
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());  
		
		test.log(Status.FAIL, result.getName()+" got failed");
		test.log(Status.INFO, result.getThrowable());
		//test.log(Status.INFO, result.getThrowable().getMessage());
		try {
			String imgPath = new BaseClassXML().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());  
		
		test.log(Status.SKIP, result.getName()+" got skipped");
	//	test.log(Status.INFO, result.getThrowable().getMessage());
		test.log(Status.INFO, result.getThrowable());
	}
	
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
		String pathOfExtentReport = System.getProperty("user.dir")+ ".\\reports\\" + reportName;
		File extentReport = new File(pathOfExtentReport);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*	
		  try { 
		
			  URL url = new URL("file:///"+System.getProperty("user.dir")+"\\reports\\"+reportName);
		  
		  //comment - create email message 
		  
		  
		  ImageHtmlEmail email = new ImageHtmlEmail();
		  email.setDataSourceResolver(new DataSourceUrlResolver(url));
		  email.setHostName("smtp.googlemail.com"); 
		  email.setSmtpPort(465);
		  email.setAuthenticator(new DefaultAuthenticator("learningnewskills001@gmail.com", "google@12345"));
		  email.setSSLOnConnect(true); 
		  email.setFrom("learningnewskills001@gmail.com");
		  email.setSubject("Test Result");
		  email.setMsg("Please find the attached report");
		  email.addTo("learningnewskills001+to@gmail.com");
		  email.addCc("learningnewskills001+cc@gmail.com");
		  email.addBcc("learningnewskills001+bcc@gmail.com");
		  email.attach(url,"Extent report", "please check report"); email.send();
		 
		  } catch (Exception e) { e.printStackTrace(); 
		 */	 
		  }
	
	}