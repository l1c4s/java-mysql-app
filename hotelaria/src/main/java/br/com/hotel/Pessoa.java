package br.com.hotel;

import java.util.Date;
import javax.swing.JOptionPane;

public class Pessoa {

    
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private Date data_Nasc;

    
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }

    public void setCpf(String cpf){
        if(cpf.length()!=11){
            JOptionPane.showMessageDialog(null, 
        "CPF inválido! Deve conter exatamente 11 dígitos numéricos.", 
        "Erro", 
        JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
        else{
            this.cpf = cpf;}
    }
    public String getCpf(){
        return cpf;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    public String getTelefone(){
        return telefone;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }

    public void setDataNasc(Date data_Nasc){
        this.data_Nasc = data_Nasc;
    }
    public Date getDataNasc(){
        return data_Nasc;
    } 
    
}
