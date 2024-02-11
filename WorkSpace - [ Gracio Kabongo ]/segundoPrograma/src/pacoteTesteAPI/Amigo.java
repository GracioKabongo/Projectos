package pacoteTesteAPI;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import pacoteTesteAPI.Pessoa;
public class Amigo extends Pessoa{
	private Calendar agora;
	private Calendar dataAniversario;
public Amigo (String nome, String sexo,int idade,Calendar dataAniversario) {
	super(nome,sexo,idade);
	this.dataAniversario=dataAniversario;
}
	public Calendar getDataAniversario() {
		return dataAniversario;
	}
	public void data() {
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/mm/yyyy");
	}

	public Calendar getAgora() {
		return agora;
	}
	public void setAgora(Calendar agora) {
		this.agora = agora;
	}
	public void setDataAniversario(Calendar dataAniversario) {
		this.dataAniversario = dataAniversario;
	}
	public String toString() {
		return super.toString()+"Amigo [dataAniversario=" + dataAniversario + "]";
	}	
}
