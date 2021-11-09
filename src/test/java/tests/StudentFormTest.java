package tests;

import models.Student;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StudentFormTest extends TestBase {

    @BeforeMethod
    public void preconditions() {
        app.studentHelper().selectItemForms();
        app.studentHelper().selectPracticeForm();
        app.studentHelper().hideFooter();

    }

    @Test
    public void studentFormTest() {
        Student student = Student.builder()
                .firstName("Ilia")
                .lastName("Finkel")
                .email("ilia@gmail.com")
                .gender(Student.Gender.MALE)
                .mobileNumber("1234567890")
                .birthday("20 March 1988")
                .subjects("Maths,Chemistry")
//                        .hobbieSport(true)
//                        .hobbieReading(false)
//                        .hobbieMusic(true)
                .hobbie("Sports,Music")
                .currentAdress("Tishbi 86")
                .state(Student.State.NCR)
                .city("Delhi")


                .build();

        app.studentHelper().fillStudentForm(student);
        app.studentHelper().pause(1000);
        app.studentHelper().submitStudentForm();
        app.studentHelper().pause(1000);
        Assert.assertEquals(app.studentHelper().getTitleFromDialog(), "Thanks for submitting the form");
        app.studentHelper().closeSuccessDialog();


    }

}
