#pragma once
#include <iostream>
using namespace std;

class Invaders
{
public:
	string GetShape() const;
	void Destroy();
private:
	string shape = " *|* ";
};

string Invaders::GetShape() const {
	return shape;
}

void Invaders::Destroy() {
	shape = "     ";
	return;
}
