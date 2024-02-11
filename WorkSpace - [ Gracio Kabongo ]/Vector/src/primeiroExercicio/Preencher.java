package primeiroExercicio;
import java.util.Scanner;
import primeiroExercicio.main;
public class Preencher {
	public void preencherVector() {
		Scanner ler = new Scanner (System.in);
		for (int i=0 ; i < V.length; i++) {
			System.out.println("Insira o "+ (i+1) +"o numero");
			int valor = ler.nextInt();
		}
	}
	
}
