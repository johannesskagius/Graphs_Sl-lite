package com.company;

import java.util.Objects;

public class Bow {
    private Node fNode;
    private Node lNode;
    private int weight;

    public Bow (Node fNode,Node lNode,int weight) {
        this.fNode = fNode;
        this.lNode = lNode;
        this.weight = weight;
    }

    public Node getfNode () {
        return fNode;
    }

    public void setfNode (Node fNode) {
        this.fNode = fNode;
    }

    public Node getlNode () {
        return lNode;
    }

    public Bow getBow(Node next){
        return this;
    }
    public void setlNode (Node lNode) {
        this.lNode = lNode;
    }

    public int getWeight () {
        return weight;
    }

    public void setWeight (int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (!(o instanceof Bow)) return false;
        Bow bow = (Bow) o;
        return weight == bow.weight && Objects.equals ( fNode,bow.fNode ) && Objects.equals ( lNode,bow.lNode );
    }

    @Override
    public int hashCode () {
        return Objects.hash ( fNode,lNode,weight );
    }
}
