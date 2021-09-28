#include <iostream>

using namespace std;

// doubleNumber takes a number and returns double its value
int doubleNumber(int num) {
  return num * 2;
}

int main(int argc, char** argv) {
  int x = 1;
  while (x <= 64) {
    int y = doubleNumber(x);
    cout << x << ", " << y << endl;
    x = y;
  }
  return 0;
}