package manager;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class ActionHelper extends HelperBase{
    public ActionHelper(WebDriver wd) {
        super(wd);
    }

    public void droppeableTests(){
        WebElement dragMe = wd.findElement(By.id("draggable"));
        WebElement dropHere = wd.findElement(By.id("droppable"));

        Rectangle dropHereRect = dropHere.getRect();
        int x = dropHereRect.getWidth()*2;
        int y = dropHereRect.getHeight()/2;

        pause(3000);
        dragMe.click();
        Actions actions = new Actions(wd);
       // actions.dragAndDrop(dragMe,dropHere).build().perform();
        actions.dragAndDropBy(dragMe,x,y).build().perform();
        pause(3000);

        String text = dropHere.getText();
        if(text.equals("Dropped!")){
            System.out.println("Pass: Dropped");
        }
        else {
            System.out.println("Failed: Not dropped");
        }
    }

    public void selectInteractions(){
        if (isElementPresent(By.id("close-fixedban"))) {
            click(By.id("close-fixedban"));
        }
        click(By.xpath("//div[@class='category-cards']/div[5]"));
        pause(500);
    }

    public void selectDropable(){
        hideFooter();
        click(By.xpath("//span[text()='Droppable']"));
    }
}
