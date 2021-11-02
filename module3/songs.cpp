#include <iostream>
using namespace std;

struct song {
  string title;
  string artist;
  int year;
};

string songToString(song s) {
  return s.title + " - " + s.artist + " (" + std::to_string(s.year) + ")";
}

song** songsFromYear(song **songs, int size, int year, int* resultSize) {
  // reset number of results and calculate new value
  *resultSize = 0;
  for (int i = 0; i < size; i ++) {
    if (songs[i] != NULL && songs[i]->year == year) {
      *resultSize = *resultSize + 1;
    }
  }

  song **resultArray = new song*[*resultSize];
  // second iteration variable for keeping track where in our result array we add the result
  int i2 = 0;
  for (int i = 0; i < size; i ++) {
    if (songs[i] != NULL && songs[i]->year == year) {
      resultArray[i2] = songs[i];
      i2++;
    }
  }
  return resultArray;
}

//int numSongsForYear()

int main() {
  int numberOfSongs = 6;
  song **songArray = new song*[numberOfSongs];

  // create new songs in the heap
  for (int i = 0; i < numberOfSongs; i++) {
    songArray[i] = new song;
  }

  // assign some values, good tunage!
  songArray[0]->title = "Heaven";
  songArray[0]->artist = "Talking Heads";
  songArray[0]->year = 1984;

  songArray[1]->title = "Hey";
  songArray[1]->artist = "Pixies";
  songArray[1]->year = 1989;

  songArray[2]->title = "Malibu Gas Station";
  songArray[2]->artist = "Sonic Youth";
  songArray[2]->year = 2009;

  songArray[3]->title = "Tomorrow Never Knows";
  songArray[3]->artist = "The Beatles";
  songArray[3]->year = 1966;

  songArray[4]->title = "The Room Got Heavy";
  songArray[4]->artist = "Yo La Tengo";
  songArray[4]->year = 2006;

  songArray[5]->title = "I Wanna Be Adored";
  songArray[5]->artist = "The Stone Roses";
  songArray[5]->year = 1989;

  // print the full song library array
  cout << "Favourite tunes: " << endl;
  for (int i = 0; i < numberOfSongs; i++) {
    if (songArray[i] != NULL) {
      cout << " - " << songToString(*songArray[i]) << endl;
    }
  }

  // one song is from 2006
  int yearToQuery = 1989;
  int * numSongsForYear = new int;
  song **songsFromGivenYear = songsFromYear(songArray, numberOfSongs, yearToQuery, numSongsForYear); 

  cout << "\nSongs for " << yearToQuery << ":" << endl;
  for (int i = 0; i < *numSongsForYear; i++) {
    cout << " - " << songToString(*songsFromGivenYear[i]) << endl;
  }

  // delete songs and arrays again
  for (int i = 0; i < numberOfSongs; i++) {
    delete songArray[i];
  }
  delete [] songArray;
  delete [] songsFromGivenYear;
  delete numSongsForYear;

  return 0;
}