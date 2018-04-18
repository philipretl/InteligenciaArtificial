/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo.genetico;

import java.util.ArrayList;

/**
 *
 * @author philipretl
 */
public class Cromosoma {
    
    ArrayList<Integer> genotipo;
    Double fenotipo;
    int info,entero,decimal;
    int decimalValue = 0;
     
    public Cromosoma(ArrayList<Integer> genotipo,int info,int entero, int decimal) {
        this.genotipo = genotipo;
        this.info=info;
        this.entero=entero;
        this.decimal=decimal;
    }

    public ArrayList<Integer> getGenotipo() {
        return genotipo;
    }

    public void setGenotipo(ArrayList<Integer> genotipo) {
        this.genotipo = genotipo;
    }

    public Double getFenotipo() {
        return fenotipo;
    }

    public void setFenotipo(Double fenotipo) {
        this.fenotipo = fenotipo;
    }


    
    public double calcularFenotipo(){
        
        int [] vectorEntero = new int [entero];
        int [] vectorDecimal =  new int[decimal];
        int parteEntera=0;
        int parteDecimal=0;
        int cont=0;
        System.out.println("/");
        for(int i=info; i<=entero;i++){
            
            vectorEntero[cont]=genotipo.get(i);
            
            System.out.print(" - " + vectorEntero[cont]);
            cont ++;
        }
        
        cont = 0;
        System.out.println("");
        for(int i=entero+1; i<genotipo.size();i++){
            
            vectorDecimal[cont]=genotipo.get(i);
           
            System.out.print(" - " + vectorDecimal[cont]);
            cont ++;
        }
        
        parteDecimal=convertBinaryToDecimal(vectorDecimal,vectorDecimal.length-1);      
        decimalValue=0;
        parteEntera=convertBinaryToDecimal(vectorEntero,vectorEntero.length-1);
        
        
        System.out.println("parte entera"+ parteEntera);
        String cadenaEntera = String.valueOf(parteEntera);
        System.out.println("cadena entera: " + cadenaEntera);
        String cadenaDecimal = String.valueOf(parteDecimal);
        System.out.println("cadena decimal: " + cadenaDecimal);
        String cadenaTotal = cadenaEntera + "."+cadenaDecimal;
        
        fenotipo= Double.parseDouble(cadenaTotal);
        
        System.out.println("fenotipo: " + fenotipo);
        return fenotipo;
    }   


 public int convertBinaryToDecimal( int[] binaryValue, int index ) {
  //comprueba que el indice no sea menor que 0
  System.out.print("index: " + index);
 
  
  if(index >= 0) {
    //comprueba que el valor del binario sea 1 en la posicion del indice
    if(binaryValue[index] == 1) {
      // suma el valor del binario correspondiente al indice y lo guarda en decimalValue
      // ten en cuenta que el valor de un digito binario depende de la posicion en la que este en el arreglo
      // 
      // Ejemplo
      // 
      // indice del arreglo        0           2          3           4           5           6            7
      // valor del binario        2^6         2^5        2^4         2^3         2^2         2^1          2^0
      // 
      // Nota que se le resta 1 al numero de elementos del arreglo ya que un array comienza desde la posicion 0
      //
      decimalValue = (int) (decimalValue + (Math.pow(2, ( (binaryValue.length-1) - index ))));
      //Recursividad restandole 1 al indice para trabajar con el indice anterior
      convertBinaryToDecimal(binaryValue, index-1);
    }
    //en caso de que el valor del binario sea 0 en la posicion del indice no hace falta hacer ninguna operacion
    else{
    //Recursividad restandole 1 al indice para trabajar con el indice anterior
      convertBinaryToDecimal(binaryValue, index-1);
    }
  }
  //devuelve el valor del binario en Decimal
  return decimalValue;
  }
}