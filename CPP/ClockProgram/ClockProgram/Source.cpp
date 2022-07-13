#include <iostream>;
#include <string>;
#include <iomanip>;
#include <chrono>;
#include <thread>;
#include <conio.h>;


using namespace std::this_thread;
using namespace std::chrono_literals;
using namespace std;


void timeSplitter(int& seconds, int& hours24, int& hours12, int& minutes, bool& morning) {
	//takes the total time from timeSeconds and reassings all 4 time int vars with appropriate numbers
	hours24 = seconds / 3600;
	hours12 = seconds / 3600;
	seconds = seconds % 3600;
	minutes = seconds / 60;
	seconds = seconds % 60;
	// fixes hours12 format and checks for AM/PM
	if (hours12 > 12) {
		morning = false;
		hours12 -= 12;
	}
	else if (hours12 == 12) {
		morning = false;
	}
	else {
		morning = true;
	}
	return;
}

void clockPrinter(const int& seconds, const int& hours24, const int& hours12, const int& minutes, const bool& morning) {
	//function prints the formatted clocks, std::setfill and setw set each int var to fill with a leading 0 so each var is always 2 digits
	cout << "*************************     *************************" << endl
		<< "*     12-Hour Clock     *     *     24-Hour Clock     *" << endl
	    << "*     ";
	std::cout << std::setfill('0') << std::setw(2) << hours12;
	cout << ":";
	std::cout << std::setfill('0') << std::setw(2) << minutes;
	cout << ":";
	std::cout << std::setfill('0') << std::setw(2) << seconds;
	if (morning) {
		cout << " A M";
	}
	else {
		cout << " P M";
	}
	cout << "      *     *        ";
	std::cout << std::setfill('0') << std::setw(2) << hours24;
	cout << ":";
	std::cout << std::setfill('0') << std::setw(2) << minutes;
	cout << ":";
	std::cout << std::setfill('0') << std::setw(2) << seconds;
	cout << "       *" << endl
		<< "*************************     *************************" << endl;
	return;
}

void menuPrinter() {
	//prints menu options for display
	cout << "*************************" << endl
		<< "* 1 - Add One Hour      *" << endl
		<< "* 2 - Add One Minutue   *" << endl
		<< "* 3 - Add One Second    *" << endl
		<< "* 4 - Exit Program      *" << endl
		<< "*************************" << endl;
}

void consoleClear(int& currentTime) {
	//adds one second per main while loop iteration, std:cout outputs are ANSI escape codes that push old output off the screen and return the cursor to the top left
	currentTime += 1;
	std::cout << "\x1B[2J\x1B[H";
}

void adjustTime(int& currentTime, const char& command, bool& exit) {
	//handles user input fetched from the console buffer by _getch function from the conio.h library
	switch (command) {
	case '1':
		currentTime += 3600;
		break;
	case '2':
		currentTime += 60;
		break;
	case '3':
		currentTime += 1;
		break;
	case '4':
		exit = false;
		break;
	default:
		break;
	}
	return;
}

void inputStream(char& currentChar) {
	//_kbhit returns a bool, checking for any user input, then _getch adds its to an input buffer to be evaluated once per iteration of the main while loop
	if (_kbhit()) {
		currentChar = _getch();
	}
	else {
		currentChar = '0';
	}
	return;
}


//MAIN STARTS HERE
int main() {
	int totalTime, time24Hours, time12Hours, timeMinutes, timeSeconds;
	bool AM, keepRunning;
	char current = '0';
	keepRunning = true;
	totalTime = 0;


	while (keepRunning) {
		if (totalTime >= 86400) {
			totalTime -= 86400;
		}
		timeSeconds = totalTime;
		timeSplitter(timeSeconds, time24Hours, time12Hours, timeMinutes, AM);
		clockPrinter(timeSeconds, time24Hours, time12Hours, timeMinutes, AM);
		menuPrinter();
		sleep_for(1s);
		inputStream(current);
		adjustTime(totalTime, current, keepRunning);
		consoleClear(totalTime);
	}

	return 0;
}


