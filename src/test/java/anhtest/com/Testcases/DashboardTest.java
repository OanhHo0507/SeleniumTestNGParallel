package anhtest.com.Testcases;

import anhtest.com.Pages.customers.CustomerPage;
import anhtest.com.Pages.DashboardPage;
import anhtest.com.Pages.LoginPage;
import anhtest.com.common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;
    @Test
    public void testTotalDashboard(){
        loginPage = new LoginPage();
        //Lien ket trang duoc xay ra nho ham login tra ve la su khoi tao cua trang Dashboard
        dashboardPage = loginPage.loginValidEmail("admin@example.com", "123456");
        //Toi trang Dashboard sau do goi ham verifyDashboardLink()
        dashboardPage.verifyDashboardLink();

        //Lien ket trang giua Dashboard va Customers (tu Dashboard di toi Customer page)
        customerPage = dashboardPage.openCustomerPage();
        //Toi trang Customers sau do goi ham verifyCustomerPage()
        customerPage.verifyCustomerPage();

    }
    @Test
    public void filterWidgetsDashboard(){
        loginPage = new LoginPage();
        //Lien ket trang duoc xay ra nho ham login tra ve la su khoi tao cua trang Dashboard
        dashboardPage = loginPage.loginValidEmail("admin@example.com", "123456");
        dashboardPage.verifyVisibleWidget();
    }
}
