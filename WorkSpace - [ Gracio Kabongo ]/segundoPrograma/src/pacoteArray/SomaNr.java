package pacoteArray;
import java.util.Scanner;
public class SomaNr {
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		System.out.println("Insira dois numeros: ");
		int a = ler.nextInt();
		int b = ler.nextInt();
		comparacao(a,b);
	}
	public static void comparacao (int a , int b) {
		if (a>b) {
			System.out.println(a+" e maior que "+b);
		}
		else if (a<b) {
			System.out.println(b+" e maior que "+ a);
		}
		else {
			System.out.println(a+ " e igual a "+ b);
		}
	}
}
