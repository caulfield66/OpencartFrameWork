package testCases;

import org.apache.poi.ss.formula.functions.T;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {

    @Test
    public void verify_login() throws InterruptedException {
        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        Thread.sleep(3000);
        hp.clickLogin();

        LoginPage lp = new LoginPage(driver);
        Thread.sleep(2000);
        lp.setEmail(p.getProperty("email"));
        lp.setPassword(p.getProperty("password"));
        Thread.sleep(2000);
        lp.clickLogin();

    }
}
