package pacoteCarro;
import pacoteVeiculo.Veiculo;
public class Carro extends Veiculo {

	public Carro(int velocidade) {
		super(velocidade);
	}
	
	public void acelerar() {
		setVelocidade(getVelocidade()+20);
	}
	
	public int frear () {
		return -10;
	}
	
}
