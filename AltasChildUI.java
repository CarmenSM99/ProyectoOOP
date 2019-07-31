import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;
import java.util.Calendar;

//Interfaz grafica para dar de alta niños

public class AltasChildUI extends JInternalFrame implements ActionListener{

  JButton agregar;
  JButton limpiarCampos;
  JButton searchPhoto;
  JButton back;
  JButton addDate;
  JLabel addchild;
  JLabel nombre;
  JLabel apellidoPat;
  JLabel apellidoMat;
  JLabel fechaNac;
  JLabel sexo;
  JLabel curp;
  JLabel discapacidad;
  JLabel foto;
  JLabel addphoto;
  JTextField txtnombre;
  JTextField txtapep;
  JTextField txtapem;
  JTextField txtcurp;
  JTextField txtnac;
  JComboBox sexocombo;
  JComboBox discapacidadcombo;
  JComboBox diacombo; 
  JComboBox mescombo; 
  JComboBox comboyear;
  private static Style uistyle;
  public static Style changeUIHandler(){ return uistyle; }
  ImageIcon imagen;
  
  //CONSTRUCTOR para un JInternal frame que define si se maximiza, minimiza, se cierra y el tamaño que se le puede dar
  //Contiene todos los elementos para la interfaz grafica
  public AltasChildUI(boolean size, boolean close, boolean maximize, boolean minimize) {
  	super("Altas morros", size, close, maximize, minimize);

    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new GridLayout(2,1) );
    
    JPanel panelOne = new JPanel();
    panelOne.setLayout(new GridLayout(10,2));

    JPanel panelTwo = new JPanel();
    panelTwo.setLayout(new FlowLayout());
    panelTwo.setSize(400,600);

    JPanel panelThree = new JPanel();
    panelThree.setLayout(new GridLayout(3,1));

    JPanel panelFour = new JPanel();
    panelFour.setLayout(new FlowLayout());
    panelFour.setSize(600,200);

	JPanel panelfecha = new JPanel();
	panelfecha.setLayout(new FlowLayout());
	panelfecha.setSize(300,600);
		
	imagen = new ImageIcon();
    nombre = new JLabel("Nombres:");
    apellidoMat = new JLabel("Apellido Materno:");
    apellidoPat = new JLabel("Apellido Paterno:");
    fechaNac = new JLabel("Fecha de nacimiento:");
    curp = new JLabel("CURP:");
    sexo = new JLabel("Sexo:");
    fechaNac = new JLabel("Fecha de nacimiento:");
    discapacidad = new JLabel("Discapacidad:");
    foto = new JLabel("Foto:", SwingConstants.CENTER);
    addphoto = new JLabel("Foto aqui", SwingConstants.CENTER);

	
    txtnombre = new JTextField();
    txtapep = new JTextField();
    txtapem = new JTextField();
    txtcurp = new JTextField();
    txtnac  = new JTextField();
    txtnac.setEditable(false);

    agregar= new JButton("Agregar datos"); agregar.addActionListener(this);
    limpiarCampos = new JButton("Limpiar casillas"); limpiarCampos.addActionListener(this);
    searchPhoto = new JButton("Insertar foto"); searchPhoto.addActionListener(this);
    back = new JButton("Regresar"); back.addActionListener(this);
    addDate = new JButton("Set date"); addDate.addActionListener(this);

    sexocombo = new JComboBox();
    sexocombo.addItem("Seleccione");
    sexocombo.addItem("Femenino");
    sexocombo.addItem("Masculino");
    discapacidadcombo = new JComboBox();
    discapacidadcombo.addItem("Seleccione");
    discapacidadcombo.addItem("NO");
    discapacidadcombo.addItem("SI");
	diacombo = new JComboBox();
	diacombo.addItem("Dia");
	mescombo = new JComboBox();
	mescombo.addItem("Mes");
	comboyear = new JComboBox();
	comboyear.addItem("Year");
	
	//Fors que agregan los dias, meses y años para establecer fechas 
       
       for (int i = 1; i<= 31; i++) {
           diacombo.addItem(i);
       }

	   for (int j = 1; j<= 12; j++) {
           mescombo.addItem(j);
       }
       
       int year = Calendar.getInstance().get(Calendar.YEAR);
       for (int y = 2015; y<= year; y++) {
           comboyear.addItem(y);
       }
	
