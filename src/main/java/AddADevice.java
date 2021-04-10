import java.util.List;
import java.util.Scanner;

public class AddADevice {
  private List<Device> devices;

  public AddADevice(List<Device> devices) {
    this.devices = devices;
  }

  public void addADeviceUserInterface() {
    print(deviceOptionMenu());

    DeviceMenu option = null;
    Scanner scanner = new Scanner(System.in);
    String deviceName = scanner.nextLine();
    while (deviceName.isEmpty()) {
      print("Option cannot be empty");
      deviceName = scanner.nextLine();
    }

    try {
      option = DeviceMenu.valueOf(deviceName);
      if (option == DeviceMenu.s) {
        print("Please enter the stereo device name:");
        this.devices.add(new Stereo(scanner.nextLine()));
      }
      else if (option == DeviceMenu.t) {
        print("Please enter the television device name:");
        this.devices.add((new Television(scanner.nextLine())));
      }
      else if (option == DeviceMenu.w) {
        print("Please enter the Switch light name:");
        this.devices.add((new SwitchableLight(scanner.nextLine())));
      }
      else if (option == DeviceMenu.d) {
        print("Please enter the Dimmable light name:");
        this.devices.add((new DimmableLight(scanner.nextLine())));
      }
    } catch (IllegalArgumentException error) {
      System.out.println("That isn't the valid Add-Device option. Please try again!");
    }
  }

  private void print(String prompt) {
    System.out.println(prompt);
  }

  private String deviceOptionMenu() {
    StringBuilder output = new StringBuilder();
    output.append("\n*** Add a Device Menu ***\n");
    for (DeviceMenu option : DeviceMenu.values()) {
      output.append(option.toString()).append("\n");
    }
    return output.toString();
  }
}

