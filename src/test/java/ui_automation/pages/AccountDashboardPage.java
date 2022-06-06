package ui_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountDashboardPage {

    WebDriver driver;

    public AccountDashboardPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@class='menuItem newSpace']")
    public WebElement newSpaceButton;

    @FindBy(id = "name")
    public WebElement nameBox;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement createButton;

    @FindBy(className = "spaceOwner")
    public WebElement spaceOwner;

    @FindBy(xpath = "//*[text()='New Project']")
    public WebElement newProjectButton;

    @FindBy(xpath = "//*[@class='action newRStudioProject']")
    public WebElement newRStudioProject;

    @FindBy(xpath = "//*[@class='userName']/div")
    public WebElement accOwner;

    @FindBy(id = "contentIFrame")
    public WebElement rStudioIDE;




}
