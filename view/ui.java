import java.awt.BorderLayout;

import javax.swing.*;  
public class ui {  
    public static void main(String[] args) {  
        
        JFrame f=new JFrame();//creating instance of JFrame     
        f.setSize(800,700);//400 width and 500 height  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation        
        f.setLayout(new BorderLayout());//using no layout managers  
        f.setVisible(true);//making the frame visible 
        
        JPanel p = new JPanel(); 
        f.getContentPane().add(p);
        

    }  
}  