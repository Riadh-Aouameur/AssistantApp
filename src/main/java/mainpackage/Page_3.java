package mainpackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Page_3 {



    @FXML
    private TextField fildId;

    @FXML
    private TextField fildFirstName;

    @FXML
    private TextField fildLastName;

    public void OnSetData(ActionEvent actionEvent) {

        Patients.pateintArryList.add(new Patient(fildFirstName.getText(),fildLastName.getText()));
    }
}
