public class Usser {

  private String usuario;
  private String password;

//CONSTRUCTOR que recibe los strings usuario y password como parametro
  public Usser(String usuario, String password) {
    this.usuario = usuario;
    this.password = password;
  }

//GETTERS para Usuario y Contraseña 
  public String getUsuario() { return usuario; }
  public String getPassword() {return password;}
}
