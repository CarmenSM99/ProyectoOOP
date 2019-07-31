public class Child {
//Campos para dar de alta un niño
  private String cve; //Cve es una excepcion porque no la captura el usuario, sino que es dada por el sistema
  private String curp;
  private String name;
  private String lastNamePat;
  private String lastNameMat;
  private String gender;
  private String dateofbirth;
  private String discapacity;

  //GETTERS Y SETTERS 
	  public String getChildGender(){ return gender;}
	  public String getDiscapacity(){return discapacity;}
	  public String getCurp(){ return curp;}
	  public String getName(){ return name;}
	  public String getLastNamePat(){ return lastNamePat;}
	  public String getLastNameMat(){ return lastNameMat;}
	  public String getCve() { return cve;}
	  public String getDateofBirth() { return dateofbirth;}
	  
	  public void setChildGender(String g){gender = g;}
	  public void setDiscapacity(String y){discapacity = y;}
	  public void setCurp(String c){curp = c;}
	  public void setName(String m){name = m;}
	  public void setLastNamePat(String c){lastNamePat = c;}
	  public void setLastNameMat(String m){lastNameMat = m;}
	  public void setCve(String t) { cve = t;}
	  public void setDateofBirth(String t) { dateofbirth = t;}


}
