/**
 * 
 */
package aniversariante2;
import java.util.Scanner;
/**
 * @author Gracio Kabongo
 *
 */
public class Executa {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ler = new Scanner (System.in);
		Pessoa p1 = new Pessoa();
		System.out.println("id: ");
		p1.id = ler.nextInt();
		System.out.println("nome: ");
		p1.nome = ler.next();
		System.out.println("Idade: ");
		p1.idade = ler.nextInt();
		System.out.println("Insira 1 para completar anos, 0 para terminar");
		//completarAnos();
		//compl
		
	}
}
