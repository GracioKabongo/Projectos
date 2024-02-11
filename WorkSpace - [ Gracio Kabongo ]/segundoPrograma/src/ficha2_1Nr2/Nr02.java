package ficha2_1Nr2;
import java.util.Scanner;
public class Nr02 {
	public static void executar() {
		Scanner ler = new Scanner (System.in);
		System.out.println("Insira um nr: ");
		int num = ler.nextInt();
		int soma= 0;
		while(num!=0) {
			int digito = num%10;
			soma += digito;
			num = num/10;
		}
		System.out.println("A soma dos numeros digitados e: " + soma);
	}
	public static void main (String Args[]) {
		executar ();
	}
}

