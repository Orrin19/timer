import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App implements ITimerWindow, ITimerController {
  private JFrame frame;
  private JLabel countdownLabel;
  private int totalSeconds = 0;
  private Timer timer;
  private SoundPlayer soundPlayer;

  private IState state;
  private JButton resetButton;
  private JButton startButton;
  private JButton stopButton;
  private JButton pauseButton;

  public App() {
    frame = new JFrame("Таймер");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1280, 720);
    frame.setLayout(new BorderLayout());
    frame.setResizable(false);
    frame.setIconImage(new ImageIcon("src/assets/icon.png").getImage());

    countdownLabel = new JLabel("00:00:00");
    countdownLabel.setFont(new Font("Tahoma", Font.BOLD, 172));
    countdownLabel.setHorizontalAlignment(SwingConstants.CENTER);
    frame.add(countdownLabel, BorderLayout.CENTER);

    ButtonPanelCreator buttonPanelCreator = new ButtonPanelCreator();
    JPanel timeButtonPanel =
      buttonPanelCreator.createButtonPanel(
        new String[] {
          "+ 5 секунд", "+ 15 секунд", "+ 1 минута", "+ 5 минут", "+ 15 минут", "+ 1 час"
        },
        new int[] {5, 15, 60, 300, 900, 3600},
        new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            JButton clickedButton = (JButton) e.getSource();
            int secondsToAdd =
              Integer.parseInt(clickedButton.getClientProperty("secondsToAdd").toString());
            totalSeconds += secondsToAdd;
            updateCountdownLabel();
          }
        });

        JPanel controlButtonPanel =
          buttonPanelCreator.createButtonPanel(
            new String[] {"Сбросить", "Старт", "Стоп", "Пауза"},
            new ActionListener[] {
              new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                  totalSeconds = 0;
                  updateCountdownLabel();
                }
              },
              new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                  startTimer();
                }
              },
              new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                  stopTimer();
                }
              },
              new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                  pauseTimer();
                }
              }
            });
        resetButton = (JButton) controlButtonPanel.getComponent(0);
        startButton = (JButton) controlButtonPanel.getComponent(1);
        stopButton = (JButton) controlButtonPanel.getComponent(2);
        pauseButton = (JButton) controlButtonPanel.getComponent(3);
        updateState(new WaitingState());

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BorderLayout());
        buttonsPanel.add(timeButtonPanel, BorderLayout.NORTH);
        buttonsPanel.add(controlButtonPanel, BorderLayout.SOUTH);
        frame.add(buttonsPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

  /** Обновляет текущее значение таймера. */
  public void updateCountdownLabel() {
    int hours = totalSeconds / 3600;
    int minutes = (totalSeconds % 3600) / 60;
    int seconds = totalSeconds % 60;
    countdownLabel.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
  }

  /**
   * Обновляет состояние таймера и кнопок.
   *
   * @param  newState  объект нового состояния таймера
   */
  public void updateState(IState newState) {
    state = newState;
    resetButton.setVisible(state.getResetButtonState());
    startButton.setVisible(state.getStartButtonState());
    stopButton.setVisible(state.getStopButtonState());
    pauseButton.setVisible(state.getPauseButtonState());
  }

  /** Запуск таймера. */
  public void startTimer() {
    if (timer == null) {
      timer =
          new Timer(
              1000,
              new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                  totalSeconds--;
                  updateCountdownLabel();
                  if (totalSeconds == 0) {
                    soundPlayer.play();
                    stopTimer();
                  }
                }
              });
    }
    if (totalSeconds > 0) {
      updateState(new RunningState());
      soundPlayer = new SoundPlayer("assets/sound.wav");
      timer.start();
    }
  }

  /** Остановка и сброс таймера. */
  public void stopTimer() {
    if (timer != null) {
      updateState(new WaitingState());
      timer.stop();
      timer = null;
      totalSeconds = 0;
      updateCountdownLabel();
    }
  }

  /** Постановка таймера на паузу. */
  public void pauseTimer() {
    if (timer != null) {
      updateState(new PausedState());
      timer.stop();
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new App();
          }
        });
  }
}
