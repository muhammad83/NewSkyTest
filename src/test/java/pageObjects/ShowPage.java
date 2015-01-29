package pageObjects;

import org.openqa.selenium.support.ui.WebDriverWait;
import sharedDriver.SharedDriver;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by muhammadqureshi on 21/01/15.
 */
public class ShowPage {
    private SharedDriver driver;
    private String linkBar = "main-nav";

    public ShowPage(final SharedDriver driver) {
        this.driver = driver;
    }

    private void waitforPageToLoad(){
        (new WebDriverWait(driver,10)).until(visibilityOfElementLocated(id(linkBar)));
    }

    public void verifyHighlightTabSelected() {
        waitforPageToLoad();
        driver.findElement(id("tab-highlights")).getAttribute("class").equals("tab selected highlights");
    }

    public void verifyEpisodesTabSelected() {
        waitforPageToLoad();
        driver.findElement(id("tab-episodes")).getAttribute("class").equals("tab selected episodes");
    }
}
