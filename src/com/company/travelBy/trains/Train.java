package com.company.travelBy.trains;

import com.company.Node;
import com.company.travelBy.Status;
import com.company.travelBy.TransportationWay;

import java.util.ArrayList;

public abstract class Train extends TransportationWay {
    public int nextDepartureTime;
    public boolean isOnTime;
    public int delayed;

    public Train () {
    }


    public void setNextDepartureTime (int nextDepartureTime) {
        this.nextDepartureTime = nextDepartureTime;
    }

    @Override
    public boolean isOnTime () {
        return isOnTime;
    }

    public void setOnTime (boolean onTime) {
        isOnTime = onTime;
    }
}
