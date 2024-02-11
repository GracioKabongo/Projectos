package pacoteArray;

public class Array {

	public static void main(String[] args) {
		int [] array = new int [5];
		
	}
	
	
	public static int buscaSequencialRecursiva(int[] array, int valor) {
	    return buscaSequencialRecursivaAux(array, valor, 0);
	}

	private static int buscaSequencialRecursivaAux(int[] array, int valor, int indice) {
	    if (indice >= array.length) return -1;
	    if (array[indice] == valor) return indice;
	    return buscaSequencialRecursivaAux(array, valor, indice + 1);
	}

}
