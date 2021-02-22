/*
 * FUP que tenha uma matriz (ideia) 5x2 (5 linhas e 2 colunas) para armazenar o nome de 
 * uma fruta e o seu preço. Ao final, percorra a matriz e diga qual a fruta com o menor 
 * valor e qual a com o maior valor.
 * 
 * Double.toString(<variavel double aqui>) = método que recebe um valor em Double e 
 *                                           converte para uma String
 * 
 * Double.parseDouble(<variavel string aqui>) = método que recebe um valor em String e 
 *                                           converte para um Double
 */

public class MatrizFrutas{
 
    public static void main(String[] args){
      
      String[][] frutas = new String[5][2];
      
      
      for(int i = 0; i < frutas.length; i++){
        frutas[i][0] = EntradaScanner.leiaString("Informe o nome da fruta: ");
        frutas[i][1] = Double.toString(EntradaScanner.leiaDouble("Informe o valor da fruta: "));
      }
      
      String menor = "";
      String maior = "";
      double menor_valor = 0;
      double maior_valor = 0;
      
      //percorre a matriz
      for(int i = 0; i < frutas.length; i++){
        System.out.println(frutas[i][0] + ": R$ " + frutas[i][1]);
        
        if(Double.parseDouble(frutas[i][1]) < menor_valor || menor_valor == 0){ //preenche o menor
          menor_valor = Double.parseDouble(frutas[i][1]);
          menor = frutas[i][0];
        }
        
        if(Double.parseDouble(frutas[i][1]) > maior_valor){ //preenche o maior
          maior_valor = Double.parseDouble(frutas[i][1]);
          maior = frutas[i][0];
        }
      }
      System.out.println("----FRUTAS----");
      System.out.println("Menor valor: " + menor + " a R$ " + menor_valor);
      System.out.println("Maior valor: " + maior + " a R$ " + maior_valor);
      for(int i = 0; i < frutas.length; i++){
        System.out.print(frutas[i][0] + "\t");
        System.out.println(frutas[i][1] + "\t");
      }
    }
  }