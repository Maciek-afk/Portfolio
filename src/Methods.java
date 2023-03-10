import javax.swing.*;

public class Methods extends JFrame {

    public JButton setButton(JButton button, String text, int x, int y, int width, int height){
        button.setText(text);
        button.setBounds(x, y, width, height);
        button.setVisible(true);
        button.setLayout(null);
        return button;
    }

    public JLabel setLabel(JLabel label, String text, int x, int y, int width, int height){
        label.setText(text);
        label.setBounds(x, y, width, height);
        label.setVisible(true);
        label.setLayout(null);
        return label;
    }

    public JTextField setTextField(JTextField textField, int x, int y, int width, int height){
        textField.setBounds(x, y, width, height);
        textField.setVisible(true);
        textField.setLayout(null);
        return textField;
    }


}
