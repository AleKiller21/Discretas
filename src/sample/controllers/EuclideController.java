package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EuclideController extends VBox {

    @FXML
    private TextField txtNumero;

    @FXML
    private TextField txtResultado;

    @FXML
    private Button btnIngresar;

    @FXML
    private Button btnReset;

    @FXML
    private ListView listViewNumbers;

    @FXML
    private RadioButton gcdRadio;

    @FXML
    private RadioButton lcmRadio;

    private List<Long> listNumbers;

    public EuclideController() {
        listNumbers = new ArrayList<>();
    }

    public void addToList() {
        if(!validate())
            return;

        listNumbers.add(Math.abs(Long.parseLong(txtNumero.getText())));

        Collections.sort(listNumbers);
        Collections.reverse(listNumbers);

        listViewNumbers.setItems(FXCollections.observableArrayList(listNumbers));
        txtNumero.clear();
        txtResultado.clear();
    }

    private boolean validate() {
        long num;

        try {
            num = Long.parseLong(txtNumero.getText());
        }

        catch (Exception e) {
            txtResultado.setText("Solo se pueden ingresar numeros.");
            txtNumero.clear();
            return false;
        }

        if(num == 0) {
            txtResultado.setText("No se permite ingresar 0");
            txtNumero.clear();
            return false;
        }

        return true;
    }

    public void calcular() {
        if(gcdRadio.isSelected()) getGcd();

        else getLcm();
    }

    private void getGcd() {
        if(listNumbers.size() < 2) txtResultado.setText(new Integer(0).toString());

        else txtResultado.setText(new Long(calculateGcd(listNumbers.get(0), listNumbers.get(1), 0, 0)).toString());
    }

    private void getLcm() {
        if(listNumbers.size() < 2) txtResultado.setText(new Integer(0).toString());

        else txtResultado.setText(new Long(calculateLcm()).toString());
    }

    private long calculateLcm() {
        long lcm = 1;
        for(int i = 0; i < listNumbers.size() - 1; i++) {
            if(i == 0) lcm = listNumbers.get(0);

            lcm = (lcm * listNumbers.get(i + 1)) / calculateGcd(lcm, listNumbers.get(i + 1), listNumbers.size() - 2, 0);
        }

        return lcm;
    }

    private long calculateGcd(long dividend, long divisor, int iterator, long gcd) {
        long remainder = dividend % divisor;

        if(remainder == 0) {
            iterator++;
            gcd = divisor;
            if(iterator == listNumbers.size() - 1) return gcd;

            return divisor > listNumbers.get(iterator + 1) ? calculateGcd(divisor, listNumbers.get(iterator+1), iterator, gcd) :
                                                            calculateGcd(listNumbers.get(iterator+1), divisor, iterator, gcd);
        }

        else {
            return calculateGcd(divisor, remainder, iterator, gcd);
        }
    }

    public void reset() {
        txtNumero.setText("");
        txtResultado.setText("");
        listViewNumbers.setItems(null);
        listNumbers.clear();
    }

    @FXML
    public void keyEnterPressed(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER) addToList();
    }
}
