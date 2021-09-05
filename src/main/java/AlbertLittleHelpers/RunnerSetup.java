package AlbertLittleHelpers;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Abstract Test class that creates a new WebDriver for Each Test.
 */
public class RunnerSetup {
    private static WebDriver driver;

    @Before
    public void setup() {
        System.out.println("Preparing Driver");

        //find the chromedriver and set its location in a system property
        ClassLoader classLoader = getClass().getClassLoader();
        String path = "/Users/testimonynl/Downloads/chromedriver";
        System.out.println("Path:" + path);
        System.setProperty("webdriver.chrome.driver", path);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        System.out.println("Driver Started");
    }

    @After
    public void teardown() {
        driver.quit();
    }

    protected static WebDriver getDriver() {
        return driver;
    }
}

