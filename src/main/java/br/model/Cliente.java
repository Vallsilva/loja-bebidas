package br.model;

import javax.persistence.*;

@Entity
@Table(name = "Clientes")
public class Cliente extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "Nome")
    private String nome;
    @Column(name = "Idade")
    private int idade;
    @Column(name = "CPF")
    private String cpf;

    public Cliente(String nome, int idade, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    public long getId(){
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    public void setCpf(String cpf){
        if(cpf.length()==11){
            this.cpf = cpf;
        } else {
            System.out.println("Valor inválido para CPF");
        }
    }

    public String getCpf(){
        return this.cpf;
    }

    @Override
    public String toString(){
        return "Cliente [id= " + id + "nome= " + nome + ", idade= " + idade + ", cpf= " + cpf;
    }
}
