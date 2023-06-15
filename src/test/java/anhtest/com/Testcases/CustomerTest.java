package anhtest.com.Testcases;

import anhtest.com.Pages.customers.AddCustomerPage;
import anhtest.com.Pages.customers.CustomerDetailPage;
import anhtest.com.Pages.customers.CustomerPage;
import anhtest.com.Pages.DashboardPage;
import anhtest.com.Pages.LoginPage;
import anhtest.com.common.BaseTest;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest  {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;
    AddCustomerPage addCustomerPage;
    CustomerDetailPage customerDetailPage;
    @Test
    public void testTotalDashboard(){
        String COMPANY_NAME = "Test Global 4";
        loginPage = new LoginPage();
        //dashboardPage = new DashboardPage(driver);
        //customerPage = new CustomerPage(driver);
        dashboardPage = loginPage.loginValidEmail("admin@example.com", "123456");
        customerPage = dashboardPage.openCustomerPage();
        customerPage.verifyCustomerPage();
        addCustomerPage = new AddCustomerPage();
        addCustomerPage = customerPage.clickNewCustomerButton();
        addCustomerPage.addCustomer(COMPANY_NAME, "https://cmcglobal.com.vn/vi/home-vi/");
        //Search the added customer
        customerPage.searchCustomer(COMPANY_NAME);
        //Click on the first customer record to go to customer detail page
        customerDetailPage = customerPage.clickonFirstRowCustomerName();
        customerDetailPage.checkCustomerDetail(COMPANY_NAME, "VAT123456", "0903123456");

    }

}
