package com.company;

import java.util.HashMap;
import java.util.Map;

public class NodeList {
    public Map<Character, Node> nodes = new HashMap<> ();

    private final String[] LOCATIONS = {"Hjulsta","Akalla","Mörby","Ropsten",
            "Hässelby Strand","Åkeshov","Alvik","Västra skogen","Fridhemsplan","Östermalm",
            "TC","Kungsträdgården","Mälarhöjden","Liljeholmen","Slussen","Norsborg","Fruängen","Hagsätra","Farsta Strand","Skarpnäck"
    };
    Node a;
    Node b;
    Node c;
    Node d;
    Node e;
    Node f;
    Node g;
    Node h;
    Node i;
    Node j;
    Node k;
    Node l;
    Node m;
    Node n;
    Node o;
    Node p;
    Node q;
    Node r;
    Node s;
    Node t;
    private Position[] COORDINATES = {
            new Position ( 4,13 ),       //A
            new Position ( 5,13 ),       //B
            new Position ( 14,13 ),      //C
            new Position ( 16,13 ),      //D
            new Position ( 2,9 ),        //E
            new Position ( 6,9 ),        //F
            new Position ( 8,9 ),        //g
            new Position ( 9,10 ),       //H
            new Position ( 9,9 ),         //i
            new Position ( 14,9 ),       //J
            new Position ( 14,8 ),       //K
            new Position ( 16,8 ),       //L
            new Position ( 7,6 ),        //m
            new Position ( 9,6 ),        //n
            new Position ( 14,6 ),       //o
            new Position ( 2,2 ),        //p
            new Position ( 4,2 ),        //q
            new Position ( 11,2 ),       //r
            new Position ( 14,2 ),       //s
            new Position ( 17,2 )        //t
    };

    public NodeList () {
        addLocations ();
    }

    public void addLocations () {
        char x = 'a';
        for (int i = 0; i < 20; i++) {
            nodes.put ( x,new Node ( COORDINATES[i],LOCATIONS[i] ) );
            x++;
        }
        addSubway ();
    }

    public void addSubway () {
        a = getNode ( 'a' );
        b = getNode ( 'b' );
        c = getNode ( 'c' );
        d = getNode ( 'd' );
        e = getNode ( 'e' );
        f = getNode ( 'f' );
        h = getNode ( 'h' );
        g = getNode ( 'g' );
        i = getNode ( 'i' );
        j = getNode ( 'j' );
        k = getNode ( 'k' );
        l = getNode ( 'l' );
        m = getNode ( 'm' );
        n = getNode ( 'n' );
        o = getNode ( 'o' );
        p = getNode ( 'p' );
        q = getNode ( 'q' );
        r = getNode ( 'r' );
        s = getNode ( 's' );
        t = getNode ( 't' );

        addBothWays ( a,h,5 );
        addBothWays ( b,h,3 );
        addBothWays ( h,i,1 );
        addBothWays ( e,f,3 );
        addBothWays ( f,g,1 );
        addBothWays ( g,i,1 );
        addBothWays ( i,j,4 );
        addBothWays ( i,k,1 );

        addBothWays ( j,c,4 );
        addBothWays ( j,d,5 );
        addBothWays ( j,k,1 );

        addBothWays ( k,l,1 );
        addBothWays ( k,o,1 );

        addBothWays ( o,n,5 );
        addBothWays ( o,r,3 );
        addBothWays ( o,t,3 );
        addBothWays ( o,s,2 );

        addBothWays ( n,m,1 );
        addBothWays ( n,q,5 );
        addBothWays ( m,p,5 );

        addStationInfo();

    }

    private void addStationInfo () {

    }


    private Node getNode (Character x) {
        return nodes.get ( x );
    }

    private void addBothWays (Node x,Node y,int weight) {
        x.addBow ( y,weight );
        y.addBow ( x,weight );
    }

    public Node getA () {
        return a;
    }

    public void setA (Node a) {
        this.a = a;
    }

    public Node getB () {
        return b;
    }

    public void setB (Node b) {
        this.b = b;
    }

    public Node getC () {
        return c;
    }

    public void setC (Node c) {
        this.c = c;
    }

    public Node getD () {
        return d;
    }

    public void setD (Node d) {
        this.d = d;
    }

    public Node getE () {
        return e;
    }

    public void setE (Node e) {
        this.e = e;
    }

    public Node getF () {
        return f;
    }

    public void setF (Node f) {
        this.f = f;
    }

    public Node getG () {
        return g;
    }

    public void setG (Node g) {
        this.g = g;
    }

    public Node getH () {
        return h;
    }

    public void setH (Node h) {
        this.h = h;
    }

    public Node getI () {
        return i;
    }

    public void setI (Node i) {
        this.i = i;
    }

    public Node getJ () {
        return j;
    }

    public void setJ (Node j) {
        this.j = j;
    }

    public Node getK () {
        return k;
    }

    public void setK (Node k) {
        this.k = k;
    }

    public Node getL () {
        return l;
    }

    public void setL (Node l) {
        this.l = l;
    }

    public Node getM () {
        return m;
    }

    public void setM (Node m) {
        this.m = m;
    }

    public Node getN () {
        return n;
    }

    public void setN (Node n) {
        this.n = n;
    }

    public Node getO () {
        return o;
    }

    public void setO (Node o) {
        this.o = o;
    }

    public Node getP () {
        return p;
    }

    public void setP (Node p) {
        this.p = p;
    }

    public Node getQ () {
        return q;
    }

    public void setQ (Node q) {
        this.q = q;
    }

    public Node getR () {
        return r;
    }

    public void setR (Node r) {
        this.r = r;
    }

    public Node getS () {
        return s;
    }

    public void setS (Node s) {
        this.s = s;
    }

    public Node getT () {
        return t;
    }

    public void setT (Node t) {
        this.t = t;
    }

    public Map<Character, Node> getNodes () {
        return nodes;
    }
}
