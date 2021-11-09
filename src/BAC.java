import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.Kernel;
import java.text.DecimalFormat;

public class BAC extends JFrame implements ActionListener {
    JFrame frame;
    JLabel alcoTypeLabel, alcoAmountLabel, gender, weightLabel, time, info;
    JComboBox alcType, inputType, one, two, three, four, five, six, seven, eight, nine, ten;
    JTextField alcAmount, wghtIn, timeIn;
    JButton calc, menu;
    JRadioButton male, female;

    JFrame frame2;
    JLabel yourBAC, BACtext, BACcatLabel, BACcatText;
    public String alcChosen, typeOfInput, BACcat;
    public double BAC;
    public int drinks, alcohol, temp;


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

//        alcType = new JComboBox();
        String[] types = {"Vodka", "Beer", "Wine"};
        alcType = new JComboBox(types);
        alcType.setVisible(true);
        alcType.setBounds(200, 15, 150, 30);
        add(alcType);

//        AMOUNT OF ALCOHOL WITH THE INPUT


        alcoAmountLabel = new JLabel();
        alcoAmountLabel.setBounds(5, 65, 200, 30);
        alcoAmountLabel.setText("Alcohol Amount :");
        alcoAmountLabel.setVisible(true);
        add(alcoAmountLabel);

        alcAmount = new JTextField();
        alcAmount.setBounds(50, 105, 150, 30);
        alcAmount.setVisible(true);
        alcAmount.setLayout(null);
        add(alcAmount);

        String[] lqInput = {"shot 40ml/1.35oz", "bottle 500ml/16.9oz", "bottle 350ml/11.8oz", "ounces", "milliliters", "gallons",  "litres"};
        inputType = new JComboBox(lqInput);
        inputType.setVisible(true);
        inputType.setBounds(210, 105, 150, 30);
        add(inputType);


//        GENDER CHOICE WITH 2 CHOICES


        gender = new JLabel();
        gender.setBounds(5, 160, 200, 30);
        gender.setText("What is Your gender? ");
        gender.setVisible(true);
        add(gender);

        /*
        next to each other
         */
        male = new JRadioButton("Male");
        male.setBounds(200, 160, 60, 30);
        male.setBackground(new Color(206, 205, 203));
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(270, 160, 100, 30);
        female.setBackground(new Color(206, 205, 203));
        add(female);

        ButtonGroup group = new ButtonGroup();
        group.add(female);
        group.add(male);

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
        weightLabel.setBounds(5, 205, 200, 30);
        weightLabel.setText("How much do you weight?");
        weightLabel.setVisible(true);
        add(weightLabel);

        wghtIn = new JTextField();
        wghtIn.setBounds(200, 205, 150, 30);
        wghtIn.setVisible(true);
        wghtIn.setLayout(null);
        add(wghtIn);


//        TIME WITH INPUT


        time = new JLabel();
        time.setText("Hours since 1st drink?");
        time.setBounds(5, 245, 200, 30);
        time.setVisible(true);
        time.setLayout(null);
        add(time);

        timeIn = new JTextField();
        timeIn.setBounds(200, 245, 150, 30);
        timeIn.setVisible(true);
        timeIn.setLayout(null);
        add(timeIn);


//        INFO ON LIQ AMOUNTS


        info = new JLabel();
        info.setBounds(0, 295, 400, 80);
        info.setText("<html><font size=\"5\" face=\"verdana\" color=\"red\">All fields must be filled</font></html>");
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

