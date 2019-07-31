import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuPrincipalUI extends JFrame implements ActionListener{

  AltasChildUI w1;
  AltasTeacherUI w2;
  GruposUI w3;
  ChildDatabaseUI w4;
  TeacherDatabaseUI w5;
  JMenuItem item;

  public MenuPrincipalUI(){
    super("Menu Principal");
    changeUIHandler();
    JDesktopPane desktop = new JDesktopPane();

    JMenuBar menu = new JMenuBar();
    JMenu options = new JMenu("Opciones");
    JMenu file = new JMenu("Abrir");
    item = new JMenuItem("Salir");
    item.addActionListener(this);
    file.add(item);

    menu.add(options);
	menu.add(file);
	
    this.setJMenuBar(menu);
    this.getContentPane().add(desktop);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    w1 = new AltasChildUI(true, true, true, true);
    w2 = new AltasTeacherUI(true, true, true, true);
    w3 = new GruposUI(true, true, true, true);
    w4 = new ChildDatabaseUI(true, true, true, true);
    w5 = new TeacherDatabaseUI(true, true, true, true);
    w1.setLocation(0,0);
    w2.setLocation(0,0);
    w3.setLocation(0,0);
    w4.setLocation(0,0);
    w5.setLocation(0,0);
    desktop.add(w1);
    desktop.add(w2);
    desktop.add(w3);
    desktop.add(w4);
    desktop.add(w5);
      
    desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
    this.setSize(1000,700);
   // this.setVisible(true);

  }

  public void actionPerformed(ActionEvent evt){
      if( evt.getSource() == item){
        System.exit(0);
      }
  }


  public void changeUIHandler(){
    String[] uis = {"com.sun.java.swing.plaf.windows.WindowsLookAndFeel",
      "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel",
     "javax.swing.plaf.metal.MetalLookAndFeel",
     "javax.swing.plaf.nimbus.NimbusLookAndFeel",
     "com.sun.java.swing.plaf.motif.MotifLookAndFeel"
   };

    try{
      UIManager.setLookAndFeel(uis[3]);
    }catch(Exception cnfe){
      System.out.println("Exception " + cnfe);
    }

  }
  public static void main(String args[]){
    new MenuPrincipalUI();
  }

}
