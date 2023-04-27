package model;

public abstract class Conta {

    protected int identificador;
    protected double saldo;

    public Conta(int identificador, double saldo) {
        this.identificador = identificador;
        this.saldo = saldo;
    }

    public Conta() {
    }

    public int getIdentificador() {
        return identificador;
    }

    public double getSaldo() {
        return saldo;
    }

    public void deposita(double valor){
        this.saldo += valor;
    }
    public void saca(double valor){
        this.saldo -= valor;
        if(this.saldo <0){
            System.out.println("Cuidado, seu saldo está negativo");
            //alguns bancos permitem que alguns tipos de conta tenham saldo negativo e outros que não disponibilizam saque
        }
    }

    public void atualiza(double taxa){
        this.saldo *= (1+(taxa/100));
    }


}
