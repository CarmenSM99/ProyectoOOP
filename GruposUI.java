import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;

public class GruposUI extends JInternalFrame implements ActionListener{

  JButton lactantes;
  JButton maternales;
  JButton preescolares;
  JTextArea mostrar;
  
  private static Style uistyle;
  public static Style changeUIHandler(){ return uistyle; }
  
  public GruposUI(boolean size, boolean close, boolean maximize, boolean minimize) {
  	super("Grupos", size, close, maximize, minimize);


    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new GridLayout(1,3));

    JPanel panelOne = new JPanel();
    panelOne.setLayout(new GridLayout(3,1));

    JPanel panelTwo = new JPanel();
    panelTwo.setLayout(new GridLayout(1,1));
    
    JScrollPane scroll = new JScrollPane();
    
    
    mostrar = new JTextArea(20,1);
    
    scroll.setViewportView(mostrar);
    mostrar.setEditable(false);
    
    lactantes = new JButton("Lactantes");
    lactantes.addActionListener(this);
    maternales = new JButton("Maternales");
    maternales.addActionListener(this);
    preescolares = new JButton("Preescolares");
    preescolares.addActionListener(this);

    mainPanel.add(panelOne);
    panelOne.add(lactantes);
    panelOne.add(maternales);
    panelOne.add(preescolares);
    mainPanel.add(panelTwo);
    panelTwo.add(scroll);

    getContentPane().add(mainPanel);
   setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
    setSize(700,400);
    setVisible(true);
	//setVisible(false);
	
  }
  
  public ArrayList roadList(int indice) { 
  	StringBuffer infoKid = new StringBuffer();
  	Grupos show = new Grupos();
  	System.out.println("NIIICEEE");
  	ArrayList listas = show.groupClassifier();
  	System.out.println(listas);
  	System.out.println("Group Classifier");
  	ArrayList children = (ArrayList)listas.get(indice);
  	Child infante=null;
  	
  	  	System.out.println("Vamos bien");
  	
  	for(int i=0; i<children.size(); i++) {
  		
  		System.out.println("Entrandooooo");
  		infante = (Child)children.get(i);
  		
  		infoKid.append(infante.getCve());
	    infoKid.append(","); 
	    infoKid.append(infante.getCurp());
	   	infoKid.append(","); 
	    infoKid.append(infante.getName());
	   	infoKid.append(","); 
	    infoKid.append(infante.getLastNamePat());
	   	infoKid.append(",");
	    infoKid.append(infante.getLastNameMat());
	   	infoKid.append(",");
	    infoKid.append(infante.getChildGender());  
		infoKid.append(",");
	    infoKid.append(infante.getDiscapacity());
	  	infoKid.append(",");
	    infoKid.append(infante.getDateofBirth());
	    infoKid.append("\n");
  	}
  		mostrar.setText(infoKid.toString());
  		System.out.println("Very gud");
  		return children;
  }

  public void actionPerformed(ActionEvent evt){
	if(evt.getSource() ==lactantes) {
		System.out.println("Se apreto el boton");
		roadList(0);
	
	}
	if(evt.getSource() ==maternales) {
		roadList(1);
	}
	if(evt.getSource() ==preescolares) {
		roadList(2);
	}
  }

  /*public static void main(String args[]){
    new GruposUI();
  }*/
}
