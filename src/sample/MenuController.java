package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MenuController {

    private Stage dialog;

    public MenuController() {
        dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
    }

    public void showEuclideAlgorithm() throws Exception {
        showDisplay("dialogs/Euclide.fxml", "Algoritmo de Euclide");
    }

    private void showDisplay(String dialog, String title) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(dialog));
        this.dialog.setTitle(title);
        this.dialog.setMinHeight(471);
        this.dialog.setMinWidth(850);
        this.dialog.setMaxHeight(471);
        this.dialog.setMaxWidth(850);
        this.dialog.setResizable(false);
        this.dialog.setScene(new Scene(root, 674, 404));
        this.dialog.showAndWait();
    }
}
