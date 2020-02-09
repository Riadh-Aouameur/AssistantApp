package MainPackage;

public class Patient {
     String FirstName;
      String LastName;


    public Patient(String firstName, String lastName) {
      this.FirstName = firstName;
      this.LastName = lastName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }
}
