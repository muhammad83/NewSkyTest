package pageObjects;

import org.openqa.selenium.By;
import sharedDriver.SharedDriver;

/**
 * Created by muq on 16/01/15.
 */
public class HomePage {
    private SharedDriver driver;

    public HomePage(final SharedDriver driver) {
        this.driver = driver;
        driver.navigate().to("http://www.sky.com/");
    }

    public void BrowseToFindAndWatch() {
        driver.findElement(By.name("skycom_watch")).click();
    }

    public void SelectTvOption(){
        driver.findElement(By.xpath("id('skycom-search-wrapper')/div/div/label[2]")).click();
    }

    public void SearchShowing(String showToSearch){
        driver.findElement(By.id("skycom-search-text")).sendKeys(showToSearch);
        driver.findElement(By.id("skycom-search")).click();
    }

}
