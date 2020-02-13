package MainPackage;

import java.time.LocalDate;

public class Patient {

    Integer number =0 ;
     String FirstName;
     String LastName;
     String gender;
     LocalDate birthday;

    public Patient(String firstName, String lastName, String gender, LocalDate birthday) {
        number++;
        FirstName = firstName;
        LastName = lastName;
        this.gender = gender;
       this.birthday = birthday;
    }
//setter
    public void setNumber(int number) {
        this.number = number;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    public void setFirstName(String firstName) {
        FirstName = firstName;
    }
    public void setLastName(String lastName) {
        LastName = lastName;
    }
//getter
    public String getFirstName() {
        return FirstName;
    }
    public String getLastName() {
        return LastName;
    }
    public Integer getNumber() {
        return number;
    }
    public String getGender() {
        return gender;
    }
    public LocalDate getBirthday() {
        return birthday;
    }

}
