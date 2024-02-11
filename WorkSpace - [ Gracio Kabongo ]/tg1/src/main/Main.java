package main;
import java.util.ArrayList;
import java.util.List;
public class Main {
	public static void main(String[] args) {
		List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Gerente("João", 5000));
        funcionarios.add(new Vendedor("Maria", 3000, 10000));
        funcionarios.add(new Atendente("José", 2000));
        
        Empresa empresa = new Empresa();
        double totalFolha = empresa.calcularFolhaPagamento(funcionarios);
        System.out.println("Total da folha de pagamento da empresa: MZN " + totalFolha);	        
	}
}


