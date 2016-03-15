package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class DivisionController {

    @FXML
    private TextField txtDividendo;

    @FXML
    private TextField txtDivisor;

    @FXML
    private TextArea txtArea;

    public void calculate() {
        long cociente = 0;
        long residuo = 0;
        long dividendo = 0;
        long divisor = 0;

        try {
            dividendo = Long.parseLong(txtDividendo.getText());
            divisor = Long.parseLong(txtDivisor.getText());
            cociente = dividendo / divisor;
            residuo = dividendo % divisor;
        }

        catch (Exception ex) {
            txtArea.setText("Ha ocurrido un error");
            return;
        }

        if(residuo == 0) {
            txtArea.setText("" + divisor + " divide a " + dividendo + " con un residuo de " + residuo);
        }

        else {
            txtArea.setText("" + divisor + " no divide a " + dividendo + " ya que da un residuo de " + residuo);
        }
    }

    public void reset() {
        txtArea.clear();
        txtDividendo.clear();
        txtDivisor.clear();
    }
}
