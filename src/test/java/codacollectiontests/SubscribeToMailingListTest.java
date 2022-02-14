package codacollectiontests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SubscribeToMailingListTest extends BaseTest {

    private static final String EXPECTED_CONFIRMATION_MESSAGE = "Great. You're in.";

    @Test
    public void verifySubscription() {
        getHomePage().scrollPageToTheBottom();
        getHomePage().provideEmail();
        getHomePage().submitSubscribeButton();
        String actualConfirmMessage = getHomePage().getSubscribeConfirmation();
        Assert.assertEquals(actualConfirmMessage, EXPECTED_CONFIRMATION_MESSAGE);
    }
}
