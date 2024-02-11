package pacoteALUNO;

public class Aluno {
	private String nome;
	private int matricula;
	private double nota;
	private int idade;

	public double Calcularmedia( int nota1, int nota2, int nota3) {
		int soma = nota1+nota2+nota3;
		double media = soma / 3;
		return media;
	}
	public String situacao (double media) {
		if (media>=7) {
			return "Aprovado";
		}else {
			return "Reprovado";
		}
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome=nome;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula=matricula;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota=nota;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade=idade;
	}
}
