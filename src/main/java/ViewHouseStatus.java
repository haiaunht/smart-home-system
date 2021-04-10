import java.util.List;

public class ViewHouseStatus {
  private List<Device> devices;

  public ViewHouseStatus(List<Device> devices) {
    this.devices = devices;
  }

  public String displayAllStatus() {
    StringBuilder output = new StringBuilder();
    for (int i=0; i<devices.size(); i++) {
      output.append(i+1).append(" - ");
      output.append(devices.get(i).status()).append("\n");
    }
    return output.toString();
  }
}
