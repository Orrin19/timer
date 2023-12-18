import java.awt.event.ActionListener;
import javax.swing.JButton;

public interface IButtonCreator {
    public abstract JButton createButton(String name, int secondsToAdd, ActionListener listener);
    public abstract JButton createButton(String name, ActionListener listener);
}
