package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class GoogleSearchStepDefs {

    String str;


    @Given("I am on Google Search homepage")
    public void iAmOnGoogleSearchHomepage() {
        Driver.getDriver().get("https://www.google.com/");
    }

    @When("I search  for a {string}")
    public void iSearchForA(String string) {
        str = string;
        Driver.getDriver().findElement(By.name("q")).sendKeys(str + Keys.ENTER);

    }

    @Then("The title of the page should contain the term")
    public void theTitleOfThePageShouldContainTheTerm() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains(str));
        String title = Driver.getDriver().getTitle();
        Assert.assertTrue(title.contains(str));
    }

}
