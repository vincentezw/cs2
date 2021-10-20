#include <iostream>

using namespace std;

// doubleNumber takes a number and returns double its value
bool isSorted(int array[], int numItems) {
  for (int i = 0; i < numItems; i++) {
    if (!(array[i - 1] <= array[i])) return false;
  }
  return true;
}

int main() {
  const int TEST_ARRAYS_SIZE = 7;
  int testArray1[TEST_ARRAYS_SIZE] = {4, 2, 4, 5, 6, 7, 8};
  int testArray2[TEST_ARRAYS_SIZE] = {1, 2, 2, 5, 6, 7, 8};
  cout << "isSorted returned " << isSorted(testArray1, TEST_ARRAYS_SIZE);
  cout << "isSorted returned " << isSorted(testArray2, TEST_ARRAYS_SIZE);
  return 0;
}