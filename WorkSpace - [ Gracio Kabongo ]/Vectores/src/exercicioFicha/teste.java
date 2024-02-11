package exercicioFicha;
import exercicioFicha.Aluno;
import java.util.*;
@SuppressWarnings("unused")
public class teste {

	public static void main(String[] args) {
		
		Vector v = new Vector ();
		
		
		Aluno a = new Aluno("Shelton", 6659, "LECC21");
		Aluno b = new Aluno ("Gracio", 6254, "LECC21");
		Aluno c = new Aluno ("Mauro", 6669, "LECC21");
		
		v.add(a);
		v.add(b);
		v.add(c);
		
		System.out.println(v.toString());
		
		v.insertElementAt(a, 0);
		v.insertElementAt(b, 1);
		v.insertElementAt(c, 2);
		
		System.out.println(v.toString());
		
	}

}
