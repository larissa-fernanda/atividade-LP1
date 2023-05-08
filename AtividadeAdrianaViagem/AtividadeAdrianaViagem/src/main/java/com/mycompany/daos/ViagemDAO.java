/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.daos;

import Conexao.Conexao;
import com.mycompany.models.Viagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author larissa
 */
public class ViagemDAO {

    public void save(Viagem viagem) {
        String sql = "INSERT INTO viagem(nome_pessoa, cpf_pessoa, origem, destino, modelo_veiculo, placa_veiculo, data_partida, data_chegada) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = Conexao.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, viagem.getNome_pessoa());
            pstm.setString(2, viagem.getCpf_pessoa());
            pstm.setString(3, viagem.getOrigem());
            pstm.setString(4, viagem.getDestino());
            pstm.setString(5, viagem.getModelo_veiculo());
            pstm.setString(6, viagem.getPlaca_veiculo());
            pstm.setString(7, viagem.getDataPartida());
            pstm.setString(8, viagem.getDataChegada());

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Viagem> getViagens() {
        String sql = "SELECT * FROM viagem";

        List<Viagem> viagens = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = Conexao.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while (rset.next()) {
                Viagem viagem = new Viagem();
                viagem.setNome_pessoa(rset.getString("nome_pessoa"));
                viagem.setCpf_pessoa(rset.getString("cpf_pessoa"));
                viagem.setOrigem(rset.getString("origem"));
                viagem.setDestino(rset.getString("destino"));
                viagem.setModelo_veiculo(rset.getString("modelo_veiculo"));
                viagem.setPlaca_veiculo(rset.getString("placa_veiculo"));
                viagem.setDataPartida(rset.getString("data_partida"));
                viagem.setDataChegada(rset.getString("data_chegada"));

                viagens.add(viagem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }

                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return viagens;
    }

    public List<Viagem> getViagensByNomePessoa(String nome_pessoa) {
        String sql = "SELECT * FROM viagem WHERE nome_pessoa = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        List<Viagem> viagens = new ArrayList<>();

        try {
            conn = Conexao.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, nome_pessoa);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Viagem viagem = new Viagem();
                viagem.setNome_pessoa(rset.getString("nome_pessoa"));
                viagem.setCpf_pessoa(rset.getString("cpf_pessoa"));
                viagem.setOrigem(rset.getString("origem"));
                viagem.setDestino(rset.getString("destino"));
                viagem.setModelo_veiculo(rset.getString("modelo_veiculo"));
                viagem.setPlaca_veiculo(rset.getString("placa_veiculo"));
                viagem.setDataPartida(rset.getString("data_partida"));
                viagem.setDataChegada(rset.getString("data_chegada"));

                viagens.add(viagem);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return viagens;
    }

    public List<Viagem> getViagensByPlacaVeiculo(String placa_veiculo) {
        String sql = "SELECT * FROM viagem WHERE placa_veiculo = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        List<Viagem> viagens = new ArrayList<>();

        try {
            conn = Conexao.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, placa_veiculo);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Viagem viagem = new Viagem();
                viagem.setNome_pessoa(rset.getString("nome_pessoa"));
                viagem.setCpf_pessoa(rset.getString("cpf_pessoa"));
                viagem.setOrigem(rset.getString("origem"));
                viagem.setDestino(rset.getString("destino"));
                viagem.setModelo_veiculo(rset.getString("modelo_veiculo"));
                viagem.setPlaca_veiculo(rset.getString("placa_veiculo"));
                viagem.setDataPartida(rset.getString("data_partida"));
                viagem.setDataChegada(rset.getString("data_chegada"));

                viagens.add(viagem);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return viagens;
    }

    public Viagem getLastViagem() {
        String sql = "SELECT * FROM viagem ORDER BY created_at DESC LIMIT 1";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        Viagem viagem = new Viagem();

        try {
            conn = Conexao.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            if (rset.next()) {
                viagem.setNome_pessoa(rset.getString("nome_pessoa"));
                viagem.setCpf_pessoa(rset.getString("cpf_pessoa"));
                viagem.setOrigem(rset.getString("origem"));
                viagem.setDestino(rset.getString("destino"));
                viagem.setModelo_veiculo(rset.getString("modelo_veiculo"));
                viagem.setPlaca_veiculo(rset.getString("placa_veiculo"));
                viagem.setDataPartida(rset.getString("data_partida"));
                viagem.setDataChegada(rset.getString("data_chegada"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return viagem;
    }
}
