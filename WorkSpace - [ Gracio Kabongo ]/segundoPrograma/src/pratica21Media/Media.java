/**
 * 
 */
package pratica21Media;
import java.util.Scanner;
/**
 * @author Gracio Kabongo
 *
 */
public class Media {

	/**
	 * @param args
	 */
	
	public static void executar () {
		Scanner ler = new Scanner(System.in);
		double soma =0 ;
		double nr = 0;
		int i =0;
		int x =0;
		do { 
			System.out.println("Insira um nr: ");
			nr = ler.nextInt();
			soma += nr;
			System.out.println("Insira 1 para terminar a operacao e 0 para continuar: ");
			i = ler.nextInt();
			x += 1;
		}while (i==0);
		double media=0;
		media = soma/x;
		System.out.println("A media dos nrs e: "+ media);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		executar();
	}

}
