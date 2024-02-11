/**
 * 
 */
package exercicio03;
import java.util.Scanner;

/**
 * @author Gracio Kabongo
 *
 */
public class Funcionario {
	
	/**
	 * @param args
	 */
	public static void executar () {
		Scanner ler = new Scanner (System.in);
		System.out.println("Nome: ");
		String nome = ler.next();
		System.out.println("salario: ");
		double salario = ler.nextDouble();
		System.out.println("Digite o aumento salarial %");
		double aumento = ler.nextDouble();
		double novoSalario = salario + (salario*(aumento/100));
		System.out.println("O funcionario "+ nome +", cujo o salario era "+salario+" passa a receber "+novoSalario);
		
	}
	public static void main(String[] args) {
		executar();
	}
}
