package model;

import java.time.LocalDate;

public class Fornecimento {
    private final LocalDate data = LocalDate.now();
    private int sequencial;
    private Fornecedor fornecedor;
    private Produto produto;
    //coloquei final, pois o atributo data já é iplementado assim que for criado a instancia deste fornecimento
    private double valorTotal;

    public Fornecimento(int sequencial, Fornecedor fornecedor, Produto produto) {
        this.sequencial = sequencial;
        this.fornecedor = fornecedor;
        this.produto = produto;
        this.valorTotal = produto.getPreco() * produto.getQuantidade();
    }

    public Fornecimento(int sequencial) {
        this.sequencial = sequencial;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public LocalDate getData() {
        return data;
    }

    public int getSequencial() {
        return sequencial;
    }

    public void setSequencial(int sequencial) {
        this.sequencial = sequencial;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void calculaTotalFornecimento(int quantidade) {
        this.valorTotal = this.produto.getPreco() * quantidade;
    }

    @Override
    public String toString() {
        return "Fornecimento{\n" +
                "fornecedor=" + fornecedor.getNome() +
                ", produto=" + produto.getNome() +
                ", data=" + data +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
