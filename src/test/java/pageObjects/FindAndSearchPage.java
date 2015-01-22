package pageObjects;

import org.openqa.selenium.support.ui.WebDriverWait;
import sharedDriver.SharedDriver;

import static org.openqa.selenium.By.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by muhammadqureshi on 21/01/15.
 */
public class FindAndSearchPage {
    private SharedDriver driver;

    private String results = "content";

    public FindAndSearchPage(final SharedDriver driver) {
        this.driver = driver;
    }

    private void pageLoaded(String element){
        (new WebDriverWait(driver,20)).until(visibilityOfElementLocated(id(element)));
    }

    public boolean verifyShowResultsReturned(String searchString){
        pageLoaded(results);
        return driver.findElement(id(results)).getText().contains(searchString);
    }

    public void clickOnLink(String linkText) {
        driver.findElement(linkText(linkText)).click();
    }

    public boolean verifyFindAndSearchResultPage() {
        return driver.findElement(xpath("//div[@id='page']/div[3]/div/div[1]/a")).getAttribute("text").equals("Find & Watch Results");
    }
}
