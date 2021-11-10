public class Flower {
  String colour;
  int height;
  float percentWater;

  public Flower(String colour, int height, float percentWater) {
    this.colour = colour;
    this.height = height;
    this.percentWater = percentWater;
  }

  public void print() {
    System.out.println(this.colour + " (" + this.height + " cm, "
       + this.percentWater + "% water)");
  }

  public void growFlower() {
    this.height += 2;
    this.percentWater -= 0.05f;
  }

  public void waterFlower() {
    this.percentWater += 0.1f;
  }
};