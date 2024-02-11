package client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import transporte.Transportar;
import view.*;

public class Cliente {
	// a variavel vai guardar o ip do servidor
	private String ip_host = "192.168.208.246";
	private Transportar transporte;
	private int porta = 4400;
	private Tela_chat tela;

	// construtor da classe
	public Cliente(Tela_chat tela) {
		this.tela = tela;

	}

	public Cliente() {

	}

	public void criar_socket() throws UnknownHostException, IOException {// start
		transporte = new Transportar(new Socket(ip_host, porta));
		
        new Thread(() -> {
            String msg;
            while ((msg = transporte.receberMsg()) != null) {
                tela.mostrarmenssagem(msg);
            }
        }).start();
	}

	// metodo para enviar menssagem

	public void enviarmenssagem(String menssagem) {
		transporte.enviarMsg(menssagem);

	}

	public static void main(String[] args) {

		try {
			new Cliente().criar_socket();
		} catch (IOException e) {
		
		}

	}

}