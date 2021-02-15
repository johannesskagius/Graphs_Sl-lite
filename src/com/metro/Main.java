package com.metro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private final String[] LOCATIONS = {"Hjulsta","Akalla","Mörby","Ropsten",
            "Hässelby Strand","Åkeshov","Alvik","Västra skogen","Fridhemsplan","Östermalm",
            "TC","Kungsträdgården","Mälarhöjden","Liljeholmen","Slussen","Norsborg","Fruängen","Hagsätra","Farsta Strand","Skarpnäck"
    };
    private final int[] COORDINATES ={
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
    private Scanner scan = new Scanner(System.in);
    private Map<Character, Node> nodes = new HashMap<> ();
    private Map<Integer, Routes> routes = new HashMap<> ();


    public static void main (String[] args) {
        Main main = new Main ();
        main.addNods ();
        main.addBows ();
        main.addTrains ();
        main.run();
    }

    private void run () {
        showInstructions();
        String choice = "2";//scan.nextLine ();
        boolean runAgain = true;
            switch (choice) {
                case "1":
                    System.out.println ( "1" );
                    break;
                case "2":
                    findRouteShortest();
                    break;
                case "99":
                    System.out.println ( "quit" );
                    runAgain = false;
                    break;
                default:
            }
            if(runAgain)
                run ();
    }

    private void findRouteShortest () {
        A_Star a = new A_Star ();
        System.out.println (a.findShortestPath ( nodes.get ( 'a' ), nodes.get ( 'h' ) ));
    }

    private void showInstructions () {
        System.out.println ("What would you like to do?");
        System.out.println ("1: Show for a train?");
        System.out.println ("2: Find the shortest route to a station");
    }

    private void addTrains () {
        ArrayList<Node> route = new ArrayList<> ();
        char[] route4 = {'a','h','i','k','l'};
        Routes newRoute = getNodesForRoute ( route4 );
        Trains train1 = new Trains ( 1, newRoute, nodes.get ( 'a' ) );

        System.out.println ( newRoute.toString () );
        char[] route5 = {'b','h','i','k','l'};
         newRoute =getNodesForRoute ( route5 );
        System.out.println (newRoute.toString ());
        Trains train2 = new Trains ( 2, newRoute, nodes.get ( 'l' ) );
    }

    private Routes getNodesForRoute (char[] routes) {
        Node n;
        Routes r = new Routes ();
        for (char route : routes) {
            n = nodes.get ( route );
            r.addToRoute ( n );
        }
        return r;
    }

    private void addBows () {
        nodes.get ( 'a' ).addConnectedNode ( "ah",nodes.get ( 'h' ),5 );
        nodes.get ( 'b' ).addConnectedNode ( "bh",nodes.get ( 'h' ),3 );
        nodes.get ( 'c' ).addConnectedNode ( "cj",nodes.get ( 'j' ),4 );
        nodes.get ( 'd' ).addConnectedNode ( "dj",nodes.get ( 'j' ),5 );
        nodes.get ( 'e' ).addConnectedNode ( "ef",nodes.get ( 'f' ),3 );
        nodes.get ( 'h' ).addConnectedNode ( "hi",nodes.get ( 'i' ),1 );
        nodes.get ( 'f' ).addConnectedNode ( "fg",nodes.get ( 'g' ),1 );
        nodes.get ( 'g' ).addConnectedNode ( "gi",nodes.get ( 'i' ),1 );

        nodes.get ( 'i' ).addConnectedNode ( "ij",nodes.get ( 'j' ),4 );
        nodes.get ( 'i' ).addConnectedNode ( "ik",nodes.get ( 'k' ),5 );
        nodes.get ( 'j' ).addConnectedNode ( "jk",nodes.get ( 'k' ),1 );

        nodes.get ( 'k' ).addConnectedNode ( "kl",nodes.get ( 'l' ),1 );
        nodes.get ( 'k' ).addConnectedNode ( "ko",nodes.get ( 'o' ),1 );

        nodes.get ( 'o' ).addConnectedNode ( "on",nodes.get ( 'n' ),5 );
        nodes.get ( 'o' ).addConnectedNode ( "or",nodes.get ( 'r' ),3 );
        nodes.get ( 'o' ).addConnectedNode ( "os",nodes.get ( 's' ),2 );
        nodes.get ( 'o' ).addConnectedNode ( "ot",nodes.get ( 't' ),3 );

        nodes.get ( 'n' ).addConnectedNode ( "nm",nodes.get ( 'm' ),1 );
        nodes.get ( 'n' ).addConnectedNode ( "nq",nodes.get ( 'q' ),5 );

        nodes.get ( 'm' ).addConnectedNode ( "mp",nodes.get ( 'p' ),5 );
    }

    private void addNods () {
        char x = 'a';
        for (int i = 0; i < 20; i++) {
            nodes.put ( x,new Node ( LOCATIONS[i] ) );
            nodes.get ( x ).setID ( x );
            x++;
        }
        x='a';
        for(int i = 0 ;i<20; i ++){
            nodes.get ( x ).setxValue ( COORDINATES[i] );
            nodes.get ( x ).setyValue ( COORDINATES[i+1] );
            System.out.println (nodes.get ( x ));
            x++;
        }
    }
}
