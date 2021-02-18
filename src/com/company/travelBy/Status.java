package com.company.travelBy;

import com.company.Node;

import java.util.ArrayList;

public interface Status {
    int getDepartureTimes (Node n);
    ArrayList<Node> route();
    boolean isOnTime();
    String identifier();
}
