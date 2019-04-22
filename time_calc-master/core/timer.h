/*
* (C) HuXiaozhong 2018
*
* 定时器数据结构
* time_mode：定时器模式
* need_time：所需计时时间，单位（MS）
* machine_time：微机机器周期（uS）
* fp：晶振频率（MHZ）
* time：定时器高位和低位组成的四字节数据
*/

#ifndef TIME_CALC_TIME_H
#define TIME_CALC_TIME_H

#endif //TIME_CALC_TIME_H

typedef struct {
    short time_mode;
    short need_time;
    float fp;
    float machine_time;
    int time;
} Timer;

/*
* 初始化计数器/定时器各项参数
*/
void init_timer(Timer &timer);

/*
* 输出计数器/定时器计算结果
*/
void timer_output(Timer &timer);
