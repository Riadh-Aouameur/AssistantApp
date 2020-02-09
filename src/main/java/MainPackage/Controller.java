package MainPackage;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public TextField TFFirstName;
    public TextField TFLastName;
    ObservableList<Patient> observableList = FXCollections.observableArrayList(
            new Patient("samir","benhami"),
            new Patient("samir","benhami")

    );
    @FXML
    private TableView<Patient> tableView;
    @FXML
    private TableColumn<Patient,String> colFirstName,colLastName;

    public void BAdd(ActionEvent actionEvent) {
        if(TFFirstName.getText().equals("")|| TFLastName.getText().equals("")){

            System.out.println("Error");

        }
        else
            {
                Patient patient =new Patient(TFFirstName.getText(),TFLastName.getText());
                tableView.getItems().add(patient) ;
                System.out.println("A");
                System.out.println("--"+TFFirstName.getText()+"--");
                System.out.println(TFLastName.getText());
            }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        tableView.setItems(observableList);
        tableView.setEditable(true);
        colFirstName.setCellFactory(TextFieldTableCell.forTableColumn());
        colLastName.setCellFactory(TextFieldTableCell.forTableColumn());


    }


    public void onEditFirstName(TableColumn.CellEditEvent<Patient, String> FirstNameStringCellEditEvent) {
        Patient patient =tableView.getSelectionModel().getSelectedItem();
        patient.setFirstName(FirstNameStringCellEditEvent.getNewValue());
    }

    public void onEditLastName(TableColumn.CellEditEvent<Patient, String> LastNameStringCellEditEvent) {
        Patient patient =tableView.getSelectionModel().getSelectedItem();
        patient.setLastName(LastNameStringCellEditEvent.getNewValue());
    }

    public void onDelete(ActionEvent actionEvent) {
        tableView.getItems().remove(tableView.getSelectionModel().getSelectedItem());
    }
}