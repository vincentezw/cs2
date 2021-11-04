#include <iostream>
using namespace std;

struct soda {
  int gramsOfSugar;
  float gramsOfCarbonation;
};

int main() {
  int numberOfSodas = 3;
  soda **sodaArray = new soda*[numberOfSodas];

  sodaArray[0] = new soda;
  sodaArray[1] = new soda;
  sodaArray[2] = new soda;

  // assign values, sugary stuff!
  sodaArray[0]->gramsOfSugar = 900;
  sodaArray[0]->gramsOfCarbonation = 1.2;
  sodaArray[1]->gramsOfSugar = 1200;
  sodaArray[1]->gramsOfCarbonation = 1.1;
  sodaArray[2]->gramsOfSugar = 1500;
  sodaArray[2]->gramsOfCarbonation = 1.3;

  // print values for each soda
  for (int i = 0; i<numberOfSodas; i++) {
    if (sodaArray[i] != NULL) {
      cout << "Soda number: " << i << endl;
      cout << " - grams of sugar: " << sodaArray[i]->gramsOfSugar << endl;
      cout << " - grams of carbonation: " << sodaArray[i]->gramsOfCarbonation << endl;
    }
  }

  // delete sodas again
  for (int i = 0; i<numberOfSodas; i++) {
    delete sodaArray[i];
    sodaArray[i] = NULL;
  }
  delete [] sodaArray;
  sodaArray = NULL;

  return 0;
}