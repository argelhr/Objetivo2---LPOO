package model;

public interface Associado {
    int getQtdDeCotas();
    void setQtdDeCotas(int qtdDeCotas);
    double getValorCota();
    void setValorCota(double valorCota);
    double lucros(int qtdDeCotas,double valorCota);
}
