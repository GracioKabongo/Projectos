package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketAddress;


public class ClientSocket {
    public final Socket socket;
    private final BufferedReader in;
    private final PrintWriter out;

    public ClientSocket(Socket socket) throws IOException {
        this.socket = socket;
        this.out = new PrintWriter(socket.getOutputStream(), true);
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public String getMessage(){
        try{
            return in.readLine();
        } catch (IOException e) {
            return null;
        }

    }



    public boolean sendMeg(String msg) {
        out.println(msg);
        return out.checkError(); // retorna falso se nao hover erro no envio da msg!
    }

    public SocketAddress getRemoteSocketAddress(){
        return this.socket.getRemoteSocketAddress();
    }

    public void close() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Erro ao fechar recursos do socket");
        }

    }

    @Override
    public String toString() {
        return "ClientSocket{" +
                "socket=" + socket +
                ", in=" + in +
                ", out=" + out +
                '}';
    }
}
