import java.io.*;
import java.util.*;

public class TeacherDatabase{ 
	
	private ArrayList teachers = null;
	
	public ArrayList readFile() {
  	Teacher profesora;
  	
    try{
      FileReader arch = new FileReader("Teachers.csv");
      BufferedReader reader = new BufferedReader(arch);
		 
	  teachers = new ArrayList();
      String str  = "";
      
      while( (str = reader.readLine()) != null ){
      	profesora = new Teacher();
      	
        StringTokenizer tokenizer = new StringTokenizer(str,",");
       	 if(!str.equals("")){
        	profesora.setCve(tokenizer.nextToken());
	        profesora.setTeacherCurp(tokenizer.nextToken());
	        profesora.setName(tokenizer.nextToken());
	        profesora.setLastNamePat(tokenizer.nextToken());
	        profesora.setLastNameMat(tokenizer.nextToken());
			teachers.add(profesora);
      	}
      }
      
      arch.close();
    }catch(FileNotFoundException fnfe){
      System.out.println(fnfe);
    }catch(IOException ioe){
      System.out.println(ioe);
    }
    return teachers;
  }
  

  
}