import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import java.awt.*;
import java.util.StringTokenizer;

public class Board extends JFrame implements ActionListener{

JComboBox stateCB,askFinal,edoiniCB;
JButton bacceptState;
JPanel panel1,panel2;


public Board(){
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

edoiniCB=new JComboBox();
edoiniCB.addItem("1");
edoiniCB.addItem("2");
edoiniCB.addItem("3");
edoiniCB.addItem("4");
edoiniCB.addItem("5");

bacceptState=new JButton("Ingresar datos");
stateCB.addActionListener(this);
askFinal.addActionListener(this);
bacceptState.addActionListener(this);
edoiniCB.addActionListener(this);


panel1=new JPanel();
panel2=new JPanel();

  stateCB.setSelectedIndex(-1);
  askFinal.setSelectedIndex(-1);
  edoiniCB.setSelectedIndex(-1);

  panel1.setLayout(new GridLayout(0,2));
    panel2.setLayout(new FlowLayout());

    panel1.add(new JLabel("Numero de estados:"));
    panel1.add(stateCB);
    panel1.add(new JLabel("Edo inicial:"));
    panel1.add(edoiniCB);
    panel1.add(new JLabel("Numero de estados finales:"));
    panel1.add(askFinal);
    panel1.add(bacceptState);
    panel2.add(panel1);


  add(panel2);
  setSize(550,600);
  setVisible(true);
  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }

  public void actionPerformed(ActionEvent e) {
    String edos,edosFin,edoIni;
    if(e.getSource()==bacceptState){
      edos=(String) stateCB.getSelectedItem();
      edosFin=(String) askFinal.getSelectedItem();
      edoIni=(String)edoiniCB.getSelectedItem();
    }


      // code
  }
  public static void main(String args[])
{
    new Board();
}
}
