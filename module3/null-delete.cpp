#include <iostream>
using namespace std;

void printArray(int *array[], int arrayLength) {
  for (int i = 0; i < arrayLength; i++) {
    if (array[i] != NULL) {
      cout << i << ": " << *array[i] << endl;
    }
  }
}

void deleteValues(int *array[], int arrayLength) {
  for (int i = 0; i < arrayLength; i++) {
    // this check looks obsolete
    if (array[i] != NULL) {
      delete array[i];
      array[i] = NULL;
    }
  }
}

int main()
{
  int arrayLength = 4;
  int * pointerArray[arrayLength];

  pointerArray[0] = new int;
  pointerArray[1] = new int;
  pointerArray[2] = NULL;
  pointerArray[3] = new int;

  *(pointerArray[0]) = 1;
  *(pointerArray[1]) = 10;
  *(pointerArray[3]) = 50;

  printArray(pointerArray, arrayLength);
  deleteValues(pointerArray, arrayLength);
  printArray(pointerArray, arrayLength);

  /* If we don't check for NULL in our printArray function, the program crashes with a segmentation fault. This is because the pointer
  in the array that holds NULL doesn't point anywhere in this scenario.

  The check for null in deleteValues looks obsolete, as I can use delete many times over on the same instance, even if it holds NULL.

  If we don't reset the values of our array to NULL, the pointer will point to random garbage.
  */
}