package pacoteListaSequencial;

import java.util.Arrays;

public class ListaSequencial {
	   public int lista[];
	   private int tamanho;
	   

		// 1. Criacao
	    public ListaSequencial(int capacidade) {
	        this.lista = new int[capacidade];
	        this.tamanho = 0;
	    } 

	    // 2. Determinar o numero de elementos presentes na lista
	    public int count () {
	    	return this.tamanho;
	    }

	    // 3. Determinar se esta ou nao vazia
	    public boolean isEmpty() {
	    	return this.count() == 0;
	    }
	    public boolean isFull() {
	    	return this.count()==this.lista.length;
	    }

	    // 4. Listagem de todos elementos presentes na lista
	    public void listAll() {
	    	for (int i = 0; i < this.lista.length; i++) {
	    		if(this.lista[i] != 0) {
	    			System.out.print(this.lista[i] + " ");
	    		}
	        }
	    }

	    // 5. Adicionar um elemento à lista
	    public boolean add(int elemento){
	    	return addAt(elemento, this.tamanho);
	    	/*if (tamanho == lista.length) {
	            return false;
	        }
	        lista[tamanho] = elemento;
	        tamanho++;
	        return true;*/
	    }

	    // 6. Adicionar um elemento à lista em um indice especifico
	    public boolean addAt(int elemento, int indice){
	    	if (this.isFull()) {
	            return false;
	        }else {
	        	this.lista[indice] = elemento;
	        	tamanho++;
	        	return true;
	        }
	        
	        
	    }

	    // 7. Verificar se um elemento existe ou nao na lista
	    public boolean exists(int elemento) {
	    	for (int i = 0; i < this.lista.length; i++) {
	            if (this.lista[i] == elemento) {
	                return true;
	            }
	        }
	        return false;
	    }

	    // 8. Remover um elemento da lista
	    public boolean remove(int elemento){
	    	if (exists(elemento)) {
	    		for (int i = 0; i < this.lista.length; i++) {
	    	        if (this.lista[i] == elemento) {
	    	            return removeAt(i);
	    	        }
	    		}    
	    	}
	    	    return false;
	    }

	    // 9. Remover um elemento da lista de um indice especifico
	    public boolean removeAt(int indice){
	    	if(indice >= 0 && indice < this.lista.length) {
	    		this.lista[indice] = 0;
	    		this.tamanho--;
	    		return true;
	    	}else {
	    		return false;
	    	}
	    }

	    public static void main() {
	        // 1. Criacao de uma ListaSequencial
	        ListaSequencial LS = new ListaSequencial(5);

	        // 2. Retornar a contagem de elementos presentes na lista
	        System.out.println("count: "+LS.count());
	        
	        // 3. Determinacao se esta ou nao vazia
	        System.out.println("isEmpty "+LS.isEmpty());
	        System.out.println("isFull "+LS.isFull());
	        
	        // 4. Mostrar todos elementos da lista
	        LS.listAll();
	  
	        // 5. Adicionar um elemento à lista
	        System.out.println("Add " + LS.add(1));
	        LS.listAll();

	        // 6. Adicionar um elemento à lista em uma posição 
	        System.out.println("addAt: " + LS.addAt(2, 2));
	        LS.listAll();

	        // 7. Verificar a existencia de um elemento
	        // LS.exists(2);

	        // 8. Remover um elemento, se existir
	        // LS.remove(3);
	        // LS.remove(2);

	        // 9. Remover um elemento em um indice
	        // LS.removeAt(1)
	    }


	}

