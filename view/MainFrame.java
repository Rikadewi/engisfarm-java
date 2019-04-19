package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.Image;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.Font;

public class MainFrame extends JFrame implements ActionListener {
    
    private static JLabel[][] grid = new JLabel[10][10];
    static String name = "charles";
    private static JPanel LeftPanel;
    private static JPanel InventoryPanel;
    private static JPanel CondPanel;
    private static JPanel RightPanel;
    private static JPanel MidPanel;
    private static JPanel TopPanel;
    private static JPanel BotPanel;
    private static JPanel Map;
    private JLabel Animals;
    private JLabel Name;
    private JLabel Ticker;

    public MainFrame() {
        setTitle("Rikas Farm Game");
        setSize(1000, 800);
        
        /*Create Panels */

        //Left Panel
        LeftPanel = new JPanel(new GridLayout(2, 1));
        LeftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        InventoryPanel = new JPanel(new GridLayout(10,0));
        CondPanel = new JPanel(new GridLayout(3,0));  
        renderCondition(10, 5000, true);      

        //Right Panel
        RightPanel = new JPanel();
        RightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        //Top Panel
        TopPanel = new JPanel(null);
        TopPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));



        Animals = new JLabel("Animals : " );
        Animals.setFont(new Font("Dialog", Font.BOLD, 18));
        Animals.setBounds(800, 3, 200, 50);
        TopPanel.add(Animals);

        Ticker = new JLabel("Tick: ");
        Ticker.setFont(new Font("Dialog", Font.BOLD, 18));
        Ticker.setBounds(400, 3, 100, 50);
        TopPanel.add(Ticker);

        //Bot Panel
        BotPanel = new JPanel(new GridLayout(3,3));
        BotPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel Msg1 = new JLabel("Message 1 : ");
        JLabel Msg2 = new JLabel("Message 2 : ");
        JLabel Msg3 = new JLabel("Message 3 : ");
        BotPanel.add(Msg1);
        BotPanel.add(Msg2);
        BotPanel.add(Msg3);

        //Mid Panel
        MidPanel = new JPanel(new BorderLayout());
        MidPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        /*Create Map Instance */
        Map = new JPanel();
        renderStart(); //Default map

        Map.setLayout(new GridLayout(10,10));
        Map.setBackground(Color.green);
        Map.setVisible(true);
        
        /*Add panels to Main Frame*/        
        add(LeftPanel,BorderLayout.WEST);
        LeftPanel.setPreferredSize(new Dimension(200,0));
        add(RightPanel,BorderLayout.EAST);
        RightPanel.setPreferredSize(new Dimension(200,0));
        add(TopPanel,BorderLayout.NORTH);
        TopPanel.setPreferredSize(new Dimension(0,50));
        add(BotPanel,BorderLayout.SOUTH);
        BotPanel.setPreferredSize(new Dimension(0,100));
        add(MidPanel,BorderLayout.CENTER);
        MidPanel.add(Map, BorderLayout.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

//    public boolean getRunning () {
//        return isRunning;
//    }
//
//    public void setRunning(boolean running) {
//        isRunning = running;
//    }

    public void renderName(String S){
        Name = new JLabel("Name : " + S);
        Name.setFont(new Font("Dialog", Font.BOLD, 18));
        Name.setBounds(20, 3, 200, 50);
        TopPanel.add(Name);
    }

    public void renderTick(int N){
        TopPanel.remove(Ticker);
        TopPanel.revalidate();
        TopPanel.repaint();
        Ticker = new JLabel("Tick : " + N);
        Ticker.setFont(new Font("Dialog", Font.BOLD, 18));
        Ticker.setBounds(470, 3, 300, 50);
        TopPanel.add(Ticker);

    }

    public void renderAnimalCount(int N){
        TopPanel.remove(Animals);
        TopPanel.revalidate();
        TopPanel.repaint();
        Animals = new JLabel("Animals : " + Integer.toString(N));
        Animals.setFont(new Font("Dialog", Font.BOLD, 18));
        Animals.setBounds(800, 3, 200, 50);
        TopPanel.add(Animals);

    }

    public void renderInventory(String[] List){
        JLabel InventoryLabel = new JLabel ("Inventory : ");
        InventoryPanel.add(InventoryLabel);
        LeftPanel.add(InventoryPanel);
    }
    
    public void renderCondition(int water,int money, boolean available){
        JLabel WaterLabel = new JLabel ("Water : " + Integer.toString(water));
        JLabel MoneyLabel = new JLabel ("Money : " + Integer.toString(money));
        if (available) {
            JLabel TruckLabel = new JLabel ("Truck : Available" );
            CondPanel.add(TruckLabel);
        }
        else {
            JLabel TruckLabel = new JLabel ("Truck : Busy" );
            CondPanel.add(TruckLabel);
        }
        CondPanel.add(WaterLabel);
        CondPanel.add(MoneyLabel);
        LeftPanel.add(CondPanel);                
    }
    
    private ImageIcon getIcon (int X) {
        
        if (X==1){
            /*Code to create image Icon*/
            ImageIcon imageIcon = new ImageIcon("assets/perry.png"); // load the image to a imageIcon
            Image image = imageIcon.getImage(); // transform it 
            Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            imageIcon = new ImageIcon(newimg);  // transform it back
            return imageIcon;
        }
        else {
            /*Code to create image Icon*/
            ImageIcon imageIcon = new ImageIcon("assets/b.png"); // load the image to a imageIcon
            Image image = imageIcon.getImage(); // transform it 
            Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            imageIcon = new ImageIcon(newimg);  // transform it back
            return imageIcon;
        }
    }

    //To DO Add parameter matrix of Int and make cases (1-12 animal, 19-21 facility, 13-18 Land, 20 mixer, 21 truck 22 player)
//    public void render(){
//        for (int row = 0; row < grid.length; row++) {
//            for (int col = 0; col < grid[row].length; col++) {
//                if(row<5 && col<5){
//                    grid[row][col] = new JLabel("       C");
//                }
//                else if (row<5){
//                    grid[row][col] = new JLabel("       B");
//                }
//                else{
//                    grid[row][col] = new JLabel("       G");
//                }
//                // grid[row][col].setIcon(getIcon(X));
//                grid[row][col].setOpaque(false);
//                grid[row][col].setBorder(BorderFactory.createLineBorder(Color.BLACK));
//                Map.add(grid[row][col]);
//            }
//        }
//    }

    public void renderStart(){
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if(row<5 && col<5){
                    grid[row][col] = new JLabel("       C");
                }
                else if (row<5){
                    grid[row][col] = new JLabel("       B");
                }
                else{
                    grid[row][col] = new JLabel("       G");
                }
                // grid[row][col].setIcon(getIcon(X));
                grid[row][col].setOpaque(false);
                grid[row][col].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                Map.add(grid[row][col]);
            }
        }   
    }


    private Color getGrassColor (int X) {
       if (X%2 != 0) {
           return Color.YELLOW;
       } 
       else {
           return Color.GREEN;
       }
    }
    


//
//

//
        @Override
        public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        System.out.println("The first button has been clickled");
    }
}

