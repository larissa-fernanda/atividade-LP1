/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.daos;

import Conexao.Conexao;
import com.mycompany.models.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author larissa
 */
public class VeiculoDAO {

    public void save(Veiculo veiculo) {
        String sql = "INSERT INTO veiculo(modelo, placa, ano, cor) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = Conexao.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, veiculo.getModelo());
            pstm.setString(2, veiculo.getPlaca());
            pstm.setLong(3, veiculo.getAno());
            pstm.setString(4, veiculo.getCor());

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

    public List<Veiculo> getVeiculos() {
        String sql = "SELECT * FROM veiculo";

        List<Veiculo> veiculos = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = Conexao.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while (rset.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setModelo(rset.getString("modelo"));
                veiculo.setPlaca(rset.getString("placa"));
                veiculo.setAno(rset.getInt("ano"));
                veiculo.setCor(rset.getString("cor"));

                veiculos.add(veiculo);
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

        return veiculos;
    }

    public Veiculo getVeiculoByPlaca(String placa) {
        String sql = "SELECT * FROM veiculo WHERE placa = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        Veiculo veiculo = new Veiculo();

        try {
            conn = Conexao.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, placa);
            rset = pstm.executeQuery();

            if (rset.next()) {
                veiculo.setModelo(rset.getString("modelo"));
                veiculo.setPlaca(rset.getString("placa"));
                veiculo.setAno(rset.getInt("ano"));
                veiculo.setCor(rset.getString("cor"));
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
        return veiculo;
    }

    public Veiculo getVeiculoByModelo(String modelo) {
        String sql = "SELECT * FROM veiculo WHERE modelo = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        Veiculo veiculo = new Veiculo();

        try {
            conn = Conexao.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, modelo);
            rset = pstm.executeQuery();

            if (rset.next()) {
                veiculo.setModelo(rset.getString("modelo"));
                veiculo.setPlaca(rset.getString("placa"));
                veiculo.setAno(rset.getInt("ano"));
                veiculo.setCor(rset.getString("cor"));                                                                                                                                                                                                                                                          
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
        return veiculo;
    }
    public Veiculo getLastVeiculo(){
		String sql = "SELECT * FROM veiculo ORDER BY created_at DESC LIMIT 1";
				
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
                Veiculo veiculo = new Veiculo();

		try {
			conn = Conexao.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);

			rset = pstm.executeQuery();
			
			if (rset.next()) {
				
                            veiculo.setModelo(rset.getString("modelo"));
                            veiculo.setPlaca(rset.getString("placa"));
                            veiculo.setAno(rset.getInt("ano"));
                            veiculo.setCor(rset.getString("cor")); 
				
			}
		}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rset!=null) {
						rset.close();
					}
					
					if(pstm!=null) {
						pstm.close();
					}
					
					if(conn!=null) {
						conn.close();
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
        return veiculo;
    }
}
