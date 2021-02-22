package com.company;

import com.company.travelBy.Train;

import java.util.ArrayList;
import java.util.HashMap;

public class Route {
    private ArrayList<Node> route = new ArrayList<> ();
    private AStar aStar = new AStar (this);
    private Node startNode;
    private Node endNode;

    public int getTotalWeight(){
        int x = 0;
        for(int i = 0 ; i< route.size (); i ++){
            if(route.size () != i+1)
                x += route.get ( i ).getWeightForSpecific ( route.get ( i+1 ) );
        }
        return x;
    }

    public Route () {
    }

    public Node addNode (Node node) {
        if (route.size () == 0)
            startNode = node;
        route.add ( node );
        endNode = node;
        return node;
    }

    public Route getRoute (Node s,Node n){
        return aStar.getPath ( s,n );
    }

    private HashMap<String, ArrayList<Node>> checkWhichTrain () {
        return null;
    }

    public int getNrOfStops () {
        return route.size ();
    }

    protected Route getRoute () {
        return this;
    }

    protected ArrayList<Node> getRouteArray () {
        return route;
    }

    public Node getStartNode () {
        return startNode;
    }

    public Node getEndNode () {
        return endNode;
    }

    @Override
    public String toString () {
        StringBuilder s = new StringBuilder ( "Route: " );
        for (Node n : route) {
            s.append ( n );
        }
        s.append ( " }" );
        return s.toString ();
    }
}
