package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
    public AccountRegistrationPage(WebDriver driver) {
        super(driver);
    }

    //Elements
    @FindBy(xpath = "//input[@id=\"input-firstname\"]")
    WebElement txtFirstName;

    @FindBy(xpath = "//input[@id=\"input-lastname\"]")
    WebElement txtLastName;

    @FindBy(xpath = "//input[@id=\"input-email\"]")
    WebElement txtEmail;

    @FindBy(xpath = "//input[@id=\"input-password\"]")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@name=\"agree\"]")
    WebElement chkdPolicy;

    @FindBy(xpath = "//button[normalize-space()=\"Continue\"]")
    WebElement btnContinue;

    @FindBy(xpath = "//h1[normalize-space()=\"Register Account\"]")
    WebElement msgConfirmation;

    //Action Methods

    public void setFirstName(String firstName){
        txtFirstName.sendKeys(firstName);
    }

    public void setLastName(String lastName){
        txtLastName.sendKeys(lastName);
    }

    public void setEmail(String email){
        txtEmail.sendKeys(email);
    }

    public void setPassword(String password){
        txtPassword.sendKeys(password);
    }

    public void setPublicPolicy() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", chkdPolicy);
        Thread.sleep(5000);
        chkdPolicy.click();
    }

    public void clickContinue(){
        Actions act=new Actions(driver);
        act.moveToElement(btnContinue).click().perform();
    }

    public String getConfirmationMsg(){
        try{
            return msgConfirmation.getText();

        } catch(Exception e){
            return e.getMessage();
        }
    }
}
