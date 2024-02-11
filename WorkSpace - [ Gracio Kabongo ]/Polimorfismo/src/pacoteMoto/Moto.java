package pacoteMoto;
import pacoteVeiculo.Veiculo;
public abstract class Moto extends Veiculo{
	public Moto(int velocidade) {
		super(velocidade);
	}
	
	public void acelerar() {
		setVelocidade(getVelocidade()+20);
	}
	
	public int frear () {
		return -10;
	}
	
}
