package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import client.*;
import transporte.Transportar;

public class Servidor_socket1 {
    private ServerSocket server;
    private static int porta = 4400;
    ArrayList<Transportar> clientes = new ArrayList<>(); 

    public void start() throws IOException {
        server = new ServerSocket(porta);
        System.out.println("Server conectado");
        conectarClientes();
    }

    public void conectarClientes() throws IOException {
        while (true) {
            Transportar trasportar = new Transportar(server.accept());
            clientes.add(trasportar);
            System.out.println("Cliente Conectado");
            new Thread(() -> {
                escutarMsg(trasportar);
            }).start();
        }
    }

    public void escutarMsg(Transportar transporte) {
        String msg;
        try {
            while ((msg = transporte.receberMsg()) != null) {
                System.out.println(msg);
                enviarTodos(transporte, "other: " + msg);
            }

        } finally {
            transporte.fechar();
        }

    }

    public void enviarTodos(Transportar origem, String msg) {
        for (Transportar destino : clientes) {
            if (!destino.equals(origem)) {
                destino.enviarMsg(msg);
            }
        }
    }

    public static void main(String[] args) {
        try {
            new Servidor_socket1().start();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}