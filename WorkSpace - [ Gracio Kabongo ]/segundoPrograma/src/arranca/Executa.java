package arranca;
import logica.Cliente;
import base.Conta;
public class Executa {
	public static void main(String[] args) {
		Cliente desonesto = new Cliente();
		desonesto.setId(1);
		desonesto.setNome("Joao");
		desonesto.setSexo("M"); 
		
		Cliente honesto = new Cliente();
		honesto.setId(2); 
		honesto.setNome("Maria");
		honesto.setSexo("F");
		
		Conta conta1 =new Conta();
		conta1.setId(123);
		conta1.setNome("CC");
		conta1.setSaldo(100);
		conta1.setCl(desonesto); 
		conta1.imprimirSaldo();
		
		Conta conta2 = new Conta();
		conta2.setId(1234); 
		conta2.setNome("CC");
		conta2.setSaldo(2000); 
		conta2.setCl(honesto);
		conta2.imprimirSaldo();
		
		conta1.setId(1234); //troca valores
		conta2.setId(123); //troca valores
		conta1.imprimirSaldo();
		conta2.imprimirSaldo();
		
	}
}
