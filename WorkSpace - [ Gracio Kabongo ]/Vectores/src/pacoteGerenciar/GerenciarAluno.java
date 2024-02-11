package pacoteGerenciar;
import pacoteAluno.Aluno;
import java.util.Vector;

public class GerenciarAluno {
	public void listar(Vector V) {
		for (int i =0 ; i<V.size();i++) {
			System.out.println(V.elementAt(i));
		}
	}
	public void listarporTurma(Vector V, String turma) {
		for (int i =0 ; i<V.size();i++) {
			if (((Aluno)V.get(i)).getTurma().equals(turma)) {
				System.out.println(((Aluno)V.get(i)).getTurma());
			}
		}
	}
}
