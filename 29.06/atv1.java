import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
FUP que leia o arquivo de texto anexo na atividade, um arquivo com a relação de contas bancárias (conta, senha, Titular, saldo).
Você deverá armazenar o vetor recebido em uma matriz. 
Ou seja, com o vetor retornado do método EntradaScanner.leiaArquivo() você precisará 
transformá-lo em uma matriz através do separador | (pipe) que cada linha possui. 
Você poderá separar as informações da linha utilizando o split("\\|"), exemplo:
Se você aplicar o split("\\|") em uma linha contendo "teste|123|000", você terá um 
novo vetor com 3 posições, índice 0 = teste, índice 1 = 123 e índice 2 = 000.
Com a matriz montada, você poderá realizar algumas operações de crédito, ou seja,
transferência de valores entre as contas em questão. Contudo, para conseguir realizar uma 
operação de transferência, você deverá solicitar ao usuário do 
programa a senha da conta, caso o usuário erre a senha, a operação não poderá ser realizada. 
Todas as operações deverão ser armazenadas em um novo arquivo, e o saldo atualizado
das contas da matriz inicial deverão ser armazenadas em um novo arquivo intitulado
com a data atual (hoje = 29062020).
Você deverá realizar ao menos 10 operações envolvendo todas as contas do arquivo.
*/

