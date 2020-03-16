package my.test.app.test.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import my.test.app.utils.ui.Session;
import my.test.app.utils.ui.app.GoogleMainPage;
import my.test.app.utils.ui.app.GoogleResultPage;
import my.test.app.utils.ui.app.customWidget.SearchResultItem;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleSteps {
    @Given("^I open Google search page$")

    public void iOpenGoogleSearchPage (){

        Session.get().wd().get("https://google.com");

    }

    @And("^I enter value \"(.+?)\" to search field$")
    public void iEnterValueToSearch (String value){
        GoogleMainPage mainPage = new GoogleMainPage();
        GoogleResultPage resultPage =  mainPage.search(value);
        resultPage.confirmPage();
    }

    @Then("^Link to site \"(.+?)\" exists$")
    public void linkToSiteExists (String site) {
        boolean found = false;
        GoogleResultPage resultPage = new GoogleResultPage();
        for (SearchResultItem item : resultPage.getResultItems()){
            if (item.site().equalsIgnoreCase(site)){
                found = true;
                break;
            }
        }
        Assert.assertTrue("Site \""  + site+ "\" not found", found);

    }

}
