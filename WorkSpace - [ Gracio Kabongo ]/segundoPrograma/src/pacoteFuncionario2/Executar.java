package pacoteFuncionario2;
import pacoteFuncionario2.Funcionario2;
import pacoteFuncionario2.vendedor;
public class Executar {
	
	public static void main(String[] args) {
		Funcionario2 f = new Funcionario2("Qualquer","BI",1215156.0,200000.0);
		System.out.println(f.toString());
		vendedor V = new vendedor ("Jobless","Passaporte",50000106.0,500000.0,20000.0);
		System.out.println(V.toString());
	}
	
}
