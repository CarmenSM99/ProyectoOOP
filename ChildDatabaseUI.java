import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;
import javax.swing.table.*;

public class ChildDatabaseUI extends JInternalFrame implements ActionListener{

	JButton back;
 	JTable myTable;
 	DefaultTableModel model;
	private static Style uistyle;
	public static Style changeUIHandler(){ return uistyle; }
    
	public ChildDatabaseUI(boolean size, boolean close, boolean maximize, boolean minimize){

	super("BD morros", size, close, maximize, minimize);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(3,1) );

   		JPanel panelOne = new JPanel();
   		panelOne.setLayout(new GridLayout());

		model = new DefaultTableModel();
	    model.addColumn("CVE");
        model.addColumn("CURP");
        model.addColumn("Nombre");
        model.addColumn("Apellido Paterno");
        model.addColumn("Apellido Materno");
        model.addColumn("Sexo");
        model.addColumn("Discapacidad");
        model.addColumn("Fecha de nacimiento"); 
		
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
		//setVisible(false);
}

  public void actionPerformed(ActionEvent evt){

	if(evt.getSource() ==back) {
		this.dispose();
	}
  }

  /*public static void main(String args[]){
    new ChildDatabaseUI("Base de datos");
  }*/

}
