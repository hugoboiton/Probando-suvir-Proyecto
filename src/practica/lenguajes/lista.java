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
public class lista {
    int numeroElementos=0;
    Datos inicio;
    Datos fin;
    static String matris[][];
    public lista(){
    this.numeroElementos=0;
    this.inicio=null;
    this.fin=null;
    
    }
    public boolean EsVacio()
    {
        if(numeroElementos==0){return true;}
        else {return false;}
    }
    public void incertar(Datos nodo){
       try{
        if(EsVacio()==true){
            inicio = nodo;
            fin = inicio;
            
        }
     
        else{ 
            fin.siguiente= nodo;
            fin = fin.siguiente;
            
        }
         numeroElementos++;
       }catch (Exception Ex){
       
       }
    }
      public boolean eliminar(int n){
        try{
        if(EsVacio()!=true){
        
         int pos = ObtenerIndiceNodo(n);
                if (pos==1 && numeroElementos == 1) {
                    inicio = fin = null; 
                }
                else if (pos ==1 &&numeroElementos>1)
                {
                    Datos Temp = inicio.siguiente; 
                    inicio.siguiente = null; 
                    inicio = Temp; 
                }
                else if (pos > 1 && pos == numeroElementos)
                {
                    Datos Temp = ObtenerNodoPorIndice(pos-1); 
                    Temp.siguiente = null; 
                    fin = Temp; 
                }
                else 
                {
                    Datos Temp = ObtenerNodoPorIndice(pos-1); 
                    Datos Aux = Temp.siguiente; 
                    Temp.siguiente = Aux.siguiente; 
                    Aux.siguiente = null; 
                }
                numeroElementos--;
                return true;
                }
        else{return false;}
        
        }  
        catch(Exception Ex){return false;}   
       
                 
        
        
}
      public int ObtenerIndiceNodo(int Dato)
    {
        try
        {
            if (EsVacio()!=true)
            {
                Datos Temp = inicio;
                int dat = -1;
                int contador = 1;
                while (Temp!=null)
                {
                    dat = Temp.getCarne();
                    if (dat == Dato)
                    {
                        return contador;
                    }
                    contador++; 
                    Temp = Temp.siguiente;  
                }
                return -1;
            }
            else{return -1;}
        }
        catch(Exception Ex)
        {
            return -1;
        }
    }
       public Datos ObtenerNodoPorIndice(int posicion)
    {
        try
        {
            if (EsVacio()!=true)
            {
                Datos Temp = inicio;
                for (int i=1;i<posicion;i++)
                {
                    Temp = Temp.siguiente;
                }
                return Temp;
            }
            else{return null;}
        }
        catch(Exception Ex)
        {
            return null;
        }
    }
      
      public void modificar(int carne,String opcion,String par){
         
          
          Datos actual=inicio;
          while(actual!=null){
           if(actual.getCarne()==carne){
            if(opcion.equalsIgnoreCase("Semestre")){
             actual.setSemestre(par);
            }else{
                actual.setNombre(par);
            }
             
         
          
           actual=null;         
           }else{
           actual =actual.siguiente;
           }
       }
      
      }
        public void imprimir (){
        Datos reco = inicio;
        while (reco != null) {
            System.out.print (reco.getCarne() + "-");
            
            reco = reco.siguiente;
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
        public void datos(){
      int f=  numeroElementos;
      matris= new String[f][3];
      for(int i=0;i<f;i++){
        for(int j=0;j<3;j++){
        matris[i][j]="";
        }
        
        }
      int b=0;
       Datos reco = inicio;
        while (reco != null) {
            matris[b][0]=Integer.toString(reco.getCarne());
            matris[b][1]=reco.getNombre();
            matris[b][2]=reco.getSemestre();
            b=b+1;
            reco = reco.siguiente;
        }
      
        
        }
    
    
}
