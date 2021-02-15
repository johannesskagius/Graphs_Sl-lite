package com.metro;

public class Bow {
    private Node nodeFrom;
    private Node nodeTo;
    private int time;
    private String direction;

    public Bow (Node nodeFrom,Node nodeTo,int time,String direction) {
        this.nodeFrom = nodeFrom;
        this.nodeTo = nodeTo;
        this.time = time;
        this.direction = direction;
    }

    public int getTime () {
        return time;
    }

    public Node getNodeTo () {
        return nodeTo;
    }
}
