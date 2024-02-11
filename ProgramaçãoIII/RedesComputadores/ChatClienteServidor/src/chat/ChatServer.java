
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {

    public static void main(String[] args) throws IOException {
        String entrada, saida;
        
        ServerSocket serverSocket = new ServerSocket(6789);
        
        Socket connectionSocket = serverSocket.accept();
        
        Scanner inFromClient = new Scanner(connectionSocket.getInputStream());
        PrintWriter outFromServer = new PrintWriter(connectionSocket.getOutputStream(),true);
        Scanner inFromServer = new Scanner(System.in);
        
        while (true) {
            entrada = inFromClient.nextLine();
            System.out.println("Cliente: "+entrada);
            
            if(entrada.equals("**Fechar**")){
                break;
            }
            
            System.out.print("Server: ");
            saida = inFromServer.nextLine();

            outFromServer.println(saida);
           
            //outFromServer.flush();
            
        }
        serverSocket.close();
    }
}
