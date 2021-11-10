public class TestScotchTape {
  // function for printing what's in the array
  public static void printTapeArray(ScotchTape[] tapeArray) {
    for (int i=0; i < tapeArray.length; i++){
      System.out.println(tapeArray[i].colour + " ("
        + tapeArray[i].length + " cm, "
        + tapeArray[i].weight + " oz)");
    }
  }

  // function to do something else
  public static void stickTape(ScotchTape tape, double percentToUse) {
    // I experimented a bit with the casting here. Math.round is nicest but rounds up.
    // the c++ original just uses the (int) format which rounds down, so I'm using that here too
    tape.weight -= (int)(tape.weight * percentToUse);
    tape.length -= (int)(tape.length * percentToUse);
  }

  public static void main(String[] args) {
    ScotchTape tapeArray[] = new ScotchTape[3];

    tapeArray[0] = new ScotchTape();
    tapeArray[0].colour = "clear";
    tapeArray[0].weight = 3;
    tapeArray[0].length = 22;

    tapeArray[1] = new ScotchTape();
    tapeArray[1].colour = "green";
    tapeArray[1].weight = 1;
    tapeArray[1].length = 15;

    tapeArray[2] = new ScotchTape();
    tapeArray[2].colour = "blue";
    tapeArray[2].weight = 2;
    tapeArray[2].length = 19;

    printTapeArray(tapeArray);

    stickTape(tapeArray[0], 0.5);
    stickTape(tapeArray[1], 0.3);
    stickTape(tapeArray[2], 0.9);

    System.out.println("\nHere is our modified array:\n");
    printTapeArray(tapeArray);
  }
}