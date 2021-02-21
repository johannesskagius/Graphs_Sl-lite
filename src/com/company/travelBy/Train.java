package com.company.travelBy;

import com.company.Node;
import com.company.Route;

import java.util.Objects;


public class Train {
    private Route trainRoute;
    private String identifier;
    private int delayed;


    public Train (String identifier, Route r) {
        this.identifier = identifier;
        this.trainRoute = r;
    }

    public Route getTrainRoute () {
        return trainRoute;
    }

    public boolean isPassingNodes(Node start, Node end){
        //trainRoute.
        return false;
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

    public String identifier () {
        return identifier;
    }

    public String lateBy () {
        return identifier +" is late by "+delayed+"min";
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
