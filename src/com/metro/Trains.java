package com.metro;

//Består av en rutt, avgångstider, etc
public class Trains {
    private int ID;
    private Routes route;
    private Node currentPos;

    public Trains (int ID,Routes route,Node currentPos) {
        this.ID = ID;
        this.route = route;
        this.currentPos = currentPos;
    }
}
