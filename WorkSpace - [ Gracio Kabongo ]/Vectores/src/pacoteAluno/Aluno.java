package pacoteAluno;

public class Aluno {
	private String nome;
	private int Numero;
	private String Turma;
	
	public Aluno(String nome, int numero, String turma) {
		this.nome = nome;
		this.Numero = numero;
		this.Turma = turma;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return Numero;
	}

	public void setNumero(int numero) {
		Numero = numero;
	}

	public String getTurma() {
		return Turma;
	}

	public void setTurma(String turma) {
		Turma = turma;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", Numero=" + Numero + ", Turma=" + Turma + "]";
	}
	
	
}
