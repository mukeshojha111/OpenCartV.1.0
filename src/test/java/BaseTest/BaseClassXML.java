package BaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClassXML {

	public static WebDriver driver;
	public Logger logger;
	public Properties prop;

	@BeforeClass

	@Parameters({ "browser" })
	public void setup(String brwName) throws IOException { // Loading Config.properties file
		FileInputStream readfile = new FileInputStream(
				System.getProperty("user.dir") + ".//src//test//resources//config.properties");
		prop = new Properties();

		prop.load(readfile);

		logger = LogManager.getLogger(this.getClass());
		if (brwName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (brwName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (brwName.equalsIgnoreCase("Microsoft Edge") || brwName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("Browser name not provided or Invalid browser !");
			return;
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("applicationURL"));
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public String randomString() {
		String generateString = RandomStringUtils.randomAlphabetic(5);
		return generateString;
	}

	public String randomNumber() {
		String generateNumber = RandomStringUtils.randomNumeric(10);
		return generateNumber;
	}

	public String randomPassword() {
		String generateString = RandomStringUtils.randomAlphabetic(5);
		String generateNumber = RandomStringUtils.randomNumeric(5);
		return (generateString + "@@#@#*^%$" + generateNumber);
	}

	public String captureScreen(String screenShotName) throws IOException {
         String timeStamp = new SimpleDateFormat("dd-MM-yyyy.HH.mm.ss").format(new Date()); //time stamp
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String tagetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+ screenShotName + "_" + timeStamp+ ".png";
		File tagetFile = new File(tagetFilePath);
		
		sourceFile.renameTo(tagetFile);
		
		return tagetFilePath;
	}

}
