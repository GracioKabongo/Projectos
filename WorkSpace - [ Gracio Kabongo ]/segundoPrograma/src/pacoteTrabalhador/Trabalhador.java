package pacoteTrabalhador;
import pacotePessoa.Pessoa;
public class Trabalhador {
	private String categoria;
	private String funcao;
	private Pessoa c1;
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public Pessoa getC1() {
		return c1;
	}
	public void setC1(Pessoa c1) {
		this.c1 = c1;
	}
	public void trabalhar() {}
	public void picarCartao() {}
}
