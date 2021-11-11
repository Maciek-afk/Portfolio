import javax.swing.*;
import java.awt.*;

public class BMIdef extends JFrame {
    //methods
    Methods lab = new Methods();

    JFrame frame;
    JLabel definition;



    BMIdef(){
        frame = new JFrame();
        setSize(300, 200);
        setVisible(true);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("BAC Definition");
        getContentPane().setBackground(new Color(219, 229, 219));
        setLocationRelativeTo(null);

        definition = new JLabel();
        lab.setLabel(definition, "<html> BMI - Body Mass Index :  <br/><br/> It is a value derived from the mass and height of a person, The BMI is defined as the body mass devided by the square of the body height, and is expressed in units" + "" +
                "of kg/m2, resulting from mass in kilograms and height in metres. </html>", 1, 1, 380, 150);
        add(definition);

    }
}
