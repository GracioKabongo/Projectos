package tpc;



class LinkedList {
    class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    Node inicio;
    int tamanho;

    // 1. Criacao de uma Lista Vazia
    public LinkedList() {
        this.inicio = null;
        this.tamanho = 0;
    }

    // Contagem de elementos
    public int count() {
        return this.tamanho;
    }

    public boolean isEmpty() {
        return this.count() == 0;
    }

    // 2. Listagem de todos elementos da lista
    public void listAll() {
        if (this.count() == 0) {
            System.out.println("Lista Vazia");
        } else {
            // System.out.println(this.inicio.data);
            Node currentNode = this.inicio;
            System.out.print("[ ");
            while (currentNode != null) {
                System.out.print(currentNode.data + " ");
                currentNode = currentNode.next;
            }
            System.out.print("]");
        }
        System.out.println("");
    }

    // 3. Adicao de um elemento a lista
    public void add(int valor) {
        // Criamos o elemento na memoria sem fazer parte da
        // Lista Ligada
        Node newNode = new Node(valor, null);

        // Se a lista estiver vazia, o novo elemento
        // passa a ser o primeiro da lista
        if (this.count() == 0) {
            // inicio [newNode] -> null
            this.inicio = newNode;
        } else {
            // Percorremos toda lista ate encontrar um elemento
            // que nao tenha seguinte (next == null)
            Node currentNode = this.inicio;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            // O elemento actual (currentNode) é o último da lista
            // Agora, anexamos o novo elemento ao atributo next
            // [currentNode] -> [newNode] -> null
            currentNode.next = newNode;
        }

        this.tamanho++;
    }

    // 4. Adicao de um elemento no inicio da lista
    public void addFirst(int valor) {
        Node newNode = new Node(valor, null);
        // [newNode] -> inicio [node] -> ... resto da lista
        newNode.next = this.inicio;

        // inicio [newNode] -> [node] -> ... resto da lista
        this.inicio = newNode;
        this.tamanho++;
    }

    // 5. Adicao de um elemento no inicio da lista
    public void addLast(int valor) {
        this.add(valor);
    }

    // 6. Adicao de um elemento em posicao na lista
    public boolean addAt(int indice, int valor) {
        if (indice < 0 || indice > tamanho) {
            return false;
        }

        Node newNode = new Node(valor, null);

        // Neste método, queremos adicionar um nó entre dois nós na lista
        // Para tal, temos que percorrer a lista até ao nó imediatamente antes da
        // posição desejada
        Node currentNode = this.inicio;
        int contador = 0;
        while (currentNode.next != null && contador < indice - 1) {
            currentNode = currentNode.next;
            contador++;
        }
        // Neste momento: ... -> [currentNode] -> [node seguinte] -> ...

        // Fazemos com que o novo nó aponte para o nó a seguir ao currentNode
        // ... -> [newNode] -> [node seguinte] -> ...
        newNode.next = currentNode.next;

        // E com que o currentNode aponte para o newNode
        // Efectivamente introduzindo o newNode no meio, entre currentNode e node
        // seguinte
        // ... -> [currentNode] -> [newNode] -> [node seguinte] -> ...
        currentNode.next = newNode;

        this.tamanho++;
        return true;
    }

    // 7. Remover um elemento no fim da lista
    public boolean removeLast() {
        if (this.isEmpty() == true) {
            return false;
        } else {
            if (this.count() == 1) {
                this.inicio = null;
                this.tamanho--;
            } else {
                // Percorremos toda lista ate encontrar um elemento
                // que nao tenha seguinte (next == null)
                Node currentNode = this.inicio;
                int contador = 1;
                while (contador < this.count() - 1) {
                    currentNode = currentNode.next;
                    contador++;
                }
                currentNode.next = null;
                this.tamanho--;
            }
            return true;
        }
    }

    // 8. Remover elemento no inicio
    public boolean removeFirst() {
        if (this.isEmpty() == true) {
            return false;
        } else {
            this.inicio = this.inicio.next;
            this.tamanho--;
            return true;
        }

    }
    
