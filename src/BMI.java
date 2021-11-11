import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMI extends JFrame implements ActionListener {
    //methods
    Methods lab = new Methods();
    Methods button = new Methods();
    Methods textfield = new Methods();
    Methods combobox = new Methods();


    JLabel InWeight, InHeight;
    JTextField getW, getH;
    JButton calc, menu;
    JComboBox heightInputType, weightInputType;
    
    JFrame frame2;
    JLabel yourBMI, BMIcat, pic, pic1, error;
    String BMIcatSTR;
    ImageIcon img, img1;

    BMI(){
        setSize(400, 300);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("BMI Calculator");
        getContentPane().setBackground(new Color(206, 205, 203));
        setResizable(false);
        setLocationRelativeTo(null);

        InWeight = new JLabel();
        lab.setLabel(InWeight, "Input your weight: ", 25, 50, 150, 25);

        InHeight = new JLabel();
        lab.setLabel(InHeight, "Input Your height: ", 25, 125, 150, 25);

        getW = new JTextField();
        textfield.setTextField(getW, 175, 50, 125, 25);

        getH = new JTextField();
        textfield.setTextField(getH, 175, 125, 125, 25);

        String[] typesW = {"kg", "lbs"};
        weightInputType = new JComboBox(typesW);
        combobox.setComboBox(weightInputType, 315, 50, 50, 25);

        String[] typesH = {"cm", "ft"};
        heightInputType = new JComboBox(typesH);
        combobox.setComboBox(heightInputType, 315, 125, 50, 25);

        calc = new JButton();
        button.setButton(calc, "Calculate", 250, 185, 125, 50);
        calc.addActionListener(this);
        calc.setBorder(new RoundBtn(10));

        menu = new JButton();
        button.setButton(menu, "Return to the menu", 25, 185, 175, 50);
        menu.addActionListener(this);
        menu.setBorder(new RoundBtn(10));

        add(InWeight);
        add(InHeight);
        add(getW);
        add(getH);
        add(calc);
        add(menu);
        add(weightInputType);
        add(heightInputType);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == calc){


            double mass = Double.parseDouble(getW.getText());
            double height = Double.parseDouble(getH.getText());
            String checkW = (String) weightInputType.getSelectedItem();
            String checkH = (String) heightInputType.getSelectedItem();

            if (checkW.equalsIgnoreCase("lbs"))
                mass *= 0.45359237;

            if (checkH.equalsIgnoreCase("ft"))
                height *= 30.48;

            double BMInr = (int) (100 * mass / ((height/100) * height));

            yourBMI = new JLabel();
            yourBMI.setText("Your BMI equals:   " + BMInr);
            yourBMI.setBounds(15, 5, 200, 40);

            BMIcatSTR = new String();
            if (BMInr > 0){
                if (BMInr < 15)
                    BMIcatSTR = "Very severely underweight";
                else if (BMInr < 16)
                    BMIcatSTR = "Severely underweight";
                else if (BMInr < 18.5)
                    BMIcatSTR = "Underweight";
                else if (BMInr < 25)
                    BMIcatSTR = "Healthy";
                else if (BMInr < 30)
                    BMIcatSTR = "Overweight";
                else if (BMInr < 35)
                    BMIcatSTR = "Class 1 (low-risk) Obesity";
                else if (BMInr < 40)
                    BMIcatSTR = "Class 2 (moderate-risk) Obesity";
                else if (BMInr >= 40)
                    BMIcatSTR = "Class 3 (high-risk) Obesity";

                BMIcat = new JLabel();
                BMIcat.setText("Your BMI category is:   " + BMIcatSTR);

            } else {
                yourBMI.setText("-1");
                BMIcat.setText("Incorrect Data");
            }

            BMIcat.setBounds(15, 50, 300, 40);

            img = new ImageIcon("bmi-range.png");
            pic = new JLabel(img);
            pic.setBounds(12, 125, 320, 35);
            pic.setVisible(true);

            img1 = new ImageIcon("arr.png");
            pic1 = new JLabel(img1);
            pic1.setLayout(null);
            pic1.setVisible(true);
            int loc = (((int)(BMInr))-12) * 10;
            pic1.setBounds(loc, 112, 25, 15);

            frame2 = new JFrame();
            frame2.setTitle("Fit Ass - BMI results");
            frame2.setSize(344, 200);
            frame2.setLayout(null);
            frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame2.setVisible(true);
            frame2.add(yourBMI);
            frame2.add(BMIcat);
            frame2.setResizable(false);
            frame2.setLocationRelativeTo(null);
            if (BMInr >=12 && BMInr <= 44) {
                frame2.add(pic);
                frame2.add(pic1);
            }else{
                error = new JLabel();
                lab.setLabel(error, "BMI OUT OF SCALE", 100, 100, 144, 50);
                error.setText("BMI OUT OF SCALE");
                error.setForeground(Color.RED);
                frame2.add(error);
            }
            frame2.setLocationRelativeTo(null);

        } else if (actionEvent.getSource() == menu){
            Menu backToMenu = new Menu();
            dispose();
        }
    }
}
