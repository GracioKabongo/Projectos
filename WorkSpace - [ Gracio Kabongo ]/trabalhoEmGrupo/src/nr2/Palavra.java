package nr2;

import java.util.*;

	public class Palavra{
		private String frase;
		private StringTokenizer tokenizer1;
		//Construtor
		public Palavra(String frase) {
			this.frase=frase;
			this.tokenizer1 = new StringTokenizer(this.frase," ");
		}
		
		public void PalavraCapitalizada(){
			//declaração da variável que armazenará os tokens
			String token; 
			
			//Captura e manipulação dos token
			while(tokenizer1.hasMoreTokens()){
				//Armazenamento do token capturado
				token=tokenizer1.nextToken();
				
				//Captura do primeiro caractere e transformação do mesmo em maiúscula
				char primeiroCaractere = Character.toUpperCase(token.charAt(0));
				
				//Junção do 
				token = primeiroCaractere + token.substring(1);
				
				//Resultado Final!!
				System.out.print(token+" ");
			}
		}
		

	public static void main(String[] args) {
		
		String frase = "instituto superior de transportes e comunicacoes";
        Palavra capitalizador = new Palavra(frase);
        capitalizador.PalavraCapitalizada();

	}
}
