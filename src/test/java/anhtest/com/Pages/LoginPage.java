package anhtest.com.Pages;

import anhtester.com.drivers.DriverManager;
import anhtester.com.keywords.WebUI;

//import static anhtest.com.common.BaseTest.driver;
import static anhtester.com.keywords.WebUI.*;//goi tat ca cac ham co trang thai la "Static" trong WebUI clas
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class LoginPage {
    private String URL = "https://crm.anhtester.com/admin/authentication";
    private String PAGETEXT = "Login";

    //Save Object of Login page
    //Dung doi tuong By trong Selenium de khai bao ten Object cung gia tri Locator tuong ung
    By headerPage = By.xpath("//h1");
    By inputEmail = By.xpath("//input[@id='email']");
    By inputPassword = By.xpath("//input[@id='password']");
    By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    By rememberCheckbox = By.xpath("//label[@for='remember']");
    By forgetPassword = By.xpath("//a[normalize-space()='Forgot Password?']") ;
    By emailErrorMessage = By.xpath("//div[normalize-space()='The Email Address field is required.']");
    By passwordErrorMessage = By.xpath("//div[normalize-space()='The Password field is required.']");
    By invalidEmail = By.xpath("//div[@class='text-center alert alert-danger']");

    //Viet cac ham xu ly cho trang Login
    public void verifyHeaderPage(){
        System.out.println("Header cua login page: " + getTextElement(headerPage));
        Assert.assertEquals(getTextElement(headerPage),"Login","FAIL. This is not Login page.");
    }
    //Kiem tra title cua Login page

    public void enterEmail(String email){
        setTextElement(inputEmail, email);
    }
    public void enterPassword(String password){
        setTextElement(inputPassword, password);
    }

    public void verifyErrorMessage(){
        boolean checkAlertError = WebUI.checkElementExist(invalidEmail);
        Assert.assertTrue(checkAlertError,"FAIL. The error message does not display");
        Assert.assertEquals(getTextElement(invalidEmail), "Invalid email or password", "The error message does not match as expected.");
    }
    public void clickOnLoginButton(){
        clickElement(buttonLogin);
    }
    public DashboardPage loginValidEmail(String email, String password){
        openURL(URL);
        verifyHeaderPage();
        //getSignInPageTitle();
        enterEmail(email);
        //OR write as: setTextElement(inputEmail, email);
        enterPassword(password);
        //OR write as: setTextElement(inputPassword, password);
        clickOnLoginButton();
        WebUI.sleep(2);

        return new DashboardPage();
    }
    public void loginInvalidEmail(String email, String password){
        openURL(URL);
        enterEmail(email);
        enterPassword(password);
        clickOnLoginButton();
        verifyErrorMessage();
    }

}