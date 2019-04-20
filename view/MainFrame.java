package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
import javax.swing.*;
import java.awt.Font;
import java.util.ArrayList;

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

    private ImageIcon chicken;
    private ImageIcon jago;
    private ImageIcon bull;
    private ImageIcon cow;
    private ImageIcon player;
    private ImageIcon perry;
    private ImageIcon golden;
    private ImageIcon truck;
    private ImageIcon well;
    private ImageIcon mixer;
    


    public MainFrame() {
        setTitle("Rikas Farm Game");
        setSize(1000, 800);
        
        /*Create Panels */

        //Left Panel
        LeftPanel = new JPanel(new GridLayout(2, 1));
        LeftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        InventoryPanel = new JPanel(new GridLayout(10,0));
        JLabel InventoryLabel = new JLabel ("Inventory : ");
        InventoryPanel.add(InventoryLabel);
        LeftPanel.add(InventoryPanel);

        CondPanel = new JPanel(new GridLayout(2,0));  
        renderCondition(10, 5000);      

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
        BotPanel = new JPanel(new GridLayout(2,0));
        BotPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        // JLabel Msg1 = new JLabel("Message  : ");
        
        // BotPanel.add(Msg1);

        //Mid Panel
        MidPanel = new JPanel(new BorderLayout());
        MidPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        /*Create Map Instance */
        Map = new JPanel();
        Map.setLayout(new GridLayout(10,10));
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

        chicken = new ImageIcon("view/assets/chicken.png");
        Image image = chicken.getImage(); // transform it 
        Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        chicken = new ImageIcon(newimg);  // transform it back


        jago = new ImageIcon("view/assets/jago.png");
        image = jago.getImage(); // transform it 
        newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        jago = new ImageIcon(newimg);  // transform it back

        bull = new ImageIcon("view/assets/pdip.png");
        image = bull.getImage(); // transform it 
        newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        bull = new ImageIcon(newimg);  // transform it back

        cow = new ImageIcon("view/assets/cow.png");
        image = cow.getImage(); // transform it 
        newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        cow = new ImageIcon(newimg);  // transform it back

        player = new ImageIcon("view/assets/player.png");
        image = player.getImage(); // transform it 
        newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        player = new ImageIcon(newimg);  // transform it back

        perry = new ImageIcon("view/assets/perry.png");
        image = perry.getImage(); // transform it 
        newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        perry = new ImageIcon(newimg);  // transform it back

        golden = new ImageIcon("view/assets/golden.png");
        image = golden.getImage(); // transform it 
        newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        golden = new ImageIcon(newimg);  // transform it back

        truck = new ImageIcon("view/assets/b.png");
        image = truck.getImage(); // transform it 
        newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        truck = new ImageIcon(newimg);  // transform it back

        well = new ImageIcon("view/assets/b.png");
        image = well.getImage(); // transform it 
        newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        well = new ImageIcon(newimg);  // transform it back

        mixer = new ImageIcon("view/assets/b.png");
        image = mixer.getImage(); // transform it 
        newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        mixer = new ImageIcon(newimg);  // transform it back
    }

