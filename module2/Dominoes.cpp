#include <iostream>
using namespace std;

struct domino {
  int bottomHalf;
  int topHalf;
};

void drawDominoes(domino dominoArray[], int numberOfDominoes) {
  // dominos have three lines of hashes on either halve. These are the values 0 - 6
  const string firstAndThird[7] = {"|   |","|   |", "| * |", "| * |", "|* *|", "|* *|", "|* *|"};
  const string second[7] = {"|   |", "| * |", "|   |", "| * |", "|   |", "| * |", "|* *|"};

  for (int i = 0; i < 9; i++) {
    for (int i2 = 0; i2 < numberOfDominoes; i2++) {
      string toPrint;
      if (i == 0 || i == 4 || i == 8) toPrint = "-----";
      else if (i == 2 || i == 6)  toPrint = i < 4 ? second[dominoArray[i2].topHalf] : second[dominoArray[i2].bottomHalf];
      else toPrint = i < 4 ? firstAndThird[dominoArray[i2].topHalf] : firstAndThird[dominoArray[i2].bottomHalf];
      cout << toPrint << "  ";
    }
    cout << "\n";
  }  
}

void sortDominos(domino dominoArray[], int numberOfDominoes) {
  for (int i = 1; i < numberOfDominoes; i++) {
    for (int i2 = i; i2 > 0 && dominoArray[i2-1].topHalf > dominoArray[i2].topHalf; i2--) {
      domino temporary = dominoArray[i2-1];
      dominoArray[i2 -1] = dominoArray[i2];
      dominoArray[i2] = temporary;
    }
  }
}

int main() {
  const int numberOfDominoes = 28;
  domino dominoArray[numberOfDominoes];

  // the number of dominoes to fill with a particular number vs. the ones done.
  int numberToAssign = 7, tilesAssigned = 0;

  for (int i = 0; i < numberOfDominoes; i++) {
    // the actual number of bottom dots is one less than the number of tiles we give it, e.g. there are 7 tiles with a 6, 6 with a 5 etc.
    int bottomHalf = numberToAssign - 1;
    // the number of tiles on the top is equal to the number of tiles on the bottom minus tiles done
    int topHalf = bottomHalf - tilesAssigned;
    dominoArray[i] = {bottomHalf, topHalf};
    // adjust our numbers when a row is complete
    tilesAssigned++;
    if (tilesAssigned >= numberToAssign) {
      tilesAssigned = 0;
      numberToAssign--;
    }
  }

  drawDominoes(dominoArray, numberOfDominoes);
  
  cout << "\nAnd now... let's shuffle them dominoes!\n\n";
  // I'm not fully sure why this works, I'm passing my array as value not reference, yet it gets updated? I guess the array itself serves as a reference to structs?
  // Also: my sort function can't do "return dominoArray" unless I set return value to "domino *" - but then I can't reassign back to dominoArray here in main.
  sortDominos(dominoArray, numberOfDominoes);
  drawDominoes(dominoArray, numberOfDominoes);
  return 0;
}
