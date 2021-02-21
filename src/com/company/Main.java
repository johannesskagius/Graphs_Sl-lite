package com.company;

import com.company.travelBy.Train;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Main {
    public static final NodeList nodeList = new NodeList ();
    private Map<Character, Node> nodes;
    private Map<String, Train> travelRoute;

    public static void main (String[] args) {
        // write your code here
    }


    @BeforeEach
    public void getNodesAndTravelWays () {
        nodes = nodeList.getNodes ();
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
        assertEquals ( (int) nodes.get ( 'a' ).calcHeuristicLength ( nodes.get ( 'f' ) ),4 );
        assertEquals ( (int) nodes.get ( 'd' ).calcHeuristicLength ( nodes.get ( 'e' ) ),14 );
        assertEquals ( (int) nodes.get ( 'p' ).calcHeuristicLength ( nodes.get ( 'f' ) ),8 );
        assertEquals ( (int) nodes.get ( 'a' ).calcHeuristicLength ( nodes.get ( 't' ) ),17 );
        assertEquals ( (int) nodes.get ( 'd' ).calcHeuristicLength ( nodes.get ( 'p' ) ),17 );
        assertEquals ( (int) nodes.get ( 'e' ).calcHeuristicLength ( nodes.get ( 'l' ) ),14 );
        assertEquals ( (int) nodes.get ( 'g' ).calcHeuristicLength ( nodes.get ( 'h' ) ),1 );
        assertEquals ( (int) nodes.get ( 'f' ).calcHeuristicLength ( nodes.get ( 'g' ) ),2 );
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

    @Test
    public void testBlueTrain () {
        assertEquals ( travelRoute.get ( "Blue line 1").getTrainRoute ().getNrOfStops (), 9 );
    }

    @Test
    public void testAstar_With_Trains () {
        Travel_Route t = new Travel_Route ();

        t.getTravel_Route ( nodes.get ( 'a' ), nodes.get ( 'h' ) );


    }
}
