package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MenuController {

    private Stage dialog;

    public MenuController() {
        dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
    }

    public void showEuclideAlgorithm() throws Exception {
        showDisplay("dialogs/Euclide.fxml", "Algoritmo de Euclide", 850, 471);
    }

    public void showBaseConversion() throws Exception {
        showDisplay("dialogs/BaseConversion.fxml", "Base-Converter", 600, 400);
    }

    public void showSubConjunto() throws Exception {
        showDisplay("dialogs/SubConjunto.fxml", "Sub Conjunto",800,600);
    }

    public void showDivision() throws Exception {
        showDisplay("dialogs/Division.fxml", "Algoritmo Division", 600, 400);
    }

    private void showDisplay(String dialog, String title, int width, int height) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(dialog));
        this.dialog.setTitle(title);
        this.dialog.setMinHeight(height);
        this.dialog.setMinWidth(width);
        this.dialog.setMaxHeight(height);
        this.dialog.setMaxWidth(width);
        this.dialog.setResizable(false);
        this.dialog.setScene(new Scene(root, width, height));
        this.dialog.showAndWait();
    }
}
