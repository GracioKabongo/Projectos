/**
 * 
 */
package aniversariante;
import java.util.Scanner;
/**
 * @author Gracio Kabongo
 *
 */
public class Pessoa {

	/**
	 * @param args
	 */
	public static void executar() {
		Scanner ler = new Scanner(System.in);
		System.out.println("Insira o seu id:");
		String id = ler.next();
		System.out.println("Insira o seu nome:");
		String nome = ler.next();
		System.out.println("Insira a sua idade:");
		int idade = ler.nextInt();
		int n = 0;
		do {
			System.out.println("--------   Completar anos  ---------");
			System.out.println("[1].Sim");
			System.out.println("[2].Nao");
			int x = ler.nextInt();
			switch (x) {
			case 1: idade += 1;break;
			case 2: System.out.println("Nome: "+nome);
			System.out.println("ID: "+id);
			System.out.println("Idade final: "+idade);;break;
			default : System.out.println("ERRO!");break;
			}
			System.out.println("Para terminar a operacao insira 1: ");
			System.out.println("Para continuar insira outro numero diferente de 1: ");
			n = ler.nextInt();
		}while(n!=1);
		System.out.println("FIM!");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		executar();
	}

}
