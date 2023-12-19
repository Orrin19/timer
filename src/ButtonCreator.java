import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ButtonCreator implements IButtonCreator {
  /**
   * Создаёт JButton с заданными параметрами.
   *
   * @param name имя кнопки
   * @param secondsToAdd количество секунд
   * @param listener обработчик нажатия
   * @return созданный JButton
   */
  @Override
  public JButton createButton(String name, int secondsToAdd, ActionListener listener) {
    JButton button = createButton(name, listener);
    button.putClientProperty("secondsToAdd", secondsToAdd);
    return button;
  }

  /**
   * Создаёт JButton с заданными параметрами.
   *
   * @param name имя кнопки
   * @param listener обработчик нажатия
   * @return созданный JButton
   */
  @Override
  public JButton createButton(String name, ActionListener listener) {
    JButton button = new JButton(name);
    button.setBorderPainted(false);
    button.setFocusPainted(false);
    button.setBackground(new Color(59, 89, 182));
    button.setPreferredSize(new Dimension(180, 70));
    button.setMargin(new Insets(10, 20, 10, 20));
    button.setForeground(Color.WHITE);
    button.setFont(new Font("Tahoma", Font.BOLD, 20));
    button.addActionListener(listener);
    return button;
  }
}
