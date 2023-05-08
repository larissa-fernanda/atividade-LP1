/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany;

import com.mycompany.daos.VeiculoDAO;
import com.mycompany.models.Veiculo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author larissa
 */
public class VerVeiculosController {

    @FXML
    private Label nometelaatual;

    @FXML
    private TableColumn<?, ?> tabelaAno;

    @FXML
    private TableColumn<?, ?> tabelaCor;

    @FXML
    private TableColumn<?, ?> tabelaModelo;

    @FXML
    private TableColumn<?, ?> tabelaPlaca;

    @FXML
    private TableView<Veiculo> tabelaVeiculos;

    @FXML
    private Button voltarBT;

    private List<Veiculo> listVeiculos = new ArrayList<>();
    private ObservableList<Veiculo> observablelistVeiculos = FXCollections.observableArrayList();

    public void initialize() {
        carregarTabelaVeiculos();

    }

    @FXML
    void voltar(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NovoVeiculo.fxml"));
        Parent root = loader.load();
        Scene cena = new Scene(root);
        Stage stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
        stage.setScene(cena);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    public void carregarTabelaVeiculos() {
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        listVeiculos.clear();
        listVeiculos.addAll(veiculoDAO.getVeiculos());
        observablelistVeiculos.setAll(listVeiculos);
        tabelaVeiculos.setItems(observablelistVeiculos);

        tabelaModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        tabelaPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        tabelaAno.setCellValueFactory(new PropertyValueFactory<>("ano"));
        tabelaCor.setCellValueFactory(new PropertyValueFactory<>("cor"));

        tabelaVeiculos.refresh();

    }
}
