import javax.swing.*;
import java.awt.*;

public class BMIdef extends JFrame {
    JFrame frame;
    JLabel definition;

    BMIdef(){
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
        definition.setBounds(1, 1, 300, 150);
        definition.setText("<html> BMI - Body Mass Index :  <br/><br/> It is a value derived from the mass and height of a person, The BMI is defined as the body mass devided by the square of the body height, and is expressed in units of kg/m2, resulting from mass in kilograms and height in metres. </html>");
        definition.setVisible(true);
        frame.add(definition);

    }
}
