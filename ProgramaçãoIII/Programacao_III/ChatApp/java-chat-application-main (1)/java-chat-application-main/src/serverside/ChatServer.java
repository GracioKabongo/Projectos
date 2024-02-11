package serverside;

import util.ClientSocket;
import view.Chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ChatServer {

    public static final int PORT = 4400;
    private ServerSocket serverSocket;
    private List<ClientSocket> clients = new LinkedList<>();

    public void start() throws IOException {
        serverSocket = new ServerSocket(PORT);
        clientConnectionLoop();

    }


    // manter o server a espera de novas conexoes
    private void clientConnectionLoop() throws IOException {
        while (true) {
            ClientSocket clientSocket = new ClientSocket(serverSocket.accept());
            clients.add(clientSocket);
            new Thread(() -> {
                clientMsgLoop(clientSocket);
            }).start();
        }
    }

    // manter o server recebendo novas mensagens
    private void clientMsgLoop(ClientSocket clientSocket){
        String msg;

        try{
            while ((msg = clientSocket.getMessage()) != null){
                String sendToAll = String.format("%s: %s",System.getProperty("user.name"), msg ); //Identifica o nome do computador na conversação
                sendMsgToAll(clientSocket, sendToAll);

            }
        } finally {
            clientSocket.close();
        }
    }

    private void sendMsgToAll(ClientSocket sender, String msg){
        clients.forEach(client -> {
            if(!client.equals(sender))
                client.sendMeg(msg);
        });
    }



    public static void main(String[] args) {
        try {
            new ChatServer().start();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
