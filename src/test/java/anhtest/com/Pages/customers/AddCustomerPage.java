package anhtest.com.Pages.customers;

import anhtester.com.drivers.DriverManager;
import anhtester.com.keywords.WebUI;
import static anhtester.com.keywords.WebUI.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AddCustomerPage extends CustomerPage {
    private String CUSTOMER_URL = "https://crm.anhtester.com/admin/clients";
    private String PAGE_TEXT = "Customer";
    private By headerCustomer = By.xpath("//div[@class='mbot15']/h4[contains(.,'" + PAGE_TEXT + "')]");
    private By menuCustomers = By.xpath("//span[normalize-space()='Customers']");
    private String COMPANY_NAME;
    private String WEBSITE;
    public By Company = By.id("company");
    public By VAT = By.id("vat");
    public By Phone = By.id("phonenumber");
    public By Website = By.id("website");
    public By Group1 = By.xpath("//div[@class='form-group form-group-select-input-groups_in[] input-group-select']/div");
    public By Group2 = By.xpath("//div[@class='bs-searchbox']/input");
    public By Address = By.id("address");
    public By City = By.id("city");
    public By State = By.id("state");
    public By Zip  = By.id("zip");
    public By Country = By.xpath("//label[@for='country']/following-sibling::div");
    public By Country1 = By.xpath("//label[@for='country']/following-sibling::div//input[@type='search']");
    private By btnSave = By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']");
    private By customerDetailsTab = By.xpath("//a[normalize-space()='Customer Details']");

    private WebDriver driver;


    //Ham xay dung de truyen vao driver
//    public AddCustomerPage(WebDriver _driver){
//        super(_driver); //Tuan theo cau truc ham xay dung cua thang cha (CustomerPage)
//        driver = _driver; //Khoi tao driver chjo thang con (AddCustomerPage)
//        new WebUI(driver);//Khoi tao class WebUI de truyen gia tri Driver tu ben ngoai
//    }
    public void addCustomer(String COMPANY_NAME, String WEBSITE){
        //driver.findElement(Company).sendKeys(COMPANY_NAME);
        setTextElement(Company, COMPANY_NAME);
        //driver.findElement(VAT).sendKeys("VAT123456");
        setTextElement(VAT, "VAT123456");
        //driver.findElement(Phone).sendKeys("0903123456");
        setTextElement(Phone, "0903123456");
        //driver.findElement(Website).sendKeys(WEBSITE);
        setTextElement(Website, WEBSITE);
        //driver.findElement(Group1).click();
        clickElement(Group1);
        DriverManager.getDriver().findElement(Group2).sendKeys("Group1", Keys.ENTER);
        WebUI.sleep(1);
        //driver.findElement(Group2).click();
        clickElement(Group2);
        WebUI.sleep(1);
        //driver.findElement(Address).sendKeys("Viet Nam");
        setTextElement(Address, "Viet Nam");
        //driver.findElement(City).sendKeys("Can Tho");
        setTextElement(City, "Can Tho");
        //driver.findElement(State).sendKeys("Can Tho");
        setTextElement(State, "Can Tho");
        //driver.findElement(Zip).sendKeys("92000");
        setTextElement(Zip, "92000");
        WebUI.sleep(1);
        //driver.findElement(Country).click();
        clickElement(Country);
        WebUI.sleep(1);
        DriverManager.getDriver().findElement(Country1).sendKeys("Vietnam", Keys.ENTER);
        WebUI.sleep(1);
        //driver.findElement(btnSave).click();
        clickElement(btnSave);
        WebUI.waitForPageLoaded();
        //Kiểm tra Save thành công chuyển hướng đến trang Customer Details
        Assert.assertTrue(checkElementExist(customerDetailsTab), "Can not navigate to Customer Details page.");
    }
}
