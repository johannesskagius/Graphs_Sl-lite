package com.company;

import com.company.travelBy.trains.Train;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Node {
    private ArrayList<Bow> connectedNodes = new ArrayList<> ();
    private Position position;
    private String location;
    private boolean isVisited = false;

    public Node (Position position,String location) {
        this.position = position;
        this.location = location;
    }

    public void addBow (Node nodeTo,int weight) {
        Bow b = new Bow ( this,nodeTo,weight );
        connectedNodes.add ( b );
    }

    public boolean gotChilds () {
        return connectedNodes.size () != 0;
    }

    public ArrayList<Node> getConnectedNodes () {
        ArrayList<Node> connected = new ArrayList<> ();
        for (Bow x : connectedNodes) {
            connected.add ( x.getlNode () );
        }
        return connected;
    }

    public int getCost (int n) {
        return connectedNodes.get ( n ).getWeight ();
    }

    public double calcHeuristicLength (Node n) {
        return position.countHeuristicDistance ( this.position,n.position );
    }

    public Position getPosition () {
        return position;
    }

    public String getLocation () {
        return location;
    }

    public boolean isVisited () {
        return isVisited;
    }

    public void setVisited (boolean visited) {
        isVisited = visited;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return location.equals ( node.location );
    }

    @Override
    public int hashCode () {
        int hashCode = 0;
        final int PRIME = 13;
        for (Character x : location.toCharArray ()) {
            hashCode += PRIME * x;
        }
        return hashCode;
    }

    @Override
    public String toString () {
        return position + ", " + location;
    }
}
