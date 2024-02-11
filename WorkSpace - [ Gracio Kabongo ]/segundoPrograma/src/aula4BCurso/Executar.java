/**
 * 
 */
package aula4BCurso;

/**
 * @author Gracio Kabongo
 *
 */
public class Executar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Caneta c1 = new Caneta("NIC","Amarela",0.5f);
		
		c1.status();
		
		Caneta c2 = new Caneta("Lxkzm","Preta",1.5f);		
		c2.status();
		/*c1.setModelo("BIC");
		//c1.modelo = "BIC";
		
		c1.setPonta(0.5f);
		//c1.ponta = 0.5f;
		
		//c1.status();
		System.out.println("Tenho uma caneta "+ c1.getModelo()+" de ponta"+c1.getPonta());*/
	} 

}
 