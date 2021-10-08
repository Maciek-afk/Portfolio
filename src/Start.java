import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start extends JFrame implements ActionListener {
    JFrame age;
    JLabel greeting, question;
    JButton yes, no;

    Start(){

        age = new JFrame();
        age.setSize(500, 325);
        age.setVisible(true);
        age.setLayout(null);
        age.setDefaultCloseOperation(EXIT_ON_CLOSE);
        age.getContentPane().setBackground(new Color(206, 205, 203));
        age.setTitle("Age Verification");
        age.setResizable(false);
        age.setLocationRelativeTo(null);

        greeting = new JLabel();
        greeting.setText("Hi! Just a quick question.");
        greeting.setBounds(160, 50, 200, 50);
        greeting.setVisible(true);
        age.add(greeting);

        question = new JLabel();
        question.setText("Are you over 18 years old?");
        question.setBounds(155, 100, 200, 50);
        question.setVisible(true);
        age.add(question);

        yes = new JButton();
        yes.setText("Yes");
        yes.setBounds(100, 200, 100, 50);
        yes.setVisible(true);
        yes.addActionListener(this);
        yes.setBorder(new RoundBtn(10));
        age.add(yes);

        no = new JButton();
        no.setText("No");
        no.setBounds(300, 200, 100, 50);
        no.setVisible(true);
        no.addActionListener(this);
        no.setBorder(new RoundBtn(10));
        age.add(no);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == yes) {
            Menu ofAge = new Menu();
            age.dispose();
        } else if (actionEvent.getSource() == no){
            MenuUA NotOfAge = new MenuUA();
            age.dispose();
        }
    }
}
