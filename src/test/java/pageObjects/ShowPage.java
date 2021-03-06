package pageObjects;

import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.support.ui.WebDriverWait;
import sharedDriver.SharedDriver;

import java.util.Arrays;
import java.util.List;

import static org.openqa.selenium.By.*;
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

    private void waitforPageToLoad() {
        (new WebDriverWait(driver, 10)).until(visibilityOfElementLocated(id(linkBar)));
    }

    public boolean verifyHighlightTabSelected() {
        waitforPageToLoad();
        return driver.findElement(id("tab-highlights")).getAttribute("class").equals("tab selected highlights");
    }

    public boolean verifyEpisodesTabSelected() {
        waitforPageToLoad();
        return driver.findElement(id("tab-episodes")).getAttribute("class").equals("tab selected episodes");
    }

    public void clickOnLink(String linkText) {
        driver.findElement(linkText(linkText)).click();
    }

    public int verifySeasonEpisodesAvailableFor(int seasonNo) {
//        driver.findElement(xpath("//div[@id='seasons']/div[3]/div/span")).getText().contains("Season" + seasonNo);
        return driver.findElement(xpath("//div[@id='seasons']/div[2]/div")).getText().split("\\d+").length - 1;
    }

    public List<String> getSeasonEpisodes() {
        return removeNewLineCharacter(Arrays.asList(ArrayUtils.remove(driver.findElement(xpath("//div[@id='seasons']/div[2]/div")).getText().split("\\d+"), 0)));
    }

    private List<String> removeNewLineCharacter(List<String> episodes) {
        int index = 0;
        for (String episode : episodes) {
            episodes.set(index++, episode.replace("\n", ""));
        }
        return episodes;
    }
}
