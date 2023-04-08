package model;

public class Cliente implements Associado {
    public double valorCota;
    private String nome;
    private int qtdDeCotas;

    public Cliente() {
    }

    public Cliente(String nome, int qtdDeCotas, double valorCota) {
        this.nome = nome;
        this.qtdDeCotas = qtdDeCotas;
        this.valorCota = valorCota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int getQtdDeCotas() {
        return qtdDeCotas;
    }

    @Override
    public void setQtdDeCotas(int qtdDeCotas) {
        this.qtdDeCotas = qtdDeCotas;

    }

    @Override
    public double getValorCota() {
        return valorCota;
    }

    @Override
    public void setValorCota(double valorCota) {
        this.valorCota = valorCota;
    }

    @Override
    public double lucros(int qtdDeCotas, double valorCota) {
        return this.qtdDeCotas * this.valorCota - qtdDeCotas * valorCota;
        // estipulei que lucros fosse uma formula de valor atual do cliente em comparação
        // ao valor antigo que o cliente possuia
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + getNome() + '\'' +
                ", qtdDeCotas=" + getQtdDeCotas() +
                ", valorCota=" + getValorCota() +
                '}';
    }
}
