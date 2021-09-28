#include <iostream>

using namespace std;

// doubleNumber takes a number and return double its value
int doubleNumber(int num) {
  return num * 2;
}

int main(int argc, char** argv) {
  int x = 2;
  while (x <= 64) {
    int y = doubleNumber(x);
    cout << x << ", " << y << endl;
    x = y;
  }
  return 0;
}