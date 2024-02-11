package pacoteVeiculo;

public abstract class Veiculo {
	private int velocidade=0;
	
	public Veiculo(int velocidade) {
		this.velocidade = velocidade;
	}
	
	public abstract void acelerar();
	public abstract int frear ();
	
	public int getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}
	
}
