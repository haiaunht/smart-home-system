import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ManageDevices {
  private List<Device> devices;

  public ManageDevices(List<Device> devices) {
    this.devices = devices;
  }

  public void mangeDevicesInterface() {
    System.out.println(showAllDevices());
    Scanner scanner = new Scanner(System.in);

    Device selectedDevice = null;
    do {
      System.out.println("What device would you like to work with. Please enter the number:");
      String userInput = scanner.nextLine();
      try {
        selectedDevice = this.devices.get(Integer.parseInt(userInput)-1);
        selectedDevice.manageThisDevice();
      } catch (IndexOutOfBoundsException e) {
        System.out.println("Please enter a valid device.");
      } catch (NumberFormatException e) {
        System.out.println("Please enter a device's number, not text");
      }
    } while (selectedDevice == null);
  }

  private String showAllDevices() {
    StringBuilder string = new StringBuilder();
    string.append("Your current devices:\n");
    for (int i=0; i<devices.size(); i++) {
      string.append(i+1).append(" - ").append(devices.get(i).getType()).append(" ").append(devices.get(i).getName()).append("\n");
    }
    return string.toString();
  }
}

