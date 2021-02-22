import java.util.*;

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
     System.out.print(texto);
     Scanner leia = new Scanner(System.in);
     
     try{
       
       retorno = leia.nextInt();
       
     }catch(Exception ex){
       leiaInt(texto); //recursividade
     }
     
     return retorno;
  }
  
  public static Double leiaDouble(String texto){
     double retorno = 0;
     System.out.print(texto);
     Scanner leia = new Scanner(System.in);
     
     try{
       retorno = leia.nextDouble();
     }catch(Exception ex){
       leiaDouble(texto); //recursividade
     }
     
     return retorno;
  }
  
}