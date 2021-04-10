
public class SwitchableLight extends Device{
  private String type;

  public SwitchableLight(String name) {
    super(name);
    this.type  = "(Switchable Light)";
  }

  @Override
  public String getType() {
    return this.type;
  }

  @Override
  public String powerStatus() {
    return (this.isPowerOn()) ? "switched on" : "switched off";
  }

  @Override
  public String status() {
    return  this.getType() + " " + this.getName() + ", " + this.powerStatus();
  }

  @Override
  public void manageThisDevice() {
    super.managePower();
  }
}
