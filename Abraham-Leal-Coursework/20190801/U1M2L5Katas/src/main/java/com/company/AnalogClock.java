package com.company;

import com.company.interfaces.Clock;

public class AnalogClock implements Clock {

    private int time;
    private int timerHour;
    private int timerMinute;

    public AnalogClock(){

    }

    public void displayTime(){
        System.out.println(time);
    }

    public void timer(int hour, int minute){
        System.out.println(this.timerHour +":" + this.timerMinute);
    }
}