public class atv1{
    public static void main(String[] args) throws IOException {

        String[] arquivo = EntradaScanner.leiaArquivo(
                "C:\\Users\\T-Gamer\\Dropbox\\Univates\\1 semestre\\algoritmos e programacao\\29.06\\contas.txt");
        String[][] matriz = new String[5][4];

        for (int i = 0; i < arquivo.length; i++) {
            String[] col = arquivo[i].split("\\|");
            for (int j = 0; j < col.length; j++) {
                matriz[i][j] = col[j];
            }
        }
        FileWriter operacoes = new FileWriter("E:\\atv\\operacoes.txt");
        PrintWriter opera = new PrintWriter(operacoes);
        FileWriter depois = new FileWriter("E:\\atv\\29062020.txt");
        PrintWriter text = new PrintWriter(depois);
        String conta = Entrada.leiaString("Digite o numero da conta.");
        String senha = Entrada.leiaString("Digite sua senha.");
        boolean fim = false;
        String oper = "";
        boolean logado = false;
        while (logado == false) {
            for (int a = 0; a < arquivo.length; a++) {
                if (conta.equals(matriz[a][0]) && senha.equals(matriz[a][1])) {
                    matriz[a][3] = (matriz[a][3]);
                    Entrada.mostraTexto("Bem vindo",
                            "Seja bem vindo(a) " + matriz[a][2] + ". Seu saldo atual é: " + matriz[a][3] + ".");
                    logado = true;
                }
            }
        }
        String outra = "";
        double valor = 0;
        while (fim == false) {
            boolean outro;
            int opc = Entrada.leiaOpcao("Escolha a operação.", "Sair.", "Deposito.", "transferência.", "Saque");
            if (opc == 1) {
                fim = true;
            }
            if (opc == 4) {
                boolean pronto = false;
                valor = Entrada.leiaDouble("Informe o valor que deseja sacar.");
                boolean menor = true;
                while (menor == true) {
                    int a = 0;
                    if (conta.equals(matriz[a][0])) {
                        if (Double.parseDouble(matriz[a][3]) <= 0) {
                            Entrada.mostraTexto("Erro", "Seu saldo é insuficiente para realizar esta operação.");
                            menor = false;
                            pronto = true;
                        } else if (Double.parseDouble(matriz[a][3]) < valor) {
                            Entrada.mostraTexto("Erro",
                                    "Seu saldo é menor que valor inserido. Favor inserir outro valor.");
                            menor = false;
                            pronto = true;
                        } else {
                            menor = false;
                        }
                    } else {
                        a++;
                    }
                }
                int a = 0;
                while (pronto == false) {
                    if (conta.equals(matriz[a][0])) {
                        (matriz[a][3]) = String.valueOf((Double.parseDouble(matriz[a][3])) - valor);
                        pronto = true;
                    } else {
                        a++;
                    }
                }
                oper += ("\n" + "Uma operação de saque foi feita na conta " + conta + " no valor de " + valor
                        + ". O saldo atual da conta é: " + matriz[a][3] + "\n ");
                outro = Entrada.leiaBoolean("Você deseja fazer outra operação?", "Sim.", "Não.");
                if (outro) {
                    fim = false;
                } else {
                    fim = true;
                }
            } else if (opc == 2) {
                outra = Entrada.leiaString("Informe a conta que você deseja depositar o valor.");
                valor = Entrada.leiaDouble("Informe o valor que deseja depositar.");
                int i = 0;
                boolean pronto = false;
                while (pronto == false) {
                    if (outra.equals(matriz[i][0])) {
                        matriz[i][3] = String.valueOf(Double.parseDouble(matriz[i][3]) + valor);
                        oper += ("\n" + "Um valor de R$ " + valor + " foi depositado na conta " + outra
                                + ". O saldo atual da conta é de : " + matriz[i][3] + "\n");
                        outro = Entrada.leiaBoolean("Você deseja fazer outra operação?", "Sim.", "Não.");
                        if (outro) {
                            fim = false;
                            pronto = true;
                        } else {
                            fim = true;
                            pronto = true;
                        }
                    } else {
                        i++;
                    }
                }
            } else if (opc == 3) {
                boolean pronto1 = false;
                outra = Entrada.leiaString("Informe a conta para qual você deseja transferir o valor.");
                valor = Entrada.leiaDouble("Digite o valor a ser tranferido");
                int i = 0;
                boolean ex = false;
                while (ex == false) {
                    int a = 0;
                    if (conta.equals(matriz[a][0])) {
                        if (Double.parseDouble(matriz[a][3]) <= 0) {
                            Entrada.mostraTexto("Erro", "Você não tem saldo suficiente para realizar essa operação.");
                            outro = Entrada.leiaBoolean("Você deseja fazer outra operação?", "Sim.", "Não.");
                            if (outro) {
                                fim = false;
                                ex = true;
                                pronto1 = true;
                            } else {
                                fim = true;
                                pronto1 = true;
                            }
                        } else if (valor > Double.parseDouble(matriz[a][3])) {
                            Entrada.mostraTexto("Erro",
                                    "O valor da transferência não pode ser maior que o presente na conta.");
                            valor = Entrada.leiaDouble("Insira um valor menor que " + matriz[a][3]);
                        } else {
                            ex = true;
                        }
                    } else {
                        a++;
                    }
                }
                while (pronto1 == false) {
                    if (outra.equals(matriz[i][0])) {
                        matriz[i][3] = String.valueOf(Double.parseDouble(matriz[i][3]) + valor);
                        int a = 0;
                        boolean pronto = false;
                        while (pronto == false) {
                            if (conta.equals(matriz[a][0])) {
                                (matriz[a][3]) = String.valueOf((Double.parseDouble(matriz[a][3])) - valor);
                                pronto = true;
                            } else {
                                a++;
                            }
                        }
                        oper += ("\n" + "Um valor de R$ " + valor + " foi transferido da conta " + conta
                                + " para a conta " + outra + ". O saldo atual da primeira é de: " + matriz[a][3]
                                + " e da segunda de " + matriz[i][3] + "\n");
                        outro = Entrada.leiaBoolean("Você deseja fazer outra operação?", "Sim.", "Não.");
                        if (outro) {
                            fim = false;
                            pronto1 = true;
                        } else {
                            fim = true;
                            pronto1 = true;
                        }
                    } else {
                        i++;
                    }
                }
            }
        }
        opera.println(oper);
        for (int x = 0; x < arquivo.length; x++) {
            text.println(matriz[x][3]);
        }
        opera.close();
        text.close();
    }
}