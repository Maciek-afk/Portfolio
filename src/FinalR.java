import javax.swing.*;
import java.awt.*;

public class FinalR {
//methods
    Methods label = new Methods();
    Methods button = new Methods();

//vars
    JButton save, end, begin;
    ImageIcon result;
    JLabel logo, infoR;
    JFrame frameR;

    FinalR(){
        frameR  = new JFrame();
        frameR.setSize(440, 360);
        frameR.setVisible(true);
        frameR.setLayout(null);
        frameR.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameR.getContentPane().setBackground(new Color(243, 230, 178));
        frameR.setTitle("Water Mark Maker - Results");
        frameR.setResizable(false);
        frameR.setLocationRelativeTo(null);

        logo = new JLabel("", SwingConstants.CENTER);
        label.setLabel(logo, "Water Mark Maker", 100, 25, 240, 40);
// setting appropriate size of the font
        Font labelFont = logo.getFont();
        String labelText = logo.getText();
        int stringWidth = logo.getFontMetrics(labelFont).stringWidth(labelText);
        int componentWidth = logo.getWidth();
        double widthRatio = (double)componentWidth / (double)stringWidth;
        int newFontSize = (int)(labelFont.getSize() * widthRatio);
        int componentHeight = logo.getHeight();
        int fontSizeToUse = Math.min(newFontSize, componentHeight);
        logo.setFont(new Font(labelFont.getName(), Font.BOLD, fontSizeToUse));
        frameR.add(logo);

        infoR = new JLabel();
        label.setLabel(infoR, "Here is the preview of your result:", 100, 70, 290, 40);
        frameR.add(infoR);



    }
}
