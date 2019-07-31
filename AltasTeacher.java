import java.io.*;
import java.util.*;

public class AltasTeacher{
	
  String archivo = "Teachers.csv";
  File file = new File(archivo);
	
  public boolean addTeacher(Teacher profesora) {
  	
    try{   
    	if(!file.exists()) {
    		file.createNewFile();
    	}
    	      
   		if(validateExistence(profesora) == false) {

      FileWriter writer = new FileWriter(archivo,true);
      PrintWriter output = new PrintWriter(writer, true);

	  	
		StringBuffer infoTeacher = new StringBuffer();
		
	    infoTeacher.append(profesora.getCve());
	    infoTeacher.append(","); 
	    infoTeacher.append(profesora.getTeacherCurp());
	   	infoTeacher.append(","); 
	    infoTeacher.append(profesora.getName());
	   	infoTeacher.append(","); 
	    infoTeacher.append(profesora.getLastNamePat());
	   	infoTeacher.append(",");
	    infoTeacher.append(profesora.getLastNameMat());
	   	//infoTeacher.append("\n");
		output.println(infoTeacher.toString());
		output.close();
		return true;
	  	
    }	
    	
    }catch(FileNotFoundException fnfe){
            System.out.println("No existe el archivo");
      System.out.println(fnfe);
 
    }catch(IOException ioe){
      System.out.println(ioe);
  	}
  	return false;
  }
  
  public boolean validateExistence(Teacher profesora) { 
  	TeacherDatabase teacherDB = new TeacherDatabase();
 	ArrayList teacherList = teacherDB.readFile();
 	Teacher maestra; 
 	
 	
 	if(teacherList.size()!= 0) {
 		for(int i = 1; i<teacherList.size(); i++) {
 			maestra = (Teacher)teacherList.get(i);
 			if(maestra.getTeacherCurp().equals(profesora.getTeacherCurp())) {
 				return true;
 			}
 		}
 		
 	}  	
 	profesora.setCve(""+ teacherList.size());
 	return false;
  }

}
