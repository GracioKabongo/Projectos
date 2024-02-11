package exercicioFicha;
public class Aluno {
	private String nome;
	private int nr;
	private String turma;
	
	public Aluno (String nome, int nr, String turma) {
		this.nome = nome;
		this.nr = nr;
		this.turma = turma;
	}
	
	public String getNome () {
		return nome;
	}
	public void setNome (String nome) {
		this.nome = nome;
	}
	public int getNr() {
		return nr;
	}
	public void setNr(int nr) {
		this.nr = nr;
	}
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	
	
	public String toString() {
		return "Aluno [nome=" + nome + ", nr=" + nr + ", turma=" + turma + "]" + "\n";
	}
	
	
	
}
