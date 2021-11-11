public class LegoMiniFigure {
  String name;
  LegoHat hat;
  LegoItem rightHand;
  LegoItem leftHand;

  // constructor for a fully kitted lego figure
  public LegoMiniFigure(String name, LegoHat hat, LegoItem right, LegoItem left) {
    this.name = name;
    this.hat = hat;
    this.rightHand = right;
    this.leftHand = left;
  }

  // constructor for a figure not holding anything
  public LegoMiniFigure(String name) {
    this.name = name;
  }

  public void swapHands() {
    LegoItem tempItem = this.leftHand;
    this.leftHand = this.rightHand;
    this.rightHand = tempItem;
  }

  public void wearHat(LegoHat hat) {
    this.hat = hat;
  }

  public void placeInLeftHand(LegoItem item) {
    this.leftHand = item;
  }

  public void placeInRightHand(LegoItem item) {
    this.rightHand = item;
  }

  public String toString() {
    String printFigure = "A Lego minifigure named " + this.name;
    if (this.hat != null || this.rightHand != null || this.leftHand != null) {
      printFigure += ", who ";
    }
    if (this.hat != null) {
      printFigure += "is wearing " + this.hat.toString();
    }
    if (this.rightHand != null || this.leftHand != null) printFigure += " and holding ";
    if (this.leftHand != null) {
      printFigure += this.leftHand.toString() + " in their left hand";
    }
    if (this.rightHand != null) {
      if (this.leftHand != null) printFigure += " and ";
      printFigure += this.rightHand.toString() + " in their right hand";
    }
    printFigure += ".";
    return printFigure;
  }

  public boolean isGood(String season, float threshold) {
    // need to check the properties for null to avoid calling method on a null
    boolean rightHandTooHeavy = this.rightHand == null ? false : this.rightHand.isHeavy(threshold);
    boolean leftHandTooHeavy = this.leftHand == null ? false : this.leftHand.isHeavy(threshold);
    boolean isStylish = this.hat == null ? true : this.hat.computeStyle(season) >= 6;
    return isStylish && !rightHandTooHeavy && !leftHandTooHeavy;
  }
};