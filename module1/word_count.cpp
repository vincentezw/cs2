#include <iostream>

using namespace std;

// Function to check if array holds a value
// yes, it appears there are better ways. Also not sure how to get length of fixed size array.
bool checkArray(char toFind, int *data, int arraySize) {
  for(int i = 0; i < arraySize; i++){
    if(data[i] == toFind){
      return true;
    }
  }
  return false;
}

int main() {
  char input, previousInput;
  int index = 0, number, longestWord = 0, words = 0, currentWordLength = 0, mostVowels = 0, currentVowelLength = 0;
  bool containsVowels = false;

  int punctution[6] = {33, 44, 46, 58, 59, 63};
  int vowels[10] = {65, 69, 73, 79, 85, 97, 101, 105, 111, 117};

  cout << "Enter a sentence: ";

  while (input != 10) { 
    previousInput = input;
    input = cin.get();
    if (input != 32 && input != 10 && !checkArray(input, punctution, 6)) {
      currentWordLength++;
      containsVowels = true;
      if (checkArray(input, vowels, 10)) {
        currentVowelLength++;
      }
    } else {
      longestWord = currentWordLength > longestWord ? currentWordLength : longestWord;
      mostVowels = currentVowelLength > mostVowels ? currentVowelLength : mostVowels;
      currentWordLength = 0;
      currentVowelLength = 0;
    }

    if ((input == 32 || input == 10) && previousInput != 32 && index != 0 && containsVowels) {
      words++;
      containsVowels = false;
    }
    index++;
  }

  cout << "Word count: " << words << "\n";
  cout << "Longest word: " << longestWord << "\n";
  cout << "Most vowels: " << mostVowels << "\n";
  return 0;
}