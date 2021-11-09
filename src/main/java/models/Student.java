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
    String birthday;
    String subjects;

//    Boolean hobbieSport;
//    Boolean hobbieReading;
//    Boolean hobbieMusic;

    String hobbie;
    String currentAdress;
    State state;
    String city;

    public enum Gender{
        MALE,
        FEMALE,
        OTHER;
    }
    public enum State{
        NCR,
        UttarPradesh,
        Haryana,
        Rajasthan;
    }


}
