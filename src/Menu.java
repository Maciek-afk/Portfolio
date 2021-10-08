import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {
    JLabel greeting, question;
    JButton BMI, BMIdef, NV, BAC, BACdef, backToStart;

    Menu() {
        setSize(500, 600);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Health app");
        getContentPane().setBackground(new Color(206, 205, 203));
        setResizable(false);
        setLocationRelativeTo(null);

        greeting = new JLabel();
        greeting.setText("Let's get healthy and responsible!");
        greeting.setBounds(160, 50, 250, 50);
        greeting.setVisible(true);
        add(greeting);


        question = new JLabel();
        question.setText("What would You like to do?");
        question.setBounds(175, 100, 200, 50);
        question.setVisible(true);
        add(question);

        BMI = new JButton();
        BMI.setText("Check Your BMI");
        BMI.setBounds(135, 200, 150, 50);
        BMI.setVisible(true);
        BMI.addActionListener(this);
        BMI.setBorder(new RoundBtn(10));
        add(BMI);

        BMIdef = new JButton();
        BMIdef.setText("BMI def");
        BMIdef.setBounds(290, 200, 95, 50);
        BMIdef.setVisible(true);
        BMIdef.setBorder(new RoundBtn(10));
        BMIdef.addActionListener(this);
        add(BMIdef);

        NV = new JButton();
        NV.setText("Check nutrient value");
        NV.setBounds(135, 300, 250, 50);
        NV.setVisible(true);
        NV.addActionListener(this);
        NV.setBorder(new RoundBtn(10));
        add(NV);

        BAC = new JButton();
        BAC.setText("Check Your BAC");
        BAC.setBounds(135, 400, 150, 50);
        BAC.setVisible(true);
        BAC.addActionListener(this);
        BAC.setBorder(new RoundBtn(10));
        add(BAC);

        BACdef = new JButton();
        BACdef.setText("BAC def");
        BACdef.setBounds(290, 400, 95, 50);
        BACdef.setVisible(true);
        BACdef.addActionListener(this);
        BACdef.setBorder(new RoundBtn(10));
        add(BACdef);

        backToStart = new JButton();
        backToStart.setText("Go back to Start");
        backToStart.setBounds(10, 490, 150, 50);
        backToStart.setVisible(true);
        backToStart.addActionListener(this);
        backToStart.setBorder(new RoundBtn(10));
        add(backToStart);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == BMI){
            BMI openBMI = new BMI();
            dispose();
        } else if (actionEvent.getSource() == BMIdef){
            BMIdef openBMIdef = new BMIdef();
        } else if (actionEvent.getSource() == NV){
            NV openNV = new NV();
            dispose();
        } else if (actionEvent.getSource() == BAC){
            BAC openBAC = new BAC();
            dispose();
        } else if (actionEvent.getSource() == BACdef){
            BACdef openBACdef = new BACdef();
        } else if (actionEvent.getSource() == backToStart){
            Start backToStart = new Start();
            dispose();
        }
    }
}
