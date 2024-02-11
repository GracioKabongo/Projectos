package tpcVendedorAdimin;
import tpcVendedorAdimin.Vendedores;
import tpcVendedorAdimin.Administradores;
public class Executar {
	public static void main(String[] args) {
		Vendedores x = new Vendedores("Mateus",1254365449.0,20000.0,50000);
		System.out.println(x.toString());
		x.calculaSalario();
		Administradores V = new Administradores ("Maria", 84654465123.0,50000.0,12.0);
		System.out.println(V.toString());
		V.calcualSalario();
	}
}
