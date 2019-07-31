import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;
import java.util.Calendar;

public class Style {

  public Style() {

  }

  public void changeUIHandler(){
  String[] uis = {"com.sun.java.swing.plaf.windows.WindowsLookAndFeel",
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

  }
}
