public class TestFlower {
  public static void main(String[] args) {
    Flower f = new Flower("purple", 10, 0.5f);
    f.print();

    f.waterFlower();
    f.print();

    f.growFlower();
    f.print();
  }
}