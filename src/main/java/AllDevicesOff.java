import java.util.List;

public class AllDevicesOff {
  private List<Device> devices;

  public AllDevicesOff(List<Device> devices) {
    this.devices = devices;
  }

  public void execute() {
    for (Device device : devices) {
      device.setPowerOn(false);
    }
  }
}
