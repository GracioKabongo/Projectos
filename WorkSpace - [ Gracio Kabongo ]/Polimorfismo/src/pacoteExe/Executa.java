package pacoteExe;
import pacoteVendedor.Vendedor;
import pacoteFuncionario.Funcionario;
import pacoteCalculaBonus.ControloBonus;
public class Executa {
	public static void main(String[] args) {
		ControloBonus c = new ControloBonus();
		Vendedor v = new Vendedor("Mateus",1321651651.0,20000000.0,25000.0);
		Vendedor v2 = new Vendedor("Gracio",12654884.0,50000000.0,50000.0);
	//	c.calculaBonus(v);
	//	c.calculaBonus(v2);
		
		System.out.println(c.toString());
	}
}
