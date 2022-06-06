package ui_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.ConfigurationReader;
import ui_automation.utilities.Driver;

public class LoginPage {
    WebDriver driver = Driver.getInstance().getDriver();
    HomePage hpage = new HomePage(driver);

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "email")
    public WebElement emailBox;

    @FindBy(xpath = "//*[text()='Continue']")
    public WebElement continueButton;

    @FindBy(xpath = "//*[@name='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement loginButton2;

    @FindBy(xpath = "//*[@class='message']/span")
    public WebElement errorMessage;

    public void login(){
        driver.get(ConfigurationReader.getProperty("ui-config.properties","rstudio.url"));
        hpage.loginButton.click();
        emailBox.sendKeys(ConfigurationReader.getProperty("ui-config.properties","rstudio.username"));
        continueButton.click();
        passwordBox.sendKeys(ConfigurationReader.getProperty("ui-config.properties","rstudio.password"));
        loginButton2.click();
    }

}
