package anhtest.com.Testcases;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParameterOptional {
    @Test
    @Parameters({"val1", "val2"})
    public void Sum(@Optional("10") int v1, int v2) {
        int finalSum = v1 + v2;
        System.out.println("Kết quả là: " + finalSum);
    }
    @Test
    @Parameters({"message"})
    public void Notification(String message) {
        System.out.println("Message is: " + message);
    }
}
