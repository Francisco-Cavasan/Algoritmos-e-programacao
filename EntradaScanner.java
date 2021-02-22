import java.util.Scanner;
import java.io.File;

/* created at: 2020-05-20
 * author: Jonas Dhein
*/

public class EntradaScanner{
  
  public static String leiaString(String texto){
     System.out.print(texto);
     Scanner leia = new Scanner(System.in);
     return leia.nextLine();
  }
  
  public static int leiaInt(String texto){
     int retorno = 0;
     
     Scanner leia = new Scanner(System.in);
     
     int cont = 0;
     do{
       try{
         System.out.print(texto);
         leia = new Scanner(System.in);
         retorno = leia.nextInt();
         cont += 1;
       }catch(Exception ex){
         System.out.print("Erro\n");
       }
       
     }while(cont == 0);
     
     return retorno;
  }
  
  public static Double leiaDouble(String texto){
     double retorno = 0;
     
     Scanner leia = new Scanner(System.in);
     
     int cont = 0;
     do{
       try{
         System.out.print(texto);
         leia = new Scanner(System.in);
         retorno = leia.nextDouble();
         cont += 1;
       }catch(Exception ex){
         System.out.print("Erro\n");
       }
       
     }while(cont == 0);
     
     return retorno;
  }
  
  public static String[] leiaArquivo(String caminho){
      try {
        File arquivo = new File(caminho);
        Scanner scan = new Scanner(arquivo);

        //encontrar o número de linhas do arquivo lido
        int linhas = 0;
        while(scan.hasNextLine()){
            String linha = scan.nextLine();
            linhas += 1;
        }
        
        scan.close();
        scan = new Scanner(arquivo);
        int pos = 0;
        String[] vetor = new String[linhas];
        while(scan.hasNextLine()){ //busca linha a linha
            String linha = scan.nextLine();
            vetor[pos] = linha;
            pos += 1;
        }

        scan.close();

        return vetor;

    }catch (Exception e) {
        System.out.println("Erro na leitura do arquivo");
        return null;
    }
  }

}