package MainPackage;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private AnchorPane anch_1;
    @FXML
    private AnchorPane anch_2;

    @FXML
    private Button btn_1;

    @FXML
    private Button btn_2;

    @FXML
    private Button btn_3;

    @FXML
    private Button btn_4;
    @FXML
    private void handleButtonAction(ActionEvent event){
        if (event.getSource() == btn_1 || event.getSource()==btn_3){
                anch_1.toFront();
        } else if (event.getSource()== btn_2|| event.getSource()==btn_4){
                anch_2.toFront();

        }
    }
//-----------------------------------------------------------------------------------------------------------------
//table View
    ObservableList<Patient> observableList = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Patient, LocalDate> colBirth;
    @FXML
    private TableColumn<Patient, Integer> colNb;

    @FXML
    private TableColumn<Patient, String> colGender;
    @FXML
    private TableView<Patient> tableView;
    @FXML
    private TableColumn<Patient,String> colFirstName,colLastName;

    public void BAdd(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(new File("D:\\My Project\\AppAssistant\\src\\main\\resources\\src\\Page_3.fxml").toURI().toURL());
        Parent root = loader.load();
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Hello World!");


        primaryStage.setScene(new Scene(root));
        primaryStage.show();


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colFirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        colNb.setCellValueFactory(new PropertyValueFactory<>("number"));
        colBirth.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
         Patients.addPatient();
        observableList.setAll(Patients.arrayListPatients);



        tableView.setEditable(true);
        colFirstName.setCellFactory(TextFieldTableCell.forTableColumn());
        colLastName.setCellFactory(TextFieldTableCell.forTableColumn());
        tableView.setItems(observableList);



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