   // 9. Existência do valor
    public boolean exists(int valor) {
        boolean found = false;
        if (this.isEmpty() == true) {
            return false;
        } else {
            Node currentNode = this.inicio;
            int contador = 0;

            while (currentNode != null && found == false) {
                if (currentNode.data == valor) {
                    found = true;
                } else {
                    currentNode = currentNode.next;
                    contador++;
                }
            }
        }
        return found;
       }
    
    // 10. 
    public int indexOf(int valor) {
        Node currentNode = this.inicio;
        int index = 0;
        while (currentNode != null) {
            if (currentNode.data == valor) {
                return index;
            }
            currentNode = currentNode.next;
            index++;
        }
        return -1; // retorna -1 caso o valor não seja encontrado na lista
    }
    
    // 11. sort 
    
    public void sort() {
        Node printNode = this.inicio;
        Vector printVector = new Vector<>();
        int contador = 0;
        while (printNode != null) {
            printVector.addElement(printNode.data);
            printNode = printNode.next;
            contador++;
        }
        boolean troca;
        do {
            troca = false;
            for (int i = 0; i < printVector.size() - 1; i++) {
                if ((Integer) printVector.elementAt(i) > (Integer) printVector.elementAt(i + 1)) {
                    int guarda = (Integer) printVector.elementAt(i);
                    printVector.set(i, printVector.elementAt(i + 1));
                    printVector.set(i + 1, guarda);
                    troca = true;
                }
            }
        } while (troca);
        System.out.println(printVector.toString());}
    
    // 12. removeAt
    public boolean removeAt(int index) {
        if (index < 0 || index >= tamanho) {
            return false;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == tamanho - 1) {
            return removeLast();
        } else {
            Node previousNode = inicio;
            int count = 0;
            while (count < index - 1) {
                previousNode = previousNode.next;
                count++;
            }
            previousNode.next = previousNode.next.next;
            tamanho--;
            return true;
        }
    }



    public static void main(String args[]) {
        // 1. Criacao
        LinkedList LL = new LinkedList();

        // Listagem inicial da lista
        LL.listAll();

        // Verificando se a lista está vazia
        System.out.println("isEmpty: " + LL.isEmpty());

        // Contagem de elementos presentes na lista
        System.out.println("count: " + LL.count());

        // 3. Adicao de um elemento a lista
        System.out.println("add(1)");
        LL.add(1);
        System.out.println("add(2)");
        LL.add(2);

        LL.listAll();

        // Adicao de um elemento no inicio lista
        System.out.println("addFirst(3): ");
        LL.addFirst(3);
        LL.listAll();

        // Adicao de um elemento no fim da lista
        System.out.println("addLast(4)");
        LL.addLast(4);
        LL.listAll();

        // Adicao de elementos em posicao
        System.out.println("addAt(-1,5): " + LL.addAt(-1, 5));
        System.out.println("addAt(1,5): " + LL.addAt(1, 5));
        LL.listAll();

        // 7. Remover um elemento no fim da lista
        System.out.println("removeLast: " + LL.removeLast());
        LL.listAll();

        // 8. Remover um elemento no inicio da lista
        System.out.println("removeFirst: " + LL.removeFirst());
        LL.listAll();
        System.out.println("count: " + LL.count());

        // Testes dos novos métodos aqui...
        
        LL.add(5);
        LL.add(10);
        LL.add(15);
        LL.add(20);

        System.out.println("A lista contém o valor 10? " + LL.exists(10)); // Deve imprimir true
        System.out.println("A lista contém o valor 25? " + LL.exists(25)); // Deve imprimir false

        System.out.println("O valor 10 está na posição " + LL.indexOf(10)); // Deve imprimir 1
        System.out.println("O valor 25 está na posição " + LL.indexOf(25)); // Deve imprimir -1
        
        LL.add(10);
        LL.add(20);
        LL.add(30);
        LL.add(40);
        LL.add(50);
        LL.listAll();
        int indexToRemove = 2; // índice do elemento a ser removido
        boolean removed = LL.removeAt(indexToRemove);
        LL.listAll();
    }
}
