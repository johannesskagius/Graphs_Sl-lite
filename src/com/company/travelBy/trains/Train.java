package com.company.travelBy.trains;

import com.company.Node;
import com.company.travelBy.Status;

import java.util.ArrayList;

public abstract class Train implements Status {
     public ArrayList<Node> route = new ArrayList<> ();
     public int nextDepartureTime;
     public boolean isOnTime;
     public int delayed;

    public Train (ArrayList<Node> route) {
        this.route = route;
    }

    public ArrayList<Node> getRoute () {
        return route;
    }

    public void setRoute (ArrayList<Node> route) {
        this.route = route;
    }

    public int getNextDepartureTime () {
        return nextDepartureTime;
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
