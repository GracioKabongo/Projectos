package Produtos;

import java.io.Serializable;

public class DadosProdutos implements Serializable {
    private String nome, fornecedor;
    private int numero, quantidade, stock;
    private float preco;
    private int dia, mes, armazem;
    private String ano;

    public DadosProdutos(String nome, String fornecedor, int numero, int armazem, int quantidade, int stock, float preco, int dia, int mes, String ano) {
        this.nome = nome;
        this.fornecedor = fornecedor;
        this.numero = numero;
        this.armazem = armazem;
        this.quantidade = quantidade;
        this.stock = stock;
        this.preco = preco;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "DadosProdutos{" + "nome=" + nome + ", fornecedor=" + fornecedor + ", numero=" + numero + ", armazem=" + armazem + ", quantidade=" + quantidade + ", stock=" + stock + ", preco=" + preco + ", dia=" + dia + ", mes=" + mes + ", ano=" + ano + '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getArmazem() {
        return armazem;
    }

    public void setArmazem(int armazem) {
        this.armazem = armazem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
    

    
    
}
