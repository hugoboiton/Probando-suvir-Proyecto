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
import java.io.*;
import java.util.*;
public class AnalizadorLexico {
    
    lista l;
    
    
     static boolean agregar= false;
    static boolean eliminar=false;
   static boolean modificar=false;
   static boolean listado= false;
     boolean Eagregar= false;
    boolean Eeliminar=false;
    boolean Emodificar=false;
    boolean Elistado= false;
    boolean menu=false;
    boolean opcion=false;
    String palabra="";
    String reservada="";
    String etiqueta="";
    String opciones="";
    int carne=0;
    String nombre="";
    String semestre="";
    char operador;
    String aux="";
    String mando="";
    boolean falso=false;
    int line=1;
    int refe=0;
    
    public AnalizadorLexico(lista lis){
    l=lis;
    
    }
    public void analizar(String ruta){
     
 String bufferIn;
        try{
            DataInputStream in=new DataInputStream(new FileInputStream(ruta));
            try{
                while((bufferIn=in.readLine())!=null){
                    int i=0;
                    String cad=bufferIn.trim();
                    
                                      
                    while(i<cad.length()){
                        char t=cad.charAt(i);
                        if(!Character.isLetterOrDigit(t)){
                           
                            if(evaluarCaracter(t)){
                                System.out.println("Operador--- "+evaluarOperador(t));
                                operador=evaluarOperador(t);
                                 
                            }else{//¿o es un operador?
                               
                                char ero=t;
                                System.out.println("Error linea # "+line+" no pertenes al lenguaje -- "+ero);
                              operador=t;
                              refe=line; 
                             falso=true;
                             
                            }
                            mando="";
                            mando=mando+operador;
                            if(!falso){
                            estado(mando);
                            mando="";
                            } else if(line>refe){
                           falso=false;
                           }
                            mando="";
                            
                            
                            
                            i++;
                            continue;
                            
                        }else{
                        
                        String ora="";
                            ora+=t;
                            int j=i+1;
                            while(Character.isLetterOrDigit(cad.charAt(j))){
                            
                                ora+=cad.charAt(j);
                                j++;
                                if(j==cad.length())break;
                            }
                            i=j;
                            
                             
                            if(!falso){
                            if(palabraReservada(ora)){
                                System.out.println("Palabra reservada--- "+ora);
                                 reservada=ora;
                                 mando=reservada;
                                 estado(mando);
                                 mando="";
                                 
                                
                                 
                                }else if(palabraOpcion(ora)){
                                 System.out.println("Palabra reservada opcional--- "+ora);
                                 opciones=ora;    
                                 
                                 if(enti()){
                                 mando=opciones;    
                                 estado(mando);   
                                 mando="";    
                                 }else{
                                 hablitarMenu();}
                                   
                                                          
                                  
                                }else if(etiquetas(ora)){
                                 System.out.println("Etiqueta--- " +ora);
                                 etiqueta=ora;
                                 if(etiqueta.equals("opcion")){
                                 mando=etiqueta;
                                 estado(mando);
                                 etiqueta="";
                                 }
                                 
                                }
                                
                            else{
                           
                                System.out.println("ID--- "+ora);
                                  palabra=ora;
                                  opciones(opciones);
                                  palabra="";
                                  
                            }
                            
                            }else{ora="";}
                           continue;
                            
                            
                        }
                    }
                   line++; 
                }
            }catch(IOException e){}
        }catch(FileNotFoundException e){}
    }
    public static boolean evaluarCaracter(char c){
        if(c=='<') return true;
        else if(c=='>') return true;
        else if(c=='/') return true;
        else return false;
    }
    public static char evaluarOperador(char c){
        char car=' ';
        if(c=='<')car='<';
        else if(c=='>')car='>';
        else if(c=='/')car='/';
        
        return car;
    }
     public static boolean etiquetas(String eti){
         if(eti.equalsIgnoreCase("Carnet"))return true;
         else if(eti.equalsIgnoreCase("Semestre"))return true;
         else if (eti.equalsIgnoreCase("Nombre"))return true;
         else if(eti.equalsIgnoreCase("opcion"))return true;
         
     return false;
     }
    public static boolean palabraReservada(String cad){
        if(cad.equalsIgnoreCase("menu")) return true;
        else if(cad.equalsIgnoreCase("XML"))return true;
        
        else return false;
    }
    public  boolean palabraOpcion(String cad){
        if(cad.equals("Agregar"))return true;
        else if(cad.equalsIgnoreCase("Modificar"))return true;
        else if(cad.equalsIgnoreCase("Eliminar"))return true;
        else if(cad.equalsIgnoreCase("Listado"))return true;
        else return false;
    }  
    
