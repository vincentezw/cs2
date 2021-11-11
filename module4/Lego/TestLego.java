public class TestLego {
  // the "isGood" LegoMiniFigure method returns a boolean per assignment.
  // it looks a bit silly to add another class method just for pritning the result (with the same input), so I just made this a seperate function here
  public static void testCharacter(LegoMiniFigure figure, String season, float threshold) {
    if (figure.isGood(season, threshold)) {
      System.out.println(figure.name + " is good");
    } else {
      System.out.println(figure.name + " is bad");
    }
  }

  public static void main(String[] args) {
    String season = "summer";
    float threshold = 200;

    LegoHat sunvisor = new LegoHat("sun visor", 0);
    LegoHat toque = new LegoHat("toque", 2);
    LegoHat beanie = new LegoHat("beanie", 1);

    LegoItem sword = new LegoItem("sword", 250);
    LegoItem shovel = new LegoItem("shovel", 150);
    LegoItem walkieTalkie = new LegoItem("walkie talkie", 50);

    LegoMiniFigure figure1 = new LegoMiniFigure("Leo");
    LegoMiniFigure figure2 = new LegoMiniFigure("Laura", sunvisor, sword, walkieTalkie);

    // print Leo, he is not wearing or holding anything
    System.out.println(figure1.toString());
    // print Laura, wearing a sun visor, and holding a walkie talkie and sword
    System.out.println(figure2.toString());

    // dress up Leo and print
    figure1.wearHat(toque);
    figure1.placeInLeftHand(walkieTalkie);
    figure1.placeInRightHand(shovel);
    figure1.swapHands();
    System.out.println(figure1.toString());

    // Leo may not be carrying anything heavy, but he is wearing a toque in summer so is a bad boy
    testCharacter(figure1, season, threshold);
    System.out.println("** a sudden change of season **");
    season = "winter";
    testCharacter(figure1, season, threshold);

    // Laura quickly changes to a beanie now that it's winter, but is holding a heavy sword in her right hand
    figure2.wearHat(beanie);
    testCharacter(figure2, season, threshold);
    System.out.println("** Laura gets rid of that heavy sword **");
    figure2.placeInRightHand(null);
    testCharacter(figure2, season, threshold);
  }
}