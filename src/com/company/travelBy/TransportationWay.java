package com.company.travelBy;

import com.company.Node;
import com.company.NodeList;

public abstract class TransportationWay {
    protected NodeList nodeList;
    public abstract int getDepartureTimes (Node from);
    public abstract boolean isOnTime();
    public abstract String identifier();
    public abstract String lateBy();
    public abstract Node Direction();

    public NodeList getNodeList () {
        return nodeList;
    }

    public void setNodeList (NodeList nodeList) {
        this.nodeList = nodeList;
    }
}
