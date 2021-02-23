package br.model;

public class Funcionario extends Pessoa {
    private String cargo;
    private double salario;
    private double meta;
    private int codigo=2;

    public Funcionario(){

        this.salario = salario;
        this.meta = 0.10*salario;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setSalario(double salario) {

    }
}
