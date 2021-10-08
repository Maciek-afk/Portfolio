import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMI extends JFrame implements ActionListener {
    JLabel InWeight, InHeight;
    JTextField getW, getH;
    JButton calc, menu;
    
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
        InWeight.setBounds(25, 50, 225, 25);
        InWeight.setText("Input Your weight (in kg): ");
        InWeight.setVisible(true);

        InHeight = new JLabel();
        InHeight.setBounds(25, 125, 225, 25);
        InHeight.setText("Input Your height (in cm): ");
        InHeight.setVisible(true);

        getW = new JTextField();
        getW.setBounds(225, 50, 150, 25);
        getW.setVisible(true);

        getH = new JTextField();
        getH.setBounds(225, 125, 150, 25);
        getH.setVisible(true);

        calc = new JButton();
        calc.setText("Calculate");
        calc.setBounds(250, 185, 125, 50);
        calc.addActionListener(this);
        calc.setBorder(new RoundBtn(10));
        calc.setVisible(true);

        menu = new JButton();
        menu.setText("Return to the menu");
        menu.setBounds(25, 185, 175, 50);
        menu.addActionListener(this);
        menu.setBorder(new RoundBtn(10));
        menu.setVisible(true);

        add(InWeight);
        add(InHeight);
        add(getW);
        add(getH);
        add(calc);
        add(menu);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == calc){

            double mass = Double.parseDouble(getW.getText());
            double height = Double.parseDouble(getH.getText());
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
                error.setText("BMI OUT OF SCALE");
                error.setBounds(100, 100, 144, 50);
                error.setVisible(true);
                error.setLayout(null);
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
