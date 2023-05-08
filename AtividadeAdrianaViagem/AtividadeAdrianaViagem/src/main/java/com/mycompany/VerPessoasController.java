/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany;

import com.mycompany.daos.PessoaDAO;
import com.mycompany.models.Pessoa;
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
public class VerPessoasController {

    @FXML
    private Label nometelaatual;

    @FXML
    private TableColumn<?, ?> tabelaCpf;

    @FXML
    private TableColumn<?, ?> tabelaIdade;

    @FXML
    private TableColumn<?, ?> tabelaNome;

    @FXML
    private TableView<Pessoa> tabelaPessoas;

    @FXML
    private Button voltarBT;

    private List<Pessoa> listPessoas = new ArrayList<>();
    private ObservableList<Pessoa> observablelistPessoas = FXCollections.observableArrayList();

    public void initialize() {
        carregarTabelaPessoas();

    }

    @FXML
    void voltar(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NovaPessoa.fxml"));
        Parent root = loader.load();
        Scene cena = new Scene(root);
        Stage stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
        stage.setScene(cena);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    public void carregarTabelaPessoas() {
        PessoaDAO pessoaDAO = new PessoaDAO();
        listPessoas.clear();
        listPessoas.addAll(pessoaDAO.getPessoas());
        observablelistPessoas.setAll(listPessoas);
        tabelaPessoas.setItems(observablelistPessoas);

        tabelaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tabelaCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        tabelaIdade.setCellValueFactory(new PropertyValueFactory<>("idade"));

        tabelaPessoas.refresh();

    }
}
