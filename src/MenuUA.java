import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuUA extends JFrame implements ActionListener {
    //methods
    Methods lab = new Methods();
    Methods button = new Methods();

    JFrame frame;
    JLabel greeting, question;
    JButton BMI, NV, backToStart, BMIdef, xxxx;
    

    MenuUA() {
        frame = new JFrame();
        setSize(500, 600);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(206, 205, 203));
        setTitle("Health app - Under Age");
        setResizable(false);
        setLocationRelativeTo(null);

        greeting = new JLabel();
        lab.setLabel(greeting, "Let's get healthy and responsible", 160, 50, 250, 50);


        question = new JLabel();
        lab.setLabel(question, "What would You like to do?", 175, 100, 200, 50);



        BMI = new JButton();
        button.setButton(BMI, "Check Your BMI", 135, 200, 150, 50);
        BMI.addActionListener(this);
        BMI.setBorder(new RoundBtn(10));

        BMIdef = new JButton();
        button.setButton(BMIdef, "BMI def", 290, 200, 95, 50);
        BMIdef.addActionListener(this);
        BMIdef.setBorder(new RoundBtn(10));

        NV = new JButton();
        button.setButton(NV, "Check nutrient value", 135, 300, 250, 50);
        NV.addActionListener(this);
        NV.setBorder(new RoundBtn(10));

        xxxx = new JButton();
        button.setButton(xxxx, "????", 135, 400, 250, 50);
        xxxx.addActionListener(this);
        xxxx.setBorder(new RoundBtn(10));

        backToStart = new JButton();
        button.setButton(backToStart, "Go back to start", 5, 500, 150, 50);
        backToStart.addActionListener(this);
        backToStart.setBorder(new RoundBtn(10));

        add(greeting);
        add(question);
        add(BMI);
        add(BMIdef);
        add(NV);
        add(xxxx);
        add(backToStart);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == BMI){
            BMI openBMI = new BMI();
            dispose();
        } else if (actionEvent.getSource() == BMIdef){
            BMIdef openBMIdef = new BMIdef();
        }else if (actionEvent.getSource() == NV){
            NV openNV = new NV();
            dispose();
        } else if (actionEvent.getSource() == backToStart){
            Start backToStart = new Start();
            dispose();
        }
    }
}


/*
TODO

WHOLE IDEAAAAAAAA
 */