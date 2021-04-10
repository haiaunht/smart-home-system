import java.util.InputMismatchException;
import java.util.Scanner;

public class Television extends Stereo{
  private String type;
  private int channel;

  public Television(String name) {
    super(name);
    this.channel = 1;
    this.type = "(Television)";
  }

  public int getChannel() {
    return this.channel;
  }

  public void setChannel(int channel) {
    if (channel < 1) {
      this.channel = 1;
    } else if (channel > 999) {
      this.channel = 999;
    } else {
      this.channel = channel;
    }
  }

  @Override
  public String getType() {
    return this.type;
  }

  @Override
  public String status() {
    return this.getType() + " " + this.getName() + ", " + this.powerStatus() + ", volume: " + this.getVolume() + ", channel: " + this.getChannel();
  }

  public void manageChannel() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("What channel would you like to set your television?");
    try {
      int channel = scanner.nextInt();
      this.setChannel(channel);
      System.out.println(this.getName() + " " + this.powerStatus() + ", channel of " + this.getChannel());
    } catch (InputMismatchException e) {
      System.out.println("Please enter number in the range 1-999.");
    }
  }

  @Override
  public void manageThisDevice() {
    super.managePower();
    if (this.isPowerOn()) {
      super.manageVolume();
      manageChannel();
    }
    else {
      System.out.println("Your stereo device has turned off!");
    }
  }
}


