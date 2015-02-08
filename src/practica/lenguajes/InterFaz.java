/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica.lenguajes;

/**
 *
 * @author HUGO
 */
import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;


public class InterFaz extends JFrame implements  ActionListener {
static ArrayList<String> vectTexto = new ArrayList<String>();
static String datos[][];
    static  boolean agregar;
    static  boolean modificar;
    static  boolean eliminar;
    static  boolean lista;
    JLabel titulo;
    JButton bagregar;
    JButton blista;
    JButton bmodificar;
    JButton beliminar;
    JButton salir;
    JButton bmenu;
    int i=0;
    static lista l;
    public InterFaz(lista lis){
    agregar=menu.agregar; 
    modificar=menu.modificar;
    eliminar=menu.eliminar;
    lista=menu.lista;
    l=lis;
    listado();   
    this.setBounds(0, 0, 430, 460);
     setLayout(null);
     titulo=new JLabel("OPCIONES");
     Font tipoFuente =new Font("Arial Black", Font.BOLD, 24);
     titulo.setBounds(170,5, 400, 30);
      add(titulo);
    
          if(agregar){
          bagregar=new JButton("Agregar");
    bagregar.setBounds(150,50+(75*i),100,50);
    add(bagregar);
      bagregar.addActionListener(this);
      i=i+1;
          }
    if(modificar){
          bmodificar=new JButton("Modificar");
    bmodificar.setBounds(150,50+(75*i),100,50);
    add(bmodificar);
    bmodificar.addActionListener(this);
     i=i+1;
          }
    if(eliminar){
          beliminar=new JButton("Eliminar");
    beliminar.setBounds(150,50+(75*i),100,50);
    add(beliminar);
    beliminar.addActionListener(this);
    i=i+1;
          }
    if(lista){
          blista=new JButton("lista");
    blista.setBounds(150,50+(75*i),100,50);
    add(blista);
    blista.addActionListener(this);
    i=i+1;
         }
           
      
     salir=new JButton("Salir");
     salir.setBounds(280, 330, 80, 50);
     add(salir);
     salir.addActionListener(this);
     
      bmenu=new JButton("Menu");
     bmenu.setBounds(40, 330, 80, 50);
     add(bmenu);
     bmenu.addActionListener(this);
     
    }
    
    public InterFaz(boolean ag,boolean mo, boolean el,boolean li, lista le){
    
    agregar=ag; 
    modificar=mo;
    eliminar=el;
    lista=li;
    l=le;
    listado();   
    this.setBounds(0, 0, 430, 460);
     setLayout(null);
     titulo=new JLabel("OPCIONES");
     Font tipoFuente =new Font("Arial Black", Font.BOLD, 24);
     titulo.setBounds(170,5, 400, 30);
      add(titulo);
    
          if(agregar){
          bagregar=new JButton("Agregar");
    bagregar.setBounds(150,50+(75*i),100,50);
    add(bagregar);
      bagregar.addActionListener(this);
      i=i+1;
          }
    if(modificar){
          bmodificar=new JButton("Modificar");
    bmodificar.setBounds(150,50+(75*i),100,50);
    add(bmodificar);
    bmodificar.addActionListener(this);
     i=i+1;
          }
    if(eliminar){
          beliminar=new JButton("Eliminar");
    beliminar.setBounds(150,50+(75*i),100,50);
    add(beliminar);
    beliminar.addActionListener(this);
    i=i+1;
          }
    if(lista){
          blista=new JButton("lista");
    blista.setBounds(150,50+(75*i),100,50);
    add(blista);
    blista.addActionListener(this);
    i=i+1;
         }
           
      
     salir=new JButton("Salir");
     salir.setBounds(280, 330, 80, 50);
     add(salir);
     salir.addActionListener(this);
     
      bmenu=new JButton("Menu");
     bmenu.setBounds(40, 330, 80, 50);
     add(bmenu);
     bmenu.addActionListener(this);
    
    
    }
   
    
     public void actionPerformed(ActionEvent e) {
     
     if(e.getSource()==salir){
     System.exit(0);
     }
     
     if(e.getSource()==bmenu){
     menu m =new menu();
     m.setVisible(true);
     this.hide();
     }
     
   if(e.getSource()==bagregar){
       ag();
    
    }
   if(e.getSource()==bmodificar){
       
    modi();
    }
   if(e.getSource()==beliminar){
       eliminar();
    
    }
   if(e.getSource()==blista){
      Listado les=new Listado(l);
      les.setVisible(true);
      this.hide();
     System.out.println("lista");
    }
     
     
     }
     public void ag(){
     Agregar ag=new Agregar(l);
    ag.setVisible(true);
    this.hide();
     
     }
     
     public void modi(){
      Modificar m=new Modificar(l);
     m.setVisible(true);
     this.hide();
     }
     public void eliminar(){
     Eliminar el=new Eliminar(l);
     el.setVisible(true);
     this.hide();
     
     }
     public void listado(){
     l.datos();
     datos=l.matris.clone();
     
     
     }
}
