package tpcVendedorAdimin;
public class Administradores {
	private String nome;
	private double nrDoc;
	private double salario;
	private double horasExtras;
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
	public double getHorasExtras() {
		return horasExtras;
	}
	public void setHorasExtras(int horasExtras) {
		this.horasExtras = horasExtras;
	}
	public Administradores (String nome,double nrDoc,double salario,double horasExtras) {
		this.nome=nome;
		this.nrDoc= nrDoc;
		this.salario=salario;
		this.horasExtras = horasExtras;
	}
	
	public void calcualSalario () {
		double novoS =(salario/100)*horasExtras;
		salario = salario+novoS;
		System.out.println("O novo salario sera: "+ salario);
	}
	public String toString() {
		return "Administradores [nome=" + nome + ", numero de Documento=" + nrDoc + ", salario=" + salario + ", horasExtras="
				+ horasExtras + "]";
	}
	
	
}
