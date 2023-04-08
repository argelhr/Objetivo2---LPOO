package model;

public class ContaPoupanca extends Conta {
    public ContaPoupanca() {
    }

    public ContaPoupanca(int identificador, double saldo) {
        super(identificador, saldo);
    }

    @Override
    public void saca(double valor) {
        if(this.saldo < valor)
            System.out.println("SALDO INDISPONIVVEL, em conta poupança não é possivel ter saldo negativo");
        else
            this.saldo -= valor;
        // contas poupanças nao permitem saldos negativos até onde sei
    }

    @Override
    public String toString() {
        return "ContaPoupanca{" +
                "identificador=" + identificador +
                ", saldo=" + saldo +
                "} "+"\n";
    }
}
