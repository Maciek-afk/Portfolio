import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Menu extends JComponent implements ActionListener {
    //methods
    Methods label = new Methods();
    Methods button = new Methods();

    JFrame menu;
    JLabel logo, drw1, drw2, ins1, ins2, chosenFileInfo, chosenFileImg;
    JButton text, insert, file;
    JFileChooser chooseFileOG;
    public Image dimgOriginalPicture;
    File fileImg;

    Menu(){
// frame setup
        menu = new JFrame();
        menu.setSize(880, 360);
        menu.setVisible(true);
        menu.setLayout(null);
        menu.setDefaultCloseOperation(EXIT_ON_CLOSE);
        menu.getContentPane().setBackground(new Color(243, 230, 178));
        menu.setTitle("Water Mark Maker");
        menu.setResizable(false);
        menu.setLocationRelativeTo(null);

        logo = new JLabel("", SwingConstants.CENTER);
        label.setLabel(logo, "Water Mark Maker", 100, 40, 240, 40);
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

// choose file button
        file = new JButton();
        button.setButton(file, "Choose a file", 145, 130, 150, 40);
        file.setVisible(true);
        file.addActionListener(this);
        chooseFileOG = new JFileChooser();
        chooseFileOG.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                insert.setVisible(true);
                text.setVisible(true);
            }
        });
        menu.add(file);

//insert button
        insert = new JButton();
        insert.setLayout(new BorderLayout());
        ins1 = new JLabel("<html>Insert</html>", SwingConstants.CENTER);
        //getting appropriate font size
        ins1.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));
        //
        ins2 = new JLabel("a water mark", SwingConstants.CENTER);
        insert.add(BorderLayout.NORTH, ins1);
        insert.add(BorderLayout.SOUTH, ins2);
        insert.setBounds(40,220,160,50);
        insert.setVerticalAlignment(SwingConstants.CENTER);
        insert.addActionListener(this);
        insert.setVisible(false);

//
// text button
        text = new JButton();
        text.setLayout(new BorderLayout());
        drw1 = new JLabel("<html>Write</html>", SwingConstants.CENTER);
        //getting appropriate font size :
        drw1.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));
        //
        drw2 = new JLabel("a water mark", SwingConstants.CENTER);
        text.add(BorderLayout.NORTH, drw1);
        text.add(BorderLayout.SOUTH, drw2);
        text.setBounds(240,220,160,50);
        text.setVerticalAlignment(SwingConstants.CENTER);
        text.addActionListener(this);
        text.setVisible(false);

        class Drawing extends JComponent {
            public void paint(Graphics g) {
                // draw and display the line
                super.paint(g);
                g.setColor(Color.black);
                g.drawLine(440, 0, 440, 360);
            }
        }


// "Chosen file : "
        chosenFileInfo = new JLabel();
        chosenFileInfo = new JLabel("", SwingConstants.CENTER);
        label.setLabel(chosenFileInfo, "Your chosen file:", 500, 40, 240, 40);
        chosenFileInfo.setFont(new Font(labelFont.getName(), Font.BOLD, fontSizeToUse));

        chosenFileImg = new JLabel();
        chosenFileImg.setSize(300, 200);
        chosenFileImg.setLocation(500, 85);
        chosenFileImg.setVisible(true);

        menu.add(logo);
        menu.add(text);
        menu.add(insert);
        menu.add(chosenFileInfo);
        menu.add(chosenFileImg);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == file){
            BufferedImage pictobedone;
                int result = chooseFileOG.showOpenDialog(getParent());
                if (result == JFileChooser.APPROVE_OPTION){
                    try {
                        fileImg = chooseFileOG.getSelectedFile();
                        pictobedone = ImageIO.read(fileImg);

                        //resizing
                        dimgOriginalPicture = pictobedone.getScaledInstance(chosenFileImg.getWidth(), chosenFileImg.getHeight(),
                                Image.SCALE_SMOOTH);

                        chosenFileImg.setIcon(new ImageIcon(dimgOriginalPicture));
                        menu.add(chosenFileImg);
                    } catch (IOException ioe){
                        ioe.printStackTrace();
                        JOptionPane.showMessageDialog(null, "ERROR");
                    }
                }
        }
        else if (e.getSource() == insert){
            Inss WindowIn = new Inss();
            menu.dispose();
        } else if (e.getSource() == text){
            Text WindowDr = new Text();
            menu.dispose();
        }
    }
}
