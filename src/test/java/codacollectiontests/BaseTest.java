package codacollectiontests;

import codacollectionpages.AmazonPage;
import codacollectionpages.FilmsPage;
import codacollectionpages.HomePage;
import codacollectionpages.JobsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTest {

    private WebDriver driver;
    public static final String CODACOLLECTION_URL = "https://codacollection.co/";

    @BeforeTest
    public void profileSetUp() {
        chromedriver().setup();
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(CODACOLLECTION_URL);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public FilmsPage getFilmsPage() {
        return new FilmsPage(getDriver());
    }

    public JobsPage getJobsPage() {
        return new JobsPage(getDriver());
    }

    public AmazonPage getAmazonPage() {
        return new AmazonPage(getDriver());
    }

}
