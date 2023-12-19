public class WaitingState implements IState {
  private boolean resetButtonState = true;
  private boolean startButtonState = true;
  private boolean stopButtonState = false;
  private boolean pauseButtonState = false;

  /**
   * Возвращает состояние кнопки сброса.
   *
   * @return состояние кнопки сброса
   */
  public boolean getResetButtonState() {
    return resetButtonState;
  }

  /**
   * Возвращает состояние кнопки старта.
   *
   * @return состояние кнопки старта
   */
  public boolean getStartButtonState() {
    return startButtonState;
  }

  /**
   * Возвращает состояние кнопки остановки.
   *
   * @return состояние кнопки остановки
   */
  public boolean getStopButtonState() {
    return stopButtonState;
  }

  /**
   * Возвращает состояние кнопки паузы.
   *
   * @return состояние кнопки паузы
   */
  public boolean getPauseButtonState() {
    return pauseButtonState;
  }
}
