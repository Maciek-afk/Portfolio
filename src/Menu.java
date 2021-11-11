import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {
    //methods
    Methods lab = new Methods();
    Methods button = new Methods();

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

        // labels
        greeting = new JLabel();
        lab.setLabel(greeting, "Let's get healthy and responsible!", 160, 50, 250, 50);

        question = new JLabel();
        lab.setLabel(question, "What would You like to do?", 175, 100, 200, 50);

        //buttons
        BMI = new JButton();
        button.setButton(BMI, "Check Your BMI", 135, 200, 150, 50);
        BMI.addActionListener(this);
        BMI.setBorder(new RoundBtn(10));

        BMIdef = new JButton();
        button.setButton(BMIdef, "BMI def", 290, 200, 95, 50);
        BMIdef.setBorder(new RoundBtn(10));
        BMIdef.addActionListener(this);

        NV = new JButton();
        button.setButton(NV, "Check nutrient value", 135, 300, 250, 50);
        NV.addActionListener(this);
        NV.setBorder(new RoundBtn(10));

        BAC = new JButton();
        button.setButton(BAC, "Check Your BAC", 135, 400, 150, 50);
        BAC.addActionListener(this);
        BAC.setBorder(new RoundBtn(10));

        BACdef = new JButton();
        button.setButton(BACdef, "BAC def", 290, 400, 95, 50);
        BACdef.addActionListener(this);
        BACdef.setBorder(new RoundBtn(10));

        backToStart = new JButton();
        button.setButton(backToStart, "Go back to start", 10, 490, 150, 50);
        backToStart.addActionListener(this);
        backToStart.setBorder(new RoundBtn(10));

        //adding components to JFrame
        add(greeting);
        add(question);
        add(BMI);
        add(BMIdef);
        add(NV);
        add(BAC);
        add(BACdef);
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
