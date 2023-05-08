/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.models;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author larissa
 */
public class Pessoa {
    private String nome;
    private String cpf;
    private long idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public long getIdade() {
        return idade;
    }

    public void setIdade(long idade) {
        this.idade = idade;
    }

    public void savePessoa(Pessoa pessoa, String nomeArquivo) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(nomeArquivo);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(pessoa);
        out.close();
        fileOut.close();
        System.out.printf("Pessoa salva no arquivo %s\n", nomeArquivo);
    }

    public Pessoa readPessoa(String nomeArquivo) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(nomeArquivo);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        Pessoa pessoa = (Pessoa) in.readObject();
        in.close();
        fileIn.close();
        return pessoa;
    }

}
