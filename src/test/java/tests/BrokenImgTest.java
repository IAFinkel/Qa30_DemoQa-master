package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenImgTest extends TestBase{

    @BeforeMethod
    public void precondition(){
        app.brokenLinksSearchHelper().selectElements();
        app.brokenLinksSearchHelper().selectBrokenLinks();
    }

    @Test
    public void test1(){

        app.brokenLinksSearchHelper().checkBrokenImages();

    }

    @Test
    public void test2(){

        app.brokenLinksSearchHelper().checkBrokenImagesJS();

    }
}
