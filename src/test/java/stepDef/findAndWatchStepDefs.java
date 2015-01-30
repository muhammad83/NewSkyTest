package stepDef;

import com.google.common.collect.Lists;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.FindAndSearchPage;
import pageObjects.HomePage;
import pageObjects.ShowPage;
import sharedDriver.SharedDriver;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by muq on 16/01/15.
 */
public class findAndWatchStepDefs {
    private static final String HIGHLIGHTS = "Highlights";
    private HomePage homePage;
    private FindAndSearchPage findAndSearchPage;
    private ShowPage showPage;

    public findAndWatchStepDefs(SharedDriver driver) {
        homePage = new HomePage(driver);
        findAndSearchPage = new FindAndSearchPage(driver);
        showPage = new ShowPage(driver);
    }

    @Given("^I am on the search and find page$")
    public void I_am_on_the_search_and_find_page() throws Throwable {
        homePage.SelectTvOption();
    }

    @When("^I search for \"([^\"]*)\"$")
    public void I_search_for(String showName) throws Throwable {
        homePage.SearchShowing(showName);
    }

    @Given("^I am on the sky home page$")
    public void I_am_on_the_sky_home_page() throws Throwable {
        assertTrue(homePage.getTitle().contains("Sky.com"));
    }

    @And("^I have selected the find and search bar$")
    public void I_have_selected_the_find_and_search_bar() throws Throwable {
        homePage.SelectTvOption();
        assertTrue(homePage.getFindAndSearchBarDefaultText().equals("Search Find & Watch TV"));
    }

    @Then("^I should see \"([^\"]*)\" series$")
    public void I_should_see_series(String showName) throws Throwable {
        verifyOnFindAndSearchResultsPage(showName);
    }

    @Given("^I have searched for \"([^\"]*)\" series$")
    public void I_have_searched_for_series(String showName) throws Throwable {
        homePage.SelectTvOption();
        homePage.SearchShowing(showName);
    }

    @And("^I am on the Find and Search page results of \"([^\"]*)\"$")
    public void I_am_on_the_Find_and_Search_page_results(String showName) throws Throwable {
        verifyOnFindAndSearchResultsPage(showName);
    }

    @When("^I click on \"([^\"]*)\"$")
    public void I_click_on(String linkText) throws Throwable {
        findAndSearchPage.clickOnLink(linkText);
    }

    @Then("^I should see (Highlights|Episodes) of Arrow$")
    public void I_should_see_of_Arrow(String tabName) throws Throwable {
        if (tabName.equalsIgnoreCase(HIGHLIGHTS)) {
            assertTrue(showPage.verifyHighlightTabSelected());
        } else {
            assertTrue(showPage.verifyEpisodesTabSelected());
        }
    }

    @Given("^I am on the episodes page of Arrow$")
    public void I_am_on_the_episodes_page_of_Arrow() throws Throwable {
        homePage.SelectTvOption();
        homePage.SearchShowing("Arrow");
        findAndSearchPage.clickOnLink("Episodes");
    }

    @When("^I click on season \"([^\"]*)\"$")
    public void I_click_on_season(String seasonNo) throws Throwable {
        showPage.clickOnLink(seasonNo);
    }

    @Then("^I should see (\\d+) episodes of season (\\d+)$")
    public void I_should_see_episodes_of_season(int totalEpisodes, int seasonNo) throws Throwable {
        assertEquals(showPage.verifySeasonEpisodesAvailableFor(seasonNo), totalEpisodes);
    }

    @Then("^I should see the following episodes$")
    public void I_should_see_the_following_episodes(List<String> episodes) throws Throwable {

        assertTrue(episodes.containsAll(showPage.getSeasonEpisodes()));

    }

    private void verifyOnFindAndSearchResultsPage(String showName) {
        assertTrue(findAndSearchPage.verifyFindAndSearchResultPage());
        assertTrue(findAndSearchPage.verifyShowResultsReturned(showName));
    }
}
