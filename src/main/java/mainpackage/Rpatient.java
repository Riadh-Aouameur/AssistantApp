package mainpackage;

import java.time.LocalDate;

public class Rpatient {
    int ID=0;
    String lastName;
    String firstName;
    LocalDate Rdate;

    public Rpatient(String lastName, String firstName, String rdate,int Id) {
        this.ID = Id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.Rdate = LocalDate.parse(rdate);
    }
    public Rpatient(String lastName, String firstName, String rdate) {

        this.lastName = lastName;
        this.firstName = firstName;
        this.Rdate = LocalDate.parse(rdate);
    }



    public int getID() {
        return ID;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getRdate() {
        return String.valueOf(Rdate);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setRdate(LocalDate rdate) {
        Rdate = rdate;
    }
}
