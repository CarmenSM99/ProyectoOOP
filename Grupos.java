import java.io.*;
import java.util.*;
import java.util.Date.*;
import java.text.*;

public class Grupos { 

	public static ArrayList groupClassifier() {
		ChildDatabase child = new ChildDatabase(); 
		ArrayList children = child.readFile();
		System.out.println(children);
		ArrayList groupsList = new ArrayList();
		SimpleDateFormat dateFormater = null;
		Child infante=null;
		Date birthday = null;
		Date currentDate = null;
		ArrayList lactante = new ArrayList(); 
		ArrayList maternal = new ArrayList();
		ArrayList preescolar = new ArrayList();
		
		  	  	System.out.println("Vamos bien x2");
		if(children.size()!= 0) {
			dateFormater = new SimpleDateFormat("dd/MM/yyyy");
			
			currentDate = new Date();
			System.out.println("2");
			for(int i = 0; i<children.size(); i++) {
				infante = (Child)children.get(i);
				try {
					birthday = dateFormater.parse(infante.getDateofBirth());
					float fechadif = (float)((currentDate.getTime() - birthday.getTime())/86400000);
					float years = fechadif/365;
						if(years>=1 && years<2) {
							lactante.add(infante);
							System.out.println("1");
						}else if(years>=2 && years<3) {
							maternal.add(infante);
							System.out.println("2");
						}else if(years>=3 && years<=4) {
							preescolar.add(infante);
							System.out.println("3");
						}
					
				}catch(Exception e) { 
					System.out.println("Error");
					e.printStackTrace();
				}
			}
			
		}
System.out.println("Tamaño lactante: " + lactante.size());
System.out.println("Tamaño maternal: " + maternal.size());
System.out.println("Tamaño preescolar: " + preescolar.size());
System.out.println(lactante);
System.out.println(maternal);
System.out.println(preescolar);
		groupsList.add(lactante);
		groupsList.add(maternal);
		groupsList.add(preescolar);
		
System.out.println(groupsList);
		return groupsList;
	}

}