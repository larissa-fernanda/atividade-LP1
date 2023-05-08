/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany;

import com.mycompany.daos.LugarDAO;
import com.mycompany.daos.PessoaDAO;
import com.mycompany.daos.VeiculoDAO;
import com.mycompany.daos.ViagemDAO;
import com.mycompany.models.Lugar;
import com.mycompany.models.Pessoa;
import com.mycompany.models.Veiculo;
import com.mycompany.models.Viagem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author larissa
 */
public class NovaViagemController {

    @FXML
    private DatePicker dataChegada;

    @FXML
    private DatePicker dataPartida;

    @FXML
    private ComboBox<String> destinoCB;

    @FXML
    private Label destinoL;

    @FXML
    private Button fecharTela;

    @FXML
    private Button minimizarTela;

    @FXML
    private Label nometelaatual;

    @FXML
    private Button novaPessoaBT;

    @FXML
    private Button novoLugarBT;

    @FXML
    private Button novoVeiculoBT;

    @FXML
    private ComboBox<String> origemCB;

    @FXML
    private Label origemL;

    @FXML
    private ComboBox<String> pessoaCpfCB;

    @FXML
    private Label pessoaL;

    @FXML
    private Label pessoaL1;

    @FXML
    private ComboBox<String> pessoaNomeCB;

    @FXML
    private Button salvarViagemBT;

    @FXML
    private Label veiculoL;

    @FXML
    private Label veiculoL1;

    @FXML
    private Label veiculoL11;

    @FXML
    private Label veiculoL12;

    @FXML
    private ComboBox<String> veiculoModeloCB;

    @FXML
    private ComboBox<String> veiculoPlacaCB;

    @FXML
    private Button voltarBT;

    @FXML
    private Button verViagens;

    private List<String> nomesPessoas = new ArrayList<>();
    private ObservableList<String> nomesPessoasObs = FXCollections.observableArrayList();

    private List<String> cpfsPessoas = new ArrayList<>();
    private ObservableList<String> cpfsPessoasObs = FXCollections.observableArrayList();

    private List<String> origens = new ArrayList<>();
    private ObservableList<String> origensObs = FXCollections.observableArrayList();

    private List<String> destinos = new ArrayList<>();
    private ObservableList<String> destinosObs = FXCollections.observableArrayList();

    private List<String> modelosVeiculos = new ArrayList<>();
    private ObservableList<String> modelosVeiculosObs = FXCollections.observableArrayList();

    private List<String> placasVeiculos = new ArrayList<>();
    private ObservableList<String> placasVeiculosObs = FXCollections.observableArrayList();

    public void initialize() {

    }

    @FXML
    public void limparCampos() {

        pessoaNomeCB.getSelectionModel().clearSelection();
        pessoaCpfCB.getSelectionModel().clearSelection();
        origemCB.getSelectionModel().clearSelection();
        destinoCB.getSelectionModel().clearSelection();
        veiculoModeloCB.getSelectionModel().clearSelection();
        veiculoPlacaCB.getSelectionModel().clearSelection();
        dataChegada.getEditor().clear();
        dataChegada.setValue(null);
        dataPartida.getEditor().clear();
        dataPartida.setValue(null);
    }

    private String erro = "-fx-border-color:#E06469";

