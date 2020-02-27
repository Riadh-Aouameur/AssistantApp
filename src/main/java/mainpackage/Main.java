package mainpackage;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {


        Parent root_1 =FXMLLoader.load(getClass().getResource("files/filefxml/sample.fxml"));
        stage.setScene(new Scene(root_1));
        stage.setTitle("AssistantAssistant");
        stage.show();

    }
}
