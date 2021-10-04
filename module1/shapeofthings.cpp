/*
Program to draw this shape, outputting only one hash, space or newline at a time

by Vincent Zwanenburg

#                 #
 ##             ##
  ###         ###
   ####     ####
    ###########
    ###########
   ####     ####
  ###         ###
 ##             ##
#                 #
*/

#include <iostream>

using namespace std;

// output a given character a number of times
void outputSomething(int num, char symbol) {
  for (int i = 0; i < num; i++) {
    cout << symbol;
  }
}

int main(int argc, char** argv) {
  for (int i=0; i<10; i++) {
    // the number of spaces on the left per line
    int outerSpaces = 4.5-abs(4.5-i);
    outputSomething(outerSpaces, ' ');
    //for (int i2 = 0; i2<outerSpaces; i2++) {
    //  cout << ' ';
    //}

    // the amount of spaces in the middle, with a little tweak to get the middle to zero
    int innerSpaces = 17 - (outerSpaces * 4);
    innerSpaces = innerSpaces == 1 ? 0 : innerSpaces;


    // number of hashes, with a tweak to adjust the middle two lines
    int hashes = (outerSpaces*2)+2;
    hashes = hashes == 10 ? 11 : hashes;

    // if hashes are even, we need to divide by two to display on either side, and render inner space
    // otherwise, no innerspace and all hashes in one go
    if (hashes % 2 == 0) {
      outputSomething(hashes/2, '#');
      outputSomething(innerSpaces, ' ');
      outputSomething(hashes/2, '#');
    } else {
      outputSomething(hashes, '#');
    }
    cout << '\n';
  }

  return 0;
}