import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundPlayer {
  private Clip clip;

  public SoundPlayer(String soundFilePath) {
    try {
      InputStream inputStream = getClass().getClassLoader().getResourceAsStream(soundFilePath);
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(inputStream);
      clip = AudioSystem.getClip();
      clip.open(audioInputStream);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /** Проигрывание звука */
  public void play() {
    if (clip != null) {
      clip.start();
    }
  }
}
