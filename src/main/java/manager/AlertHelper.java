package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertHelper extends HelperBase{
    public AlertHelper(WebDriver wd) {
        super(wd);
    }
    public void selectItemAlert() {
        if(isElementPresent(By.id("close-fixedban"))) {
            click(By.id("close-fixedban"));
        }
        click(By.xpath("//div/h5[.='Alerts, Frame & Windows']"));

    }
    public void selectAlerts() {
        hideFooter();
        click(By.xpath("//span[text()='Alerts']"));
    }
}
