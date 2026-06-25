import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Objects;

public class Main {
    static int escolha1(){
        String[] opcoesIniciais = {"Abrir conta", "Acessar conta"};
        return JOptionPane.showOptionDialog(
                null,
                "O que deseja fazer?",
                "BancoPH",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoesIniciais,
                opcoesIniciais[0]
        );
    }

    public static void main(String[] args) {
        ArrayList<ContaBancaria> contas = new ArrayList<>();
        while (true) {
            int escolha = escolha1();

            if (escolha == 0) {
                String[] opcoesAbrir = {"Conta Bancaria", "Conta Corrente", "Conta Poupança"};
                int qualConta = JOptionPane.showOptionDialog(
                        null,
                        "Que tipo de conta?",
                        "Abrir conta",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opcoesAbrir,
                        opcoesAbrir[0]
                );
                ContaBancaria novaConta = null;
                String nome = JOptionPane.showInputDialog("Insira o titular:");
                    if (nome.isEmpty()) JOptionPane.showMessageDialog(null,"Titular inválido");
                switch (qualConta) {
                    case 0 -> {
                        novaConta = new ContaBancaria(nome, 0);
                        contas.add(novaConta);
                    }
                    case 1 -> {
                        novaConta = new ContaCorrente(nome, 0);
                        contas.add(novaConta);
                    }
                    case 2 -> {
                        novaConta = new ContaPoupanca(nome, 0);
                        contas.add(novaConta);
                    }
                }
            }
            if (escolha == 1) {
                String user = JOptionPane.showInputDialog("Titular:");
                boolean encontrou = false;
                int count = contas.size();
                for(int i=0; i < count; i++){
                    if(Objects.equals(user, contas.get(i).getTitular())) {
                        encontrou = true;
                        String[] opcoesConta = {"Depositar", "Sacar", "Ver saldo", "Render juros"};
                        int qualEscolha = JOptionPane.showOptionDialog(null,
                                "Escolha:",
                                "Sua conta",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                opcoesConta,
                                opcoesConta[0]
                        );
                        switch (qualEscolha) {
                            case 0 -> {
                                String str = JOptionPane.showInputDialog("Valor:");
                                double valor = Double.parseDouble(str);
                                contas.get(i).depositar(valor);
                            }
                            case 1 -> {
                                String str = JOptionPane.showInputDialog("Valor:");
                                double valor = Double.parseDouble(str);
                                contas.get(i).sacar(valor);
                            }
                            case 2 -> {
                                double saldo = contas.get(i).getSaldo();
                                JOptionPane.showMessageDialog(null, "Seu saldo é: R$" + saldo);
                            }
                            case 3 -> {
                                if (contas.get(i).renderJuros()) JOptionPane.showMessageDialog(null,"Operação efetuada com sucesso.");
                                else JOptionPane.showMessageDialog(null,"Falha: Sua conta não é de poupança.");
                            }
                        }
                        break;
                    }
                }
                    if(!encontrou) JOptionPane.showMessageDialog(null, "Conta não encontrada.");
            }

            if (escolha == -1) break;
        }
    }
}