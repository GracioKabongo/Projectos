package pacoteFuncionario;

public class Funcionario {
	private String nome;
	private double nrBI;
	protected double salario;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getNrBI() {
		return nrBI;
	}
	public void setNrBI(double nrBI) {
		this.nrBI = nrBI;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public Funcionario (String nome, Double nrBI,Double salario){
		this.nome = nome;
		this.nrBI = nrBI;
		this.salario = salario;
	}
	public double bonus() {
		return salario*0.10;
	}
	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", nrBI=" + nrBI + ", salario=" + salario + "]";
	}
	
}
