#include <iostream>
using namespace std;

float getAverageScore(int *scores[], int arrayLength) {
  float total = 0;
  for (int i = 0; i < arrayLength; i++) {
    if (scores[i] != NULL) {
      total += *(scores[i]);
    }
  }
  return total / arrayLength;
}

void deleteValues(int *scores[], int arrayLength) {
  for (int i = 0; i < arrayLength; i++) {
    delete scores[i];
    scores[i] = NULL;
  }
}

int main()
{
  const int arrayLength = 10;
  // in Java, arrays are objects so stored in the heap, but the variable kept in the stack.
  // We can declare an array of null pointers to do the same
  int *scores[arrayLength] = {};

  // create new values on the heap in the same way the Java code does it
  for (int i = 0; i < arrayLength; i +=2) {
    scores[i] = new int(i);
  }

  cout << "Average score: " << getAverageScore(scores, arrayLength) << endl;
  // unlike in Java, we need to clean up afterwards
  deleteValues(scores, arrayLength);
  return 0;
}