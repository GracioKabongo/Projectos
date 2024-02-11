package principiosEncapsulamento;

public class Tempo {
	int hora;
	int minuto;
	public Tempo() {}
	
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	public int getMinuto() {
		return minuto;
	}
	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}
	public static void main(String[] args) {
		Tempo t = new Tempo();
		t.hora = 3;
		t.minuto =37;
		System.out.println("A hora e "+t.hora+": "+ t.minuto);
	}
}
