public class francisco_cavasan {
    public static void main(String[] args) {

        Entrada.mostraTexto("Seja bem vindo(a)",
                "Aqui começa usa jornada pelo labirinto da sorte. Entre e você verá porque ele recebeu esse nome. \n As regras são simples, escolha o caminho certo e seguiras em frente, escolha o caminho errado e, bom, aí você mesmo deverá descobrir.\n O labirinto é habitado por criatuas desconhecidas, e cabe a você se livrar delas.\n Com cada passo dado um novo inimigo irá aparecer, mas caso você escolha o caminho certo, ele fica para trás e você não terá que se preocupar com ele novamente. \n Para prosseguir, você deverá escolher entre três direções, sendo elas frente, direita ou esquerda. \n Você deve escolher entre algumas classes, cada uma com suas próprias estatísticas. Além disso, você sempre corre o risco de receber uma quantia bônus de dano, só pra deixar mais fácil mesmo.  \n Isso é tudo que você precisa para começar sua aventura.\n Boa sorte e tenha cuidado.");

        int count = 0;
        int ataque = 0;
        boolean opc;
        int vida = 100;
        String[] inimigos = new String[10];
        inimigos[0] = "Cabeca de gelo";
        inimigos[1] = "Ogro gigante";
        inimigos[2] = "Zumbi faminto";
        inimigos[3] = "Esquilo sanguinario";
        inimigos[4] = "Princesa da Disney";
        inimigos[5] = "Mago ancião";
        inimigos[6] = "Cavaleiro das Trevas";
        inimigos[7] = "Bicho Papão";
        inimigos[8] = "Ursinho carinhoso";
        inimigos[9] = "Gangue de saqueadores";

        int[][] stat = new int[10][2];
        stat[0][0] = (int) (((Math.random() * 35) + 1) * 100) / 100;
        stat[1][0] = (int) (((Math.random() * 30) + 1) * 100) / 100;
        stat[2][0] = (int) (((Math.random() * 20) + 1) * 100) / 100;
        stat[3][0] = (int) (((Math.random() * 50) + 1) * 100) / 100;
        stat[4][0] = (int) (((Math.random() * 70) + 1) * 100) / 100;
        stat[5][0] = (int) (((Math.random() * 33) + 1) * 100) / 100;
        stat[6][0] = (int) (((Math.random() * 30) + 1) * 100) / 100;
        stat[7][0] = (int) (((Math.random() * 35) + 1) * 100) / 100;
        stat[8][0] = (int) (((Math.random() * 70) + 1) * 100) / 100;
        stat[9][0] = (int) (((Math.random() * 25) + 1) * 100) / 100;
        stat[0][1] = 30;
        stat[1][1] = 40;
        stat[2][1] = 20;
        stat[3][1] = 15;
        stat[4][1] = 45;
        stat[5][1] = 25;
        stat[6][1] = 30;
        stat[7][1] = 50;
        stat[8][1] = 35;
        stat[9][1] = 30;

        int classe = Entrada.leiaOpcao("Escolha uma classe para jogar.", "Vai na sorte mesmo", "Assassino", "Mago",
                "Guerreiro");
        if (classe == 4) {
            ataque = (int) (15 / bonus());
            vida = 100;
            System.out.println("Você escolheu a classe guerreiro.");
            info(ataque, vida);

        } else if (classe == 3) {
            ataque = (int) (20 / bonus());
            vida = 90;
            System.out.println("Você escolheu a classe mago.");
            info(ataque, vida);

        } else if (classe == 2) {
            ataque = (int) (25 / bonus());
            vida = 80;
            System.out.println("Você escolheu a classe assassino.");
            info(ataque, vida);

        } else if (classe == 1) {
            ataque = (int) (((Math.random() * 60) + 1) * 100) / 100;
            vida = (int) (((Math.random() * 120) + 1) * 100) / 100;
            System.out.println(
                    "Você escolheu a classe vai na sorte mesmo e nesse caso seu ataque e vida são gerados aleatoriamente.\n Dessa vezes eles são: \n Ataque: "
                            + ataque + " \n Vida: " + vida);
        }

        while (count < 10) {
            int caminho = Entrada.leiaInt("Escolha a direção\n 1-frente\n 2-direita\n 3-esquerda");
            while (caminho != 1 && caminho != 2 && caminho != 3) {
                caminho = Entrada.leiaInt("Escolha a direção\n 1-frente\n 2-direita\n 3-esquerda");
            }
            if (count == 10) {
                Entrada.mostraTexto("Sortudo", "Você consegiu atravessar o labiritinto sem morrer, parabéns.");
                break;
            }
            if (caminho == certo()) {
                System.out.println("Você escolheu o caminho certo e segue em frente");
            } else {
                Entrada.mostraTexto("Peligro", "Você escolheu o caminho errado e se deparou com " + inimigos[count]
                        + " . Você quer atacar ou fugir?");
                opc = Entrada.leiaBoolean("Faça sua escolha", "Atacar", "Fugir");

                if (opc) {
                    int resultado = luta(stat[count][1], ataque);

                    if (resultado <= 0) {
                        System.out.println("Parabéns, você consegiu derrotar o inimigo.");
                        if (vida < 100) {
                            vida = ganha(vida);
                            System.out.println(
                                    "Você ganhou experiencia e vida por haver derrotado o inimigo. Com isso a sua vida passa a ser: "
                                            + vida);
                        }
                    } else if (resultado > 0) {
                        System.out.println(
                                "Parece que você não teve forças para derrotar o inimigo e acabou tomando uma surra.");
                        if (vida <= 0) {
                            Entrada.mostraTexto("Fim",
                                    "Você foi atacado muitas vezes e não resistiu, retorne para o começo e boa sorte.");
                            break;
                        }
                        if (inimigos[count] == inimigos[4] || inimigos[count] == inimigos[8]) {
                            System.out.println(
                                    "Subestimou o poder do seu inimigo e se ferrou né? Pense mais na próxima vez");
                        }
                        vida = perde(vida, stat[count][0]);
                        if (vida < 0) {
                            vida = 0;
                        }
                        System.out.println("Você recebeu: " + stat[count][0] + " de dano e sua vida agora é: " + vida);
                    }
                    if (vida <= 0) {
                        Entrada.mostraTexto("Fim",
                                "Você foi atacado muitas vezes e não resistiu, retorne para o começo e boa sorte.");
                        break;
                    }
                } else {
                    if (fugir() == fugir()) {
                        System.out.println("Você consegiu fugir sorrateiramente, a sorte está do seu lado.");
                    } else {
                        vida = perde(vida, stat[count][0]);
                        if (vida < 0) {
                            vida = 0;
                        }
                        System.out.println(
                                "Você tentou ser malandro mas a sorte não te ajudou. Após o ataque do monstro, você recebeu "
                                        + stat[count][0] + " de dano e sua vida atual é: " + vida);
                        if (vida <= 0) {
                            Entrada.mostraTexto("Fim",
                                    "Você foi atacado muitas vezes e não resistiu, retorne para o começo e boa sorte.");
                            break;
                        }
                    }
                }
            }
            count++;
            if (count == 10) {
                Entrada.mostraTexto("Sortudo", "Você consegiu atravessar o labiritinto sem morrer, parabéns.");
                break;
                }
        }
    }

    private static int ganha(int vida) {
        int n1 = (int) ((Math.random() * 20) + 1) * 100 / 100;
        vida = vida + n1;
        return (int) (vida);
    }

    private static int perde(int num, int dano) {
        num = num - dano;
        return (num);
    }

    private static int certo() {
        int certo = (int) (((Math.random() * 3) + 1) * 100) / 100;
        return certo;
    }

    private static int fugir() {
        int ran = (int) (((Math.random() * 4) + 1) * 100) / 100;
        return ran;
    }

    private static int luta(int num1, double num2) {
        int resultado = (int) (num1 - num2);
        return resultado;
    }

    private static Double bonus() {
        double bonus = ((double) Math.round(Math.random() * 100) / 100);
        return bonus;
    }

    private static void info(int num, int num1) {
        System.out.println("Seu ataque é: " + num + " e sua vida é: " + num1);
    }
}
