package anhtest.com.Testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParameters {
    @Test
    @Parameters({"Val1", "Val2"})// 2 paramters nay se duoc truyen vao trong file xml ben suites folder.
    public void Sum(int v1, int v2) {
        int finalSum = v1 + v2;
        System.out.println("Kết quả là: " + finalSum);
    }

}
