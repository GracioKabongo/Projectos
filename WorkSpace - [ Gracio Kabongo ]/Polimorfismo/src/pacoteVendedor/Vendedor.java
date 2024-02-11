package pacoteVendedor;
import pacoteFuncionario.Funcionario;
public final class Vendedor extends Funcionario{
	private double comissaoVendas;
	private Funcionario x;
	
	public Funcionario getX() {
		return x;
	}
	public void setX(Funcionario x) {
		this.x = x;
	}
	public double getComissao() {
		return comissaoVendas;
	}
	public void setComissaoVendas(double comissaoVendas) {
		this.comissaoVendas = comissaoVendas;
	}
	
	public Vendedor (String nome,Double nrBI, Double salario,Double comissaoVendas) {
		super(nome,nrBI,salario);
		this.comissaoVendas = comissaoVendas;
	}
	public double bonus() {
		return salario*0.15;
	}
	public String toString() {
		return "Vendedor [comissao=" + comissaoVendas + "]";
	}
	
}
