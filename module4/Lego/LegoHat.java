import java.util.Random;
public class LegoHat {
  String style;
  int size;

  public LegoHat(String style, int size) {
    this.style = style;
    this.size = size;
  }

  public String toString() {
    String hatSize;
    if (this.size == 0) hatSize = "small";
    else if (this.size == 1) hatSize = "medium";
    else hatSize = "large";

    return "a " + hatSize + ' ' + this.style;
  }

  public int computeStyle(String season) {
    if ((this.style == "toque" && season != "winter")
    || (this.style == "sun visor" && season != "summer")) {
      return 1;
    } else {
      Random rand = new Random();
      // Random.nextInt returns a number 0 - range. We add 6 to get a random number between 6 and 10
      return rand.nextInt(4) + 6;
    }
  }
};