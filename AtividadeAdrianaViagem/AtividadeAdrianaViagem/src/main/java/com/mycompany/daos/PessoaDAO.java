/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.daos;


import Conexao.Conexao;
import com.mycompany.models.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author larissa
 */
public class PessoaDAO {
    
    public void save(Pessoa pessoa){
        String sql = "INSERT INTO pessoa(nome, cpf, idade) VALUES (?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            conn = Conexao.createConnectionToMySQL();
            
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1,pessoa.getNome());
            pstm.setString(2, pessoa.getCpf());
            pstm.setLong(3, pessoa.getIdade());
            
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

    public List<Pessoa> getPessoas(){
		
		String sql = "SELECT * FROM pessoa";
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = Conexao.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				
				Pessoa pessoa = new Pessoa();
				
				pessoa.setNome(rset.getString("nome"));
				pessoa.setCpf(rset.getString("cpf"));
				pessoa.setIdade(rset.getLong("idade"));
				pessoas.add(pessoa);
				
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
                        System.out.println(pessoas);
			return pessoas;
	}
    
    public Pessoa getPessoabyName(String nome_pessoa){
		String sql = "SELECT * FROM pessoa where nome = ?";
				
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
                Pessoa pessoa = new Pessoa();

		try {
			conn = Conexao.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
                        pstm.setString(1,nome_pessoa);

			rset = pstm.executeQuery();
			
			if (rset.next()) {
				
				pessoa.setNome(rset.getString("nome"));
				pessoa.setCpf(rset.getString("cpf"));
				pessoa.setIdade(rset.getLong("idade"));
				
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
                        System.out.println(pessoa);
        return pessoa;
    }
    
    public Pessoa getPessoabyCpf(String cpf){
	
                String sql = "SELECT * FROM pessoa WHERE cpf = ?";
				
		Connection conn = null;
		PreparedStatement pstm = null;
		//Classe que vai recuperar os dados do banco. ***SELECT****
		ResultSet rset = null;
                Pessoa pessoa = new Pessoa();
		
		try {
			conn = Conexao.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
                        pstm.setString(1, cpf);			
			rset = pstm.executeQuery();
                        
			
                        if (rset.next()) {
				
				pessoa.setNome(rset.getString("nome"));
				pessoa.setCpf(rset.getString("cpf"));
				pessoa.setIdade(rset.getLong("idade"));
				                                
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
			return pessoa;
    }
    public Pessoa getLastPessoa(){
		String sql = "SELECT * FROM pessoa ORDER BY created_at DESC LIMIT 1";
				
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
                Pessoa pessoa = new Pessoa();

		try {
			conn = Conexao.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);

			rset = pstm.executeQuery();
			
			if (rset.next()) {
				
				pessoa.setNome(rset.getString("nome"));
				pessoa.setCpf(rset.getString("cpf"));
				pessoa.setIdade(rset.getLong("idade"));
				
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
        return pessoa;
    }
}

