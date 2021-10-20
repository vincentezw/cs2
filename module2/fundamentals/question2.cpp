#include <iostream>

using namespace std;

// doubleNumber takes a number and returns double its value
int countCapitals(char array[], int numItems) {
  int capitals = 0;
  for (int i = 0; i < numItems; i++) {
    int charAsInt = array[i] - '0';
    //cout << "testing: " << charAsInt << '\n';
    if (charAsInt >= 17 && charAsInt <= 42) capitals++;
  }
  return capitals;
}

int main() {
  const int TEST_ARRAYS_SIZE = 11;
  char testArray1[TEST_ARRAYS_SIZE] = {'a', 'A', 'b', 'B', 'c', 'C', 'd', 'E', 'e', 'F', 'f'};
  char testArray2[TEST_ARRAYS_SIZE] = {'a', 'A', 'b', 'B', 'c', 'C', 'd', 'E', 'e', 'F', 'f'}; 

  cout << "countCapitals returned " << countCapitals(testArray1, TEST_ARRAYS_SIZE);
  cout << "countCapitals returned " << countCapitals(testArray2, TEST_ARRAYS_SIZE);
  return 0;
}