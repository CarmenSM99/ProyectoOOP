import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;

//Clase principal que genera un login grafico 

public class Login extends JFrame implements ActionListener { 

	JButton enter; //elementos a ocupar en la interfaz fgrafica 
	JButton exit;
	JLabel user;
	JLabel password;
	JLabel welcome;
	JTextField usertxt;
	JPasswordField passtxt;

  	 static MenuPrincipalUI menu = null;// instanciando clases
	 static LoginCheck login = null;


	//EMPIEZA CONSTRUCTOR 
	//Interfaz grafica del login
	public Login(String title){

	super(title);
	String uis[] = {
    "com.sun.java.swing.plaf.windows.WindowsLookAndFeel",
    "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel",
    "javax.swing.plaf.metal.MetalLookAndFeel",
    "javax.swing.plaf.nimbus.NimbusLookAndFeel",
    "com.sun.java.swing.plaf.motif.MotifLookAndFeel"
  	};

    try{
      UIManager.setLookAndFeel(uis[1]);
    }catch(Exception cnfe){
      System.out.println("Exception " + cnfe);
    }

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(3,1) );

	    JPanel panelOne = new JPanel();
	    panelOne.setLayout(new GridLayout(1,1) );

	    JPanel panelTwo = new JPanel();
	    panelTwo.setLayout(new GridLayout(2,2) );

	    JPanel panelThree = new JPanel();
	    panelThree.setLayout(new GridLayout(1,2) );

	    JPanel panelFour = new JPanel();
	    panelFour.setLayout(new GridLayout(1,2) );

	    JPanel finalPanel = new JPanel();
	    finalPanel.setLayout(new GridLayout(1,1));

	    welcome = new JLabel("Bienvenido, ingrese usuario y password", SwingConstants.CENTER);
	    user = new JLabel("Usuario:");
	    password = new JLabel("Password:");

	    enter = new JButton("Entrar");
	    enter.addActionListener(this);
	    exit = new JButton("Salir");
	    exit.addActionListener(this);

	    usertxt = new JTextField();
	    passtxt = new JPasswordField();
	    mainPanel.add(panelOne);
	    mainPanel.add(panelTwo);
	    mainPanel.add(finalPanel);
	    panelOne.add(welcome);
	    panelTwo.add(panelThree);
	    panelTwo.add(panelFour);
	    panelThree.add(user);
	    panelThree.add(usertxt);
	    panelFour.add(password);
	    panelFour.add(passtxt);
	    finalPanel.add(exit);
	    finalPanel.add(enter);
	    
	    menu = new MenuPrincipalUI();
		login = new LoginCheck();

		getContentPane().add(mainPanel);
      	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      	setSize(400,200);
      	setVisible(true);

	}
//TERMINA CONSTRUCTOR


	// Manda a llamar el metodo validateUssers de la clase LoginCheck
		public boolean getData() {
				return login.validateUssers(usertxt.getText(), passtxt.getText());
				
		}
		
		//Metodo para que realice una accion al apretar algun boton
      	public void actionPerformed(ActionEvent evt){

		//Si la validacion demuestra que los datos ingresados por el usuario son correctos, permite que se abra el menu principal
			 if( evt.getSource() == enter ){
				if(this.getData()){
					JOptionPane.showMessageDialog(null,"ACCESO CONCEDIDO");	
				    menu.setVisible(true);
					this.dispose();

				}else //si no es asi, se denega el acceso.
					JOptionPane.showMessageDialog(null,"ACCESO DENEGADO");
					usertxt.setText("");
					passtxt.setText("");
			}
			//System.exit cierra la ventana y termina el programa
	  		if( evt.getSource() == exit ){
	       		System.exit(0);
	    	}
  		}
  		
  	
  	//Main class
	  public static void main(String args[]){
    	new Login("Log in");
 		}
}
