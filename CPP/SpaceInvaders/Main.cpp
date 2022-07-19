#include <iostream>
#include <string>
#include <vector>
#include <iomanip>
#include <chrono>
#include <thread>
#include <conio.h>
#include "Invaders.h"
#include "Projectile.h"

using namespace std::this_thread;
using namespace std::chrono_literals;
using namespace std;


/*
TODO
figure out how to detect projectile collision
figure out how to limit the number of projectiles the player can shoot at once
Create a function that fires the player projectile (I may need to move the printer for the spaces between the player and the invaders to this function, from the invader printer function)
Create a win condition function
Create a start screen


DEBUG
the invaders can move much farther to the right than I can
find a way to limit the getch buffer so we don't overload it, or so the player can change their mind (I added fflush to the input stream function but 
it does not seem to work the way I want, I will need to check into it next time).
*/


//global variables

char inputChar;
bool keepRunning = true, movingRight = true, playerWin;
int currentInvaders = 24, vertposition = 0, horposition = 0, playerPosition = 0;
vector<Invaders> invaderList(24);



void initializeInvaders(vector<Invaders>& listPop) {
	//Initializes the vector of current invaders
	int i;
	for (i = 0; i < invaderList.size(); ++i) {
		Invaders currentInvader;
		invaderList.at(i) = currentInvader;
	}
}

void destroyInvader(Invaders& currInvader, int& invaderCount) {
	//destroys the current invader (making it's shape just spaces)
	currInvader.Destroy();
	invaderCount -= 1;
	return;
}


void inputStream(char& currentChar) {
	//this function gets and modifies the inputChar var, controlling user input for the game.
	fflush(stdin);
	if (_kbhit()) {
		currentChar = _getch();
	}
	else {
		currentChar = '0';
	}
	return;
}

void invaderPrinter(const vector<Invaders>& myList, const int& spacesDown, const int& spacesRight) {
	//Function prints the remaining invaders based on their .GetShape(). Spaces right is how many they're displaced from centered in the 15 character frame
	//spacesDown is the number of spaces they've moved down. 
	// TODO: modify this to show the border of the game (which is 15 characters on either side)
	
	//\n from top
	int i;
	for (i = 0; i < spacesDown; ++i) {
		cout << endl;
	}
	//row 1
	for (i = 0; i < (spacesRight + 20); ++i) {
		cout << " ";
	}
	for (i = 0; i < 8; ++i) {
		cout << myList.at(i).GetShape();
	}
	for (i = 0; i < spacesRight; ++i) {
		cout << " ";
	}
	for (i = 0; i < (20 - spacesRight); ++i) {
		cout << " ";
	}
	cout << endl;
	//row 2
	for (i = 0; i < (spacesRight + 20); ++i) {
		cout << " ";
	}
	for (i = 8; i < 16; ++i) {
		cout << myList.at(i).GetShape();
	}
	for (i = 0; i < spacesRight; ++i) {
		cout << " ";
	}
	for (i = 0; i < (20 - spacesRight); ++i) {
		cout << " ";
	}
	cout << endl;
	//row 3
	for (i = 0; i < (spacesRight + 20); ++i) {
		cout << " ";
	}
	for (i = 16; i < 24; ++i) {
		cout << myList.at(i).GetShape();
	}
	for (i = 0; i < spacesRight; ++i) {
		cout << " ";
	}
	for (i = 0; i < (20 - spacesRight); ++i) {
		cout << " ";
	}
	//\n between invaders and player
	for (i = 0; i < 15 - spacesDown; ++i) {
		cout << endl;
	}
	return;
}

void invaderMover(int& spacesDown, int& spacesRight, bool& movingRight) {
	//if statements keep invaders within bounds, move them right to the edge, then down, then left to the edge then down, so on.
	if (movingRight && spacesRight < 6) {
		spacesRight += 1;
	}
	else if (movingRight && spacesRight == 6) {
		movingRight = false;
		spacesDown += 1;
	}
	else if (!movingRight && spacesRight > -6) {
		spacesRight -= 1;
	}
	else if (!movingRight && spacesRight == -6) {
		movingRight = true;
		spacesDown += 1;
	}
}

void consoleClear() {
	std::cout<< "\x1B[2J\x1B[H";
	return;
}

void playerPrinter(int spacesRight) {
	int i;
	for (i = 0; i < spacesRight + 37; ++i) {
		cout << " ";
	}
	cout << "o|_|o";
	for (i = 0; i < 37 - spacesRight; ++i) {
		cout << " ";
	}
	cout << endl;
	for (i = 0; i < 80; ++i) {
		cout << "-";
	}
}

void playerMover(char input, int& playerPosition) {
	switch (input) {
	case 'a':
		if (playerPosition > -20) {
			playerPosition -= 2;
		}
		break;
	case 'd':
		if (playerPosition < 20) {
			playerPosition += 2;
		}
		break;
	case ' ':
		//TODO fire projectile
		break;
	default:
		break;
	}
	return;
}




int main() {
	initializeInvaders(invaderList);
	int i = 0;
	while (keepRunning) {
		invaderPrinter(invaderList, vertposition, horposition);
		playerPrinter(playerPosition);
		inputStream(inputChar);
		playerMover(inputChar, playerPosition);
		if (i % 5 == 0) {
			invaderMover(vertposition, horposition, movingRight);
		}
		sleep_for(100ms);
		consoleClear();
		i++;
	}
	
	return 0;
}

