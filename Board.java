import javax.swing.*;
import java.util.*;

public class Board{

JComboBox stateCB;
JButton accept;
JPanel panel1,panel2;


public Board(){
  super("DFA");


stateCB=new JComboBox("");
stateCB.addItem("1");
stateCB.addItem("2");
stateCB.addItem("3");
stateCB.addItem("4");
stateCB.addItem("5");

panel1=new JPanel();
panel2=new JPanel();

  stateCB.setSelectedIndex(-1);

  setSize(550,600);
  setVisible(true);
  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }
}
