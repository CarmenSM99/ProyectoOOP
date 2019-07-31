import java.io.*;
import java.util.*;

public class LoginCheck {
//Instanciando clase Usser con el fin de hacer uso de sus elementos
  private Usser usu = null;
	
//Metodo para validar usuarios
  public boolean validateUssers(String appUser, String appPassword) {
    try{
    	//abriremos un archivo
      FileReader arch = new FileReader("Ussers.txt"); 
      BufferedReader reader = new BufferedReader(arch);

		//Lee el archivo
      String str  = ""; //validar que la linea no este vacia 
      while( (str = reader.readLine()) != null ){
      	//Conforme vaya leyendo comas, almanacene el string que lea en str
        StringTokenizer tokenizer = new StringTokenizer(str,",");
        
        //Usu es el nombre que recibe la clase Ussers y se le estan dando los valores que reciben los strings que se han leido
        usu = new Usser(tokenizer.nextToken(), tokenizer.nextToken());
        
        //Si los datos ingresados son correctos tanta en el campo usuario como en password, regresa un valor true
       if( usu.getUsuario().equals(appUser) && usu.getPassword().equals(appPassword) ){
        	return true;
      	}
      }
      
      
//      arch.closeFile();
    }catch(Exception e){
      System.out.println(e);
    }
    return false;
  }


  }
