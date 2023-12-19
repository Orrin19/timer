public interface IApp {
  public abstract void updateCountdownLabel();

  public abstract void updateState(IState newState);

  public abstract void startTimer();

  public abstract void stopTimer();

  public abstract void pauseTimer();
}