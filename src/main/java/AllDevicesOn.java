import java.util.List;

public class AllDevicesOn {
  private List<Device> devices;

  public AllDevicesOn(List<Device> devices) {
    this.devices = devices;
  }

  public void execute() {
    for (Device device : devices) {
      device.setPowerOn(true);
    }
  }
}
