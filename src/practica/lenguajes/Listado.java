/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.lenguajes;

/**
 *
 * @author HUGO
 */



import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author HUGO
 */
public class Listado extends JFrame implements ActionListener {
   JButton g,c;
    String t[][];
 static lista lis;
 static  boolean agregar;
  static  boolean modificar;
  static  boolean eliminar;
  static  boolean lista;
  JPanel panel;
  JTable table;
  String v[]=new String[]{"Carnet","Nombre","Semestre"};
     
    public Listado(lista l){
        
     agregar=InterFaz.agregar;
    modificar=InterFaz.modificar;
    eliminar=InterFaz.eliminar;
    lista=InterFaz.lista;
        lis=l;
      setTitle("Listado");  
     this.setBounds(0, 0, 500,500);
      setLayout(null);
         
    panel=new JPanel();
    this.add(panel);
    panel.setSize(500,500);
    this.setUndecorated(true);
    this.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
    t=InterFaz.datos.clone();
     
  
    table = new JTable(t,v);
  
  JScrollPane pane = new JScrollPane(table);
  table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
  panel.add(pane);
  
  c=new JButton("Regresar"); 
  c.setBounds(100,430, 100, 30);
 panel.add(c);
 c.addActionListener(this);
 
   
        
        
  
 
     
    }
    public void actionPerformed(ActionEvent e) {
            
     if (e.getSource()==c) {
        
         
     InterFaz in =new InterFaz(agregar,modificar,eliminar,lista,lis);
        in.setVisible(true);
       this.hide();
        }
    }
    
}
	 

