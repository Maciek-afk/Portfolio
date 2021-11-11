import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start extends JFrame implements ActionListener {
    //methods
    Methods lab = new Methods();
    Methods button = new Methods();

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
        lab.setLabel(greeting, "Hi! Just a quick question", 160, 50, 200, 50);

        question = new JLabel();
        lab.setLabel(question, "Are you over 18 years old?", 155, 100, 200, 50);

        yes = new JButton();
        button.setButton(yes, "Yes", 100, 200, 100, 50);
        yes.addActionListener(this);
        yes.setBorder(new RoundBtn(10));

        no = new JButton();
        button.setButton(no, "No", 300, 200, 100, 50);
        no.addActionListener(this);
        no.setBorder(new RoundBtn(10));

        age.add(greeting);
        age.add(question);
        age.add(yes);
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
