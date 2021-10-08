import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuUA extends JFrame implements ActionListener {
    JFrame frame;
    JLabel greeting, question;
    JButton BMI, NV, backToStart, BMIdef, xxxx;

    MenuUA() {
        frame = new JFrame();
        frame.setSize(500, 600);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(206, 205, 203));
        frame.setTitle("Health app - Under Age");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        greeting = new JLabel();
        greeting.setText("Let's get healthy and responsible!");
        greeting.setBounds(160, 50, 250, 50);
        greeting.setVisible(true);
        frame.add(greeting);

        question = new JLabel();
        question.setText("What would You like to do?");
        question.setBounds(175, 100, 200, 50);
        question.setVisible(true);
        frame.add(question);

        BMI = new JButton();
        BMI.setText("Check Your BMI");
        BMI.setBounds(135, 200, 150, 50);
        BMI.setVisible(true);
        BMI.addActionListener(this);
        BMI.setBorder(new RoundBtn(10));
        frame.add(BMI);

        BMIdef = new JButton();
        BMIdef.setText("BMI def");
        BMIdef.setBounds(290, 200, 95, 50);
        BMIdef.setVisible(true);
        BMIdef.setBorder(new RoundBtn(10));
        frame.add(BMIdef);

        NV = new JButton();
        NV.setText("Check nutrient value");
        NV.setBounds(135, 300, 250, 50);
        NV.setVisible(true);
        NV.addActionListener(this);
        NV.setBorder(new RoundBtn(10));
        frame.add(NV);

        xxxx = new JButton();
        xxxx.setText("xxxx");
        xxxx.setBounds(135, 400, 250, 50);
        xxxx.setVisible(true);
        xxxx.addActionListener(this);
        xxxx.setBorder(new RoundBtn(10));
        frame.add(xxxx);

        backToStart = new JButton();
        backToStart.setText("Go back to Start");
        backToStart.setBounds(5, 500, 150, 50);
        backToStart.setVisible(true);
        backToStart.addActionListener(this);
        backToStart.setBorder(new RoundBtn(10));
        frame.add(backToStart);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == BMI){
            BMI openBMI = new BMI();
            frame.dispose();
        } else if (actionEvent.getSource() == NV){
            NV openNV = new NV();
            frame.dispose();
        } else if (actionEvent.getSource() == backToStart){
            Start backToStart = new Start();
            frame.dispose();
        }
    }
}
