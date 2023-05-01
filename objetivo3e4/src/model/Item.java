package model;

public class Item {
    private int codItem;
    private Produto produto;
    private int quantidade;
    //atribui quantidade como int para permanecer no mesmo tipo da classe Produto, pois estas quantidades possuem ligação
    private double desconto;
    private double valorTotal;



    public Item(int codItem, Produto produto, int quantidade, double desconto) {
        this.codItem = codItem;
        this.produto = produto;
        this.quantidade = quantidade;
        this.desconto = desconto;
        this.valorTotal = calculaSubTotal();
    }

    public Item() {
    }

    public int getCodItem() {
        return codItem;
    }

    public void setCodItem(int codItem) {
        this.codItem = codItem;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public double calculaSubTotal(){
        return  (this.quantidade * this.produto.getPreco()) * (1 - this.desconto / 100);
    }

    @Override
    public String toString() {
        return "Item{ " +
                "\n codItem=" + codItem +
                ",produto=" + produto.getNome() +
                ",quantidade=" + quantidade +
                ",desconto=" + desconto +
                ",valor=" + valorTotal +
                "}";
    }
}
