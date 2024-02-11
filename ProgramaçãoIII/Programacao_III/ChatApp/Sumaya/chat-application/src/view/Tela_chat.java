package view;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import client.*;

public class Tela_chat extends JFrame implements ActionListener {
	private JButton bt_enviar;
	private JTextArea ta_escrever, ta_menssagem;
	private Cliente cliente_intermediario;
	
	
	
	
	// cosntrutor da classe
	
	public Tela_chat() {
	 bt_enviar=new JButton("Enviar");
	 ta_escrever=new  JTextArea(4,45);
	 ta_menssagem=new  JTextArea(25,47);
	
	 cliente_intermediario=new  Cliente(this);
	  
	try {
		cliente_intermediario.criar_socket();
	} catch (IOException e) {
		JOptionPane.showConfirmDialog(this, e.getMessage());

	}
	 
	 
	 
	 //"setLineWrap(true);"- serve para criar quebra de linha ao escrever a menssagem
	 ta_escrever.setLineWrap(true);
	 
	 //
	 
	 ta_menssagem.setLineWrap(true);
	 

	 
	 
	 
	 // Atributos da frame
	  this.setSize(600,500);
	  this.setTitle("Tela de Chat");
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setLayout(new FlowLayout(FlowLayout.CENTER));
	  
	  
	  // adicionando componenetes a frame
	  
	  this.add(ta_menssagem);
	  this.add(ta_escrever);
	  this.add(bt_enviar);
	  
	  bt_enviar.addActionListener(this);

	  
	 this.setVisible(true);
	
	}
	
	// a classe teste
	
	public static void main(String[] args) {
		new Tela_chat();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	     if(e.getSource()==bt_enviar) {
			String escrever;

			if((escrever = ta_escrever.getText()).equals("")) return;

	    	cliente_intermediario.enviarmenssagem(escrever);
	    
	   	    ta_menssagem.setText(ta_menssagem.getText().concat("\n".concat("me: " + escrever)));
	   	    
	   	 	ta_escrever.setText("");
	    	
	     }
		
	}
	
	public void mostrarmenssagem(String menssagem) {
		 ta_menssagem.setText(ta_menssagem.getText().concat("\n" + menssagem));
		
	}
	

}