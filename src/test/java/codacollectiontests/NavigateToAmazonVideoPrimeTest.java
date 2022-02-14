package codacollectiontests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigateToAmazonVideoPrimeTest extends BaseTest {

    private static final String FILMS_EXPECTED_URL = "https://codacollection.co/films";
    private static final String EXPECTED_TITLE = "Amazon.com Sign up for Prime Video";

    @Test
    public void verifyNavigationToAmazonTrial() {
        getHomePage().clickFilmsTab();
        String actualFilmsUrl = getFilmsPage().getFilmsActualUrl();
        Assert.assertEquals(actualFilmsUrl, FILMS_EXPECTED_URL);
        getFilmsPage().clickFreeTrial();
        getFilmsPage().isTwoWindowsOpen();
        getFilmsPage().switchToNewWindow();
        String currentPageTitle = getFilmsPage().getCurrentPageTitle();
        Assert.assertEquals(currentPageTitle, EXPECTED_TITLE);

    }

}
