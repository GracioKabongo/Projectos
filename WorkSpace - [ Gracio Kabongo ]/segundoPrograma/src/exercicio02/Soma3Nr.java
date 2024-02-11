package exercicio02;
import java.util.Scanner;
public class Soma3Nr {
	public static void main(String[] args) {
		Scanner ler = new Scanner (System.in);
		System.out.println("Insira o primeiro nr: ");
		int a = ler.nextInt();
		System.out.println("Insira o segundo nr: ");
		int b = ler.nextInt();
		System.out.println("Insira o terceiro nr: ");
		int c = ler.nextInt();
		int soma = a+b+c;
		System.out.println("A soma dos nrs e: "+soma);
	}
}
