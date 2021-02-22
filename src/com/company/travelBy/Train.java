package com.company.travelBy;

import com.company.Node;
import com.company.Route;
import com.company.TravelWays_Support;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;


public class Train extends TransportationWay{
    private Route trainRoute;
    private String identifier;
    private int delayed;

    public Train (String identifier,TravelWays_Support travelWays_support,Route route) {
        super ( identifier,travelWays_support, route);
        this.identifier = identifier;
        trainRoute = route;
    }


    public Route getTrainRoute () {
        return trainRoute;
    }

    public void setTrainRoute (Route trainRoute) {
        this.trainRoute = trainRoute;
    }

    public String getIdentifier () {
        return identifier;
    }

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

    public String lateBy () {
        return identifier +" is late by "+delayed+"min";
    }

    @Override
    public boolean isPassingNode (Node node,Train n, int i) {
        Map<Node, ArrayList<Train>> x = super.getTravelWays_support ().getPassingTrains ( node );
        return x.get ( node ).get ( i ).equals ( n );
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (!(o instanceof Train)) return false;
        Train train = (Train) o;
        return Objects.equals ( trainRoute,train.trainRoute ) && Objects.equals ( identifier,train.identifier );
    }

    @Override
    public int hashCode () {
        return Objects.hash ( trainRoute,identifier );
    }

    @Override
    public String toString () {
        return  identifier;
    }
}
