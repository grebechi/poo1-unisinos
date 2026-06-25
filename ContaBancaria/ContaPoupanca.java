public class ContaPoupanca extends ContaBancaria{
    public ContaPoupanca(String nome, double valor) {
        super(nome, valor);
    }

    @Override
    public boolean renderJuros(){
        setSaldo(getSaldo() * 1.01);
        return true;
    }
}
