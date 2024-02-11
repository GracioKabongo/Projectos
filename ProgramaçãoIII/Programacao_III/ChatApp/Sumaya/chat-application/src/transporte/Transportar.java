package transporte;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Transportar {
    
    private final Socket socket;
    private final BufferedReader in;
    private final PrintWriter out;

    public Transportar(Socket socket) throws IOException{
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(socket.getOutputStream());
    }

    public String receberMsg() {
        try {
            return in.readLine();
        } catch (Exception e) {
            return null;   
        }
        
    }

    public boolean enviarMsg(String msg) {
        out.println(msg);
        return out.checkError();
    }

    public void fechar() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("Erro ao fechar recusrsos do socket");
        }
    }

}

    

   
