package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {


	public static WebDriver driver; // onTestFail we using String imgpath=new BaseClass().captureScreen(result.getName());  so conflic occured hence making WebDriver as static , so one instant for all execution
	public Properties p;
	public Logger logger;



	
	@Parameters({"os","browser"})
	@BeforeClass
	public void setup(String os,String browser) throws IOException, URISyntaxException {


		//Loading config.propeties file

		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);


		logger=LogManager.getLogger(this.getClass());

		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			
			
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			
			if(os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN10);
				
			}
			
			if(os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			}
			else {
				System.out.print("Invalid Operating System");
				return;
			}
			
			
			
			switch(browser.toLowerCase()) {

			case "chrome" :
				capabilities.setBrowserName("chrome");	;break;

			case "edge" :
				capabilities.setBrowserName("edge");;break;

			case "firefox" :
				capabilities.setBrowserName("firefox");;break;
			default :
				return;

			}
			
		//	URL url=new URI("http://192.168.0.104:4444/wd/hub").toURL();
			driver=new RemoteWebDriver(new URI("http://192.168.0.104:4444/wd/hub").toURL(),capabilities);
			
		}




		if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
			switch(browser.toLowerCase()) {

			case "chrome" :
				driver=new ChromeDriver();break;

			case "edge" :
				driver =new EdgeDriver();break;

			case "firefox" :
				driver = new FirefoxDriver();break;
			default :
				return;

			}
				

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(p.getProperty("appURL1"));

		driver.manage().window().maximize();
}

	}



	@AfterClass
	public void tearDown() {
		driver.quit();

	}

	public String getRrandomString() {

		String generatedString=	RandomStringUtils.randomAlphabetic(5);

		return generatedString;

	}

	public String getRrandomNumber() {


		return RandomStringUtils.randomNumeric(5);

	}



	


	public String captureScreen(String tname) throws IOException {

	
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname +".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
