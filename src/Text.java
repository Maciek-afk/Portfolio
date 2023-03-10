import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class Text implements ActionListener {
//methods
    Methods button = new Methods();
    Methods label = new Methods();
    Methods textField = new Methods();
//vars
    public String wordWatermark;
    JFrame frame;
    JButton back, next;
    JLabel logo;
    JTextField getText;

    // result window
    JFrame frameR;
    ImageIcon res;
    JLabel labelR;

// importing the original picture from "Menu" class, where it was input by the user.


    Text(){
        frame = new JFrame();
        frame.setSize(440, 280);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(243, 232, 203));
        frame.setTitle("Water Mark Maker - Text");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        logo = new JLabel("", SwingConstants.CENTER);
        label.setLabel(logo, "Water Mark Maker", 110, 10, 220, 40);
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
        frame.add(logo);
//input field
        getText = new JTextField();
        textField.setTextField(getText, 145, 90, 150, 40);
        frame.add(getText);
//buttons
        back = new JButton();
        button.setButton(back, "Back", 40, 170, 120, 40);
        back.addActionListener(this);
        frame.add(back);

        next = new JButton();
        button.setButton(next, "Next", 280, 170, 120 ,40);
        next.addActionListener(this);
        frame.add(next);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back){
            Menu menu = new Menu();
            frame.dispose();
        }else if (e.getSource() == next){
// saving the input word
            wordWatermark = (String)getText.getSelectedText();
//window with the result
//            BufferedImage withWMBuff = ImageIO.read(new File("xxx"));
//            int ImageW = withWMBuff.getWidth();
//            int ImageH = withWMBuff.getHeight();
            frameR = new JFrame();
            frameR.setSize(300,200);
            JLabel doneImageFile = new JLabel();
            doneImageFile.setSize(300, 200);
            doneImageFile.setVisible(true);
            labelR = new JLabel(res);
//            labelR.setSize(pictobedone.getWidth(), pictobedone.getHeight());
            frameR.add(labelR);
            frameR.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frameR.setLayout(null);
            frameR.setVisible(true);
            frameR.add(doneImageFile);
        }
    }
}
