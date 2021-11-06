package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest extends TestBase{


    @BeforeMethod
    public void preconditions() {
        app.alert().selectItemAlert();
        app.alert().selectAlerts();
    }

    @Test
    public void button1(){

    }

    @Test
    public void button2(){

    }
    @Test
    public void button3(){

    }
    @Test
    public void button4(){

    }
}
