import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.Kernel;

public class BAC extends JFrame implements ActionListener {
    JFrame frame;
    JLabel AlcType, AlcAmount, gender, weight, info;
    JComboBox AType;
    JTextField AAmount, wghtIn;
    JButton calc, menu;
    JRadioButton male, female;

    JFrame frame2;
    JLabel yourBAC, BACcat;
    public String ac;


    BAC(){
        frame = new JFrame();
        setSize(400, 450);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Blood Alcohol Concentration");
        getContentPane().setBackground(new Color(206, 205, 203));
        setResizable(false);
        setLocationRelativeTo(null);


        AlcType = new JLabel();
        AlcType.setBounds( 5, 15, 200, 30);
        AlcType.setText("Type of alcohol");
        AlcType.setVisible(true);
        add(AlcType);

        AlcAmount = new JLabel();
        AlcAmount.setBounds(5, 65, 200, 30);
        AlcAmount.setText("Alcohol Amount (in drinks)");
        AlcAmount.setVisible(true);
        add(AlcAmount);

        gender = new JLabel();
        gender.setBounds(5, 115, 200, 30);
        gender.setText("What is Your gender? ");
        gender.setVisible(true);
        add(gender);

        weight = new JLabel();
        weight.setBounds(5, 165, 200, 30);
        weight.setText("How much do you weight?");
        weight.setVisible(true);
        add(weight);

        info = new JLabel();
        info.setBounds(0, 225, 400, 80);
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

        AType = new JComboBox();
        String[] types = {"Vodka", "Beer", "Wine"};
        AType = new JComboBox(types);
//        AType.addActionListener(this);
        AType.setVisible(true);
        AType.setBounds(200, 15, 150, 30);
        add(AType);

        AAmount = new JTextField();
        AAmount.setBounds(200, 65, 150, 30);
        AAmount.setVisible(true);
        AAmount.setLayout(null);
        add(AAmount);

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

        wghtIn = new JTextField();
        wghtIn.setBounds(200, 165, 150, 30);
        wghtIn.setVisible(true);
        wghtIn.setLayout(null);
        add(wghtIn);

        menu = new JButton("Return to menu");
        menu.setBounds(25, 330, 160, 50);
        menu.setVisible(true);
        menu.addActionListener(this);
        add(menu);

        calc = new JButton("Calculate");
        calc.setBounds(220, 330, 160, 50);
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
            int drinks = Integer.parseInt(AAmount.getText());

            ac = (String) AType.getSelectedItem();

            if (male.isSelected()){

            }


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
