package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import models.Student;

public class StudentHelper extends HelperBase{
    public StudentHelper(WebDriver wd) {
        super(wd);
    }

    public void selectItemForms() {
        if(isElementPresent(By.id("close-fixedban"))) {
            click(By.id("close-fixedban"));
        }
        click(By.xpath("//div[@class='category-cards']/div[2]"));
        pause(500);
    }

    public void selectPracticeForm() {
        click(By.xpath("//span[.='Practice Form']"));
    }

    public void fillStudentForm(Student student) {
        type(By.id("firstName"),student.getFirstName());
        type(By.id("lastName"),student.getLastName());
        type(By.id("userEmail"),student.getEmail());
        selectGender(student);
        type(By.xpath("//input[@id='userNumber']"),student.getMobileNumber());
        selectHobbie(student);
        type(By.xpath("//textarea[@id='currentAddress']"),student.getCurrentAdress());

    }

    private void selectHobbie(Student student) {
        if(student.getHobbieSport())
            click(By.cssSelector("label[for='hobbies-checkbox-1']"));
        if(student.getHobbieReading())
            click(By.cssSelector("label[for='hobbies-checkbox-2']"));
        if(student.getHobbieMusic())
            click(By.cssSelector("label[for='hobbies-checkbox-3']"));
    }

    public void selectGender(Student student) {
        switch (student.getGender()){
            case MALE: click(By.cssSelector("label[for='gender-radio-1']"));
            break;
            case FEMALE: click(By.cssSelector("label[for='gender-radio-2']"));
            break;
            case OTHER: click(By.cssSelector("label[for='gender-radio-3']"));
            break;

        }

    }

    public void submitStudentForm() {
        click(By.xpath("//button[@id='submit']"));
    }
}
