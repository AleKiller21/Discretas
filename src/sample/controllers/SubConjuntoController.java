package sample.controllers;


import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import sample.controllers.Utilities.Tree;

import java.util.PriorityQueue;

public class SubConjuntoController {

    @FXML
    private TextField txtNumber;

    @FXML
    private TextField txtDestino;

    @FXML
    private TextArea txtResultado;

    @FXML
    private TextArea txtArea;

    @FXML
    private Button btnIngresar;

    @FXML
    private Button btnDestino;

    @FXML
    private Button btnCalcular;

    @FXML
    private Button btnReset;

    @FXML
    private ListView listNumbers;

    private PriorityQueue<Integer> priorityQueue;
    private Tree tree;
    private int limite;

    public SubConjuntoController() {
        priorityQueue  = new PriorityQueue<>();
    }

    public void addNumber() {
        try {
            priorityQueue.add(Integer.parseInt(txtNumber.getText()));
            listNumbers.setItems(FXCollections.observableArrayList(priorityQueue));
            txtNumber.setText("");
        }

        catch (Exception e) {
            txtResultado.setText("Ha ocurrido un error");
            limite = 0;
        }
    }

    public void setLimite() {
        try {
            limite = Integer.parseInt(txtDestino.getText());
            //tree.setSum(Integer.parseInt(txtDestino.getText()));
            txtArea.setText(txtDestino.getText());
            txtDestino.setText("");
        }

        catch (Exception e) {
            txtResultado.setText("Ha ocurrido un error");
        }
    }

    public void calculate() {

        tree = new Tree(limite);
        tree.insert(priorityQueue);

        try {
            txtResultado.setText(tree.getData());
            priorityQueue.addAll(listNumbers.getItems());
        }

        catch (Exception e) {
            txtResultado.setText("Ha ocurrido un error");
        }
    }

    public void reset() {
        txtDestino.clear();
        txtNumber.clear();
        txtArea.clear();
        txtResultado.clear();
        listNumbers.setItems(null);
        priorityQueue.clear();
    }

    @FXML
    public void keyEnterPressed(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER) addNumber();
    }
}
