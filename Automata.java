import javax.swing.*;
import java.util.*;

public class Automata{

int x;//numero de elfos que habra , se le preguntara en la quintupla
State[] statesAll;//maximo 5 states
int initial;
int fin,a;
String  alphabet[]=new String[2];//debido a que solo se permitiran dos caracteres
char[] finalesta,alfabeto;
String fi="";
String t1;
 //t1;
int[][] tablatransicion;
//buffer readaer

public void askTupla(){ //Método para los estados
  //Usamos un try catch para detectar si existe algun error

  String edos,in,fin;

    edos = JOptionPane.showInputDialog("Introduzca el número de estados que se desea:");
    x=Integer.parseInt(edos);
    statesAll=new State[x];
    System.out.println(statesAll.length);
    for(int i=0;i<x;i++){
      statesAll[i]=new State();
      statesAll[i].setNumber(i);

    }

    in= JOptionPane.showInputDialog("Introduzca el estado que deseas que sea el edo inicial");
    initial=Integer.parseInt(in);
    statesAll[initial].setInitial(true);


    fin=JOptionPane.showInputDialog("Introduzca el número de estados finales");
    finalesta=new char[Integer.parseInt(fin)];


    for(int i=0; i<finalesta.length; i++)
        {
          int fina;
            String f=JOptionPane.showInputDialog("Estado Final "+i+":");

            fi=fi+f;
            fina=Integer.parseInt(f);
            statesAll[fina].setFinal(true);
            System.out.println(fi);
        }
    finalesta=fin.toCharArray();

      }

  //Método para el ALFABETO
  void alfabeto()
  {
        //Usamos un try catch para detectar si hay error
        try{
        String al=JOptionPane.showInputDialog("Ingresar letras del alfabeto");
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
        int contador;
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







public static void main(String args[] ){
  Automata automat =new Automata();
  automat.askTupla();
}

}
