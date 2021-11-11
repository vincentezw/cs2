public class LegoItem {
  String name;
  float weight;

  public LegoItem(String name, float weight) {
    this.name = name;
    this.weight = weight;
  }

  public String toString() {
    return "a " + this.weight + "-gram " + this.name;
  }

  public boolean isHeavy(float threshold) {
    return this.weight > threshold;
  }
};