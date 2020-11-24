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
String st;
char[]cadenaString;
 //t1;
 int[] arrayString;
int[][] tablatransicion;
int[]transicion;
boolean strinState;
//buffer readaer

JComboBox stateCB,askFinal,edoiniCB,fin1CB,fin2CB;
JButton bacceptState;
JButton btReset;
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
btReset = new JButton("Comenzar de nuevo");
btReset.addActionListener(this);
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
   panel2.add(btReset);
   panel2.add(automataTa);
   panel2.add(new JScrollPane(automataTa));



  add(panel2);
  setSize(550,600);
  setVisible(true);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

public void askTupla(  String edos,String in,String fin){ //M�todo para los estados
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
      fina1=(Integer.parseInt(f1)-1);
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

       st=JOptionPane.showInputDialog("Cual sera el string que verificaras :");
    strinState =verifyString(st);
    if(strinState==true){
  JOptionPane.showMessageDialog(null,"El String fue ACEPTADO debido a quetermin� en un estado de aceptacion");
}else{  JOptionPane.showMessageDialog(null,"El String fue RECHAZADO debido a que NO termin� en un estado de aceptaci�n");}
   imprimirText();

      }

  //MÉtodo para el ALFABETO
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
  //MÉtodo para la tabla de transición
  void transicion(){
        //Usamos un try catch para detectar si hay algun error
        int contador;
        try{
        contador=1;
        tablatransicion=new int[statesAll.length][2];

        for(int ii=0; ii<x; ii++){
            for(int jj=0; jj<2; jj++){
              String r;
                r=JOptionPane.showInputDialog("Posicion en q"+(ii+1)+" y caracter "+Character.toString(alfabeto[jj]));
                tablatransicion[ii][jj]=(Integer.parseInt(r)-1);
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
    int autR=initial;
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
     if(e.getSource() == btReset)
		{
			//taCode.setText("");
			automataTa.setText("");

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

public void printMatriz(){
  automataTa.append("             "+alfabeto[0]+"          "+alfabeto[1]);
  automataTa.append("\r\n");
 int cont=0;
  for(int i=0;i<x;i++){
    for(int j=0;j<2;j++){
       if(cont==0){
          automataTa.append("q"+(i+1)+"        q"+(tablatransicion[i][j]+1));
          cont=1;
        }else{automataTa.append("        q"+(tablatransicion[i][j]+1));}

        //System.out.println("AQUI ESTA"+tablatransicion[i][j]);
    }
    cont=0;
    automataTa.append("\r\n");


  }

}
public String getStates(){
String states="";
  for(int i=0;i<x;i++){
    if(i==(x-1)){
         states+=("q"+(i+1));
    }else{states+=("q"+(i+1)+",");}

  }
  return states;
}
public void printMoveString(){
for(int i=0;i<cadenaString.length;i++){
       if(i==0){
         automataTa.append("{q"+(initial+1)+","+cadenaString[i]+"}=q"+(transicion[i]+1)+"\r\n");
       }else{
          automataTa.append("{q"+(transicion[i-1]+1)+","+cadenaString[i]+"}=q"+(transicion[i]+1)+"\r\n");
       }
  }
}

public void imprimirText(){

  automataTa.append("AUTOMATA FINITO DETERMINISTA: \n\n");
    automataTa.append("Q={"+getStates()+"}\r\n\n");
  automataTa.append("q0=q"+(initial+1)+"\n\n");
  automataTa.append("Alfabeto={"+alfabeto[0]+","+alfabeto[1]+"}\n\n");
  if(finalesta.length==1){
     automataTa.append("F={q"+(finalesta[0]+1)+"}\n\n");
     }
     if(finalesta.length==2){
       automataTa.append("F={q"+(finalesta[0]+1)+",q"+(finalesta[1]+1)+"}"+"\n\n");
        }
        automataTa.append("Matriz de transición:\n\n");
       printMatriz();
       automataTa.append("\r\n");
    automataTa.append("String ingresado:"+st+"\r\n");
    automataTa.append("\r\n");
      printMoveString();

      if(strinState==true){
        automataTa.append("El String fue aceptado");
      }else{automataTa.append("El String fue rechazado");}

}

public static void main(String args[] ){
   new Automata();

}

}
