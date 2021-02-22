import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class transacao {
    public static void main(String[] args) throws IOException {

        String[] arquivo = EntradaScanner.leiaArquivo(
                "C:\\Users\\francisco\\Dropbox\\Univates\\1 semestre\\algoritmos e programacao\\29.06\\contas.txt");
        String[][] matriz = new String[5][4];
        double max = 0;

        for (int i = 0; i < arquivo.length; i++) {
            String[] col = arquivo[i].split("\\|");
            for (int j = 0; j < col.length; j++) {
                matriz[i][j] = col[j];
            }
        }
        String[][] user = new String[5][2];
        for (int i = 0; i < arquivo.length; i++) {
            user[i][0] = matriz[i][0];
            user[i][1] = matriz[i][1];
        }
        Double valores[] = new Double[5];
        for (int i = 0; i < arquivo.length; i++) {
            valores[i] = Double.parseDouble(matriz[i][3]);
            System.out.println(valores[i]);
        }

        String conta = Entrada.leiaString("Digite o numero da conta.");
        String senha = Entrada.leiaString("Digite sua senha.");

        boolean certo = false;
        int a = 0;
        while (certo == false) {
            for (a = 0; a < arquivo.length; a++) {
                if (conta.equals(user[a][0]) && senha.equals(user[a][1])) {
                    max = Double.parseDouble(matriz[a][3]);
                    Entrada.mostraTexto("Bem vindo",
                            "Seja bem vindo(a) " + matriz[a][2] + ". Seu saldo atual é: " + max);
                    certo = true;
                }
            }
        }
        FileWriter operacoes = new FileWriter("E:\\operacoes.txt");
        PrintWriter opera = new PrintWriter(operacoes);
        FileWriter depois = new FileWriter("E:\\29062020.txt");
        PrintWriter text = new PrintWriter(depois);
        boolean opc = Entrada.leiaBoolean("Voce quer fazer uma transferencia?", "Sim.", "nao.");
        boolean mais;
        boolean operacao = true;

        boolean pronto = false;
        while(pronto == false){
        while (operacao == false) {
            opc = Entrada.leiaBoolean("Voce quer fazer uma transferencia?", "Sim.", "nao.");
            operacao = true;
        }
        if (opc) {
            boolean transacao = false;
            int i = 0;
            String outra = Entrada.leiaString("Informe a conta para qual voce deseja transferir o valor.");
            double valor = Entrada.leiaDouble("Digite o valor a ser tranferido");
            while (transacao == false) {
                while (valor > max) {
                Entrada.mostraTexto("Erro", "Seu saldo é insuficiente para realizar essa operação.");
                valor = Entrada.leiaDouble("Insira um valor menor que o limite.");
                    }
                while (outra.equals(conta)) {
                    Entrada.mostraTexto("Erro", "Voce nao pode fazer uma transferencia para sua propria conta.");
                    outra = Entrada.leiaString("Informe outra conta para qual voce deseja transferir o valor.");
                }
                if (outra.equals(matriz[i][0])) {
                    valores[i] = valores[i] + valor;
                    max = max - valor;
                    System.out.println(
                            "Um valor de R$ " + valor + " foi transferido da conta " + conta + " para a conta " + outra
                                    + ". O saldo atual da primeira é de: " + max + " e da segunda de " + valores[i]);
                    opera.println("Um valor de R$ " + valor + " foi transferido da conta " + conta + " para a conta "
                            + outra + ". O saldo atual da primeira é de: " + max + " e da segunda de " + valores[i]);

                    if (outra.equals(matriz[i][0])) {
                        matriz[i][3] = String.valueOf(valores[i]);
                    }
                    mais = Entrada.leiaBoolean("voce quer fazer mais uma tranferencia?", "Sim", "Nao");
                    if (mais) {
                        pronto = false;
                        operacao = false;
                        transacao = false;
                    } else {
                        pronto = true;
                        transacao = true;
                    }
                } else {
                    i++;
                }
            }
        }
    }
        boolean confirm = false;
        while (confirm == false) {
            int x = 0;
            if (conta.equals(matriz[x][0])) {
                matriz[x][3] = String.valueOf(max);
                confirm = true;
            } else {
                x++;
            }
        }
        for (int x = 0; x < arquivo.length; x++) {
            text.println(matriz[x][3]);
        }
        opera.close();
        text.close();
    }
}
