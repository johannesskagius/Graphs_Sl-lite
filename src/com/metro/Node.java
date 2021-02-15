package com.metro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Node {
    private String name;
    private char ID;
    private ArrayList<Bow> connectedNodes = new ArrayList<> ();
    private int xValue;
    private int yValue;
    private boolean isVisited = false;

    public Node (String name) {
        this.name = name;
    }

    public boolean isVisited () {
        return isVisited;
    }

    public void setVisited (boolean visited) {
        isVisited = visited;
    }

    public Bow getBow(int i){
        return connectedNodes.get ( i );
    }

    public int getxValue () {
        return xValue;
    }

    public void setxValue (int xValue) {
        this.xValue = xValue;
    }

    public int getyValue () {
        return yValue;
    }

    public void setyValue (int yValue) {
        this.yValue = yValue;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void addConnectedNode (String key,Node nodeTo,int i) {
        connectedNodes.add (new Bow ( this,nodeTo,i,key ) );
    }

    public ArrayList<Node> getConnectedNodes () {
        ArrayList<Node> n = new ArrayList<> ();
        for(Bow x : connectedNodes ){
            n.add ( x.getNodeTo () );
        }
        return n;
    }

    public char getID () {
        return ID;
    }

    public void setID (char ID) {
        this.ID = ID;
    }

    public int timeToChildNode (int n) {
        return connectedNodes.get ( n ).getTime ();
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return ID == node.ID && name.equals ( node.name );
    }

    @Override
    public int hashCode () {
        int hashCode = 0;
        String x = name + ID;
        for (Character c : x.toCharArray ()) {
            hashCode = 13 * c;
        }
        return hashCode;
    }

    @Override
    public String toString () {
        return "Node{" + "ID=" + ID + ", name=" + name + ", location [" + xValue + ", " + yValue + "]}";
    }
}
