package ui_automation.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ui_automation.pages.AccountDashboardPage;
import ui_automation.pages.HomePage;
import ui_automation.pages.LoginPage;
import ui_automation.utilities.Driver;
import ui_automation.utilities.WaitHelper;

public class AccDashPageSteps {
    WebDriver driver = Driver.getInstance().getDriver();
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    AccountDashboardPage accDashPage = new AccountDashboardPage(driver);

    @Given("user is already logged in")
    public void user_is_already_logged_in() {
       loginPage.login();
    }

    @When("user clicks New Space tab")
    public void user_clicks_New_Space_tab() {
        accDashPage.newSpaceButton.click();
    }

    @When("user enters {string} to the Space")
    public void user_enters_to_the_Space(String name) {
        accDashPage.nameBox.sendKeys(name);
    }

    @When("user clicks Create button")
    public void user_clicks_Create_button() {
        accDashPage.createButton.click();
    }

    @Then("user should land on the {string} of new Space")
    public void user_should_land_on_the_of_new_Space(String name) {
        String expectedOwner = name;
        String actualOwner = accDashPage.spaceOwner.getText();
        Assert.assertEquals("Actual owner name does not match with expected one!", expectedOwner, actualOwner);
    }

    @When("user clicks New Project button and selects New RStudio Project")
    public void user_clicks_New_Project_button_and_selects_New_RStudio_Project() {
        accDashPage.newProjectButton.click();
        accDashPage.newRStudioProject.click();
    }

    @Then("user should land on RStudio IDE page")
    public void user_should_land_on_RStudio_IDE_page() {
        WaitHelper.waitForVisibility(accDashPage.rStudioIDE, 20);
    }

}
