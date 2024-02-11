package testeGPT;

import java.util.Scanner;

public class ChatGpt {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a quantidade de nomes a serem inseridos: ");
        int n = sc.nextInt();
        
        String[] nomes = new String[n];
        
        for (int i = 0; i < n; i++) {
            System.out.print("Digite o nome " + (i+1) + ": ");
            nomes[i] = sc.next();
        }
        
        System.out.println("Nomes invertidos:");
        for (int i = 0; i < n; i++) {
            String nomeInvertido = "";
            for (int j = nomes[i].length() - 1; j >= 0; j--) {
                nomeInvertido += nomes[i].charAt(j);
            }
            System.out.println(nomeInvertido);
        }
    }

}

