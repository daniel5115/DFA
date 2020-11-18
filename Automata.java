import javax.swing.*;
import java.util.*;

public class Automata{

int x;//numero de elfos que habra , se le preguntara en la quintupla
State[] statesAll=new State[x];//maximo 5 states
int initial;
int final;
String  alphabet[]=new String[2];//debido a que solo se permitiran dos caracteres
//buffer readaer

public void askTupla(){ //Método para los estados
  //Usamos un try catch para detectar si existe algun error
  try{
  String edos,in,fin;
    edos = JOptionPane.showInputDialog("Introduzca el número de estados que se desea:");
    x=Integer.parseInt(edos);
    in= JOptionPane.showInputDialog("Introduzca el estado que deseas que sea el edo inicial");
    initial=Integer.parseInt(in);
    fin=JOptionPane.showInputDialog("Introduzca el número de estados finales");
    finalesta=new char[Integer.parseInt(fin)];
    for(int i=0; i<finalesta.length; i++)
        {
            String f=JOptionPane.showInputDialog("Estado Final "+i+": ");
            fi=fi+f;
        }
    finalesta=fin.toCharArray();
        for(int i=0; i<finalesta.length; i++)
        {
            JOptionPane.showMessageDialog(null,"Caracter "+finalesta[i]+" ingresado");
        }
      }
     catch(Exception e)
     {
            JOptionPane.showMessageDialog(null,"Error "+e); 
            x=0;
            finalesta=new char[0];
            fi="";
     }
}
  //Método para el ALFABETO
  void alfabeto()
  {
        //Usamos un try catch para detectar si hay error
        try{
        String al=JOptionPane.showInputDialog("Tamaño del Alfabeto: ");
        a=Integer.parseInt(al);
        tablatransicion=new int[x][a];
        for(int i=0; i<a; i++){
            String t=JOptionPane.showInputDialog("Caracter "+i+" del alfabeto:");
            t1=t1+t;
        }
        alfabeto=t1.toCharArray();
        for(int i=0; i<alfabeto.length; i++){
            JOptionPane.showMessageDialog(null,"Caracter "+alfabeto[i]+" ingresado");
        }}
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error "+e); 
            a=0;
            tablatransicion=new int[0][0];
            t1="";
            alfabeto=new char[0];
        }
    }
  //Método para la tabla de transición
  void transicion(){
        //Usamos un try catch para detectar si hay algun error
        try{
        contador=1;
        for(int ii=0; ii<x; ii++){
            for(int jj=0; jj<a; jj++){
                String r=JOptionPane.showInputDialog("Ingrese los valores de la tabla de transicion en["+ii+"]["+jj+"]");
                tablatransicion[ii][jj]=Integer.parseInt(r);
            }
        }
        for(int ii=0; ii<x; ii++){
            for(int jj=0; jj<a; jj++){
                JOptionPane.showMessageDialog(null,"Valor en posicion["+ii+"]["+jj+"]="+tablatransicion[ii][jj]);
            }
        }}
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error "+e);
            contador=0;
            tablatransicion=new int[0][0];
        }
    } 
  
  






public static void(String args[] ){
  Automata automat =new Automata()
  automat.askTupla();
}

}
