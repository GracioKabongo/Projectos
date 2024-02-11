package base;
//importar do package logica os dados do Cliente;
import logica.Cliente;

public class Conta {
	
	private int id;
	
	private String nome;
	
	private double saldo;
	
	//os dados da classe cliente fica no c1;
	private Cliente cl;
	
	
	public double Deposito(double valor) {
		if (valor>0) {
			return valor;
		}else{
			System.out.println("Tente denovo!");
			return 0;
		}
		
	}
	public void imprimirSaldo() {
		System.out.println("O saldo do "+id+" ficou "+ saldo);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome=nome;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo=saldo;
	}
	public Cliente getCl() {
		return cl;
	}
	public void setCl(Cliente cl) {
		this.cl=cl;
	}
}
