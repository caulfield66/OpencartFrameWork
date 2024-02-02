package testBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;


public class BaseClass {
    static public WebDriver driver;
    public Logger logger;
    public Properties p;

    @BeforeClass
    @Parameters({"os","browser"})
    public void setup(String os, String browser) throws IOException {

        //Loading properties
        FileReader file = new FileReader("/Users/ruslan/Desktop/Selenium/FirstFramework/src/test/resources/config.properties");
        p = new Properties();
        p.load(file);

        //Loading log4j2 file
        logger = LogManager.getLogger(this.getClass());


        if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            //os
            if (os.equalsIgnoreCase("windows")) {
                capabilities.setPlatform(Platform.WIN11);
            } else if (os.equalsIgnoreCase("mac")) {
                capabilities.setPlatform(Platform.MAC);
            }

            //browser
            if (browser.equalsIgnoreCase("chrome")) {
                capabilities.setBrowserName("chrome");
            } else if (browser.equalsIgnoreCase("safari")) {
                capabilities.setBrowserName("Safari");
            }

            driver = new RemoteWebDriver(new URL("http://192.168.1.157:4444"), capabilities);
        }

        else if(p.getProperty("execution_env").equalsIgnoreCase("local")) {


            switch (browser.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
                default:
                    System.out.println("NoSuchBrowser");
                    return;
            }
        }


//        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(p.getProperty("appUrl"));
    }





    @AfterClass
    public void teardown(){
        driver.close();
    }

    public String randomString(){
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        return generatedString;
    }

    public String randomNumber(){
        String generatedString = RandomStringUtils.randomNumeric(8);
        return generatedString;
    }

    public String randomAlphaNumeric(){
        String str = RandomStringUtils.randomAlphabetic(4);
        String num = RandomStringUtils.randomNumeric(4);
        return str + "@" + num;
    }

    public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile=new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;

    }



}
