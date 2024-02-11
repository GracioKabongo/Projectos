package logica;

public class Cliente {
	private int id;
	private String nome,sexo;
	
	public int getId() {   //devolver valor
		return id;
	}
	public void setId(int id) {  // mudar valor
		this.id=id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome=nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo=sexo;
	}
	
}
