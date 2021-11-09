import javax.swing.*;
import java.awt.event.ActionListener;

public class Methods extends JFrame{

    public JButton setButton(JButton button, String text, int x, int y, int width, int height){
        button.setText("text");
        button.setBounds(x, y, width, height);
        button.setVisible(true);
        button.addActionListener((ActionListener) this);
        button.setBorder(new RoundBtn(10));
        return button;
    }

}
