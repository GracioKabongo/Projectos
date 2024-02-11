/**
 * 
 */
package ficha2_1Nr3;
import java.util.Scanner;
import java.util.Arrays;
/**
 * @author Gracio Kabongo
 *
 */
public class Nr3Array {

	/**
	 * @param args
	 */
	public static void executar() {
		Scanner ler = new Scanner (System.in);
		System.out.println("Quantos numeros ira inserir: ");
		int n = ler.nextInt();
		int V[] = new int[n];
		for (int i=0; i < V.length;i++) {
			System.out.println("Insira o "+(i+1)+"o nr: ");
			V[i]= ler.nextInt();
		}
		/*for (int i=0 ; i<V.length;i++) {
			System.out.print("{"+V[i]+"}");
		}*/
		Arrays.sort(V);
		for (int i=0 ; i<V.length;i++) {
			System.out.print("{"+V[i]+"}");
		}
		System.out.println("O segundo maior nr e: ");
		System.out.print(V[n]-2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		executar();
	}

}
