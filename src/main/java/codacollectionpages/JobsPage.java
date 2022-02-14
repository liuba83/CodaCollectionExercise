package codacollectionpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JobsPage extends BasePage {

    private static final String QA_JOB = "//a[@href='/jobs/qa-engineer-remote-4000048217']";

    public JobsPage(WebDriver driver) {
        super(driver);
    }

    public String getJobsActualUrl() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.urlContains("jobs"));
        String jobsActualUrl = driver.getCurrentUrl();
        return jobsActualUrl;
    }

    public void clickQAJob() {
        driver.findElement(By.xpath(QA_JOB)).click();
    }

    public String getQaActualUrl() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.urlContains("qa-engineer"));
        String qaActualUrl = driver.getCurrentUrl();
        return qaActualUrl;
    }

}
