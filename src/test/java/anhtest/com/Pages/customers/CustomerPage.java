package anhtest.com.Pages.customers;

import anhtester.com.drivers.DriverManager;
import anhtester.com.keywords.WebUI;
import static anhtester.com.keywords.WebUI.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CustomerPage {
    private String CUSTOMER_URL = "https://crm.anhtester.com/admin/clients";
    private String PAGE_TEXT = "Customer";
    private String COMPANY_NAME;
    private String WEBSITE;
    private By headerCustomer = By.xpath("//div[@class='mbot15']/h4[contains(.,'" + PAGE_TEXT + "')]");
    private By menuCustomers = By.xpath("//span[normalize-space()='Customers']");
    private By btnAddCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By companyDetails = By.xpath("//input[@id='company']");
    private By SearchBox = By.xpath("//input[@class='form-control input-sm']");
    private By addItem = By.xpath("//tbody/tr[1]/td[3]/a");

    public void verifyCustomerPage() {
        //Check URL of Customer page
        Assert.assertEquals(getCurrentUrl(), CUSTOMER_URL, "This is not URL of Customer page");
        Assert.assertTrue(WebUI.checkElementExist(headerCustomer), "FAIL. Header Page Customer does not exist.");
        System.out.println(getTextElement(headerCustomer));
        Assert.assertEquals(getTextElement(headerCustomer), "Customers Summary", "Customer Summary is not displayed.");
    }
    public AddCustomerPage clickNewCustomerButton(){
        //check Customer menu exists from left menu
        WebUI.waitForPageLoaded();
        String AddNewCustomer = getTextElement(btnAddCustomer);
        System.out.println(AddNewCustomer);
        Assert.assertTrue(WebUI.verifyElementVisibility(btnAddCustomer,5),"New Customer button is not displayed.");
        clickElement(btnAddCustomer);

        return new AddCustomerPage();
    }
    public void searchCustomer(String COMPANY_NAME){
        WebUI.waitForPageLoaded();
        String companyNameinDetails = getAttributeElement(companyDetails, "value");
        System.out.println("Company Name in Customer Details tab: " + companyNameinDetails);
        Assert.assertEquals(companyNameinDetails, COMPANY_NAME);
        //Click mở trang Customers lại
        clickElement(menuCustomers);
        WebUI.waitForPageLoaded();
        //Search tên customer vừa add
        //driver.findElement(SearchBox).sendKeys(COMPANY_NAME);
        setTextElement(SearchBox,COMPANY_NAME);
        //WebUI.sleep(1);
        WebUI.waitForPageLoaded();
        //WebUI.waitForElementVisible(addItem, 10);
        //Get Text cột customer name
        String getCompanyName = getTextElement(addItem);
        System.out.println("Added record in the table is " + getCompanyName);
        //Verify equals với data input
        Assert.assertEquals(getCompanyName, COMPANY_NAME, "FAILED. Company Name on the table does not match.");
        //WebUI.sleep(2);
    }
    public CustomerDetailPage clickonFirstRowCustomerName(){
        WebUI.waitForPageLoaded();
        //WebUI.waitForElementVisible(addItem,10);
        //driver.findElement(addItem).click();
        clickElement(addItem);

        return new CustomerDetailPage();
    }
}
