package br.model;


import javax.persistence.*;

@Entity
@Table(name = "Produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "preco")
    private double preco;
    @Column(name = "tamanho")
    private String tamanho;
    @Column(name = "estoque")
    private int estoque;


    public Produto(String nome, double preco, String tamanho, int estoque){
        this.nome = nome;
        this.preco = preco;
        this.tamanho = tamanho;
        this.estoque = estoque;

    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public String getTamanho() {
        return tamanho;
    }

    public long getId(){
        return id;
    }
}
