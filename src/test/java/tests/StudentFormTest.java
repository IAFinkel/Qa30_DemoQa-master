package tests;

import models.Student;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StudentFormTest extends TestBase{

    @BeforeMethod
    public void preconditions(){
        app.studentHelper().selectItemForms();
        app.studentHelper().selectPracticeForm();
        app.studentHelper().hideFooter();

    }

    @Test
    public void studentFormTest(){
        Student student = Student.builder()
                        .firstName("Ilia")
                        .lastName("Finkel")
                        .email("ilia@gmail.com")
                        .gender(Student.Gender.MALE)
                        .mobileNumber("1234567890")
                        .dateOfBirth("20.03.1988")
                        .subjects("")
                        .hobbieSport(true)
                        .hobbieReading(false)
                        .hobbieMusic(true)
                        .currentAdress("Tishbi 86")
                        .city("Haifa")


                .build();

        app.studentHelper().fillStudentForm(student);
        app.studentHelper().submitStudentForm();








    }

}
