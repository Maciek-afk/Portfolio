import javax.swing.*;
import java.awt.*;

public class BACdef extends JFrame {
    //methods
    Methods lab = new Methods();

    JFrame frame;
    JLabel definition;

    BACdef(){
        frame = new JFrame();
        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setTitle("BAC Definition");
        frame.getContentPane().setBackground(new Color(219, 229, 219));
        frame.setLocationRelativeTo(null);

        definition = new JLabel();
        lab.setLabel(definition, "<html> BAC - Blood Alcohol Concentration : <br/><br/> It is the percentage of alcohol in the bloodstream: under the laws of most states, a BAC of 0.10 is the legal definition of intoxication, although a few states use a slightly lower" +
                " percentage, as 0.08. </html>", 1, 1, 300, 150);
        frame.add(definition);
    }
}
