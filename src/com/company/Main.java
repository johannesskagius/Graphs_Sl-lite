package com.company;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Main {
    private final String[] LOCATIONS = {"Hjulsta","Akalla","Mörby","Ropsten",
            "Hässelby Strand","Åkeshov","Alvik","Västra skogen","Fridhemsplan","Östermalm",
            "TC","Kungsträdgården","Mälarhöjden","Liljeholmen","Slussen","Norsborg","Fruängen","Hagsätra","Farsta Strand","Skarpnäck"
    };
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
    private Map<Character, Node> nodes = new HashMap<> ();


    public static void main (String[] args) {
        // write your code here
    }

    @BeforeAll
    public void addLocations () {
        char x = 'a';
        for (int i = 0; i < 20; i++) {
            nodes.put ( x,new Node ( COORDINATES[i],LOCATIONS[i] ) );
            x++;
        }
        addConnections ();
    }

    public void addConnections () {
        Node a = getNode ( 'a' );
        Node b = getNode ( 'b' );
        Node c = getNode ( 'c' );
        Node d = getNode ( 'd' );
        Node e = getNode ( 'e' );
        Node f = getNode ( 'e' );
        Node h = getNode ( 'h' );
        Node g = getNode ( 'g' );
        Node i = getNode ( 'i' );
        Node j = getNode ( 'j' );
        Node k = getNode ( 'k' );
        Node l = getNode ( 'l' );
        Node m = getNode ( 'm' );
        Node n = getNode ( 'n' );
        Node o = getNode ( 'o' );
        Node p = getNode ( 'p' );
        Node q = getNode ( 'q' );
        Node r = getNode ( 'r' );
        Node s = getNode ( 's' );
        Node t = getNode ( 't' );

        addBothWays ( h,a,5 );
        addBothWays ( h,b,3 );
        addBothWays ( h,i,1 );
        addBothWays ( e,f,3 );
        addBothWays ( g,f,1 );
        addBothWays ( g,i,1 );
        addBothWays ( j,i,4 );
        addBothWays ( k,i,1 );

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
    }

    private Node getNode (Character x) {
        return nodes.get ( x );
    }

    private void addBothWays (Node x,Node y,int weight) {
        x.addBow ( y,weight );
        y.addBow ( x,weight );
    }


    @Test
    public void testLocations () {
        assertTrue ( nodes.get ( 'i' ).getLocation ().equals ( "Fridhemsplan" ) );
        assertTrue ( nodes.get ( 's' ).getLocation ().equals ( "Farsta Strand" ) );
        assertTrue ( nodes.get ( 'g' ).getLocation ().equals ( "Alvik" ) );
        assertTrue ( nodes.get ( 'j' ).getLocation ().equals ( "Östermalm" ) );
        assertTrue ( nodes.get ( 'k' ).getLocation ().equals ( "TC" ) );
        assertTrue ( nodes.get ( 'q' ).getLocation ().equals ( "Fruängen" ) );
    }

    @Test
    public void testConnectedNodes () {
        nodes.get ( 'h' ).getConnectedNodes ().toString ();
    }

    @Test
    public void gotChilds () {
        assertTrue ( nodes.get ( 'h' ).gotChilds () );
    }

    @Test
    public void testHeuristicMeasurement () {
        assertTrue ( (int) nodes.get ( 'a' ).calcHeuristicLength ( nodes.get ( 'f' ) ) == 4 );
        assertTrue ( (int) nodes.get ( 'd' ).calcHeuristicLength ( nodes.get ( 'e' ) ) == 14 );
        assertTrue ( (int) nodes.get ( 'p' ).calcHeuristicLength ( nodes.get ( 'f' ) ) == 8 );
        assertTrue ( (int) nodes.get ( 'a' ).calcHeuristicLength ( nodes.get ( 't' ) ) == 17 );
        assertTrue ( (int) nodes.get ( 'd' ).calcHeuristicLength ( nodes.get ( 'p' ) ) == 17 );
        assertTrue ( (int) nodes.get ( 'e' ).calcHeuristicLength ( nodes.get ( 'l' ) ) == 14 );
        assertTrue ( (int) nodes.get ( 'g' ).calcHeuristicLength ( nodes.get ( 'h' ) ) == 1 );
        assertTrue ( (int) nodes.get ( 'f' ).calcHeuristicLength ( nodes.get ( 'g' ) ) == 2 );
    }

    @Test
    public void testASTAR () {
        AStar a = new AStar ();
        Route r = a.getPath ( nodes.get ( 'a' ),nodes.get ( 'j' ) );
        assertEquals ( nodes.get ( 'j' ),r.getEndNode () );
        Route r1 = a.getPath ( nodes.get ( 'c' ),nodes.get ( 'r' ) );
        assertEquals ( nodes.get ( 'r' ),r1.getEndNode () );
        Route r2 = a.getPath ( nodes.get ( 'p' ),nodes.get ( 'a' ) );
        assertEquals ( nodes.get ( 'a' ),r2.getEndNode () );
        Route r3 = a.getPath ( nodes.get ( 'e' ),nodes.get ( 't' ) );
        assertEquals ( nodes.get ( 't' ),r3.getEndNode () );
    }
}
