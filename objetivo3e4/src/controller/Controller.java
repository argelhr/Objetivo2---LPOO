package controller;

import model.Fornecedor;
import model.Produto;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    public static void main(String[] args) {
        Fornecedor f1 = new Fornecedor();
        Produto p1 = new Produto(1,"aaa",15,15,f1);

        List<Produto> produtos = new ArrayList<>();


        f1.getProdutos().add(p1);

        System.out.println(f1);
    }
}
