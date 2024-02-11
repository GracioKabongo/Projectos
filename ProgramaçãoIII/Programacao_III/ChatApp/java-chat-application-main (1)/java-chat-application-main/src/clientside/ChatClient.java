package clientside;

import serverside.ChatServer;
import util.ClientSocket;
import view.Chat;

import javax.swing.*;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;

public class ChatClient{

    private String HOST = "127.0.0.1";
    private ClientSocket clientSocket;
    private Scanner sc;
    private  Chat chat;


    {
        sc = new Scanner(System.in);
    }

    public ChatClient(Chat chat, String host) {
        this.chat = chat;
        this.HOST = host;
    }

    public void start() throws IOException {
        clientSocket = new ClientSocket(new Socket(HOST, ChatServer.PORT));
        new Thread(() -> {
            String msg;
            while ((msg = clientSocket.getMessage()) != null){
                chat.showMsg(msg);
            }
        }).start();

    }

    public void sendMsg(String msg){
        clientSocket.sendMeg(msg);
    }


    public void closeConection() {
        try {
            clientSocket.socket.close();
        } catch (IOException e) {

        }
    }


    public boolean isClosed(){
        return clientSocket.socket.isClosed();
    }
}
