package manager;

import org.openqa.selenium.*;
import models.Student;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class StudentHelper extends HelperBase {
    public StudentHelper(WebDriver wd) {
        super(wd);
    }

    public void selectItemForms() {
        if (isElementPresent(By.id("close-fixedban"))) {
            click(By.id("close-fixedban"));
        }
        click(By.xpath("//div[@class='category-cards']/div[2]"));
        pause(500);
    }

    public void selectPracticeForm() {
        click(By.xpath("//span[.='Practice Form']"));
    }

    public void fillStudentForm(Student student) {
        type(By.id("firstName"), student.getFirstName());
        type(By.id("lastName"), student.getLastName());
        type(By.id("userEmail"), student.getEmail());
        selectGender(student);
        type(By.xpath("//input[@id='userNumber']"), student.getMobileNumber());
        //typeBDay(student.getBirthday());
        typeBDaySelect(student.getBirthday());
        addSubjectByClick(student.getSubjects());
        //selectHobbie(student);
        selectHobbie(student.getHobbie());
        uploadPicture();
        type(By.xpath("//textarea[@id='currentAddress']"), student.getCurrentAdress());

        selectState(student);
        selectCity(student.getCity());

    }

    private void addSubjectByClick(String subjects) {
        String[] all = subjects.split(",");
        click(By.id("subjectsInput"));
        for (String sub : all) {
            wd.findElement(By.id("subjectsInput")).sendKeys(sub);
            wd.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);//1 вариант
            //  click(By.id("react-select-2-option-0"));//2 вариант


        }
    }

    private void typeBDaySelect(String birthday) {
        String[] data = birthday.split(" ");//20 3 1998

        click(By.id("dateOfBirthInput"));
        new Select(wd.findElement(By.cssSelector(".react-datepicker__month-select"))).selectByVisibleText(data[1]);
        new Select(wd.findElement(By.cssSelector(".react-datepicker__year-select"))).selectByValue(data[2]);
        //click(By.xpath("//div[text()='20']"));
        //String locator = "//div[text()='"+data[0]+"'";
        String locator2 = String.format("//div[text()='%s']", data[0]);
        List<WebElement> list = wd.findElements(By.xpath(locator2));

        if (list.size() > 1 && Integer.parseInt(data[0]) > 15)
            list.get(1).click();
        else list.get(0).click();

        //click(By.xpath(locator2));
        pause(6000);


    }

    private void typeBDay(String birthday) {
        WebElement dBirth = wd.findElement(By.id("dateOfBirthInput"));
        dBirth.click();
//        dBirth.clear();
//        dBirth.sendKeys(birthday);

        String os = System.getProperty("os.name");
        System.out.println(os);
        if (os.startsWith("Mac")) {
            //command+a
            dBirth.sendKeys(Keys.chord(Keys.COMMAND, "a"));//комбинация кнопок

        } else {
            //ctrl+a
            dBirth.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        }
        dBirth.sendKeys(birthday);
        dBirth.sendKeys(Keys.ENTER);
    }

//    private void selectHobbie(Student student) {
//        if(student.getHobbieSport())
//            click(By.cssSelector("label[for='hobbies-checkbox-1']"));
//        if(student.getHobbieReading())
//            click(By.cssSelector("label[for='hobbies-checkbox-2']"));
//        if(student.getHobbieMusic())
//            click(By.cssSelector("label[for='hobbies-checkbox-3']"));
//    }

    private void selectHobbie(String hobbie) {
        if (hobbie != null && !hobbie.isEmpty()) {
            String[] hobbies = hobbie.split(",");
            for (String h : hobbies) {
                switch (h) {
                    case "Sports":
                        click(By.cssSelector("label[for='hobbies-checkbox-1']"));
                        break;
                    case "Reading":
                        click(By.cssSelector("label[for='hobbies-checkbox-2']"));
                        break;
                    case "Music":
                        click(By.cssSelector("label[for='hobbies-checkbox-3']"));
                        break;
                }

            }

        } else System.out.println("The field 'hobbie' is empty");

    }

    public void selectGender(Student student) {
        switch (student.getGender()) {
            case MALE:
                click(By.cssSelector("label[for='gender-radio-1']"));
                break;
            case FEMALE:
                click(By.cssSelector("label[for='gender-radio-2']"));
                break;
            case OTHER:
                click(By.cssSelector("label[for='gender-radio-3']"));
                break;

        }

    }

    public void selectGender(String gender) {
        if (gender.equals("Male")) {
            click(By.cssSelector("label[for='gender-radio-1']"));
        } else if (gender.equals("Female")) {
            click(By.cssSelector("label[for='gender-radio-2']"));

        } else {
            click(By.cssSelector("label[for='gender-radio-3']"));
        }
    }


    public void submitStudentForm() {
        click(By.xpath("//button[@id='submit']"));
    }

    public void closeSuccessDialog() {
        click(By.id("closeLargeModal"));
    }

    public void uploadPicture() {
        wd.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\gorbu\\Documents\\GitHub\\Qa30_DemoQa-master\\foto.png");
    }

    public String getTitleFromDialog() {
        String title = wd.findElement(By.xpath("//div[@id='example-modal-sizes-title-lg']")).getText();
        return title;
    }

    public void selectState(Student student) {
        click(By.xpath("//div[contains(text(),'Select State')]"));
        switch (student.getState()) {
            case NCR:
                click(By.id("react-select-3-option-0"));
                break;
            case UttarPradesh:
                click(By.id("react-select-3-option-1"));
                break;
            case Haryana:
                click(By.id("react-select-3-option-2"));
                break;
            case Rajasthan:
                click(By.id("react-select-3-option-3"));
                break;
        }
    }

    public void selectCity(String city) {
        WebElement element = wd.findElement(By.xpath("//div[contains(text(),'Select City')]"));
//        Actions act = new Actions(wd);
//        act.moveToElement(element).click().sendKeys(city).sendKeys(Keys.ENTER).perform();
        new Actions(wd).sendKeys(element,city).sendKeys(Keys.ENTER).perform();

        Dimension dimension = wd.manage().window().getSize();//определение размера экрана
        System.out.println(dimension.getHeight()+dimension.getWidth());//распечатать высоту и ширину
        scroll(0,400);
    }

}
