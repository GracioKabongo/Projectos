/**
 * 
 */
package aniversariante2;

/**
 * @author Gracio Kabongo
 *
 */
public class Pessoa {
	int qtAni,id,idade;
	String nome;
	
	public void completarAnos(int idade) {
		idade +=1;
		qtAni++;
	}
	
	public String toString() {
		return "Pessoa [qtAni=" + qtAni + ", id=" + id + ", idade=" + idade + ", nome=" + nome + "]";
	}
	
	/*public int getQtAni() {
		return qtAni;
	}
	public void setQtAni(int qtAni) {
		this.qtAni = qtAni;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}*/
	
}
