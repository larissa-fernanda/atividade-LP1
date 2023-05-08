/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany;

import com.mycompany.daos.LugarDAO;
import com.mycompany.models.Lugar;
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
public class VerLugaresController {

    @FXML
    private Label nometelaatual;

    @FXML
    private TableColumn<?, ?> tabelaEndereco;

    @FXML
    private TableColumn<?, ?> tabelaNome;

    @FXML
    private TableView<Lugar> tabelaLugares;

    @FXML
    private Button voltarBT;

    private List<Lugar> listLugares = new ArrayList<>();
    private ObservableList<Lugar> observablelistLugares = FXCollections.observableArrayList();

    public void initialize() {
        carregarTabelaLugares();

    }

    @FXML
    void voltar(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NovoLugar.fxml"));
        Parent root = loader.load();
        Scene cena = new Scene(root);
        Stage stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
        stage.setScene(cena);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    public void carregarTabelaLugares() {
        LugarDAO lugarDAO = new LugarDAO();
        listLugares.clear();
        listLugares.addAll(lugarDAO.getLugares());
        observablelistLugares.setAll(listLugares);
        tabelaLugares.setItems(observablelistLugares);

        tabelaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tabelaEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));

        tabelaLugares.refresh();

    }
}
