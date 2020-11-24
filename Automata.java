import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Automata extends JFrame implements ActionListener,ItemListener{

int x;//numero de elfos que habra , se le preguntara en la quintupla
State[] statesAll;//maximo 5 states
int initial;//automata inicial
int fin,a;//automata final
int[] finalesta;//guarda automatas finales,max 2
char[] alfabeto=new char[2];//debido a que solo se permitiran dos caracteres
String fi="";
char[]cadenaString;
 //t1;
 int[] arrayString;
int[][] tablatransicion;
int[]transicion;
//buffer readaer

JComboBox stateCB,askFinal,edoiniCB,fin1CB,fin2CB;
JButton bacceptState;
JPanel panel1,panel2,panel3;
JLabel fin1Lbl,fin2Lbl;
JTextField car1,car2;
JTextArea automataTa;

public Automata(){
  super("DFA");


stateCB=new JComboBox();
stateCB.addItem("1");
stateCB.addItem("2");
stateCB.addItem("3");
stateCB.addItem("4");
stateCB.addItem("5");

askFinal=new JComboBox();
askFinal.addItem("1");
askFinal.addItem("2");
askFinal.addItemListener(this);

edoiniCB=new JComboBox();
edoiniCB.addItem("1");
edoiniCB.addItem("2");
edoiniCB.addItem("3");
edoiniCB.addItem("4");
edoiniCB.addItem("5");

fin1CB=new JComboBox();
fin1CB.addItem("1");
fin1CB.addItem("2");
fin1CB.addItem("3");
fin1CB.addItem("4");
fin1CB.addItem("5");


fin2CB=new JComboBox();
fin2CB.addItem("1");
fin2CB.addItem("2");
fin2CB.addItem("3");
fin2CB.addItem("4");
fin2CB.addItem("5");

fin1Lbl=new JLabel("Estado Final 1:");
fin2Lbl=new JLabel("Estado Final 2:");

car1=new JTextField();
car2=new JTextField();

automataTa = new JTextArea(20,35);

bacceptState=new JButton("Ingresar datos");
stateCB.addActionListener(this);
askFinal.addActionListener(this);
bacceptState.addActionListener(this);
edoiniCB.addActionListener(this);


panel1=new JPanel();
panel2=new JPanel();
panel3=new JPanel();

  stateCB.setSelectedIndex(-1);
  askFinal.setSelectedIndex(-1);
  edoiniCB.setSelectedIndex(-1);
//  fin1CB.setSelectedIndex(-1);
  //fin2CB.setSelectedIndex(-1);


  panel1.setLayout(new GridLayout(0,2));
  panel3.setLayout(new GridLayout(0,2));
    panel2.setLayout(new FlowLayout());

    panel1.add(new JLabel("Numero de estados:"));
    panel1.add(stateCB);
    panel1.add(new JLabel("Edo inicial:"));
    panel1.add(edoiniCB);
    panel1.add(new JLabel("Numero de estados finales:"));
    panel1.add(askFinal);

    panel3.add(fin1Lbl);
      fin1Lbl.setVisible(false);
    panel3.add(fin1CB);
    fin1CB.setVisible(false);
    panel3.add(fin2Lbl);
    fin2Lbl.setVisible(false);
    panel3.add(fin2CB);
    fin2CB.setVisible(false);
    panel1.add(new JLabel("Alfabeto:"));
    panel1.add(new JLabel("2 caracteres"));
    panel2.add(panel1);
    panel2.add(panel3);
    panel1.add(new JLabel("Caracter 1:"));
    panel1.add(car1);
    panel1.add(new JLabel( "Caracter 2:"));
    panel1.add(car2);




   panel2.add(bacceptState);
   panel2.add(automataTa);



  add(panel2);
  setSize(550,600);
  setVisible(true);
  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }

public void askTupla(  String edos,String in,String fin){ //Método para los estados
  //Usamos un try catch para detectar si existe algun error



    x=Integer.parseInt(edos);
    statesAll=new State[x];
    System.out.println(statesAll.length);
    for(int i=0;i<x;i++){
      statesAll[i]=new State();
      statesAll[i].setNumber(i+1);

    }


    initial=(Integer.parseInt(in))-1;
    statesAll[initial].setInitial(true);



    finalesta=new int[Integer.parseInt(fin)];


  if(finalesta.length==1){
    int fina;
      String f=(String) fin1CB.getSelectedItem() ;

    //  fi=fi+f;
      fina=(Integer.parseInt(f)-1);
      statesAll[fina].setFinal(true);
      finalesta[0]=fina;
      System.out.println(fi);

  }
  if(finalesta.length==2){
    int fina,fina1;
      String f=(String) fin1CB.getSelectedItem() ;
      String f1=(String) fin2CB.getSelectedItem() ;


    //  fi=fi+f;
      fina=(Integer.parseInt(f)-1);
      fina1=(Integer.parseInt(f)-1);
      statesAll[fina].setFinal(true);
      statesAll[fina1].setFinal(true);
      finalesta[0]=fina;
      finalesta[1]=fina1;

      System.out.println(fi);

  }


     String char1,char2;
     char1=car1.getText();
    char2=car2.getText();
    alfabeto(char1,char2);
    transicion();

      String st=JOptionPane.showInputDialog("Cual sera el string que verificaras :");
    boolean strinState =verifyString(st);
    if(strinState==true){
  JOptionPane.showMessageDialog(null,"El String fue aceptado satisfactoriamente");
}else{  JOptionPane.showMessageDialog(null,"El String no fue aceptado");}
   imprimirText();

      }

  //Método para el ALFABETO
  void alfabeto(String a1,String b1)
  {
        //Usamos un try catch para detectar si hay error
        try{
          //alfabeto[0]='a';



           alfabeto[0]=a1.charAt(0);
           alfabeto[1]=b1.charAt(0);
           for(int i=0;i<alfabeto.length;i++){
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
                tablatransicion[ii][jj]=Integer.parseInt(r);
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
    int ab=0;
  for(int i=0;i<cadenaString.length;i++){
        if((cadenaString[i]==alfabeto[0])||(cadenaString[i]==alfabeto[1])){
          ab+=1;
         }
       }
     if(ab==cadenaString.length){
     a=true;
   }
  return a;
 }

 public void convertString(){
     arrayString=new int[cadenaString.length];
     char a= alfabeto[0];
     char b=alfabeto[1];
     for(int i=0;i<arrayString.length;i++){
         if(cadenaString[i]==a){
           arrayString[i]=0;

           }
          if(cadenaString[i]==b){
           arrayString[i]=1;
             }
             System.out.println( arrayString[i]);
       }
     }

public void stringMove(){
  System.out.println("La transicion del string es:");
  transicion=new int[arrayString.length];
    int autR=x-1;
  for (int i=0;i<arrayString.length;i++){

  autR=tablatransicion[autR][arrayString[i]];//checar aqui,en i es donde te lleva el resultado
   transicion[i]=autR;
   System.out.println(autR);

  }
}

public boolean comparefinal(){
  boolean a=false;
  for(int i=0;i<finalesta.length;i++){
    if(transicion[(transicion.length)-1]==finalesta[i]){
       a=true;
    }
  }
return a;
}


 public boolean verifyString(String a){
   boolean ans=false;
      cadenaString=a.toCharArray();
      System.out.println(alfabeto[0]);
      System.out.println(alfabeto[1]);
      System.out.println(isCharAll());
   if(isCharAll()==true){
      convertString();
      stringMove();
      if(comparefinal()==true){
      ans=true;
      }

     }
      return ans;
   }

   public void actionPerformed(ActionEvent e) {
     String edos,edosFin,edoIni;
     if(e.getSource()==bacceptState){
       edos=(String) stateCB.getSelectedItem();
       edosFin=(String) askFinal.getSelectedItem();
       edoIni=(String)edoiniCB.getSelectedItem();
       askTupla(edos,edoIni,edosFin);
     }


}

public void addPanel(String a){
  if(a=="1"){
    fin1CB.setVisible(true);
    fin1Lbl.setVisible(true);

    fin2CB.setVisible(false);
      fin2Lbl.setVisible(false);

  }
  if(a=="2"){
    fin1CB.setVisible(true);
    fin1Lbl.setVisible(true);

    fin2CB.setVisible(true);
      fin2Lbl.setVisible(true);
  }
}
public void itemStateChanged(ItemEvent e){
String edosFin;
  if(e.getStateChange()==ItemEvent.SELECTED){
   Object source = e.getSource();
  //   edosFin=(String) askFinal.getSelectedItem();
if (source instanceof JComboBox) {
  JComboBox cb = (JComboBox)source;
  Object selectedItem = cb.getSelectedItem();
      addPanel((String)selectedItem);
  }
 }
}
public void imprimirText(){
  automataTa.append("q0=q"+x);
  automataTa.append("Alfabeto={"+alfabeto[0]+","+alfabeto[1]+"}");
  if(finalesta.length==1){
     automataTa.append("qf={q"+finalesta[0]+"}");
     }
     if(finalesta.length==1){
       automataTa.append("qf={q"+finalesta[0]+",q"+finalesta[1]+"}");
        }


}

public static void main(String args[] ){
   new Automata();

}

}
