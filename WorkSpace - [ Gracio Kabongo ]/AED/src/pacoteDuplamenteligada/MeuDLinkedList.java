package pacoteDuplamenteligada;

public class MeuDLinkedList {
	class Node{
		int data;
		Node prev;
		Node next;
		
		public Node(int data, Node prev, Node next) {
			
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
		
		int tamanho;
		Node inicio;
		Node fim;
		
		
		// 1. Criacao de uma lista vazia
		public void MeuDLinkedList() {
			this.inicio = null;
			this.fim = null;
			this.tamanho = 0;
		}
		
		// 2. Mostrar o tamanho da lista
		public int size(){
			return this.tamanho;
		}
		
		// 3. Lista vazia 
		public boolean isEmpty() {
			return this.tamanho == 0 ;
		}
		
	}
}
