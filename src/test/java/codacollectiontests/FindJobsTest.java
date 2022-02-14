package codacollectiontests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FindJobsTest extends BaseTest {

    private static final String EXPECTED_URL_JOBS = "https://codacollection.co/jobs";
    private static final String EXPECTED_URL_QA = "https://codacollection.co/jobs/qa-engineer-remote-4000048217";

    @Test
    public void verifyQAJob() {
        getHomePage().scrollPageToTheBottom();
        getHomePage().clickJobsLink();
        String actualUrl = getJobsPage().getJobsActualUrl();
        Assert.assertEquals(actualUrl, EXPECTED_URL_JOBS);
        getJobsPage().clickQAJob();
        String actualQaUrl = getJobsPage().getQaActualUrl();
        Assert.assertEquals(actualQaUrl, EXPECTED_URL_QA);
    }
}
