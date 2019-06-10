package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import html.pages.AMZNPage;
import org.junit.Assert;

import java.io.File;
import java.text.ParseException;
import java.util.*;

public class HistoryStepDefs {

    AMZNPage amznPage = new AMZNPage();

    @Given("^User opens Amazon NasdaqGS page$")
    public void userOpensAmazonNasdaqGSPage() {
        amznPage.open();
    }

    @And("^User opens tab 'Historical Data'$")
    public void userOpensTabHistoricalData() {
        amznPage.openTabHistoricalData();
    }

    @And("^User clicks link 'Download Data'$")
    public void userClicksDownloadDataLink() {
        amznPage.clickdownloadDataLink();
    }

    @Then("^User checks that history table default sorting is descending$")
    public void userChecksDefaultSortingIsDescending() throws ParseException {
        List<Date> actualOrder = amznPage.getTabHistoricalData().getColumnDates();
        List<Date> expectedOrder = new ArrayList<>(actualOrder);
        Collections.sort(expectedOrder);
        Collections.reverse(expectedOrder);
        Assert.assertEquals("Some rows in the column 'Date' are out of the sorting order", actualOrder, expectedOrder);
    }

    @Then("^User checks that file \"([^\"]*)\" was downloaded$")
    public void userChecksFileDownloaded(String expectedFileName) throws InterruptedException {
        Thread.sleep(2000);
        File[] listOfFiles = new File(System.getProperty("user.dir")).listFiles();
        boolean found = false;
        File f = null;
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                if (fileName.matches(expectedFileName)) {
                    f = new File(fileName);
                    found = true;
                    break;
                }
            }
        }
        Assert.assertTrue("Downloaded document is not found", found);
        f.deleteOnExit();
    }
}
