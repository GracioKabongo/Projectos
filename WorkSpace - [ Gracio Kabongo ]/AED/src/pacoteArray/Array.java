package pacoteArray;
import java.util.*;
public class Array {

	public static void main(String[] args) {
		int []v = new int [5];
		v [0]= 1;
		v [1]= 2;
		v [2]= 3;
		v [3]= 4;
		v [4]= 5;
		comparacao(v);
	}
	public static void comparacao (int v[]) {
		//int maior = v[0];
		int x=0,y=0;
		for(int i =0; i<v.length-1;i++) {
			if (v[i]<v[i+1]) {
				 x=+1;
			}else {
				 y=+1;
			}
			/*if(v[i]<maior) {
				System.out.println("A lista esta desordenada");
				break;
			}else {
				
			}
			System.out.println("A lista esta ordenada");
		    }*/
		
	}
		if (x > y) {
			System.out.println("Ordem crescente");
		}	
		else {
			System.out.println("Ordem decrescente");
		}
	}
}
