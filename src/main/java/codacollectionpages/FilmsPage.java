package codacollectionpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

public class FilmsPage extends BasePage {

    private static final String AMAZON_TRIAL = "//a[@data-testid='codaButton-amazonCta']";


    public FilmsPage(WebDriver driver) {

        super(driver);
    }

    public String getFilmsActualUrl() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.urlContains("films"));
        String filmsActualUrl = driver.getCurrentUrl();
        return filmsActualUrl;
    }

    public void clickFreeTrial() {
        driver.findElement(By.xpath(AMAZON_TRIAL)).click();
    }

    public boolean isTwoWindowsOpen() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    public void switchToNewWindow() {
        String parentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> windowsIterator = allWindows.iterator();

        while (windowsIterator.hasNext()) {
            String windowHandle = windowsIterator.next();
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
    }

    public String getCurrentPageTitle() {

        return driver.getTitle();
    }

}