	mainPanel.add(panelOne);
    mainPanel.add(panelThree);
    mainPanel.add(panelTwo);
    panelOne.add(curp);
    panelOne.add(txtcurp);
    panelOne.add(nombre);
    panelOne.add(txtnombre);
    panelOne.add(apellidoPat);
    panelOne.add(txtapep);
    panelOne.add(apellidoMat);
    panelOne.add(txtapem);
    panelOne.add(sexo);
    panelOne.add(sexocombo);
    panelOne.add(discapacidad);
    panelOne.add(discapacidadcombo);
    panelOne.add(fechaNac);
   	panelOne.add(panelfecha);
 	panelfecha.add(diacombo);
 	panelfecha.add(mescombo);
 	panelfecha.add(comboyear);
 	panelOne.add(addDate);
    panelOne.add(txtnac);
    panelThree.add(foto);
    panelThree.add(addphoto);
	  panelThree.add(panelFour);
	  panelFour.add(searchPhoto);
    panelTwo.add(back);
 	  panelTwo.add(limpiarCampos);
	  panelTwo.add(agregar);


    getContentPane().add(mainPanel);
   setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
    setSize(800,600);
 setVisible(true);
//	setVisible(false);
    }
    //TERMINA CONSTRUCTOR
    
    //Lo que se ingrese en el TextField de curp, estara en mayusculas
	 public void key(KeyEvent e) {
	 	txtcurp.setText(txtcurp.getText().toUpperCase());
	 }
	 
	 //Regresa cada caja de texto y combobox a su valor inicial (sin datos agregados)
	 public void clean() {
	 	txtnac.setText("");
        txtnombre.setText("");
        txtapem.setText("");
        txtapep.setText("");
        txtcurp.setText("");
        sexocombo.setSelectedIndex(0);
        discapacidadcombo.setSelectedIndex(0);
        diacombo.setSelectedIndex(0);
        mescombo.setSelectedIndex(0);
        comboyear.setSelectedIndex(0);
	 }


	//Agregaremos los datos ingresados por el usuario al archivo
    public void agregarDatos() {
    	//Instanciamos clase Child
    	Child infante = null;
    	//Checa si hay algun campo vacio para que el usuario no ingrese campos vacios
    	if((txtcurp.equals("")) || (txtnombre.equals("")) || (txtapem.equals("")) || (txtapep.equals("")) || (sexocombo.getSelectedIndex() == 0) || (discapacidadcombo.getSelectedIndex() == 0) || (txtnac.equals(""))  ){
         JOptionPane.showMessageDialog(null,"Faltan datos por llenar");
       	}else {
       		infante = new Child();
       		//Ocupamos los Setters y getters de la clase infante para establecer los valores dados por el usuario en las cajas de texto 
       		infante.setCurp(txtcurp.getText());
			infante.setName(txtnombre.getText());
			infante.setLastNamePat(txtapep.getText());
			infante.setLastNameMat(txtapem.getText());
			infante.setChildGender(sexocombo.getSelectedItem().toString());
			infante.setDiscapacity(discapacidadcombo.getSelectedItem().toString());
			infante.setDateofBirth(txtnac.getText());
			
			//instanciamos la clase helper
			AltasChild alta = new AltasChild();
	
			//Al darse de alta los niños en el archivo
			if(alta.addChild(infante)) {
				this.clean();
			   JOptionPane.showMessageDialog(null, "Datos agregados correctamente");
			   	
			} else {
				JOptionPane.showMessageDialog(null, "Error, datos duplicados");
			}
       	}	
	}

	//Acciones para los botones
    public void actionPerformed(ActionEvent evt){

      if( evt.getSource() == agregar ){
      	//se llama la funcion agregardatos
		this.agregarDatos();
		
      }
      if( evt.getSource() == limpiarCampos ){
      	//se llama la funcion clean
		this.clean();
      }
      if( evt.getSource() == searchPhoto ){
      	//Se busca una foto 
        JFileChooser fc = new JFileChooser();
        if(fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {        	
          File image = new File(fc.getSelectedFile().toString());
          	//imagen = new Imageicon(image);
			//addphoto.setIcon(imagen);		
        }
      }
     if( evt.getSource() == back ){
     	//Cierra la ventana
       this.dispose();
//       AltasChildUI.menu.setVisible(true);
      }
      if( evt.getSource() == addDate ){
      	//Concatena la fecha
       String date = diacombo.getSelectedItem() + "/" + mescombo.getSelectedItem() + "/" +comboyear.getSelectedItem();
       txtnac.setEnabled(true);
       txtnac.setText(date);
      }

    }

   /* public static void main(String args[]){
      new AltasChildUI();
    }*/

}
