
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        String messagem, inFromServer;
        
        Socket clientSocket = new Socket("localhost", 6789);
        System.out.println("Estabelecendo Conexao....");
        
        Scanner inputFromUser = new Scanner(System.in);
        PrintWriter outputToServer = new PrintWriter(clientSocket.getOutputStream(),true);
        Scanner inputFromServer = new Scanner(clientSocket.getInputStream());
        while(true){
            System.out.print("Client: ");
            messagem = inputFromUser.nextLine();
            
            outputToServer.println(messagem);
            if(messagem.equals("**close**"))
                break;
            
            inFromServer = inputFromServer.nextLine();
            System.out.println("Server: "+inFromServer);
        }
        clientSocket.close();
    }
}
