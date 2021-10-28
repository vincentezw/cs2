#include <iostream>
using namespace std;

struct course {
  string department;
  int number;
  string title;
};

int numCoursesInDepartment(course courseArray[], int numCourses, string department) {
  int coursesForDepartment = 0;
  for (int i = 0; i < numCourses; i++) {
    if (courseArray[i].department.compare(department) == 0) {
      coursesForDepartment++;
    }
  }
  return coursesForDepartment;
}

int main() {
  const int numCourses = 10;
  course courseArray[numCourses] =  {
    {"COMP", 140, "C++"},
    {"COMP", 132, "Fortran"},
    {"COMP", 152, "Ruby"},
    {"COMP", 85, "Java"},
    {"COMP", 141, "Internet Explorer for seniors"},
    {"COMP", 114, "Assembly"},
    {"LAW", 74, "Tax Avoidance for Dummies"},
    {"LAW", 161, "Small Claims Court"},
    {"LAW", 147, "Taking Bribes"},
    {"ARTS", 78, "LSD for beginners"},
  };

  string departmentToQuery;
  cout << "What department are you looking to find the amount of courses for (enter  a value and press enter): ";
  cin >> departmentToQuery;

  int coursesForDept = numCoursesInDepartment(courseArray, numCourses, departmentToQuery);
  cout << "There are " << coursesForDept << " courses in " << departmentToQuery << endl;
  return 0;
}

