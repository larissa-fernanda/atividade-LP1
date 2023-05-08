/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.daos;


import Conexao.Conexao;
import com.mycompany.models.Lugar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author larissa
 */
public class LugarDAO {
    
    public void save(Lugar lugar){
        String sql = "INSERT INTO lugar(nome, endereco) VALUES (?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            conn = Conexao.createConnectionToMySQL();
            
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1,lugar.getNome());
            pstm.setString(2, lugar.getEndereco());
            
            pstm.execute();
        }
        catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        
    }

    public List<Lugar> getLugares(){
		
		String sql = "SELECT * FROM lugar";
		
		List<Lugar> lugares = new ArrayList<Lugar>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = Conexao.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				
				Lugar lugar = new Lugar();
				
				lugar.setNome(rset.getString("nome"));
				lugar.setEndereco(rset.getString("endereco"));
				lugares.add(lugar);
				
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
                        System.out.println(lugares);
			return lugares;
	}

    public Lugar getLugarbyName(String nome_lugar){
		String sql = "SELECT * FROM lugar where nome = ?";
				
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
                Lugar lugar = new Lugar();

		try {
			conn = Conexao.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
                        pstm.setString(1,nome_lugar);

			rset = pstm.executeQuery();
			
			if (rset.next()) {
				
				lugar.setNome(rset.getString("nome"));
				lugar.setEndereco(rset.getString("endereco"));
				
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
                        System.out.println(lugar);
        return lugar;
    }
    
    public Lugar getLugarbyEndereco(String endereco){
	
                String sql = "SELECT * FROM lugar WHERE endereco = ?";
				
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
                Lugar lugar = new Lugar();
		
		try {
			conn = Conexao.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
                        pstm.setString(1, endereco);			
			rset = pstm.executeQuery();
                        
			
                        if (rset.next()) {
				
				lugar.setNome(rset.getString("nome"));
				lugar.setEndereco(rset.getString("endereco"));
				                                
			} else {
                            return null;
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
			return lugar;
    }
    public Lugar getLastLugar(){
		String sql = "SELECT * FROM lugar ORDER BY created_at DESC LIMIT 1";
				
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
                Lugar lugar = new Lugar();

		try {
			conn = Conexao.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);

			rset = pstm.executeQuery();
			
			if (rset.next()) {
				
				lugar.setNome(rset.getString("nome"));
				lugar.setEndereco(rset.getString("endereco"));
				
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
        return lugar;
    }
}
