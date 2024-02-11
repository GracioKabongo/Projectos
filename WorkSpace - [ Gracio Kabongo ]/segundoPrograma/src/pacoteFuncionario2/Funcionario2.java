package pacoteFuncionario2;

public class Funcionario2 {
	private String nome;
	private String tipoDoc;
	private double nrDoc;
	private double salario;
	
	public Funcionario2(String nome , String tipoDoc, Double nrDoc, Double salario) {
		this.nome = nome; 
		this.tipoDoc = tipoDoc;
		this.nrDoc = nrDoc;
		this.salario = salario;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
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
	
	public String toString() {
		return "Funcionario2 nome=" + nome + ", tipoDoc=" + tipoDoc + ", nrDoc=" + nrDoc + ", salario=" + salario;
	}
	
	
}
