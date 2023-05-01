package model;

import java.time.LocalDate;
import java.util.Date;

public class Fornecimento {
    private Fornecedor fornecedor;
    private Produto produto;
    private LocalDate data = LocalDate.now();
//    private double valorTotal = produto.getPreco()*produto.getQuantidade();
    private double valorTotal;

    public Fornecimento(Fornecedor fornecedor, Produto produto) {
        this.fornecedor = fornecedor;
        this.produto = produto;
        this.valorTotal = getProduto().getPreco() * getProduto().getQuantidade();
    }

    public Fornecimento() {
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

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValorTotal() {
        return valorTotal;
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
