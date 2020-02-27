package mainpackage;

import javafx.beans.property.SimpleStringProperty;

public class Patient {

//    Integer number =0 ;
     SimpleStringProperty FirstName;
     String LastName;
//     String gender;
//    LocalDate birthday;

    public Patient(String firstName, String lastName) {

        FirstName = new SimpleStringProperty(firstName);
        LastName = lastName;

    }
//setter


    public void setFirstName(String firstName) {
        this.FirstName.set(firstName);
    }


    public void setLastName(String lastName) {
        LastName = lastName;
    }
//getter

    public Object getFirstName() {
        return FirstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }


}
