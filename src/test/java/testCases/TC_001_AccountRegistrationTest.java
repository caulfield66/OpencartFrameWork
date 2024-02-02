package testCases;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;



public class TC_001_AccountRegistrationTest extends BaseClass {

    @Test
    public void verify_account_registration() throws InterruptedException {
        logger.info("**** Starting TC_001_AccountRegistrationTest ****");
        logger.debug("Application logs.....");
        try {
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            logger.info("Clicked myAccount link");
            hp.clickRegister();
            logger.info("Clicked Register link");

            logger.info("Entering the customer details");
            AccountRegistrationPage arp = new AccountRegistrationPage(driver);
            Thread.sleep(3000);
            arp.setFirstName(randomString());
            arp.setLastName(randomString());
            arp.setEmail(randomString() + "@gmail.com");
            arp.setPassword(randomAlphaNumeric());
            arp.setPublicPolicy();
            arp.clickContinue();
            logger.info("Clicked continue");

            String act_conf_message = arp.getConfirmationMsg();
            logger.info("Validating expected message");
            Assert.assertEquals(act_conf_message, "Register Account");
        }catch(Exception e){
            logger.error("test failed");
            Assert.fail();
        }
        logger.info("**** Finishes TC_001_AccountRegistrationTest ****");

    }



}
