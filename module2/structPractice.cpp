#include <iostream>
using namespace std;

struct someTime {
  string amOrPm;
  int hours;
  int minutes;
  int seconds;
};

void addMinuteAsReference(someTime &t) {
  t.minutes = t.minutes++ == 59 ? 0 : t.minutes++;
  if (t.minutes == 0) {
    t.hours++;
    if (t.hours == 12) {
      t.hours = 0;
      t.amOrPm = t.amOrPm == "PM" ? "AM" : "PM";
    }
  }
}

someTime addHourAsValue(someTime t) {
  t.hours++;
  if (t.hours == 12) {
    t.hours = 0;
    t.amOrPm = t.amOrPm == "PM" ? "AM" : "PM";
  }
  return t;
}

void printTime(someTime t) {
  // have not implemented leading zeroes
  cout << t.hours << ":" << t.minutes << ":"  << t.seconds << " " << t.amOrPm << "\n";
}

int main()
{
  someTime happyHour = {"PM", 10, 55, 0};

  // adding 5 hours with our "as value" function, we should be at 3:55:00 AM because we start at 10:55:00 PM
  for (int i = 0; i < 5; i++) {
    happyHour = addHourAsValue(happyHour);
  }
  printTime(happyHour);

  // adding 10 minutes with our "as reference" function, we should be at 4:05:00AM as we started at 3:55:00 AM
  for (int i = 0; i < 10; i++) {
    addMinuteAsReference(happyHour);
  }
  printTime(happyHour);

  return 0;
}

