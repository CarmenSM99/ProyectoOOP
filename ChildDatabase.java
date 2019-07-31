import java.io.*;
import java.util.*;

//Clase helper de ChildDatabaseUI
public class ChildDatabase{ 

	//Metodo para leer el archivo
	public ArrayList readFile() {
	ArrayList children = null;

  	Child infante;
  	
    try{
    	//Definimos el archivo que va a leer 
      FileReader arch = new FileReader("Children.csv");
      BufferedReader reader = new BufferedReader(arch);
		 
	  children = new ArrayList();
      String str  = "";
	  System.out.println("Antes de iniciar el ciclo:"); //System.out.println imprime en consola
	  //Leer las lineas del archivo
      while( (str = reader.readLine()) != null ){
		System.out.println("dentro del ciclo");
      	infante = new Child();
      	
      	//Leyendo cada dato del archivo ocupando el stringtokenizer con una coma 
        StringTokenizer tokenizer = new StringTokenizer(str,",");
	        if(!str.equals("")){
			System.out.println("dentro del if(!str.equals(vacio)");
	        infante.setCve(tokenizer.nextToken()); 
	        infante.setCurp(tokenizer.nextToken());
	        infante.setName(tokenizer.nextToken());
	        infante.setLastNamePat(tokenizer.nextToken());
	        infante.setLastNameMat(tokenizer.nextToken());
	        infante.setChildGender(tokenizer.nextToken());
	 		infante.setDiscapacity(tokenizer.nextToken());
	        infante.setDateofBirth(tokenizer.nextToken());
			children.add(infante);
			System.out.println(children);
        }
      }
      arch.close();
    }catch(FileNotFoundException fnfe){
      System.out.println(fnfe);
    }catch(IOException ioe){
      System.out.println(ioe);
    }
    return children;
  }
  
  public void fillTable() {
  	try{
		this.readFile();
		String line = reader.readLine();
		
	    for(int row = 0; row < children ; row++){
              for(int column = 0; column<8 ;column++){
				while (line != null ) {
                    String [] rowfields = line.split(",");
                          model.addRow(rowfields);
                          line = reader.readLine();
                }
                                   
              }
        }
		
  	}catch(Exception e){
		System.out.println(e);
  }
  
}

