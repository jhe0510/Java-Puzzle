import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Puzzle  extends JFrame implements ActionListener{  
	
	public static void main(String[] args) {
		new Puzzle();
	}
	
	private JButton btn[];
	  
	Puzzle() {  
		 setTitle ("전효은 퍼즐");   
		 setSize (400,300);    
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 makeUI();
		 setVisible(true);
	}
	
private void makeUI () {
	     btn = new JButton[16];
	     setLayout( new GridLayout(4,4)); 
	     for (int i=0 ; i < 16 ; i++  ) {
	    	add (  btn[i] =  new JButton(String.valueOf(i)));   
 btn[i].setEnabled(true);  
 btn[i].addActionListener(this);  
              }
	    	btn[15].setText(""); 
	    	btn[15].setEnabled(false); 
	     }
	     		  
private int[] nb = new int[4]; 
private void findNeighbor (int id) { 
  
  nb[0] = id -4;
  
 
  nb[1] = id + 4;
  if (nb[1] >= 16 )
        nb[1] = -1; 


  nb[2] = id - 1;
  if ((nb[2]) < 0  || nb[2] %4 == 3)
      nb[2] = -1;

  nb[3] = id + 1;
  if ((nb[3]) % 4 == 0 )
     nb[3] = -1; 
} 


 public void actionPerformed(ActionEvent e) {
    JButton b = (JButton)e.getSource();  
    
         int id;
         for ( id= 0 ; id<16; id++)    
               if (b == btn[id])
                  break;

                                    
            findNeighbor(id) ;         


             for (int i=0; i<4; i++) {  
             if ( nb[i] >= 0 && !btn[nb[i]].isEnabled())  { 
                 JButton act, inact;
                  act = btn[id];  
                 inact = btn[nb[i]];  
             inact.setText( act.getText() );  
	     act.setText("");            
	     inact.setEnabled(true);        
	     act.setEnabled(false);
             break;  
             }
 }
}}
