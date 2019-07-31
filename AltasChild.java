import java.io.*;
import java.util.*;

//Clase helper de AltasChildUI
public class AltasChild{
	
  //Creando un archivo cuyo nombre sera Children junto con la extension
  //El archivo guardara la informacion de los niños
  String archivo = "Children.csv";
  File file = new File(archivo);
  
  //Agregaremos niños con esta funcion y es importante notar que se agrega un valor tipo child como parametro 
  public boolean addChild(Child infante) {
  	
    try{
    	//checamos si el archivo existe, sino se crea un archivo como designamos al principio
    	if(!file.exists()) {
    		file.createNewFile();
    	}
    	//Proseguimos al metodo validateExistance del niño, este metodo se encuentra en esta misma clase, al final
    	//El if checa si esto es falso, si se cumple con la condicion seguimos, sino ejecuta lo del metodo
    	if(validateExistence(infante) == false) {

		//Filewriter escribe en el archivo y printwriter consigna el registro
	      FileWriter writer = new FileWriter(archivo,true);
	      PrintWriter output = new PrintWriter(writer, true);

	  	//El stringbuffer y lo guardamos como infokid, esto concatena la informacion por comas
		StringBuffer infoKid = new StringBuffer();
		
		//Aqui se ocupan los getters de Child
	    infoKid.append(infante.getCve());
	    infoKid.append(","); 
	    infoKid.append(infante.getCurp());
	   	infoKid.append(","); 
	    infoKid.append(infante.getName());
	   	infoKid.append(","); 
	    infoKid.append(infante.getLastNamePat());
	   	infoKid.append(",");
	    infoKid.append(infante.getLastNameMat());
	   	infoKid.append(",");
	    infoKid.append(infante.getChildGender());  
		infoKid.append(",");
	    infoKid.append(infante.getDiscapacity());
	  	infoKid.append(",");
	    infoKid.append(infante.getDateofBirth());
	    
		output.println(infoKid.toString()); //Aqui se escribe todo el stringbuffer en el archivo
		output.close(); // se cierra el writer
		return true;
	  	
    }	
    	
    }catch(FileNotFoundException fnfe){
      System.out.println(fnfe);
    }catch(IOException ioe){
      System.out.println(ioe);
  	}
  	return false;
  }
  
  // Aqui checamos la existencia de un niño dentro del archivo en base a su CURP
  public boolean validateExistence(Child infante) { 
  	//Instanciamos la clase ChildDatabase
  	ChildDatabase childDB = new ChildDatabase();
  	//Ocupamos el metodo readFile de esta clase
 	ArrayList childList = childDB.readFile();
 	
 	Child kid; 
 	
 	//Valida por medio de un arraylist que recorre cada elemento y checa si el curp existe
 	if(childList.size()!= 0) {
 		for(int i = 1; i<childList.size(); i++) {
 			kid = (Child)childList.get(i);
 			if(kid.getCurp().equals(infante.getCurp())) {
 				return true;
 			}
 		}
 		
 	}  	
 	//Aqui se le da la cve al niño dependiendo de los elementos que cuente el arraylist
 	infante.setCve(""+ childList.size());
 	return false;
  }

}
