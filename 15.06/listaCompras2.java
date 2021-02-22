public class listaCompras {
    public static void main(String[] args) {

        double total = 0;
        String esc = "";
        int count = 0;
        int qunt = 0;
        int produto = 0;
        int pipe, ecom; 
        String [][] tudo;

        String lista[] = new String[10];

        lista[0] = "Maça";
        lista[1] = "Pera";
        lista[2] = "Banana";
        lista[3] = "Abacate";
        lista[4] = "Melancia";
        lista[5] = "Mamão";
        lista[6] = "Maracujá";
        lista[7] = "Uva";
        lista[8] = "Abacaxi";
        lista[9] = "Morango";
        double valor[] = new double[10];

        valor[0] = 2.30;
        valor[1] = 2.10;
        valor[2] = 1.00;
        valor[3] = 3.30;
        valor[4] = 1.50;
        valor[5] = 3.00;
        valor[6] = 3.50;
        valor[7] = 1.75;
        valor[8] = 4.50;
        valor[9] = 6.75;

        
        while(true){
            do{
                produto = Entrada.leiaInt(imprimeProdutos(mercado));
            }while(produto < 0 || produto > mercado.length);
            
            if(produto == 0){
                carrinho = new String [quant_produtos][3];
                String [] vetor_compras = compras.split("\n");
                for(int x = 0; x < vetor_compras.length; x++){
                    pipe = vetor_compras[x].indexOf("|");
                    ecom = vetor_compras[x].indexOf("&");
                    carrinho[x][0] = vetor_compras[x].substring(0, pipe);
                }
                return;
            }

            do{
                quant = Entrada.leiaInt("Informe a quantidade de " );
            }while(quant != 0);
        }
        
        if (count == 0) {
            Entrada.mostraTexto("Carrinho", "Você não escolheu nenhum item para comprar e não deve pagar nada");
            return;
        }
        Entrada.mostraTexto("Carrinho", "Você escolheu comprar " + tudo + " e deve pagar um total de: R$ " + total);
        System.out.println("Fim do programa");
    }
}