package pacoteALUNO;
import pacoteALUNO.Aluno;
public class Executar {

	public static void main(String[] args) {
		Aluno primeiro = new Aluno();
		
		primeiro.setNota(10);
		primeiro.setNome("Joao");
		primeiro.setIdade(15);
		primeiro.setMatricula(232154);
		primeiro.Calcularmedia(12,4,10);
		primeiro.situacao(0);
		

	}

}
