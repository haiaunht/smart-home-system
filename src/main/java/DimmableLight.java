import java.util.InputMismatchException;
import java.util.Scanner;

public class DimmableLight extends SwitchableLight{
  private String type;
  private int dimLevel;

  public DimmableLight(String name) {
    super(name);
    this.type = "(Dimmable Light)";
    this.dimLevel = 0;
  }

  @Override
  public String getType() {
    return this.type;
  }


  public void setDimLevel(int level) {
    if (level < 0){
      this.setPowerOn(false);
      this.dimLevel = 0;
    } else if (level > 100) {
      this.dimLevel = 100;
    } else {
      this.dimLevel = level;
    }
    this.setPowerOn(true);
  }

  public int getDimLevel() {
    return this.dimLevel;
  }

  @Override
  public String status() {
    this.dimLevel = (this.isPowerOn()) ? this.dimLevel : 0;
    return this.getType() + " " + this.getName() + ", " + this.powerStatus() + ", " + "dim level " + this.dimLevel + "%";
  }

  public void manageDimLevel() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("What dim level would you like to set your light to?");
    try {
      int volumeLevel = scanner.nextInt();
      this.setDimLevel(volumeLevel);
      System.out.println(this.getName() + " " + this.powerStatus() + ", with volume of " + this.getDimLevel());
    } catch (InputMismatchException e) {
      System.out.println("Please enter number in the range 0-100.");
    }
  }

  @Override
  public void manageThisDevice() {
    super.managePower();
    if (this.isPowerOn()) {
      this.manageDimLevel();
    }
    else {
      System.out.println("Your dimmable light has turned off!");
    }
  }
}
