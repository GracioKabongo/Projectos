package Clientes;

import java.io.Serializable;

public class DadosCliente implements Serializable{
    private String nome, morada, sexo;
    private int id, contacto;
    private float saldo;

    public DadosCliente(String nome, String morada, String sexo, int id, int contacto, float saldo) {
        this.nome = nome;
        this.morada = morada;
        this.sexo = sexo;
        this.id = id;
        this.contacto = contacto;
        this.saldo = saldo;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "DadosCliente{" + "nome=" + nome + ", morada=" + morada + ", sexo=" + sexo + ", id=" + id + ", contacto=" + contacto + ", saldo=" + saldo + '}';
    }
    
    
}
