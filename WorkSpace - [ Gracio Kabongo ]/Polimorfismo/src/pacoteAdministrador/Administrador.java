package pacoteAdministrador;
import pacoteFuncionario.Funcionario;
public class Administrador extends Funcionario{
	private int horasExtras;
	private Funcionario x;
	
	public Funcionario getX() {
		return x;
	}

	public void setX(Funcionario x) {
		this.x = x;
	}

	public int getHorasExtras() {
		return horasExtras;
	}

	public void setHorasExtras(int horasExtras) {
		this.horasExtras = horasExtras;
	}
	public Administrador(String nome,Double nrBI, Double salario,int horasExtras) {
		super(nome,nrBI,salario);
		this.horasExtras = horasExtras;
	}
	public double bonus() {
		return salario*0.20;
	}
	public String toString() {
		return "Administrador [horasExtras=" + horasExtras + ", x=" + x + "]";
	}
	
}
