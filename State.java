import javax.swing.*;


public class State{
private int number;//q1
private boolean initial;//
private boolean isfinal;


public State(){
  number=0;
  initial=false;
  isfinal=false;


}

public int getNumber(){
  return number;
}

public boolean getInitial(){
  return initial;
}

public boolean getFinal(){
  return isfinal;

}

public void setNumber(int n){
  number=n;
}

public void setInitial(boolean a){
  initial=a;

}

public void setFinal(boolean f){
  isfinal=f;
}
//algo
}
