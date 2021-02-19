package com.company.travelBy;

import com.company.Node;

import java.util.ArrayList;

public interface Status {
    void addRoute();
    int getDepartureTimes (Node from, Node to);
    ArrayList<Node> route();
    boolean isOnTime();
    String identifier();
    String lateBy();
    Node Direction();
}
