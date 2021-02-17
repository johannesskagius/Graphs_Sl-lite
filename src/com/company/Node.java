package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Node {
    private ArrayList<Bow> connectedNodes = new ArrayList<> ();
    private Position position;
    private String location;

    public Node (Position position,String location) {
        this.position = position;
        this.location = location;
    }

    public void addBow (Node nodeTo, int weight) {
        Bow b = new Bow ( this, nodeTo, weight );
        connectedNodes.add ( b );
    }

    public Map<Node, Integer> getConnectedNodes () {
        Map<Node, Integer> connected = new HashMap<> ();
        for(Bow x : connectedNodes){
            connected.put ( x.getlNode (),x.getWeight () );
        }
        return connected;
    }

    public double calcHeuristicLength(){

        return 0.0;
    }

    public Position getPosition () {
        return position;
    }

    public String getLocation () {
        return location;
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
}
