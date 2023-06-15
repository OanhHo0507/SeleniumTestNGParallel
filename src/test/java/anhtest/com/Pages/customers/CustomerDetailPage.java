package anhtest.com.Pages.customers;

import anhtester.com.keywords.WebUI;
import static anhtester.com.keywords.WebUI.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CustomerDetailPage extends AddCustomerPage{

    public void checkCustomerDetail(String COMPANY_NAME, String VAT_NUMBER, String PHONE_NUMBER ){
        String addCompanyName = getAttributeElement(Company, "value");
        String addVAT = getAttributeElement(VAT, "value");
        String addPhoneNumber= getAttributeElement(Phone, "value");
        System.out.println("Company Name in Customer Details tab: " + addCompanyName);
        System.out.println("VAT in Customer Details tab: " + addVAT);
        System.out.println("Phone Number in Customer Details tab: " + addPhoneNumber);
        Assert.assertEquals(addCompanyName, COMPANY_NAME, "Company Name does not match the input value.");
        Assert.assertEquals(addVAT, VAT_NUMBER, "VAT does not match the input value.");
        Assert.assertEquals(addPhoneNumber, PHONE_NUMBER, "");
    }

}
