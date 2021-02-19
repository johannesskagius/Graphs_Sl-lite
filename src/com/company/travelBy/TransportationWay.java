package com.company.travelBy;

import com.company.Node;

import java.util.ArrayList;

public abstract class TransportationWay {
    public abstract void addRoute();
    public abstract int getDepartureTimes (Node from,Node to);
    public abstract ArrayList<Node> route();
    public abstract boolean isOnTime();
    public abstract String identifier();
    public abstract String lateBy();
    public abstract Node Direction();
}
