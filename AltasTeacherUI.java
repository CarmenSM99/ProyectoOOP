import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;
import java.util.Calendar;
public class AltasTeacherUI extends JInternalFrame implements ActionListener{

  JButton agregar;
  JButton limpiarCampos;
  JButton searchPhoto;
  JButton back;
  JLabel nombre;
  JLabel apellidoPat;
  JLabel apellidoMat;
  JLabel curp;
  JLabel foto;
  JLabel addphoto;
  JTextField txtnombre;
  JTextField txtapep;
  JTextField txtapem;
  JTextField txtcurp;
  ImageIcon imagen;
  private static Style uistyle;
  public static Style changeUIHandler(){ return uistyle; }
  
  public AltasTeacherUI(boolean size, boolean close, boolean maximize, boolean minimize) {
 	 super("Altas teacher", size, close, maximize, minimize);


    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new GridLayout(2,1) );

    JPanel panelOne = new JPanel();
    panelOne.setLayout(new GridLayout(8,2));

    JPanel panelTwo = new JPanel();
    panelTwo.setLayout(new FlowLayout());
    panelTwo.setSize(400,600);

    JPanel panelThree = new JPanel();
    panelThree.setLayout(new GridLayout(3,1));

    JPanel panelFour = new JPanel();
    panelFour.setLayout(new FlowLayout());
    panelFour.setSize(600,200);

    nombre = new JLabel("Nombres:");
    apellidoMat = new JLabel("Apellido Materno:");
    apellidoPat = new JLabel("Apellido Paterno:");
    curp = new JLabel("CURP:");
    foto = new JLabel("Foto:", SwingConstants.CENTER);
    addphoto = new JLabel("Foto aqui", SwingConstants.CENTER);

    txtnombre = new JTextField();
    txtapep = new JTextField();
    txtapem = new JTextField();
    txtcurp = new JTextField();

    agregar= new JButton("Agregar datos"); agregar.addActionListener(this);
    limpiarCampos = new JButton("Limpiar casillas"); limpiarCampos.addActionListener(this);
    searchPhoto = new JButton("Insertar foto"); searchPhoto.addActionListener(this);
    back = new JButton("Regresar"); back.addActionListener(this);

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
    panelThree.add(foto);
    panelThree.add(addphoto);
	  panelThree.add(panelFour);
	  panelFour.add(searchPhoto);
    panelTwo.add(back);
 	  panelTwo.add(limpiarCampos);
	  panelTwo.add(agregar);


	    //  AltasTeacherUI.menu = new MenuUI(" ");

    getContentPane().add(mainPanel);
    setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
    setSize(700,400);
    setVisible(true);
	//	setVisible(false);
    }

    public void agregarDatos() {
    	Teacher profesora= null;
    	if((txtcurp.equals("")) || (txtnombre.equals("")) || (txtapem.equals("")) || (txtapep.equals("")) ){
         JOptionPane.showMessageDialog(null,"Faltan datos por llenar");
       } else   {
            profesora = new Teacher();
       		profesora.setCve("1");
       		profesora.setTeacherCurp(txtcurp.getText());
			profesora.setName(txtnombre.getText());
			profesora.setLastNamePat(txtapep.getText());
			profesora.setLastNameMat(txtapem.getText());
			
			AltasTeacher alta = new AltasTeacher();
	
			
			if(alta.addTeacher(profesora)) {
				this.clean();
			   JOptionPane.showMessageDialog(null, "Datos agregados correctamente");
			   	
			} else {
				JOptionPane.showMessageDialog(null, "Error, datos duplicados");
			}
       }
    }	

	public void clean() {
		txtnombre.setText("");
        txtapem.setText("");
        txtapep.setText("");
        txtcurp.setText("");
	}

    public void actionPerformed(ActionEvent evt){

      if( evt.getSource() == agregar ){
		this.agregarDatos();
      }
      if( evt.getSource() == limpiarCampos ){
		clean();
      }
      if( evt.getSource() == searchPhoto ){
        JFileChooser fc = new JFileChooser();
        if(fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
          File image = new File(fc.getSelectedFile().toString());
			/*image.getBytes()
			addphoto.setIcon(imagen);*/
        }
      }
      if( evt.getSource() == back ){
      	this.dispose();
       
      }

    }

  /*  public static void main(String args[]){
      new AltasTeacherUI();
    }*/


  }
