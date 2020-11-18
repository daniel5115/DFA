import javax.swing.*;
import java.util.*;

public class Automata{

int x;//numero de elfos que habra , se le preguntara en la quintupla
State[] statesAll=new State[x];//maximo 5 states
int initial;
int final;
String  alphabet[]=new String[2];//debido a que solo se permitiran dos caracteres
//buffer readaer

public void askTupla(){
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
     catch(Exception edos)
     {
            JOptionPane.showMessageDialog(null,"Error "+edos); 
            x=0;
            finalesta=new char[0];
            fi="";
     }

}






public static void(String args[] ){
  Automata automat =new Automata()
  automat.askTupla();
}

}
