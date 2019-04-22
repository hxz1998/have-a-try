/*
* (C) HuXiaozhong 2018
* timer.h 实现文件
*/

#include <iostream>
#include "timer.h"
#include "cmd_util.h"
#include "file_util.h"

using namespace std;

void init_timer(Timer &timer) {
    cout << "输入晶振频率（MHZ）\n>>> ";
    timer.fp = read_float();
    int limit_time = (int)(65536 * 12 / timer.fp / 1000);
    cout << "根据晶振频率计算，可取时间范围：0~" << limit_time << "(MS)\n";
    cout << "输入计时时间(MS) \n>>> ";
    timer.need_time = (short)(read_int());
}

void timer_output(Timer &timer) {
    timer.need_time *= 1000;
    timer.machine_time = (float)(1.0 / timer.fp * 12);
    timer.need_time /= (short)(timer.machine_time);
    timer.time = 65536 - timer.need_time;
    int THX = timer.time >> 8;
    int TLX = timer.time & 0xFF;
    cout << "+------+-------+\n";
    cout << "|THX   |TLX    |\n";
    cout << "+------+-------+\n";
    cout << "|" << hex << THX << "\t|" << hex << TLX << "\t|\n";
    cout << "+------+-------+\n";
    string file_name("code.asm");
    write_code(file_name, THX, TLX);
    cout << "程序已在当前目录下生成。\n\n";
}