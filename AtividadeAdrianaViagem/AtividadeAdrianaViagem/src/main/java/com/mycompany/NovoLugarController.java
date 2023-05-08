/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany;

import com.mycompany.daos.LugarDAO;
import com.mycompany.models.Lugar;
import java.io.IOException;
import javafx.event.ActionEvent;
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
public class NovoLugarController {

    @FXML
    private TextField enderecoLugarTF;

    @FXML
    private TextField nomeLugarTF;

    @FXML
    private Label nometelaatual;

    @FXML
    private Button salvarLugarBT;

    @FXML
    private Button voltarBT;

    @FXML
    private Button verLugares;

    public void initialize() {

    }

    @FXML
    public void limparCampos() {
        nomeLugarTF.clear();
        enderecoLugarTF.clear();
    }

    @FXML
    void VerLugares(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VerLugares.fxml"));
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
    void salvarLugar(MouseEvent event) {
        try {
            Lugar lugar = new Lugar();

            lugar.setNome(nomeLugarTF.getText());
            lugar.setEndereco(enderecoLugarTF.getText());

            LugarDAO lugarDAO = new LugarDAO();

            lugarDAO.save(lugar);

            System.out.println("Foi");

            limparCampos();

        } catch (Exception e) {
            System.out.println("Houve um erro");
        }
    }
}