    public void hablitarMenu(){
     if(menu){
      if((opciones.equalsIgnoreCase("Agregar"))&&opcion){
        agregar=true;
        opciones="";
        mando="";
        System.out.println("HABLITADA---  "+opciones);
      }else if((opciones.equalsIgnoreCase("Modificar"))&&opcion){
      modificar=true;
       opciones="";
       mando="";
      System.out.println("HABLITADA---  "+opciones);
      }else if((opciones.equalsIgnoreCase("Eliminar"))&&opcion){
      eliminar=true;
       opciones="";
       mando="";
      System.out.println("HABLITADA---  "+opciones);
      }else if((opciones.equalsIgnoreCase("Listado"))&&opcion){
      listado=true;
       opciones="";
       mando="";
      System.out.println("HABLITADA---  "+opciones);
      }
      
     }
    }
 public void estado(String lectura ){
       aux=aux+lectura;
        
       if(aux.equals("<XML>")){
                            aux="";
              
                            
                            }
      if(aux.equals("<menu>")){
        if(!menu){
           menu=true;
            }else{
                menu=false;}
      aux="";
      reservada="";
        }else if(aux.equals("</menu>")){
        if(menu){
         menu=false;
          }else{menu=true;}
        aux="";
        reservada="";
        }
      if(aux.equals("<opcion>")){
       if(!opcion){
       opcion=true;
      }else{
           opcion=false;
       }
       aux="";
       etiqueta="";
        }else if(aux.equals("</opcion>")){
        if(opcion){
         opcion=false;
          }else{
            opcion=true;
        }
        aux="";
        etiqueta="";
        }
      if(aux.equals("<Agregar>")){
       
         if(!Eagregar){
       Eagregar=true;
      }else{
           Eagregar=false;
       }
       aux="";
       
        }else if(aux.equals("</Agregar>")){
        if(Eagregar){
         Eagregar=false;
          }else{
            Eagregar=true;
        }
        aux="";
        
        }
       if(aux.equals("<Modificar>")){
       
         if(!Emodificar){
       Emodificar=true;
      }else{
           Emodificar=false;
       }
       aux="";
       
        }else if(aux.equals("</Modificar>")){
        if(Emodificar){
         Emodificar=false;
          }else{
            Emodificar=true;
        }
        aux="";
        
        }
        if(aux.equals("<Eliminar>")){
       
         if(!Eeliminar){
       Eeliminar=true;
      }else{
           Eeliminar=false;
       }
       aux="";
       
        }else if(aux.equals("</Eliminar>")){
        if(Eeliminar){
         Eeliminar=false;
          }else{
            Eeliminar=true;
        }
        aux="";
        
        }
      
      if(aux.equals("<>")||aux.equals("</>")){
      aux="";
      
      }
      
      
      
      
    
    
 }
     
    public void opciones(String opcion){
  if(agregar&&(opcion.equalsIgnoreCase("Agregar"))){
  ingreso();
  }else if(modificar&&(opcion.equalsIgnoreCase("Modificar"))){
    modificar();
  
  }else if(eliminar&&(opcion.equalsIgnoreCase("Eliminar"))) {
     int cod=Integer.parseInt(palabra);
      l.eliminar(cod);
  }else{
 System.out.println("la opcion no se puede realizar no hablitada");
         
  
  }   

    
    
    }
    public void ingreso(){
    if(Eagregar){
        if(etiqueta.equalsIgnoreCase("Carnet")){
         carne=Integer.parseInt(palabra);
        }
        if(etiqueta.equalsIgnoreCase("Nombre")){
        nombre=palabra;
        }
        if(etiqueta.equalsIgnoreCase("Semestre")){
         semestre=palabra;
        }
        if(carne!=0&&!"".equals(nombre)&&!"".equals(semestre)){
         
            Datos nodo= new Datos();
            nodo.setCarne(carne);
    nodo.setNombre(nombre);
    nodo.setSemestre(semestre);
    carne=0;
    nombre="";
    semestre="";
    
    l.incertar(nodo);
            }
           }
    
             }
    public void modificar(){
    
    String campo="";
    String eti="";
    if(Emodificar){
    if(etiqueta.equalsIgnoreCase("carnet")){
    carne=Integer.parseInt(palabra);
    
    }
    if(etiqueta.equals("Nombre")){
    campo=palabra;
    eti=etiqueta;
    }
    if(etiqueta.equals("Semestre")){
    campo=palabra;
    eti=etiqueta;
    }
    if(carne!=0&&!"".equals(campo)) {
        l.modificar(carne,eti,campo);
        campo="";
        carne=0;
        eti="";
            }
                                     }
    
    }
    public boolean enti(){
   if(agregar&&(opciones.equalsIgnoreCase("Agregar")))return true;
   else if(modificar&&(opciones.equalsIgnoreCase("Modificar")))return true;
   else if(eliminar&&(opciones.equalsIgnoreCase("Eliminar")))return true;
   else return false;
   }
    
    }

