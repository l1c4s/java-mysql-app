package br.com.hotel;
import br.com.hotel.JanelaUser;
public class Main {
    public static void main(String[] args) {
        

        //Hospede hospede = new Hospede();
        JanelaUser janela = new JanelaUser();
       
        janela.setSize(700,600);
        janela.setResizable(false);
        janela.setVisible(true);
        
    }
}