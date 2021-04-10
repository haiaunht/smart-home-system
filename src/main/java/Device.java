import java.util.Scanner;

public class Device {
  private String name;
  private boolean powerOn;
  private String type;

  public Device(String name) {
    this.name = name;
    this.powerOn = false;
    this.type  = "(Device)";
  }

  public String getName() {
    return this.name;
  }

  public String getType() {
    return this.type;
  }

  public boolean isPowerOn() {
    return this.powerOn;
  }

  public void setPowerOn(boolean powerOn) {
    this.powerOn = powerOn;
  }

  public void togglePower() {
    this.powerOn = !this.powerOn;
  }

  public String powerStatus() {
    return (this.powerOn) ? "powered on" : "powered off";
  }

  public String status() {
    return  this.getType() + " " + this.getName() + ", " + this.powerStatus();
  }

  public void managePower() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("This " + this.getName() + " current " + this.powerStatus());
    String toggle;
    do {
      System.out.println("Do you want to toggle? 'y' for yes, 'n' for no.");
      toggle = scanner.nextLine();
      if (toggle.equalsIgnoreCase("y")) {
        this.togglePower();
      }
      System.out.println(this.getName() + " is " + this.powerStatus());
    } while (!toggle.equalsIgnoreCase("y") && !toggle.equalsIgnoreCase("n"));
  }

  public void manageThisDevice() {
    System.out.println("Manage this device");
  }
}
