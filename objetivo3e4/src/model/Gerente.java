package model;

import java.time.LocalDate;

public class Gerente extends Funcionario {
    private String formacao;

    public Gerente(int matricula, String nome, String endereco, String bairro, String cep, String cidade, String estado, String formacao) {
        super(matricula, nome, endereco, bairro, cep, cidade, estado);
        this.formacao = formacao;
    }
    public Gerente() {
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }
    public void realizaCompra(int quantidade, Produto produto,Fornecimento fornecimento){

        fornecimento.setProduto(produto);
        fornecimento.setFornecedor(produto.getFornecedor());
        fornecimento.calculaTotalFornecimento(quantidade);
        //data já é acrescentada na classe fornecimento

        produto.incrementaEstoque(quantidade);
    }

    @Override
    public String toString() {
        return "Gerente{" +
                "formacao='" + formacao + '\'' +
                "} " + super.toString();
    }

}
