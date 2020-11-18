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
  String edos,in,fin;
    edos = JOptionPane.showInputDialog("Introduzca el número de estados que se desea:");
    in= JOptionPane.showInputDialog("Introduzca el estado que deseas que sea el edo inicial");
    fin=JOptionPane.showInputDialog("Introduzca el edo que deasea que sea el final");

    x=Integer.parseInt(edos);
    initial=Integer.parseInt(in);
    fin=Integer.parseInt(fin);

}






public static void(String args[] ){
  Automata automat =new Automata()
  automat.askTupla();
}

}
