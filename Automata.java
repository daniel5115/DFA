import javax.swing.*;
import java.util.*;

public class Automata{

int x;//numero de elfos que habra , se le preguntara en la quintupla
State[] statesAll;//maximo 5 states
int initial;
int fin,a;
char[] finalesta;
char[] alfabeto=new char[2];//debido a que solo se permitiran dos caracteres
String fi="";
char[]cadenaString;
 //t1;
 int[] arrayString;
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
      statesAll[i].setNumber(i+1);

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

    alfabeto();
    transicion();

      String st=JOptionPane.showInputDialog("Cual sera el string que verificaras :");
      verifyString(st);


      }

  //Método para el ALFABETO
  void alfabeto()
  {
        //Usamos un try catch para detectar si hay error
        try{
          //alfabeto[0]='a';


        for(int i=0; i<2; i++){
            String t=JOptionPane.showInputDialog("Caracter "+(i+1)+" del alfabeto:");
           alfabeto[i]=t.charAt(0);
            System.out.println(alfabeto[i]);

        }

        for(int i=0; i<alfabeto.length; i++){
            JOptionPane.showMessageDialog(null,"Caracter "+alfabeto[i]+" ingresado");

        }

      }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error "+e);
            a=0;


            //alfabeto=new char[0];
        }
    }
  //Método para la tabla de transición
  void transicion(){
        //Usamos un try catch para detectar si hay algun error
        int contador;
        try{
        contador=1;
        tablatransicion=new int[2][statesAll.length];

        for(int ii=0; ii<x; ii++){
            for(int jj=0; jj<2; jj++){
              String r;
                r=JOptionPane.showInputDialog("Valor en con automata q"+(ii+1)+" y caracter "+Character.toString(alfabeto[jj]));
                tablatransicion[jj][ii]=Integer.parseInt(r);
            }
        }}
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error "+e);
            contador=0;
            tablatransicion=new int[0][0];
        }
    }

  public boolean isCharAll(){
    boolean a=false;
        arrayString=new int[cadenaString.length];
    for(int i=0;i<cadenaString.length;i++){
        if((cadenaString[i]==alfabeto[0])){

          if((cadenaString[i]==alfabeto[1])){
              arrayString[i]=1;

          }
        }
    }
System.out.println(a);
    return a;
 }



     public boolean verifyString(String a){
        cadenaString=a.toCharArray();
     System.out.println(alfabeto[0]);
      System.out.println(alfabeto[1]);
    if(isCharAll()==false){

      for(int i=0;i<arrayString.length;i++){
       System.out.println(arrayString[i]);
      }

    }
     return true;
   }






public static void main(String args[] ){
  Automata automat =new Automata();
  automat.askTupla();
}

}
