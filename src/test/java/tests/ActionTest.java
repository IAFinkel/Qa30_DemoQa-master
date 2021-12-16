package tests;

import org.testng.annotations.Test;

public class ActionTest extends TestBase {
    @Test
    public void actionTest(){
        app.action().selectInteractions();
        app.action().selectDropable();
        app.action().droppeableTests();

    }
}
