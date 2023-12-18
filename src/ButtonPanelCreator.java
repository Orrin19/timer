import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanelCreator implements IButtonPanelCreator {
    @Override
    public JPanel createButtonPanel(String[] names, ActionListener[] listeners) {
        JPanel panel = new JPanel();
        ButtonCreator buttonCreator = new ButtonCreator();
        for (int i = 0; i < names.length; i++) {
            JButton button = buttonCreator.createButton(names[i], listeners[i]);
            panel.add(button);
        }
        return panel;
    }

    @Override
    public JPanel createButtonPanel(String[] names, int[] seconds, ActionListener listener) {
        JPanel panel = new JPanel();
        ButtonCreator buttonCreator = new ButtonCreator();
        for (int i = 0; i < names.length; i++) {
            JButton button = buttonCreator.createButton(names[i], seconds[i], listener);
            panel.add(button);
        }
        return panel;
    }
}
