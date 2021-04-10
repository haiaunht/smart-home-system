public enum DeviceMenu {
  s("Add a Stereo Device"),
  t("Add a TV Device"),
  w("Add a Switchable Light"),
  d("Add a Dimmable Light"),
  q("Quit");

  private String optionText;

  DeviceMenu(String optionText) {
    this.optionText = optionText;
  }

  public String toString() {
    return this.name() + " - " + this.optionText;
  }
}
