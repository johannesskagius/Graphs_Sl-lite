package com.company;

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

    public void setlNode (Node lNode) {
        this.lNode = lNode;
    }

    public int getWeight () {
        return weight;
    }

    public void setWeight (int weight) {
        this.weight = weight;
    }
}
