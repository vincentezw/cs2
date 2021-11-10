#include <iostream>
#include <string.h>

using namespace std;

class flower {
public:
  string colour;
  int height;
  float percentWater;

  flower(string colour, int height, float percentWater) {
    this->colour = colour;
    this->height = height;
    this->percentWater = percentWater;
  }

  void print() {
    cout << this->colour << " (" << this->height << " cm, "
       << this->percentWater << "% water)" << endl;
  }

  void growFlower() {
    this->height += 2;
    this->percentWater -= 0.05f;
  }

  void waterFlower() {
    this->percentWater += 0.1f;
  }
};

int main() {
  flower f = flower("purple", 10, 0.5f);
  f.print();

  f.waterFlower();
  f.print();

  f.growFlower();
  f.print();

  return 0;
}