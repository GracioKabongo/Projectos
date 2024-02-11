package tpcVendedorAdimin;

public class Vendedores {
	private String nome;
	private double nrDoc;
	private double salario;
	private double comissao_vendas;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getNrDoc() {
		return nrDoc;
	}
	public void setNrDoc(double nrDoc) {
		this.nrDoc = nrDoc;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public double getComissa_vendas() {
		return comissao_vendas;
	}
	public void setComissa_vendas(double comissa_vendas) {
		this.comissao_vendas = comissa_vendas;
	}
	public Vendedores (String nome,double nrDoc,double salario,double comissao_vendas) {
		this.nome=nome;
		this.nrDoc= nrDoc;
		this.salario=salario;
		this.comissao_vendas = comissao_vendas;
	}
	public void calculaSalario() {
		double percentagem = (comissao_vendas/0.05);
		salario += percentagem;
		System.out.println("O salario total sera: "+ salario);
	}
	public String toString() {
		return "Vendedores [Nome=" + nome + ", Numero do documento=" + nrDoc + ", salario=" + salario + ", comissao de vendas="
				+ comissao_vendas+"]";
	}
	

}
