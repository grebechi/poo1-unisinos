public class ContaCorrente extends ContaBancaria {
    public ContaCorrente(String nome, double valor){
        super(nome, valor);
    }
    @Override
    public void sacar(double valor){
        super.sacar(valor + 1);
    }
}
