package controller;

import model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmpresaController {
    public static void main(String[] args) {

//      System.out.println("letra A");

        Conta poupanca1 = new ContaPoupanca(1, 500);
        Conta poupanca2 = new ContaPoupanca(2, 100);
        Conta poupanca3 = new ContaPoupanca(3, 2000);

        ContaCorrente corrente1 = new ContaCorrente(100, 800, 24, 15);
        ContaCorrente corrente2 = new ContaCorrente(101, 20, 25, 15);
        ContaCorrente corrente3 = new ContaCorrente(102, 2000, 22, 15);

        Cliente cliente1 = new Cliente("Lobo", 500, 15);
        Cliente cliente2 = new Cliente("GOLFINHO", 200, 15);
        Cliente cliente3 = new Cliente("Leão", 100, 15);

        System.out.println("Contas poupanças");
        System.out.println(poupanca1 + "" + poupanca2 + "" + poupanca3 + "-------------------------");
        System.out.println("Contas correntes");
        System.out.println(corrente1 + "" + corrente2 + "" + corrente3 + "-------------------------");
        System.out.println("clientes associados");
        System.out.println(cliente1 + "" + cliente2 + "" + cliente3 + "-------------------------");

//      letra c-------------------------------------------

        List<Conta> contas = new ArrayList<>();
        //contas poupanças
        contas.add(poupanca1);
        contas.add(poupanca2);
        contas.add(poupanca3);
        //contas correntes
        contas.add(corrente1);
        contas.add(corrente2);
        contas.add(corrente3);

        List<Associado> associados = new ArrayList<>();
        //contas correntes
        associados.add(corrente1);
        associados.add(corrente2);
        associados.add(corrente3);
        //clientes
        associados.add(cliente1);
        associados.add(cliente2);
        associados.add(cliente3);

        System.out.println("\nColeção das contas poupança e correntes");
        System.out.println(contas);

        System.out.println("\nColeção dos associados");
        System.out.println(associados);

//      letra c-------------------------------------------

        System.out.println("\nOperando contas-------------------------------------------------------------");

        System.out.println("\nantes das operações de deposito, atualização monetaria, e saque em uma conta poupanca");
        System.out.println(poupanca1);
        System.out.println("deposito de 1000");
        poupanca1.deposita(1000);
        System.out.print(poupanca1);
        poupanca1.atualiza(5);
        System.out.println("atualização monetaria de 5%");
        System.out.println(poupanca1);
        poupanca1.saca(50);
        System.out.println("saque de 50");
        System.out.println(poupanca1);
        System.out.print("-------------------------");

//      LETRA D
        System.out.println("Conta corrente antes do deposito e saque");
        System.out.print(corrente1);

        System.out.println("deposito de 500");
        corrente1.deposita(500);
        System.out.print(corrente1);

        System.out.println("saque de 400");
        corrente1.saca(400);
        System.out.println(corrente1);

        System.out.println("_______________");

//      letra e
        corrente1.setQtdDeCotas(100);
        corrente2.setQtdDeCotas(400);
        corrente3.setQtdDeCotas(600);
        cliente1.setQtdDeCotas(300);
        cliente2.setQtdDeCotas(600);
        cliente3.setQtdDeCotas(600);

//      letra f
        System.out.println("imprimindo associados na ordem que foram incluidos na lista");
        System.out.println(associados);
        associados.sort(Comparator.comparing(Associado::getQtdDeCotas).reversed());
        System.out.println("\n--------------");
        System.out.println("Associados ordenados da maior quantidade para a menor quantidade de cotas");
        System.out.println(associados);

        //maior quantidade de cotas
        System.out.println("associados que possuem a maior quantidade");
        Associado maiorQTD = Collections.max(associados, Comparator.comparing(Associado::getQtdDeCotas));
        associados.forEach(associado -> {
            if (associado.getQtdDeCotas() >= maiorQTD.getQtdDeCotas())
                System.out.print(associado);
        });

//      letra g

//      contas do sistema
        System.out.println("Contas cadastradas no sistema na ordem que foram armazenadas");
        System.out.println(contas);

        System.out.println("ASSOCIADOS QUE POSSUEM CONTAS CORRENTES");

//        retirado para correção, tinha implementado desta forma pensando que seria um filtro a mais pra imprimir
//        as instancias que tinha solicitado, mas eu entendi o ponto que salientou

//        associados.forEach(associado -> {
//            if(associado instanceof Associado && associado instanceof ContaCorrente) {
//                System.out.print(associado);
//            }
//        });

//      versao correta
        associados.forEach(associado -> {
            if(associado instanceof ContaCorrente) {
                System.out.print(associado);
            }
        });

        System.out.println("\nContas ordenadas pelo saldo maior ao menor");
        contas.sort(Comparator.comparing(Conta::getSaldo).reversed());
        System.out.println(contas);

        //acresentado a parte que imprimi as contas com os saldos maiores
        Conta maiorSaldo = Collections.max(contas, Comparator.comparing(Conta::getSaldo));

        System.out.println("\nContas que possuem os maiores saldos dentro da coleção");
        contas.forEach(conta -> {
            if(conta.getSaldo() >= maiorSaldo.getSaldo())
                System.out.print(conta);
        });
    }

}
