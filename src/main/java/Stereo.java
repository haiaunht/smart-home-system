import java.util.InputMismatchException;
import java.util.Scanner;

public class Stereo extends Device{
  private String type;
  private int volume;

  public Stereo(String name) {
    super(name);
    this.volume = 25;
    this.type = "(Stereo)";
  }

  public void setVolume(int volume) {
    if (volume < 0) {
      this.volume = 0;
    } else if (volume > 100) {
      this.volume = 100;
    } else {
      this.volume = volume;
    }
  }

  @Override
  public String getType() {
    return this.type;
  }

  public int getVolume() {
    return this.volume;
  }

  public void mute() {
    this.volume = 0;
  }

  @Override
  public String status() {
    return this.getType() + " " + this.getName() + ", " + this.powerStatus() + ", volume: " + this.getVolume();
  }

  public void manageVolume() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Would you like to mute or change volume? 'm' for mute, 'c' for change volume");
    String volumeOption = scanner.nextLine();
    while (!(volumeOption.equalsIgnoreCase("m") || volumeOption.equalsIgnoreCase("c"))) {
      System.out.println("Invalid option. Try again");
      volumeOption = scanner.nextLine();
    }
    if (volumeOption.equalsIgnoreCase("m")) {
      mute();
    } else {
      System.out.println("What volume level would you like to set your stereo to?");
      try {
        int volumeLevel = scanner.nextInt();
        this.setVolume(volumeLevel);
        System.out.println(this.getName() + " " + this.powerStatus() + ", with volume of " + this.getVolume());
      } catch (InputMismatchException e) {
        System.out.println("Please enter number in the range 0-100.");
      }
    }
  }

  @Override
  public void manageThisDevice() {
    super.managePower();
    if (this.isPowerOn()) {
      manageVolume();
    }
    else {
      System.out.println("Your stereo device has turned off!");
    }
  }
}
