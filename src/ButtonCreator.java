import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ButtonCreator implements IButtonCreator {
    @Override
    public JButton createButton(String name, int secondsToAdd, ActionListener listener) {
        JButton button = createButton(name, listener);
        button.putClientProperty("secondsToAdd", secondsToAdd);
        return button;
    }

    @Override
    public JButton createButton(String name, ActionListener listener) {
        JButton button = new JButton(name);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setBackground(new Color(59, 89, 182));
        button.setPreferredSize(new Dimension(180, 70));
        button.setMargin(new Insets(10, 20, 10, 20));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Tahoma", Font.BOLD, 24));
        button.addActionListener(listener);
        return button;
    }
}
