/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany;

import com.mycompany.daos.ViagemDAO;
import com.mycompany.models.Viagem;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author larissa
 */
public class VerViagensController {

    @FXML
    private TableColumn<?, ?> tabelaChegada;

    @FXML
    private TableColumn<?, ?> tabelaCpf;

    @FXML
    private TableColumn<?, ?> tabelaPlaca;

    @FXML
    private TableColumn<?, ?> tabelaDestino;

    @FXML
    private TableColumn<?, ?> tabelaModelo;

    @FXML
    private TableColumn<?, ?> tabelaNome;

    @FXML
    private TableColumn<?, ?> tabelaOrigem;

    @FXML
    private TableColumn<?, ?> tabelaPartida;

    @FXML
    private TableView<Viagem> tabelaViagens;

    @FXML
    private Button voltarBT;

    private List<Viagem> listViagens = new ArrayList<>();
    private ObservableList<Viagem> observablelistViagens = FXCollections.observableArrayList();

    public void initialize() {
        carregarTabelaViagens();

    }

    @FXML
    public void carregarTabelaViagens() {
        ViagemDAO viagemDAO = new ViagemDAO();
        listViagens.clear();
        listViagens.addAll(viagemDAO.getViagens());
        observablelistViagens.setAll(listViagens);
        tabelaViagens.setItems(observablelistViagens);

        tabelaNome.setCellValueFactory(new PropertyValueFactory<>("nome_pessoa"));
        tabelaCpf.setCellValueFactory(new PropertyValueFactory<>("cpf_pessoa"));
        tabelaModelo.setCellValueFactory(new PropertyValueFactory<>("modelo_veiculo"));
        tabelaPlaca.setCellValueFactory(new PropertyValueFactory<>("placa_veiculo"));
        tabelaOrigem.setCellValueFactory(new PropertyValueFactory<>("origem"));
        tabelaDestino.setCellValueFactory(new PropertyValueFactory<>("destino"));
        tabelaPartida.setCellValueFactory(new PropertyValueFactory<>("dataPartida"));
        tabelaChegada.setCellValueFactory(new PropertyValueFactory<>("dataChegada"));

        tabelaViagens.refresh();

    }

    @FXML
    void voltar(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NovaViagem.fxml"));
        Parent root = loader.load();
        Scene cena = new Scene(root);
        Stage stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
        stage.setScene(cena);
        stage.centerOnScreen();
        stage.show();
    }
}
