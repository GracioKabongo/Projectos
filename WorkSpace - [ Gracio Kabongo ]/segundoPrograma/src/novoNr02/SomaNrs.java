/**
 * 
 */
package novoNr02;
import java.util.Scanner;
/**
 * @author Gracio Kabongo
 *
 */
public class SomaNrs {
	public static void executar () {
		Scanner ler = new Scanner (System.in);
		System.out.println("Insira o primeiro nr: ");
		int a = ler.nextInt();
		System.out.println("Insira o segundo nr: ");
		int b = ler.nextInt();
		System.out.println("Insira o tercerio nr: ");
		int c = ler.nextInt();
		int soma = a + b + c; 
		System.out.println("A soma dos nrs e: "+ soma);
	}
	public static void main(String[] args) {
		executar();
	}
}