//    public boolean getRunning () {
//        return isRunning;
//    }
//
//    public void setRunning(boolean running) {
//        isRunning = running;
//    }

    public void renderMsg(JLabel msg){
        BotPanel.add(msg);
        BotPanel.validate();
    }

    public void clearMsg(){
        BotPanel.removeAll();
        BotPanel.revalidate();
        BotPanel.repaint();
    }

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


    public void renderInventory(String X){
        JLabel thingName = new JLabel(X);
        InventoryPanel.add(thingName);
        LeftPanel.add(InventoryPanel);
    }
    
    public void clearInventory(){
        InventoryPanel.removeAll();
        InventoryPanel.revalidate();
        JLabel InventoryLabel = new JLabel ("Inventory : ");
        InventoryPanel.add(InventoryLabel);
    }

    public void clearCondition(){
        CondPanel.removeAll();
        CondPanel.revalidate();
        
    }


    public void renderCondition(int water,long money){
        JLabel WaterLabel = new JLabel ("Water : " + Integer.toString(water));
        JLabel MoneyLabel = new JLabel ("Money : " + Long.toString(money));
        CondPanel.add(WaterLabel);
        CondPanel.add(MoneyLabel);
        LeftPanel.add(CondPanel);                
    }
    //0 untuk out of bound
    //1-12 untuk farm animal (ganjil laper, genap kenyang)
    //egg and milk producing? ada brpa?
    //1-2 Chicken Kampung -- egg, meat
    //3-4 ChickenJago -- Meat
    //5-6 Cow -- milk, meat
    //7-8 Golden Platypus -- egg,milk
    //9-10 Platypus -- egg,milk
    //11-12 Bull -- Meat
    //13-18 untuk land (ganjil tdk berumput, genap berumput)
    //13-14 Barn
    //15-16 Coop
    //17-18 GrassLand
    //19-21 untuk facility
    //19 untuk well
    //20 untuk mixer
    //21 untuk truck
    //22 untuk player
    private ImageIcon getIcon (int X) {

        ImageIcon imageIcon = new ImageIcon("view/assets/b.png");

        if (X==1 || X==2){
            /*Code to create image Icon*/
            imageIcon = chicken;

        }
        else if(X==3 || X==4){
            /*Code to create image Icon*/
            imageIcon = jago;
         }
        else if(X==5 || X==6){
            /*Code to create image Icon*/
            imageIcon = cow;
         }
        else if(X==7 || X==8){
            /*Code to create image Icon*/
            imageIcon = golden;

        }
        else if(X==9 || X==10){
            /*Code to create image Icon*/
            imageIcon = perry;

        }
        else if(X==11 || X==12){
            /*Code to create image Icon*/
            imageIcon = bull;

        }
        else if(X==19){
            /*Code to create image Icon*/
            imageIcon = well;

        }
        else if(X==20){
            /*Code to create image Icon*/
            imageIcon = mixer;

        }
        else if(X==21){
            /*Code to create image Icon*/
            imageIcon = truck;

        }
        else if(X==22){
            /*Code to create image Icon*/
            imageIcon = player;
        }

        return imageIcon;

    }



    public void clearMap(){
        Map.removeAll();
        Map.revalidate();
        Map.repaint();
    }


    public void renderCell(int X, int row, int col){

        if (X>=1 && X<=12) {
            grid[row][col] = new JLabel();
            grid[row][col].setIcon(getIcon(X));
            if(X%2 != 0){
                grid[row][col].setBackground(Color.RED);
            }
        }

        else if (X>=13 && X<=18) {
            if (X == 13 || X == 14) {
                grid[row][col] = new JLabel("B");
                grid[row][col].setBackground(getGrassColor(X));
            }
            else if (X==15 || X==16){
                grid[row][col] = new JLabel("C");
                grid[row][col].setBackground(getGrassColor(X));
            }
            else if (X==17 || X==18) {
                grid[row][col] = new JLabel("G");
                grid[row][col].setBackground(getGrassColor(X));
            }

        }
        else {
            grid[row][col] = new JLabel(getIcon(X));
            grid[row][col].setIcon(getIcon(X));
            grid[row][col].setBackground(getGrassColor(X));
        }
        grid[row][col].setOpaque(true);
        grid[row][col].setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Map.add(grid[row][col]);
    }
    //0 untuk out of bound
    //1-12 untuk farm animal (ganjil laper, genap kenyang)
    //egg and milk producing? ada brpa?
    //1-2 Chicken Kampung -- egg, meat
    //3-4 ChickenJago -- Meat
    //5-6 Cow -- milk, meat
    //7-8 Golden Platypus -- egg,milk
    //9-10 Platypus -- egg,milk
    //11-12 Bull -- Meat
    //13-18 untuk land (ganjil tdk berumput, genap berumput)
    //13-14 Barn
    //15-16 Coop
    //17-18 GrassLand
    //19-21 untuk facility
    //19 untuk well
    //20 untuk mixer
    //21 untuk truck
    //22 untuk player



    private Color getGrassColor (int X) {
       if (X % 2 == 0) {
           return Color.GREEN;
       } 
       else {
           return Color.YELLOW;
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

