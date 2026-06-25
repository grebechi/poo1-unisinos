import javax.swing.*;

public class ContaBancaria {
    private double saldo;
    private String titular;

    public ContaBancaria(){
        saldo = 0;
        titular = "Sem titular";
    }

    public ContaBancaria(String nome, double valor){
        saldo = valor;
        titular = nome;
    }

    public void depositar(double valor){
        saldo += valor;
    }
    public void sacar(double valor){
        if(valor >= saldo) JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
        else saldo -= valor;
    }

    public double getSaldo(){
        return saldo;
    }
    public String getTitular(){
        return titular;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setTitular(String nome) {
        titular = nome;
    }

    public boolean renderJuros() {
        return false;
    }
}
