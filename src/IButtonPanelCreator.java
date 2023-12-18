import java.awt.event.ActionListener;
import javax.swing.JPanel;

public interface IButtonPanelCreator {
    public abstract JPanel createButtonPanel(
        String[] names,
        ActionListener[] listeners
    );
    public abstract JPanel createButtonPanel(
        String[] names,
        int[] seconds,
        ActionListener listener
    );
}
