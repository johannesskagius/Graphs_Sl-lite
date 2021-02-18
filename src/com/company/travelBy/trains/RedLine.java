package com.company.travelBy.trains;

import com.company.Node;

import java.util.ArrayList;

public class RedLine extends Train{
    private String identifier = "Red line";

    public RedLine (ArrayList<Node> route) {
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
