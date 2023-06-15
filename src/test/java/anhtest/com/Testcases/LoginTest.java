package anhtest.com.Testcases;

import anhtest.com.Pages.LoginPage;
import anhtest.com.common.BaseTest;
import anhtester.com.drivers.DriverManager;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    @Test
    public void validLogin(){
        //Khoi tao object LoginPage va get driver from BaseTest
        loginPage = new LoginPage();

        //Goi ham login function from LoginPage
        loginPage.loginValidEmail("admin@example.com", "123456");
    }
    @Test
    public void invalidLogin(){
        loginPage = new LoginPage();
        loginPage.loginInvalidEmail("admin@example.com123", "123456");

    }
}
