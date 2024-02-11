package nlskjfnl;

import java.util.Scanner;

public class Soma {

	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		double campo=0;
		double distancia=input.nextDouble();
		double carga=1.6*Math.pow(10, -19);
		campo=(9* Math.pow(10,9)*carga)/Math.pow(distancia,2);
		System.out.println(campo);
	

	}


}
