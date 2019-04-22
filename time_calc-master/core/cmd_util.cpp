/*
* (C) HuXiaozhong 2018
* cmd_util.h实现代码
*/
#include "cmd_util.h"
#include <iostream>

using namespace std;

void check_exit(char input) {
    if (input == 'q') {
        //检测退出
    }
}

int read_int() {
    int input;
    cin >> input;
    return input;
}

float read_float() {
    float input;
    cin >> input;
    return input;
}

short read_short() {
    short input;
    cin >> input;
    return input;
}
