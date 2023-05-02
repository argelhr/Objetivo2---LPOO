package controller;

import model.*;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
//        instanciando o gerente
        Gerente gerente = new Gerente(
                2,
                "ALEMÃO",
                "rua",
                "bairro",
                "cep",
                "pelotas",
                "sede1",
                "administração"
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
        Fornecimento fornecimento = new Fornecimento(1, f1, p1);

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
        //ou
        //System.out.println(pedidos);

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
        System.out.println("\n\n");
        System.out.println(pedidos);

        Fornecimento fornecimento2 = new Fornecimento(2);
        Fornecimento fornecimento3 = new Fornecimento(3);

        gerente.realizaCompra(1000, p1, fornecimento2);
        gerente.realizaCompra(2000, p2, fornecimento3);

        //Registre esses eventos em uma coleção
        List<Fornecimento> fornecimentos = new ArrayList<>();

        fornecimentos.add(fornecimento);
        fornecimentos.add(fornecimento2);
        fornecimentos.add(fornecimento3);

        //relatorio de fornecimentos
        System.out.println("----------------RELATORIO de fornecimento----------------");
        fornecimentos.forEach(fornc -> {
            System.out.println("---------------------");
            System.out.println("Fornecimento nº" + fornc.getSequencial());
            System.out.println("Fornecedor: " + fornc.getFornecedor().getNome());
            System.out.println("Produto: " + fornc.getProduto().getNome() + " - codigo: " + fornc.getProduto().getCodigo());
            double aux = fornc.getValorTotal() / fornc.getProduto().getPreco();//
            System.out.println("Quantidade: " + Math.round(aux));
            System.out.println("Data: "+ fornc.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            System.out.println("Preço unitario: " + NumberFormat.getCurrencyInstance().format(fornc.getProduto().getPreco()));
            System.out.println("Preço total: " + NumberFormat.getCurrencyInstance().format(aux * fornc.getProduto().getPreco()));
        });
        //ou
        //System.out.println(fornecimentos);

        System.out.println("\n====Total dos fornecimentos: " +
                NumberFormat.getCurrencyInstance()
                        .format(fornecimentos.stream().mapToDouble(Fornecimento::getValorTotal).sum()));

        System.out.println("----------------------------");

        ////////////////////////////////////////////////////////////////////////////////////////////

        //objetivo4
        // tentando realizar uma compra com quantidade maior que o estoque

        System.out.println("PEDIDO 4 ----------------------------------------------");
        //instanciando pedido
        Pedido pedido4 = new Pedido(4, vendedor);
        //instanciando item do pedido com quantidade acima do estoque do produto
        Item item4 = new Item(4, p1, 1100, 0);

        //adicionando item ao pedido
        pedido4.getItens().add(item4);
//        pedido4.getItens().add(item2);

        //adicionando o pedido4 no relatorio de vendas
        pedidos.add(pedido4);

        //verificando os item(s) do pedido 4 e a quantidade disponivel em estoque do produto que está em item
        pedido4.getItens().forEach(p -> {
            System.out.println("nome: " + p.getProduto().getNome());
            System.out.println("quantidade em estoque: " + p.getProduto().getQuantidade());
            System.out.println("quantidade solicitada: " + p.getQuantidade());
        });

        //efetuando o pedido
        pedido4.efetuarVenda();
        System.out.println("----------------------------------");
        System.out.println("pedido nº" + pedido4.getNumero());
        System.out.println("Itens do pedido:");
        pedido4.getItens().forEach(item -> {
            System.out.print("\n Item:" + item.getProduto().getNome() + ", Quantidade: " + item.getQuantidade());
            System.out.print(", Valor: " + NumberFormat.getCurrencyInstance().format(item.getValorTotal()));
        });
        System.out.println("\nStatus do pedido: " +  pedido4.getStatus());

        System.out.println("\n-------------------imprimindo novamente relatorio de vendas");
        System.out.println("Total de vendas: "+ NumberFormat.getCurrencyInstance()
                .format(pedidos.stream().filter(pedido -> pedido.getStatus() == Tipo.ATENDIDO)
                        .mapToDouble(Pedido::getValor).sum()));

    }
}
