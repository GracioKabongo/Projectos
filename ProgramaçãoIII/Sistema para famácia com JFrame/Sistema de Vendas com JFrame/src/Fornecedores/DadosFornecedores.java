package Fornecedores;

import java.io.Serializable;

public class DadosFornecedores implements Serializable{
    private int codigo, nuit;
    private String nome;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNuit() {
        return nuit;
    }

    public void setNuit(int nuit) {
        this.nuit = nuit;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "DadosFornecedores{" + "codigo=" + codigo + ", nuit=" + nuit + ", nome=" + nome + '}';
    }

    public DadosFornecedores(int codigo, int nuit, String nome) {
        this.codigo = codigo;
        this.nuit = nuit;
        this.nome = nome;
    }
    
    
}
