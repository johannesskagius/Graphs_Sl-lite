package com.company.travelBy;

import com.company.Node;
import com.company.NodeList;
import com.company.Route;
import com.company.TravelWays_Support;

public abstract class TransportationWay {
    private Route route;
    private TravelWays_Support travelWays_support;
    private String identifier;

    public TransportationWay () {
    }

    public TransportationWay (String identifier,TravelWays_Support travelWays_support,Route route) {
        this.travelWays_support = travelWays_support;
        this.route = route;
        this.identifier = identifier;
    }

    protected NodeList nodeList;


    public abstract int getDepartureTimes (Node from);
    public abstract boolean isOnTime();
    public abstract String identifier();
    public abstract String lateBy();


    public TravelWays_Support getTravelWays_support () {
        return travelWays_support;
    }

    public NodeList getNodeList () {
        return nodeList;
    }

    public void setNodeList (NodeList nodeList) {
        this.nodeList = nodeList;
    }

    public Route getRoute () {
        return route;
    }

    public abstract boolean isPassingNode (Node node,Train n, int i);

}
