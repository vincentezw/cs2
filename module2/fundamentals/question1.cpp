#include <iostream>

using namespace std;

// isSorted returns true if an array is sorted from small to big
bool isSorted(int array[], int numItems) {
  for (int i = 0; i < numItems; i++) {
    if (array[i] < array[i - 1]) return false;
  }
  return true;
}

int main() {
  const int TEST_ARRAYS_SIZE = 7;
  int testArray1[TEST_ARRAYS_SIZE] = {4, 2, 4, 5, 6, 7, 8};
  int testArray2[TEST_ARRAYS_SIZE] = {1, 2, 2, 5, 6, 7, 8};
  cout << "isSorted returned " << isSorted(testArray1, TEST_ARRAYS_SIZE) << endl;
  cout << "isSorted returned " << isSorted(testArray2, TEST_ARRAYS_SIZE) << endl;
  return 0;
}