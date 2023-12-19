import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanelCreator implements IButtonPanelCreator {
  /**
   * Создаёт экземпляр JPanel с кнопками, созданными с переданными параметрами.
   *
   * @param names массив названий кнопок
   * @param listeners массив обработчиков событий
   * @return JPanel с кнопками
   */
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

  /**
   * Создаёт экземпляр JPanel с кнопками, созданными с переданными параметрами.
   *
   * @param names массив названий кнопок
   * @param seconds массив соответствующих времён в секундах
   * @param listener обработчик событий
   * @return JPanel с кнопками
   */
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
