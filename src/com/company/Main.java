package com.company;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Main {
    private final String[] LOCATIONS = {"Hjulsta","Akalla","Mörby","Ropsten",
            "Hässelby Strand","Åkeshov","Alvik","Västra skogen","Fridhemsplan","Östermalm",
            "TC","Kungsträdgården","Mälarhöjden","Liljeholmen","Slussen","Norsborg","Fruängen","Hagsätra","Farsta Strand","Skarpnäck"
    };
    private int[] COORDINATES = {
            4,13,       //A
            5,13,       //B
            14,13,      //C
            16,13,      //D
            2,9,        //E
            6,9,        //F
            8,9,        //g
            9,10,       //H
            9,9,         //i
            14,9,       //J
            14,8,       //K
            16,8,       //L
            7,6,        //m
            9,6,        //n
            14,6,       //o
            2,2,        //p
            4,2,        //q
            11,2,       //r
            14,2,       //s
            17,2        //t
    };
    private Map<Character, Node> nodes = new HashMap<> ();


    public static void main (String[] args) {
        // write your code here
    }

    @BeforeAll
    public void addLocations () {
        char x = 'a';
        Position p = null;
        for (int i = 0; i < 20; i++) {
            p = getPosition ( i );
            nodes.put ( x,new Node ( p,LOCATIONS[i] ) );
            x++;
        }
        addConnections ();
    }

    public void addConnections(){
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

        addBothWays ( h,a, 5 );
        addBothWays ( h,b, 3 );
        addBothWays ( h,i, 1 );
        addBothWays ( e,f, 3 );
        addBothWays ( g,f, 1 );
        addBothWays ( g,i, 1 );
        addBothWays ( j,i, 4 );
        addBothWays ( k,i, 1 );

        addBothWays ( j,c, 4 );
        addBothWays ( j,d, 5 );
        addBothWays ( j,k, 1 );

        addBothWays ( k,l, 1 );
        addBothWays ( k,o, 1 );

        addBothWays ( o,n, 5 );
        addBothWays ( o,r, 3 );
        addBothWays ( o,t, 3 );
        addBothWays ( o,s, 2 );

        addBothWays ( n,m, 1 );
        addBothWays ( n,q, 5 );
        addBothWays ( m,p, 5 );
    }

    private Node getNode(Character x){
        return nodes.get ( x );
    }
    private void addBothWays(Node x, Node y, int weight){
        x.addBow ( y, weight );
        y.addBow ( x, weight );
    }

    private Position getPosition (int i) {
        Position p = new Position ( COORDINATES[i],COORDINATES[i + 1] );
        return p;
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
}
