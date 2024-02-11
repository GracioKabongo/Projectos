package pacoteElectrodomestico;

public abstract class Electrodomestico {
	private String marca;
	private boolean estaLigado;
	
	public Electrodomestico(String marca, boolean estaLigado) {
		super();
		this.marca = marca;
		this.estaLigado = estaLigado;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public boolean isEstaLigado() {
		return estaLigado;
	}
	public void setEstaLigado(boolean estaLigado) {
		this.estaLigado = estaLigado;
	}
	public void ligar() {
	}
	public void desligar() {
		
	}
	
}
