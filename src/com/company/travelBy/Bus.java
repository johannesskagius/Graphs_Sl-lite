package com.company.travelBy;

import com.company.Node;
import com.company.Route;
import com.company.TravelWays_Support;

public class Bus extends TransportationWay{
    private String identifier;
    public Bus (String identifier,TravelWays_Support travelWays_support,Route route) {
        super ( identifier,travelWays_support, route);
        this.identifier = identifier;
    }

    @Override
    public int getDepartureTimes (Node from) {
        return 0;
    }

    @Override
    public boolean isOnTime () {
        return false;
    }

    @Override
    public String identifier () {
        return identifier;
    }

    @Override
    public String lateBy () {
        return null;
    }

    @Override
    public boolean isPassingNode (Node node,Train n, int i) {
        return false;
    }
}
