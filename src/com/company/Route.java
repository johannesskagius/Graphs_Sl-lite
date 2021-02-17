package com.company;

import java.util.ArrayList;
import java.util.Stack;

public class Route {
    private ArrayList<Node> route = new ArrayList<> ();
    private Node startNode;
    private Node endNode;

    public Route () {
    }

    protected void addNode(Node node){
        if(route.size ()==0)
            startNode = node;
        route.add ( node );
        endNode = route.get ( route.size ()-1 );
    }

    @Override
    public String toString () {
        String s ="Route{";

        for(Node n : route){
            s += "route=" + route + ", startNode=" + startNode + ", endNode=" + endNode;
        }
        s+= '}';
        return s;
    }
}
