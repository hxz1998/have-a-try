/*
* (C) HuXiaozhong 2018
*/
#include <iostream>
#include "core\timer.h"

using namespace std;

void init_sys();

int main() {
    init_sys();
    Timer timer;
    bool run = true;
    while (run) {
        init_timer(timer);
        timer_output(timer);
    }
}

void init_sys() {
    cout << "\tTime Calculator\n [ GNU General Public License v3.0] On Windows 2018 \n";
    cout << " The GNU General Public License is a free, copyleft license for software and other kinds of works.\n\n";
    cout << " Enter Ctrl + C to exit.\n\n";
    cout << " -------------------------------------------------------------------------------------------------\n\n";
}