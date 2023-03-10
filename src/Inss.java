import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.IOException;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Inss extends Component implements ActionListener {
    Methods button = new Methods();
    Methods label = new Methods();
    JFrame frame;
    JButton next, back, file;
    JLabel logo, chosenWatermarkText, chosenWatermarkImg;
    JFileChooser chooseFile;
    public Image dimgOnlyWatermark;

    Inss() {

//frame
        frame = new JFrame();
        frame.setSize(880, 360);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(243, 232, 203));
        frame.setTitle("Water Mark Maker - Insert");
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

// J components on the left side
        file = new JButton();
        button.setButton(file, "Choose a file", 145, 90, 150, 40);
        file.setVisible(true);
        file.addActionListener(this);
        chooseFile = new JFileChooser();

        back = new JButton();
        button.setButton(back, "Return back", 40, 170, 120, 40);
        back.addActionListener(this);

        next = new JButton();
        button.setButton(next, "Next", 280, 170, 120 ,40);
        next.setVisible(true);
        next.addActionListener(this);

// JComponents on the right side
        chosenWatermarkText = new JLabel();
        chosenWatermarkText = new JLabel("", SwingConstants.CENTER);
        label.setLabel(chosenWatermarkText, "Your chosen watermark", 500, 20, 280, 40);
        chosenWatermarkText.setFont(new Font(labelFont.getName(), Font.BOLD, fontSizeToUse));

        chosenWatermarkImg = new JLabel();
        chosenWatermarkImg.setSize(300,200);
        chosenWatermarkImg.setLocation(500, 85);
        chosenWatermarkImg.setVisible(true);

        frame.add(logo);
        frame.add(file);
        frame.add(back);
        frame.add(next);
        frame.add(chosenWatermarkText);
        frame.add(chosenWatermarkImg);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == file){
            int result = chooseFile.showOpenDialog(getParent());
            if (result == JFileChooser.APPROVE_OPTION){
                try{
                    File file = chooseFile.getSelectedFile();
                    BufferedImage watermarkToBeUSed = ImageIO.read(file);

                    //resizing
                    dimgOnlyWatermark = watermarkToBeUSed.getScaledInstance(chosenWatermarkImg.getWidth(), chosenWatermarkImg.getHeight(), Image.SCALE_SMOOTH);

                    chosenWatermarkImg.setIcon(new ImageIcon(dimgOnlyWatermark));
                    frame.add(chosenWatermarkImg);
                } catch (IOException ioe){
                    ioe.printStackTrace();
                    JOptionPane.showMessageDialog(null, "ERROR");
                }
            }
        } else if (e.getSource() == back){
            Menu menu = new Menu();
            frame.dispose();
        }
    }
}

