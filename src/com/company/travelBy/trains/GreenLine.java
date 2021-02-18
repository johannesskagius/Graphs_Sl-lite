package com.company.travelBy.trains;

import com.company.Node;

import java.util.ArrayList;

public class GreenLine extends Train{
    private String identifier = "Green line";

    public GreenLine (ArrayList<Node> route) {
        super ( route );
    }

    @Override
    public int getDepartureTimes (Node n) {
        return 0;
    }

    @Override
    public ArrayList<Node> route () {
        return null;
    }

    @Override
    public boolean isOnTime () {
        return false;
    }

    @Override
    public String identifier () {
        return identifier;
    }
}
