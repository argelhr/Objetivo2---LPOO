package model;

public class EstoqueInsuficienteException extends RuntimeException{
    public EstoqueInsuficienteException(){
        super("Erro, estoque insuficiente");
    }
}