                try{
                    Double number = Double.parseDouble(wghtIn.getText());
                    Integer integer = Integer.parseInt(alcAmount.getText());
                    Integer integer1 = Integer.parseInt(timeIn.getText());
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(this, "Enter a valid Number",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }

            int mass = Integer.parseInt(wghtIn.getText());
            int alcohol = Math.round(Integer.parseInt(alcAmount.getText()));
            int time = Integer.parseInt(timeIn.getText());
            int i = 0, j = 0;
            alcChosen = (String) alcType.getSelectedItem();
            typeOfInput = (String) inputType.getSelectedItem();

            if (typeOfInput.equalsIgnoreCase("milliliters"))
                alcohol = alcohol;
            else if (typeOfInput.equalsIgnoreCase("litres"))
                alcohol *= 1000;
            else if (typeOfInput.equalsIgnoreCase("gallons"))
                alcohol *= 3785.41178;
            else if (typeOfInput.equalsIgnoreCase("ounces"))
                alcohol *= 29.5735296875;
            else if (typeOfInput.equalsIgnoreCase("shot 40ml/1.35oz"))
                alcohol /= 40;
            else if (typeOfInput.equalsIgnoreCase("bottle 500ml/16.9oz"))
                alcohol /= 500;
            else if (typeOfInput.equalsIgnoreCase("bottle 350ml/11.8oz"))
                alcohol /= 350;

//            calculating amount of drinks and storing it in integer called drinks
            if (alcChosen.equalsIgnoreCase("Vodka"))
                drinks = alcohol/40;
            else if (alcChosen.equalsIgnoreCase("Beer"))
                drinks = alcohol/350;
            else if (alcChosen.equalsIgnoreCase("Wine"))
                drinks = alcohol/150;

            if (male.isSelected()){
                double[][] bacArrayM = new double[7][10];
                bacArrayM[0][0] = 0.043;
                bacArrayM[0][1] = 0.087;
                bacArrayM[0][2] = 0.130;
                bacArrayM[0][3] = 0.174;
                bacArrayM[0][4] = 0.217;
                bacArrayM[0][5] = 0.261;
                bacArrayM[0][6] = 0.304;
                bacArrayM[0][7] = 0.348;
                bacArrayM[0][8] = 0.391;
                bacArrayM[0][9] = 0.435;

                bacArrayM[1][0] = .034;
                bacArrayM[1][1] = .069;
                bacArrayM[1][2] = .103;
                bacArrayM[1][3] = .139;
                bacArrayM[1][4] = .173;
                bacArrayM[1][5] = .209;
                bacArrayM[1][6] = .242;
                bacArrayM[1][7] = .287;
                bacArrayM[1][8] = .312;
                bacArrayM[1][9] = .346;

                bacArrayM[2][0] = .029;
                bacArrayM[2][1] = .058;
                bacArrayM[2][2] = .087;
                bacArrayM[2][3] = .116;
                bacArrayM[2][4] = .145;
                bacArrayM[2][5] = .174;
                bacArrayM[2][6] = .203;
                bacArrayM[2][7] = .232;
                bacArrayM[2][8] = .261;
                bacArrayM[2][9] = .290;

                bacArrayM[3][0] = .025;
                bacArrayM[3][1] = .050;
                bacArrayM[3][2] = .075;
                bacArrayM[3][3] = .100;
                bacArrayM[3][4] = .125;
                bacArrayM[3][5] = .150;
                bacArrayM[3][6] = .175;
                bacArrayM[3][7] = .200;
                bacArrayM[3][8] = .225;
                bacArrayM[3][9] = .250;

                bacArrayM[4][0] = .022;
                bacArrayM[4][1] = .043;
                bacArrayM[4][2] = .065;
                bacArrayM[4][3] = .087;
                bacArrayM[4][4] = .108;
                bacArrayM[4][5] = .130;
                bacArrayM[4][6] = .152;
                bacArrayM[4][7] = .174;
                bacArrayM[4][8] = .195;
                bacArrayM[4][9] = .217;

                bacArrayM[5][0] = .019;
                bacArrayM[5][1] = .039;
                bacArrayM[5][2] = .058;
                bacArrayM[5][3] = .078;
                bacArrayM[5][4] = .097;
                bacArrayM[5][5] = .117;
                bacArrayM[5][6] = .136;
                bacArrayM[5][7] = .156;
                bacArrayM[5][8] = .175;
                bacArrayM[5][9] = .195;

                bacArrayM[6][0] = .017;
                bacArrayM[6][1] = .035;
                bacArrayM[6][2] = .052;
                bacArrayM[6][3] = .070;
                bacArrayM[6][4] = .087;
                bacArrayM[6][5] = .105;
                bacArrayM[6][6] = .122;
                bacArrayM[6][7] = .139;
                bacArrayM[6][8] = .156;
                bacArrayM[6][9] = .173;

                  /*
                (45 + 57) / 2 = 51
                (57 + 68) / 2 = 62.5
                (68 + 79) / 2 = 73.5
                (79 + 91) / 2 = 85
                (91 + 102) / 2 = 96.5
                (102 + 113) / 2 = 107.5
                */


                    if (mass > 107)
                        i = 6;
                    else if (mass > 96)
                        i = 5;
                    else if (mass >= 85)
                        i = 4;
                    else if (mass > 73)
                        i = 3;
                    else if (mass > 62)
                        i = 2;
                    else if (mass >= 51)
                        i = 1;
                    else if (mass < 51)
                        i = 0;

                    if (drinks < 10 && drinks > 0)
                        j = drinks - 1;
                    else if (drinks >= 10)
                        j = 10;
                    else if (drinks < 1)
                        j = 0;

                    BAC = bacArrayM[i][j];
/*
                try {
                    if (1.isSelected)
                }
                x = "ur bac";

 */

            }

            else if (female.isSelected()){
                double[][] bacArrayF = new double[5][10];
                bacArrayF[0][0] = .050;
                bacArrayF[0][1] = .101;
                bacArrayF[0][2] = .152;
                bacArrayF[0][3] = .203;
                bacArrayF[0][4] = .253;
                bacArrayF[0][5] = .304;
                bacArrayF[0][6] = .355;
                bacArrayF[0][7] = .406;
                bacArrayF[0][8] = .456;
                bacArrayF[0][9] = .507;

                bacArrayF[1][0] = .040;
                bacArrayF[1][1] = .080;
                bacArrayF[1][2] = .120;
                bacArrayF[1][3] = .162;
                bacArrayF[1][4] = .202;
                bacArrayF[1][5] = .244;
                bacArrayF[1][6] = .282;
                bacArrayF[1][7] = .324;
                bacArrayF[1][8] = .364;
                bacArrayF[1][9] = .404;

                bacArrayF[2][0] = .034;
                bacArrayF[2][1] = .068;
                bacArrayF[2][2] = .101;
                bacArrayF[2][3] = .135;
                bacArrayF[2][4] = .169;
                bacArrayF[2][5] = .203;
                bacArrayF[2][6] = .237;
                bacArrayF[2][7] = .271;
                bacArrayF[2][8] = .304;
                bacArrayF[2][9] = .338;

                bacArrayF[3][0] = .029;
                bacArrayF[3][1] = .038;
                bacArrayF[3][2] = .087;
                bacArrayF[3][3] = .117;
                bacArrayF[3][4] = .146;
                bacArrayF[3][5] = .175;
                bacArrayF[3][6] = .204;
                bacArrayF[3][7] = .233;
                bacArrayF[3][8] = .262;
                bacArrayF[3][9] = .292;

                bacArrayF[4][0] = .026;
                bacArrayF[4][1] = .050;
                bacArrayF[4][2] = .076;
                bacArrayF[4][3] = .101;
                bacArrayF[4][4] = .126;
                bacArrayF[4][5] = .152;
                bacArrayF[4][6] = .177;
                bacArrayF[4][7] = .203;
                bacArrayF[4][8] = .227;
                bacArrayF[4][9] = .253;

                /*
                (45 + 57) / 2 = 51
                (57 + 68) / 2 = 62.5
                (68 + 79) / 2 = 73.5
                (79 + 91) / 2 = 85
                 */

                if (mass > 85)
                    i = 4;
                else if (mass >= 73)
                    i = 3;
                else if (mass >= 62)
                    i = 2;
                else if (mass >= 51)
                    i = 1;
                else if (mass < 51)
                    i = 0;

                if (drinks < 10 && drinks > 0)
                    j = drinks - 1;
                else if (drinks >= 10)
                    j = 9;
                else if (drinks < 1)
                    j = 0;

                BAC = bacArrayF[i][j];

            }

            BACtext = new JLabel();
            BACtext.setBounds(75, 5, 150, 35);
            BACtext.setVisible(true);
            BACtext.setText("Your BAC is : ");

            yourBAC = new JLabel();
            yourBAC.setBounds(100, 45, 200, 50);
            yourBAC.setVisible(true);

            if (BAC < 0) {
                BAC = 0;
            }else if (drinks > 0 && drinks <= 10 ) {
                BAC = BAC - (0.15 * time);
                yourBAC.setText("around " + String.valueOf(BAC));
            }else if (drinks > 10) {
                yourBAC.setText("at least " + String.valueOf(BAC));
            }else {
                yourBAC.setText("at most " + String.valueOf(BAC));
            }

            if (BAC <= 0.05 && BAC >= 0.01)
                temp = 1;
            else if (BAC > 0.05 && BAC <= 0.1)
                temp = 2;
            else if (BAC > 0.1 && BAC <= 0.2)
                temp = 3;
            else if (BAC > 0.2 && BAC <= 0.3)
                temp = 4;
            else if (BAC > 0.3 && BAC <= 0.4)
                temp = 5;
            else if (BAC > 0.4)
                temp = 6;

            
            
            BACcatLabel = new JLabel();
            BACcatLabel.setBounds(75, 85, 150, 35);
            BACcatLabel.setVisible(true);
            BACcatLabel.setText("Your BAC category : ");

            BACcatText = new JLabel();
            BACcatText.setBounds(100, 125, 150, 35);
            BACcatText.setVisible(true);
            BACcatText.setText(BACcat);



//            BACcatText


            frame2 = new JFrame();
            frame2.setTitle("Fit Ass - BAC results");
            frame2.setSize(300, 200);
            frame2.setLayout(null);
            frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame2.setVisible(true);
            frame2.setResizable(false);
            frame2.setLocationRelativeTo(null);
            frame2.add(yourBAC);
            frame2.add(BACtext);
            frame2.add(BACcatLabel);
            frame2.add(BACcatText);


        } else if (actionEvent.getSource() == menu) {
            Menu backToMenu = new Menu();
        }
    }
}


/*
TODO

literally whole override
 */