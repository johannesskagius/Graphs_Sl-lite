package com.company;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Route {
    private ArrayList<Node> route = new ArrayList<> ();
    private Node startNode;
    private Node endNode;

    public Route () {
    }

    protected Node addNode(Node node){
        if(route.size ()==0)
            startNode = node;
        route.add ( node );
        endNode = node;
        return node;
    }

    protected Route getRoute(){
        return this;
    }

    protected ArrayList<Node> getRouteArray(){
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
        for(Node n : route){
            s.append ( n );
        }
        s.append ( " }" );
        return s.toString ();
    }
}
