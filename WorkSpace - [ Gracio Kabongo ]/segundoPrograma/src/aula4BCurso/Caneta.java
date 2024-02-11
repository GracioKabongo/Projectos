package aula4BCurso;
public class Caneta {
	private String modelo;
	private float ponta;
	public boolean tampada;
	public String cor;
	
	public Caneta(String m ,String c ,float p) {  //metodo construtor
		
		this.cor = c;
		this.modelo = m;
		this.setPonta(p);
		
		this.tampar();
		//this.cor = "Azul";
	}
	
	public String getModelo() {
		return this.modelo;
	}
	public void setModelo(String m) {
		this.modelo = m;
	}
	public float getPonta() {
		return this.ponta;
	}
	public void setPonta(float p) {
		this.ponta = p;
	}
	public void tampar() {
		this.tampada = true;
	}
	public void status () {
		System.out.println("Sobre a caneta:");
		System.out.println("Modelo: "+this.modelo);
		System.out.println("Ponta: "+this.ponta);
		
		System.out.println("Modelo: "+this.getModelo());
		System.out.println("Ponta:"+this.getPonta());
		System.out.println("Tampada: "+this.tampada);
	}
}
