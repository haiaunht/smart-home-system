import java.awt.Menu;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
  public static final String ADD_A_DEVICE = "Add a Device";
  public static final String MANAGE_DEVICES = "Manage Devices";
  public static final String HOME_STATUS = "Home Status";
  public static final String ALL_DEVICES_ON = "All Devices On";
  public static final String ALL_DEVICES_OFF = "All Devices Off";
  public static final String QUIT = "Quit";
  public static List<Device> listOfAllDevices = new ArrayList<>();

  public enum MenuOption {
    a(ADD_A_DEVICE),
    m(MANAGE_DEVICES),
    h(HOME_STATUS),
    o(ALL_DEVICES_ON),
    x(ALL_DEVICES_OFF),
    q(QUIT);

    private String optionText;

    MenuOption(String optionText) {
      this.optionText = optionText;
    }

    public String toString() {
    return this.name() + " - " + this.optionText;
  }
  }

  public static List<Device> getListOfAllDevices() {
    return listOfAllDevices;
  }


  public static void showMainMenu() {
    System.out.println("Welcome to LaunchAcademy - Smart Home System");
    MainMenu menu = new MainMenu();
    List<Device> devices = MainMenu.getListOfAllDevices();

    MenuOption selectedOption = null;
    Scanner scanner = new Scanner(System.in);
    do {
      System.out.println(menu.toString());
      try {
        selectedOption = MenuOption.valueOf(scanner.next());

        if (selectedOption == MenuOption.a) {
          AddADevice addADevice = new AddADevice(devices);
          addADevice.addADeviceUserInterface();
        }
        else if (selectedOption == MenuOption.m) {
          if (getListOfAllDevices().size() == 0) {
            System.out.println("There is no device to manage.");
          } else {
            ManageDevices manageDevices = new ManageDevices(devices);
            manageDevices.mangeDevicesInterface();
          }
        } else if (selectedOption == MenuOption.h) {
          if (getListOfAllDevices().size() == 0) {
            System.out.println("There is no device to view.");
          }
          ViewHouseStatus view = new ViewHouseStatus(devices);
          System.out.println(view.displayAllStatus());
        } else if (selectedOption == MenuOption.o) {
          AllDevicesOn on = new AllDevicesOn(devices);
          on.execute();
        } else if (selectedOption == MenuOption.x) {
          AllDevicesOff off = new AllDevicesOff(devices);
          off.execute();
        }
      } catch (IllegalArgumentException error) {
        System.out.println("That isn't the valid menu option. Please try again!");
      }
    } while (selectedOption != MenuOption.q);
    System.out.println("Thank you for using the Smart Home System!");
  }

  public String toString() {
    StringBuilder output = new StringBuilder();
    output.append("\nMAIN MENU:\n");
    for (MenuOption option : MenuOption.values()) {
      output.append(option.toString()).append("\n");
    }
    return output.toString();
  }
}
