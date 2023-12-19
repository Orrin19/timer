public interface ITimerWindow {
  public abstract void updateCountdownLabel();

  public abstract void updateState(IState newState);
}