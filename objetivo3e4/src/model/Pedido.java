package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static model.Tipo.ATENDIDO;
import static model.Tipo.CANCELADO;

public class Pedido {
    private final LocalDateTime dataPedido = LocalDateTime.now();
    private int numero;
    private LocalDateTime dataencerrado;
    private double valor;
    private Vendedor vendedor;
    private List<Item> itens = new ArrayList<>();
    private Tipo status;

    public Pedido(int numero, Vendedor vendedor) {
        this.numero = numero;
        this.vendedor = vendedor;
        this.status = Tipo.PENDENTE;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public Tipo getStatus() {
        return status;
    }

    public void setStatus(Tipo status) {
        this.status = status;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public LocalDateTime getDataencerrado() {
        return dataencerrado;
    }

    public void setDataencerrado(LocalDateTime dataencerrado) {
        this.dataencerrado = dataencerrado;
    }

    public double getValor() {
        return calculaTotal();
    }

    public void setValor() {
        this.valor = calculaTotal();
    }

    public double calculaTotal() {
        return itens.stream().mapToDouble(Item::calculaSubTotal).sum();
    }

    public void adicionaItemPedido(Item item) {
        this.getItens().add(item);
        this.valor = this.itens.stream().mapToDouble(Item::calculaSubTotal).sum();
    }

    public void efetuarVenda() throws EstoqueInsuficienteException {
        try {
            this.getItens().forEach(item -> {
                if (item.getProduto().getQuantidade() < item.getQuantidade()) {
                    throw new EstoqueInsuficienteException();
                }
            });
            this.status = ATENDIDO;
            this.dataencerrado = LocalDateTime.now();
            this.getItens().forEach(item -> {
                item.getProduto().decrementaEstoque(item.getQuantidade());
            });
        } catch (EstoqueInsuficienteException e) {
            System.out.println("Erro ao atender o pedido: "+ e.getMessage());
            System.out.println("cancelando pedido");
            this.status = Tipo.CANCELADO;
        }
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "numero=" + numero +
                ", dataPedido=" + dataPedido +
                ", dataencerrado=" + dataencerrado +
                ", valor=" + valor +
                ", vendedor=" + vendedor +
                ", itens=" + itens +
                ", status=" + status +
                '}';
    }
}
