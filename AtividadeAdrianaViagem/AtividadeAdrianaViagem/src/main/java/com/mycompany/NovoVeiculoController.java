/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany;

import com.mycompany.daos.VeiculoDAO;
import com.mycompany.models.Veiculo;
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
public class NovoVeiculoController {

    @FXML
    private TextField anoVeiculoTF;

    @FXML
    private TextField corVeiculoTF;

    @FXML
    private TextField modeloVeiculoTF;

    @FXML
    private Label nometelaatual;

    @FXML
    private TextField placaVeiculoTF;

    @FXML
    private Button salvarVeiculoBT;

    @FXML
    private Button voltarBT;

    @FXML
    private Button verVeiculos;

    public void initialize() {

    }

    @FXML
    public void limparCampos() {
        modeloVeiculoTF.clear();
        placaVeiculoTF.clear();
        anoVeiculoTF.clear();
        corVeiculoTF.clear();
    }

    @FXML
    void VerVeiculos(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VerVeiculos.fxml"));
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
    void salvarVeiculo(MouseEvent event) {
        try {
            Veiculo veiculo = new Veiculo();
            veiculo.setModelo(modeloVeiculoTF.getText());
            veiculo.setPlaca(placaVeiculoTF.getText());
            veiculo.setAno(Long.parseLong(anoVeiculoTF.getText()));
            veiculo.setCor(corVeiculoTF.getText());

            VeiculoDAO veiculoDAO = new VeiculoDAO();

            veiculoDAO.save(veiculo);

            System.out.println("Foi");

            limparCampos();
        } catch (Exception e) {
            System.out.println("Houve um erro");
        }
    }
}
