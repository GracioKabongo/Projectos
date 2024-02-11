package executarPessoa;
import pacotePessoa.Pessoa;
import pacoteEstudante.Estudante;
import pacoteTrabalhador.Trabalhador;
import java.util.Scanner;
public class Executar {
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		Estudante a = new Estudante();
		System.out.println("Insira o nome do estudante");
		
		//a.setCinoEscolar ();
		Trabalhador c = new Trabalhador();
		//c.setCategoria();
		c.setFuncao(null);
		//c.setC1();
	}
}
