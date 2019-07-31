import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;
import javax.swing.table.*;

public class TeacherDatabaseUI extends JInternalFrame implements ActionListener{

	JButton modify;
	JButton delete;
 	JTable myTable;
 	DefaultTableModel model;
    Object[][] data=new Object[0][0];
 	String titulos[]={"CURP","Nombre","Apellido Paterno","Apellido Materno","Grupo"};
	private static Style uistyle;
	public static Style changeUIHandler(){ return uistyle; }

	public TeacherDatabaseUI(boolean size, boolean close, boolean maximize, boolean minimize){

	super("BD Maestros", size, close, maximize, minimize);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(3,1) );

	    JPanel panelOne = new JPanel();
	    panelOne.setLayout(new GridLayout());

		JPanel panelTwo = new JPanel();
		panelTwo.setLayout(new FlowLayout());
		
		model = new DefaultTableModel(data,titulos);
		myTable = new JTable(model);
  	    JScrollPane scroll=new JScrollPane();
    	modify = new JButton("Modificar");
    	delete = new JButton("Borrar");
    		
    	scroll.setViewportView(myTable)
    	
    	mainPanel.add(panelOne);
 		panelOne.add(scroll);
		mainPanel.add(panelTwo);
		panelTwo.add(modify);
		panelTwo.add(delete);

		getContentPane().add(mainPanel);
      	setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
      	setSize(500,500);
      	setVisible(true);
	//	setVisible(false);
}

  public void actionPerformed(ActionEvent evt){

	if(evt.getSource() ==modify) {
		
	}
  }
  /*public static void main(String args[]){
    menu = new MenuUI(" ");
    new TeacherDatabaseUI("Maestras");
  }*/

}
