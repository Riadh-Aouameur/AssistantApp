package MainPackage;

import javafx.application.Application;
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
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader loader1 = new FXMLLoader(new File("D:\\My Project\\AppAssistant\\src\\main\\resources\\src\\sample.fxml").toURI().toURL());
        Parent root_1 = loader1.load();
        primaryStage.setScene(new Scene(root_1));

        primaryStage.setTitle("Assistant");
        primaryStage.show();

    }
}
