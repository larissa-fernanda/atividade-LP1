/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany;

import com.mycompany.daos.PessoaDAO;
import com.mycompany.models.Pessoa;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author larissa
 */
public class NovaPessoaController {

    @FXML
    private TextField cpfPessoaTF;

    @FXML
    private TextField idadePessoaTF;

    @FXML
    private TextField nomePessoaTF;

    @FXML
    private Label nometelaatual;

    @FXML
    private Button salvarPessoaBT;

    @FXML
    private Button voltarBT;

    @FXML
    private Button verPessoas;

    public void initialize() {

    }

    @FXML
    public void limparCampos() {
        nomePessoaTF.clear();
        cpfPessoaTF.clear();
        idadePessoaTF.clear();
    }

    @FXML
    void VerPessoas(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VerPessoas.fxml"));
        Parent root = loader.load();
        Scene cena = new Scene(root);
        Stage stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
        stage.setScene(cena);
        stage.centerOnScreen();
        stage.show();
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

    @FXML
    void salvarPessoa(MouseEvent event) {
        try {
            Pessoa pessoa = new Pessoa();
            pessoa.setNome(nomePessoaTF.getText());
            pessoa.setCpf(cpfPessoaTF.getText());
            pessoa.setIdade(Long.parseLong(idadePessoaTF.getText()));

            PessoaDAO pessoaDAO = new PessoaDAO();

            pessoaDAO.save(pessoa);

            System.out.println("Foi");

            limparCampos();
        } catch (Exception e) {
            System.out.println("Houve um erro");
        }
    }
}
