package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Euclide.fxml"));
        primaryStage.setTitle("Algoritmo de Euclide - Heroes' Guild");
        primaryStage.setMinHeight(471);
        primaryStage.setMinWidth(850);
        primaryStage.setMaxHeight(471);
        primaryStage.setMaxWidth(850);
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 674, 404));
        primaryStage.show();
    }


    public static void main(String[] args) { launch(args); }
}
