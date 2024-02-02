package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {

    @Test(dataProvider="LoginData", dataProviderClass = DataProviders.class)
    public void verifyLoginDDT(String email, String password, String result) throws InterruptedException {
        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        Thread.sleep(3000);
        hp.clickLogin();

        LoginPage lp = new LoginPage(driver);
        Thread.sleep(2000);
        lp.setEmail(email);
        lp.setPassword(password);
        Thread.sleep(2000);
        lp.clickLogin();
    }
}
