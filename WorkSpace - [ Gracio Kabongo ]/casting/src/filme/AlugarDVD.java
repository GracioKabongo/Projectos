package filme;
import java.util.Vector;
public class AlugarDVD {
	private int numero;
	private String nome;
	private String genero;
	private int anoLancamento;
	
	public AlugarDVD(int numero, String nome, String genero, int anoLancamento) {
		this.numero = numero;
		this.nome = nome;
		this.genero = genero;
		this.anoLancamento = anoLancamento;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}
	
	public void listar() {}
	public void atualizarGenero() {}
	public void remover() {}
	public void inserir() {}
}
