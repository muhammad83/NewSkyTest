package stepDef;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import sharedDriver.SharedDriver;

/**
 * Created by muq on 16/01/15.
 */
public class findAndWatchStepDefs {
    private SharedDriver driver;
    private HomePage homePage;

    public findAndWatchStepDefs(SharedDriver driver) {
        homePage = new HomePage(driver);
    }

    @Given("^I am on the search and find page$")
    public void I_am_on_the_search_and_find_page() throws Throwable {
        homePage.SelectTvOption();
    }

    @When("^I search for \"([^\"]*)\"$")
    public void I_search_for(String showName) throws Throwable {
        homePage.SearchShowing(showName);
    }
}
