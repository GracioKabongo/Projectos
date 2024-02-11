package Armazem;

import java.io.Serializable;

public class DadosArmazem implements Serializable{
    private int numero;
    private String nome;

    public DadosArmazem(int numero, String nome) {
        this.numero = numero;
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "DadosArmazem{" + "numero=" + numero + ", nome=" + nome + '}';
    }
    
    
}
