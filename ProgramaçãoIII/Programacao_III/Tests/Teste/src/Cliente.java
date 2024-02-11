
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {
    Scanner in=new Scanner (System.in);
    private String nome, morada,genero,tipo_conta;
    private int nr_conta,nr_telefone;





    // construtor

    public Cliente(String nome,String morada,int nr_conta,int nr_telefone){
        this.nome=nome;
        this.morada=morada;
        this.nr_conta=nr_conta;
        this.nr_telefone=nr_telefone;
    }




    public String getNome() {
        return nome;
    }




    public void setNome(String nome) {
        this.nome = nome;
    }




    public String getMorada() {
        return morada;
    }




    public void setMorada(String morada) {
        this.morada = morada;
    }




    public String getGenero() {
        return genero;
    }




    public void setGenero(String genero) {
        this.genero = genero;
    }




    public String getTipo_conta() {
        return tipo_conta;
    }




    public void setTipo_conta(String tipo_conta) {
        this.tipo_conta = tipo_conta;
    }




    public int getNr_conta() {
        return nr_conta;
    }




    public void setNr_conta(int nr_conta) {
        this.nr_conta = nr_conta;
    }




    public int getNr_telefone() {
        return nr_telefone;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    public void setNr_telefone(int nr_telefone) {
        this.nr_telefone = nr_telefone;
    }




}