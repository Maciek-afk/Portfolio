import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.Kernel;

public class BAC extends JFrame implements ActionListener {
    JFrame frame;
    JLabel alcoTypeLabel, alcoAmountLabel, gender, weightLabel, time, info;
    JComboBox alcType;
    JTextField alcAmount, wghtIn, timeIn;
    JButton calc, menu;
    JRadioButton male, female;

    JFrame frame2;
    JLabel yourBAC, BACcat;
    public String alcChosen;


    BAC(){
        frame = new JFrame();
        setSize(400, 500);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Blood Alcohol Concentration");
        getContentPane().setBackground(new Color(206, 205, 203));
        setResizable(false);
        setLocationRelativeTo(null);
        
        
//          TYPE OF ALCOHOL WITH THE CHOICE
        
        
        alcoTypeLabel = new JLabel();
        alcoTypeLabel.setBounds( 5, 15, 200, 30);
        alcoTypeLabel.setText("Type of alcohol");
        alcoTypeLabel.setVisible(true);
        add(alcoTypeLabel);
       
        alcType = new JComboBox();
        String[] types = {"Vodka", "Beer", "Wine"};
        alcType = new JComboBox(types);
//        alcType.addActionListener(this);
        alcType.setVisible(true);
        alcType.setBounds(200, 15, 150, 30);
        add(alcType);
        
        
//        AMOUNT OF ALCOHOL WITH THE INPUT
        

        alcoAmountLabel = new JLabel();
        alcoAmountLabel.setBounds(5, 65, 200, 30);
        alcoAmountLabel.setText("Alcohol Amount (in drinks)");
        alcoAmountLabel.setVisible(true);
        add(alcoAmountLabel);

        alcAmount = new JTextField();
        alcAmount.setBounds(200, 65, 150, 30);
        alcAmount.setVisible(true);
        alcAmount.setLayout(null);
        add(alcAmount);

        
//        GENDER CHOICE WITH 2 CHOICES 
        
        
        gender = new JLabel();
        gender.setBounds(5, 115, 200, 30);
        gender.setText("What is Your gender? ");
        gender.setVisible(true);
        add(gender);
        
        /*
        next to each other
         */
        male = new JRadioButton("Male");
        male.setBounds(200, 115, 60, 30);
        male.setBackground(new Color(206, 205, 203));
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(270, 115, 100, 30);
        female.setBackground(new Color(206, 205, 203));
        add(female);

        /*

        On top of each other

        male = new JRadioButton("Male");
        male.setBounds(200, 110, 150, 20);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(200, 130, 150, 20);
        add(female);
         */

        
//        WEIGHT WITH INPUT FIELD
        
        
        weightLabel = new JLabel();
        weightLabel.setBounds(5, 165, 200, 30);
        weightLabel.setText("How much do you weight?");
        weightLabel.setVisible(true);
        add(weightLabel);

        wghtIn = new JTextField();
        wghtIn.setBounds(200, 165, 150, 30);
        wghtIn.setVisible(true);
        wghtIn.setLayout(null);
        add(wghtIn);


//        TIME WITH INPUT


        time = new JLabel();
        time.setText("Hours since 1st drink?");
        time.setBounds(5, 215, 200, 30);
        time.setVisible(true);
        time.setLayout(null);
        add(time);

        timeIn = new JTextField();
        timeIn.setBounds(200, 215, 150, 30);
        timeIn.setVisible(true);
        timeIn.setLayout(null);
        add(timeIn);


//        INFO ON LIQ AMOUNTS
        
        
        info = new JLabel();
        info.setBounds(0, 275, 400, 80);
        info.setText("<html><div style='text-align: center;'>" +
                "The following are considered as one drink:<br/>\n" +
                " 40 ml of 40% liquor,<br/>\n" +
                " 350ml of beer,<br/>\n" +
                " or 150ml of table wine."  +
                "</div></html>");
        info.setHorizontalAlignment(SwingConstants.CENTER);
        info.setVerticalAlignment(SwingConstants.CENTER);
        info.setVisible(true);
        add(info);

        

        

//        BUTTONS FOR MENU AND CALC



        menu = new JButton("Return to menu");
        menu.setBounds(25, 380, 160, 50);
        menu.setVisible(true);
        menu.addActionListener(this);
        add(menu);

        calc = new JButton("Calculate");
        calc.setBounds(220, 380, 160, 50);
        calc.setVisible(true);
        calc.addActionListener(this);
        add(calc);
/*
The following are considered as one drink:
 1.25 oz. of 80 proof liquor,
 12 oz. of beer,
 or 5 oz. of table wine.
    */



    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == calc){

            yourBAC = new JLabel();
            BACcat = new JLabel();

            int mass = Integer.parseInt(wghtIn.getText());
            int drinks = Integer.parseInt(alcAmount.getText());

            alcChosen = (String) alcType.getSelectedItem();
/*
            if (male.isSelected()){
                if (weightLabel > x){

                }
            }else if(female.isSelected()){
                if (weightLabel > x){

                }
            }
*/

            frame2 = new JFrame();
            frame2.setTitle("Fit Ass - BAC results");
            frame2.setSize(300, 200);
            frame2.setLayout(null);
            frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame2.setVisible(true);
            frame2.setResizable(false);
            frame2.setLocationRelativeTo(null);
        } else if (actionEvent.getSource() == menu){
            Menu backToMenu = new Menu();
            dispose();
        }
    }
}


/*
TODO

literally whole class
 */