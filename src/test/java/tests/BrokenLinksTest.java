package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinksTest extends TestBase {
    @BeforeMethod
    public void precondition(){
        app.brokenLinksSearchHelper().selectElements();
        app.brokenLinksSearchHelper().selectBrokenLinks();
    }

    @Test
    public void linkTest1(){
       app.brokenLinksSearchHelper().checkBrokenLinks();
    }
}
