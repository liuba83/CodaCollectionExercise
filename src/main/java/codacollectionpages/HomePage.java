package codacollectionpages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    private static final String FILMS_TAB = "//a[@href='/films']//div[@class='Text__PrimaryText-sc-15dpo10-1 fLmHtB']";
    private static final String SUBSCRIBE_BUTTON = "//button[@aria-label='Submit']";
    private static final String EMAIL_FIELD = "//input[@type='email']";
    private static final String CONFIRMATION_SUBSCRIBE = "//div[@data-testid='FooterEmailSubscriptionForm-success-message']";
    private static final String JOBS_LINK = "li:nth-of-type(3) > .Text__PrimaryText-sc-15dpo10-1.carFTS";
    private static final String TEST_EMAIL = "test@gmail.com";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickFilmsTab() {
        driver.findElement(By.xpath(FILMS_TAB)).click();

    }

    public void scrollPageToTheBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void provideEmail() {
        WebElement email = driver.findElement(By.xpath(EMAIL_FIELD));
        email.click();
        email.sendKeys(TEST_EMAIL);
    }

    public void submitSubscribeButton() {
        driver.findElement(By.xpath(SUBSCRIBE_BUTTON)).submit();
    }

    public String getSubscribeConfirmation() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CONFIRMATION_SUBSCRIBE)));
        String actualMessage = driver.findElement(By.xpath(CONFIRMATION_SUBSCRIBE)).getText();
        return actualMessage;
    }

    public void clickJobsLink() {
        WebElement jobs = driver.findElement(By.cssSelector(JOBS_LINK));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", jobs);

    }
}
