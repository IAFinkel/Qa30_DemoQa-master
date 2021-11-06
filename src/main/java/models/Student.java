package models;
import lombok.*;

@Getter
@Setter
@Builder
@ToString

public class Student {
    String firstName;
    String lastName;
    String email;
    Gender gender;
    String mobileNumber;
    String dateOfBirth;
    String subjects;

    Boolean hobbieSport;
    Boolean hobbieReading;
    Boolean hobbieMusic;

    String currentAdress;
    String state;
    String city;

    public enum Gender{
        MALE,
        FEMALE,
        OTHER;
    }

}
