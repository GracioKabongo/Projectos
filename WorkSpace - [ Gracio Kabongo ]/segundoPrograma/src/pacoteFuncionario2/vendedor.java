package pacoteFuncionario2;
import pacoteFuncionario2.Funcionario2;
public class vendedor extends Funcionario2{
	private Funcionario2 x;
	private double comissao_vendas;
	public vendedor (String nome , String tipoDoc, Double nrDoc, Double salario, Double comissao_vendas) {
		super(nome,tipoDoc, nrDoc, salario); 
		this.comissao_vendas = comissao_vendas;
	}
	public double getComissao_vendas() {
		return comissao_vendas;
	}
	public void setComissao_vendas(double comissao_vendas) {
		this.comissao_vendas = comissao_vendas;
	}
	public String toString() {
		return super.toString()+" comissao_vendas"+comissao_vendas;
	}
	public void imprimir () {
		System.out.println(comissao_vendas);
	}
	public void imprimir (String msg) {
		System.out.println(msg+" "+comissao_vendas );
	}
}
