import javax.swing.*;
import java.awt.event.ActionListener;

public class Methods extends JFrame{

    public JButton setButton(JButton button, String text, int x, int y, int width, int height){
        button.setText(text);
        button.setBounds(x, y, width, height);
        button.setVisible(true);
        button.setLayout(null);
        return button;
    }

    public JLabel setLabel(JLabel lab, String text, int x, int y, int width, int height){
        lab.setText(text);
        lab.setBounds(x, y, width, height);
        lab.setVisible(true);
        lab.setLayout(null);
        return lab;
    }

    public JTextField setTextField(JTextField textfield, int x, int y, int width, int height){
        textfield.setBounds(x, y, width, height);
        textfield.setVisible(true);
        textfield.setLayout(null);
        return textfield;
    }

    public JComboBox setComboBox(JComboBox combobox, int x, int y, int width, int height){
        combobox.setBounds(x, y, width, height);
        combobox.setVisible(true);
        combobox.setLayout(null);
        return combobox;
    }

    public JRadioButton setRadioButton(JRadioButton radiobutton, int x, int y, int width, int height){
        radiobutton.setBounds(x, y, width, height);
        radiobutton.setVisible(true);
        radiobutton.setLayout(null);
        return radiobutton;
    }

}
