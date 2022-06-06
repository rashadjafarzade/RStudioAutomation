package ui_automation.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import ui_automation.pages.AccountDashboardPage;
import ui_automation.pages.HomePage;
import ui_automation.pages.LoginPage;
import ui_automation.utilities.ConfigurationReader;
import ui_automation.utilities.Driver;

public class LoginPageSteps {
    WebDriver driver = Driver.getInstance().getDriver();
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    AccountDashboardPage accDashPage = new AccountDashboardPage(driver);

    @Given("user navigates to RStudio Cloud Login Page")
    public void user_navigates_to_RStudio_Cloud_Login_Page() {
        Driver.getInstance().getDriver().get(ConfigurationReader.getProperty("ui-config.properties","rstudio.url"));
        homePage.loginButton.click();
    }

    @When("user enters {string} username and {string} password")
    public void user_enters_username_and_password(String username, String password) {
        loginPage.emailBox.sendKeys(username);
        loginPage.continueButton.click();
        loginPage.passwordBox.sendKeys(password);
    }

    @Then("user clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.loginButton2.click();
    }

    @Then("user should verify {string} error message when switch is {string}")
    public void user_should_verify_error_message_when_switch_is(String expectedErrorMessage, String flag) {
        if(flag.equalsIgnoreCase("on")) {
            String actualErrorMessage = loginPage.errorMessage.getText();
            Assert.assertEquals("Error Message verification failed!", expectedErrorMessage, actualErrorMessage);
        }
    }

    @Then("user should be successfully land on RStudio Cloud User Account Dashboard when switch is {string}")
    public void user_should_be_successfully_land_on_RStudio_Cloud_User_Account_Dashboard_when_switch_is(String flag) {
        if(flag.equalsIgnoreCase("off")) {
            String expectedUsername = "Rashad Jafarzade";
            String actualUsername = accDashPage.accOwner.getText();
            Assert.assertEquals("Username validation failed on Account Dashboard", expectedUsername, actualUsername);
        }
    }
}
