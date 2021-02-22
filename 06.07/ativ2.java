public class ativ2 {
    public static void main(String[] args) {

        String[] arquivo = EntradaScanner.leiaArquivo(
                "C:\\Users\\T-Gamer\\Dropbox\\Univates\\1 semestre\\algoritmos e programacao\\06.07\\alunos.txt");

        String alunos[][] = new String[10][3];
        double media = 0;
        int acima = 0;
        for (int i = 0; i < arquivo.length; i++) {
            String[] col = arquivo[i].split("\\|");
            for (int x = 0; x < col.length; x++) {
                alunos[i][x] = col[x];
            }
        }

        media = media(media, arquivo.length, alunos);
        System.out.println(media);
        acima = maior(alunos, arquivo.length);
        System.out.println(acima);
        acima(alunos, arquivo.length, media);
    }

    private static double media(double a, int b, String[][] c) {
        for (int i = 0; i < b; i++) {
            a += Double.parseDouble(c[i][1]);
        }
        a = (double) Math.round((a / b) * 100) / 100;
        return a;
    }


    private static String acima(String[][]c, int b, double a){
        String nomes = "";
        for (int i = 0; i < b; i++) {
        if(Double.parseDouble(c[i][1]) > a){
            nomes += c[i][0] + ", ";
        }
    }
    System.out.println("Tem altuta acima da media os alunos: " + nomes);
    return nomes; 
}

    private static int maior(String[][] c, int b) {
        int count = 0;
        for (int i = 0; i < b; i++) {
            if (Integer.parseInt(c[i][2]) > 20) {
                count++;
            }
        }
        return count;
    }
}