    @FXML
    public void salvarViagem() {

        if (pessoaNomeCB.getValue() == null
                || pessoaCpfCB.getValue() == null
                || origemCB.getValue() == null
                || destinoCB.getValue() == null
                || veiculoModeloCB.getValue() == null
                || veiculoPlacaCB.getValue() == null) {
            System.out.println("Preencha todos os campos");
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Preencha todos os campos");
            alert.setHeaderText(null);
            alert.setContentText("Algum dos campos não foi preenchido");
            alert.showAndWait();
        } else {
            try {

                String nome_pessoa = pessoaNomeCB.getSelectionModel().getSelectedItem();

                String cpf_pessoa = pessoaCpfCB.getSelectionModel().getSelectedItem();

                String nome_origem = origemCB.getSelectionModel().getSelectedItem();

                String nome_destino = destinoCB.getSelectionModel().getSelectedItem();

                String modelo_veiculo = veiculoModeloCB.getSelectionModel().getSelectedItem();

                String placa_veiculo = veiculoPlacaCB.getSelectionModel().getSelectedItem();

                Viagem viagem = new Viagem();

                viagem.setNome_pessoa(nome_pessoa);
                viagem.setCpf_pessoa(cpf_pessoa);
                viagem.setOrigem(nome_origem);
                viagem.setDestino(nome_destino);
                viagem.setModelo_veiculo(modelo_veiculo);
                viagem.setPlaca_veiculo(placa_veiculo);
                viagem.setDataPartida(dataPartida.getValue().toString());
                viagem.setDataChegada(dataChegada.getValue().toString());

                ViagemDAO viagemDAO = new ViagemDAO();

                viagemDAO.save(viagem);

                System.out.println("Foi");

                limparCampos();

            } catch (Exception e) {
                System.out.println("Houve um erro");
            }
        }
    }

    @FXML
    public void addPessoa(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NovaPessoa.fxml"));
        Parent root = loader.load();
        Scene cena = new Scene(root);
        Stage stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
        stage.setScene(cena);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    public void addLugar(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NovoLugar.fxml"));
        Parent root = loader.load();
        Scene cena = new Scene(root);
        Stage stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
        stage.setScene(cena);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    public void addVeiculo(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NovoVeiculo.fxml"));
        Parent root = loader.load();
        Scene cena = new Scene(root);
        Stage stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
        stage.setScene(cena);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    public void forneceNomePessoa() {
        PessoaDAO pessoaDAO = new PessoaDAO();
        nomesPessoas.clear();
        for (Pessoa pessoa : pessoaDAO.getPessoas()) {
            nomesPessoas.add(pessoa.getNome());
        }
        nomesPessoasObs.setAll(nomesPessoas);
        pessoaNomeCB.setItems(nomesPessoasObs);
    }

    @FXML
    public void forneceCpfPessoa() {
        PessoaDAO pessoaDAO = new PessoaDAO();
        cpfsPessoas.clear();
        for (Pessoa pessoa : pessoaDAO.getPessoas()) {
            cpfsPessoas.add(pessoa.getCpf());
        }
        cpfsPessoasObs.setAll(cpfsPessoas);
        pessoaCpfCB.setItems(cpfsPessoasObs);
    }

    @FXML
    public void forneceOrigem() {
        LugarDAO lugarDAO = new LugarDAO();
        origens.clear();
        for (Lugar lugar : lugarDAO.getLugares()) {
            origens.add(lugar.getNome());
        }
        origensObs.setAll(origens);
        origemCB.setItems(origensObs);
    }

    @FXML
    public void forneceDestino() {
        LugarDAO lugarDAO = new LugarDAO();
        destinos.clear();
        for (Lugar lugar : lugarDAO.getLugares()) {
            destinos.add(lugar.getNome());
        }
        destinosObs.setAll(destinos);
        destinoCB.setItems(destinosObs);
    }

    @FXML
    public void forneceModeloVeiculo() {
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        modelosVeiculos.clear();
        for (Veiculo veiculo : veiculoDAO.getVeiculos()) {
            modelosVeiculos.add(veiculo.getModelo());
        }
        modelosVeiculosObs.setAll(modelosVeiculos);
        veiculoModeloCB.setItems(modelosVeiculosObs);
    }

    @FXML
    public void fornecePlacaVeiculo() {
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        placasVeiculos.clear();
        for (Veiculo veiculo : veiculoDAO.getVeiculos()) {
            placasVeiculos.add(veiculo.getPlaca());
        }
        placasVeiculosObs.setAll(placasVeiculos);
        veiculoPlacaCB.setItems(placasVeiculosObs);
    }

    @FXML
    void voltar(MouseEvent event) {

    }

    @FXML
    void VerViagens(MouseEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VerViagens.fxml"));
            Parent root = loader.load();
            Scene cena = new Scene(root);
            Stage stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
            stage.setScene(cena);
            stage.centerOnScreen();
            stage.show();
        }
    }
