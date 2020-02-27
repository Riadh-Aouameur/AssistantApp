package mainpackage;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Controller implements Initializable  {

    Db db =new Db();
    ObservableList<Patient> observableList = FXCollections.observableArrayList(Patients.pateintArryList);
    ObservableList<Rpatient> observableList_1 = FXCollections.observableArrayList();

    @FXML
    private BorderPane root;

    @FXML
    private AnchorPane anch_1;
    @FXML
    private AnchorPane anch_2;
    @FXML
    private AnchorPane anch_3;
    @FXML
    private Button btn_1;

    @FXML
    private Button btn_2;

    @FXML
    private Button btn_3;

    @FXML
    private Button btn_4;
    @FXML
    private Button btn_5;


    @FXML
    private TextField FfirstName;

    @FXML
    private TextField FlastName;
    @FXML
    private TextField FId;

    @FXML
    private DatePicker DaRndv;

    @FXML
    private TableView<Rpatient> tableView_1;

    @FXML
    private TableColumn<Rpatient, String> col_1firstName;

    @FXML
    private TableColumn<Rpatient, String> col_1lastName;

    @FXML
    private TableColumn<Rpatient, LocalDate> col_1date;

    @FXML
    private TableColumn<Rpatient, Integer> col_1Id;








//    @FXML
//    private TableColumn<Patient, LocalDate> colBirth;
//    @FXML
//    private TableColumn<Patient, Integer> colNb;
//
//    @FXML
//    private TableColumn<Patient, String> colGender;


    @FXML
    private TableView<Patient> tableView;
    @FXML
    private TableColumn<Patient,String> colFirstName,colLastName;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

            db.update();

//table view for sal attend  -------------------------------------------------------------------------------------------------
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
//      colNb.setCellValueFactory(new PropertyValueFactory<>("number"));
//      colBirth.setCellValueFactory(new PropertyValueFactory<>("birthday"));
//      colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        tableView.setEditable(true);
        colFirstName.setCellFactory(TextFieldTableCell.forTableColumn());
        colLastName.setCellFactory(TextFieldTableCell.forTableColumn());
        tableView.setItems(observableList);
//---------------------------------------------------------------------------------------------------------------------------

// table view for Randv ------------------------------------------------------------------------------------------------------
        db.getData();
        observableList_1.setAll(Rpatients.rPateint);
        col_1firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        col_1lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        col_1date.setCellValueFactory(new PropertyValueFactory<>("Rdate"));
        col_1Id.setCellValueFactory(new PropertyValueFactory<>("ID"));

        //TODO : datepicker cell in table view
        tableView_1.setItems(observableList_1);

        tableView_1.setRowFactory(tv -> {
            TableRow<Rpatient> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    Rpatient rowData = row.getItem();
                    VBox vBox =new VBox();
                    Label label_1 =new Label("First Name "+rowData.firstName);
                    Label label_2 =new Label("Last Name "+rowData.lastName);
                    Label label_3 =new Label("DATe Rondv "+rowData.Rdate.toString());
                    Label label_4 =new Label("ID "+String.valueOf(rowData.ID));
                    vBox.getChildren().setAll(label_1,label_2,label_3,label_4);
                    Scene scene =new Scene(vBox,500,500);
                    Stage stage =new Stage();
                    stage.setScene(scene);
                    stage.show();

                }
            });
            return row ;
        });
//-------------------------------------------------------------------------------------------------------------------------------------

    }
//----------------------------------------------------------------------------------------------------------------------------------------
    @FXML
    private void handleButtonAction(ActionEvent event){
        if (event.getSource() == btn_1 || event.getSource()==btn_3){
            anch_1.toFront();
        } else if (event.getSource()== btn_2|| event.getSource()==btn_4){
            anch_2.toFront();

        }
        else if (event.getSource()== btn_5|| event.getSource()==btn_5){
            anch_3.toFront();

        }
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------------
public void onEditFirstName(TableColumn.CellEditEvent<Patient, String> FirstNameStringCellEditEvent) {
    Patient patient =tableView.getSelectionModel().getSelectedItem();
    patient.setFirstName(FirstNameStringCellEditEvent.getNewValue());
}

    public void onEditLastName(TableColumn.CellEditEvent<Patient, String> LastNameStringCellEditEvent) {
        Patient patient =tableView.getSelectionModel().getSelectedItem();
        patient.setLastName(LastNameStringCellEditEvent.getNewValue());

        System.out.println(Patients.pateintArryList.get(0).FirstName);
        System.out.println(Patients.pateintArryList.get(0).LastName);

    }
    public void onDelete(ActionEvent actionEvent) {
        tableView.getItems().remove(tableView.getSelectionModel().getSelectedItem());
    }

    public void OnRefresh(ActionEvent actionEvent) {

    }
    public void BAdd(ActionEvent actionEvent) throws IOException {
            VBox root =new VBox();
        Button button =new Button("click me ");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Patient patient = new Patient("gbfesF","UHGREA");
                Patients.pateintArryList.add(patient);
                observableList.setAll(Patients.pateintArryList);
                System.out.println(observableList.get(0).FirstName);

            }
        });
        root.getChildren().setAll(button);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();




    }

//----------------------------------------------------------------------------------------------------------------------------------------------------------






    public void OnSave(ActionEvent actionEvent) {

        observableList_1.add(new Rpatient(FfirstName.getText(),FlastName.getText(),DaRndv.getValue().toString(),Integer.parseInt(FId.getText())));
        tableView_1.setItems(observableList_1);
        db.setData(FfirstName.getText(),FlastName.getText(),DaRndv.getValue().toString(),Integer.parseInt(FId.getText()));


    }

    public void OnSerch(ActionEvent actionEvent) {

        ObservableList<Rpatient> observableList_2 = FXCollections.observableArrayList();
        tableView_1.setItems(observableList_2);
    }




}