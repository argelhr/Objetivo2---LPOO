package controller;

import model.*;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller {
    public static void main(String[] args) {

        //instanciando o vendedor
        Vendedor vendedor = new Vendedor(
                1,
                "JOÃO",
                "rua",
                "bairro",
                "cep",
                "pelotas",
                "RS",
                "sede1"
        );

        //instanciando o fornecedor e o produto
        Fornecedor f1 = new Fornecedor("123", "99999", "TIO JOÃO");
        Produto p1 = new Produto(
                1,
                "FEIJÃO",
                100,
                10,
                f1
        );
        Produto p2 = new Produto(
                2,
                "ARROZ",
                200,
                5,
                f1
        );

//      de acordo com o diagrama é necessario ter a classe produto no fornecedor
        f1.getProdutos().add(p1);
        f1.getProdutos().add(p2);

        //declarando o fornecimento(classe associativa) entre as classes de Fornecedor e Produto
        Fornecimento fornecimento = new Fornecimento(f1, p1);

        //questao b
        //realizando os pedidos, referentes a vendas na questao b
        Pedido pedido1 = new Pedido(1, vendedor);
        Pedido pedido2 = new Pedido(2, vendedor);


        //instanciando os objetos da classe Item que serão composição para o Pedido
        Item item1 = new Item(1, p1, 10, 0);
        Item item2 = new Item(2, p2, 20, 0);
        Item item3 = new Item(3, p2, 5, 1);

        //adicionando as instancia da classe Item no pedido1
        pedido1.adicionaItemPedido(item1);
        pedido1.adicionaItemPedido(item2);

        //adicionando as instancia da classe Item no pedido2;
        pedido2.adicionaItemPedido((item3));

        //questao b, salvando os pedidos em uma coleção
        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(pedido1);
        pedidos.add(pedido2);

        System.out.println("---------Itens vendidos de cada pedido--------------\n----------------");
        //questao b,numero 1
        //os itens vendidos de cada pedido
        pedidos.forEach(p -> {
            System.out.print("\npedido nº" + p.getNumero() + "\n----------------------------\n");

            //imprimindo os atributos das instancias de item que estão no atual pedido
            p.getItens().forEach(item -> {
                System.out.println("" +
                        "CodigoItem:" + item.getCodItem() + ", Nome:" + item.getProduto().getNome() +
                        ", Quantidade: " + item.getQuantidade() +
                        ", Total do item: " + NumberFormat.getCurrencyInstance().format(item.getValorTotal())
                );

            });
            System.out.println("===Total do pedido: " + NumberFormat.getCurrencyInstance().format(p.getValor()));
            System.out.println("===Status do pedido: " + p.getStatus());
            //questao b, numero 2
            System.out.println("===Vendedor: " + p.getVendedor().getNome());
            System.out.println("---");

        });
        //efetuando as vendas
        System.out.println("----------------------------------------------------------------");
        System.out.println("Estoque dos produtos antes de os pedidos serem ATENDIDOS");
        System.out.println("produto: " + p1.getNome() + ", Estoque: " + p1.getQuantidade());
        System.out.println("produto: " + p2.getNome() + ", Estoque: " + p2.getQuantidade());

        //pedido1 sendo atendido1
        System.out.println("\n*pedido 1 Atentido*\n");
        pedido1.efetuarVenda();

        //estoque atualizado dos produtos
        System.out.println("Estoque dos produtos depois do pedido1 ser ATENDIDO");
        System.out.println("produto: " + p1.getNome() + ", Estoque: " + p1.getQuantidade());
        System.out.println("produto: " + p2.getNome() + ", Estoque: " + p2.getQuantidade());

        //pedido 2 sendo ATENDIDO
        System.out.println("\n*pedido 2 Atentido*\n");
        pedido2.efetuarVenda();

        //estoque atualizado dos produtos
        System.out.println("Estoque dos produtos depois do pedido2 ser ATENDIDO");
        System.out.println("produto: " + p1.getNome() + ", Estoque: " + p1.getQuantidade());
        System.out.println("produto: " + p2.getNome() + ", Estoque: " + p2.getQuantidade());

        //imprimindo o relatorio de vendas
        System.out.println("\n______________________RELATORIO DE VENDAS_____________________");
        System.out.print("Valor total dos pedidos atendidos até o momento:");
        System.out.println(NumberFormat.getCurrencyInstance().format(pedidos.stream()
                        .filter(p -> p.getStatus() == Tipo.ATENDIDO)
                                .mapToDouble(Pedido::getValor)
                                        .sum()));
        System.out.println(pedidos);



    }
}
