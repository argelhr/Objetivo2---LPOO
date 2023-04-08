package model;

public class ContaCorrente extends Conta implements Associado {
    private int qtdDeCotas;
    private double valorCota;

    public ContaCorrente() {
        super();
    }

    public ContaCorrente(int identificador, double saldo, int qtdDeCotas, double valorCota) {
        super(identificador, saldo);
        this.qtdDeCotas = qtdDeCotas;
        this.valorCota = valorCota;
    }

    public ContaCorrente(int qtdDeCotas, double valorCota) {
        this.qtdDeCotas = qtdDeCotas;
        this.valorCota = valorCota;
    }

    @Override
    public int getQtdDeCotas() {
        return qtdDeCotas;
    }

    @Override
    public void setQtdDeCotas(int qtdDeCotas) {
        this.qtdDeCotas = qtdDeCotas;
    }

    @Override
    public double getValorCota() {
        return valorCota;
    }

    @Override
    public void setValorCota(double valorCota) {
        this.valorCota = valorCota;
    }

    @Override
    public double lucros(int qtdDeCotas, double valorCota) {
        return qtdDeCotas * valorCota - this.qtdDeCotas * this.valorCota;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "identificador=" + identificador +
                ", saldo=" + saldo +
                "qtdDeCotas=" + qtdDeCotas +
                ", valorCota=" + valorCota +
                "}" + "\n";
    }
}
