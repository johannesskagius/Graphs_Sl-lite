package com.company;

import com.company.travelBy.Train;
import com.company.travelBy.TransportationWay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TravelWays_Support {
    private final Map<String, Train> travelWay = new HashMap<> ();
    private final Map<Node, ArrayList<Train>> nodesWithTrainConnectin = new HashMap<> ();
    private final Map<Node, HashMap<Train, Node>> nodesWithTrainConnectin2 = new HashMap<> ();
    private final Map<Train, ArrayList<Node>> trains = new HashMap<> ();
    private NodeList n = Main.nodeList;
    private Train blue1;
    private Train blue1back;
    private Train blue2;
    private Train blue2Back;
    private Train green1;
    private Train green1Back;
    private Train green2;
    private Train green2Back;
    private Train green3;
    private Train green3Back;
    private Train red1;
    private Train red1Back;
    private Train red2;
    private Train red2Back;

    public TravelWays_Support () {
        blueLine1Route ();
        blueLine1RouteBack ();
        blueLine2Route ();
        blueLine2RouteBack ();
        greenLine1Route ();
        greenLine1RouteBack ();
        greenLine2Route ();
        greenLine2RouteBack ();
        greenLine3Route ();
        greenLine3RouteBack ();
        red1Line1Route ();
        red1Line1RouteBack ();
        redLine2Route ();
        redLine2RouteBack ();
        addStationsByTrain ( blue1 );
        addStationsByTrain ( blue2 );
        addStationsByTrain ( green1 );
        addStationsByTrain ( green2 );
        addStationsByTrain ( green3 );
        addStationsByTrain ( red1 );
        addStationsByTrain ( red2 );
        addStationsByTrain ( blue1back );
        addStationsByTrain ( blue2Back );
        addStationsByTrain ( green1Back );
        addStationsByTrain ( green2Back );
        addStationsByTrain ( green3Back );
        addStationsByTrain ( red1Back );
        addStationsByTrain ( red2Back );
    }


    private void addStationsByTrain (Train t) {
        ArrayList<Node> route = t.getTrainRoute ().getRouteArray ();
        for (Node n : route) {
            nodesWithTrainConnectin.computeIfAbsent ( n,v -> new ArrayList<> () ).add ( t );
        }
    }

    private void addTrainbyStation (Train t) {
        trains.put ( t,t.getTrainRoute ().getRouteArray () );
    }

    public Map<Train, ArrayList<Node>> getTrains () {
        return trains;
    }

    public Map<Node, ArrayList<Train>> getPassingTrains (Node n) {
        Map<Node, ArrayList<Train>> passingTrains = new HashMap<> ();
        if (nodesWithTrainConnectin.containsKey ( n )) {
            for (Train x : nodesWithTrainConnectin.get ( n )) {
                passingTrains.computeIfAbsent ( n,v -> new ArrayList<> () ).add ( x );
            }
        }
        return passingTrains;
    }

    public boolean isTrainPassing(Node n, Train t){
        return nodesWithTrainConnectin.get ( n ).contains ( t );
    }


    public Map<Node, ArrayList<Train>> getNodesWithTrainConnectin () {
        return nodesWithTrainConnectin;
    }

    public ArrayList<Train> getPossibleTrains (Node start,Node end) {
        return null;
    }

    private void redLine2Route () {
        Route red2_route = new Route ();
        red2_route.addNode ( n.getD () );
        red2_route.addNode ( n.getJ () );
        red2_route.addNode ( n.getK () );
        red2_route.addNode ( n.getO () );
        red2_route.addNode ( n.getN () );
        red2_route.addNode ( n.getQ () );
        red2 = new Train ( "Red line 2",this,red2_route );
        travelWay.put ( red2.getIdentifier (),red2 );
    }

    private void redLine2RouteBack () {
        Route red2_route = new Route ();
        red2_route.addNode ( n.getQ () );
        red2_route.addNode ( n.getN () );
        red2_route.addNode ( n.getO () );
        red2_route.addNode ( n.getK () );
        red2_route.addNode ( n.getJ () );
        red2_route.addNode ( n.getD () );
        red2Back = new Train ( "Red line 2 back",this,red2_route );
        travelWay.put ( red2Back.getIdentifier (),red2Back );
    }


    private void red1Line1Route () {
        Route red1_route = new Route ();
        red1_route.addNode ( n.getC () );
        red1_route.addNode ( n.getJ () );
        red1_route.addNode ( n.getK () );
        red1_route.addNode ( n.getO () );
        red1_route.addNode ( n.getN () );
        red1_route.addNode ( n.getM () );
        red1_route.addNode ( n.getP () );
        red1 = new Train ( "Red line 1",this,red1_route );
        travelWay.put ( red1.getIdentifier (),red1 );
    }
    private void red1Line1RouteBack () {
        Route red1_route = new Route ();
        red1_route.addNode ( n.getP () );
        red1_route.addNode ( n.getM () );
        red1_route.addNode ( n.getN () );
        red1_route.addNode ( n.getO () );
        red1_route.addNode ( n.getK () );
        red1_route.addNode ( n.getJ () );
        red1_route.addNode ( n.getC () );
        red1Back = new Train ( "Red line 1 back",this,red1_route );
        travelWay.put ( red1Back.getIdentifier (),red1Back );
    }

    private void greenLine3Route () {
        Route green3_route = new Route ();
        green3_route.addNode ( n.getG () );
        green3_route.addNode ( n.getI () );
        green3_route.addNode ( n.getJ () );
        green3_route.addNode ( n.getK () );
        green3_route.addNode ( n.getO () );
        green3_route.addNode ( n.getT () );
        green3 = new Train ( "Green Line 3",this,green3_route );
        travelWay.put ( green3.getIdentifier (),green3 );
    }
    private void greenLine3RouteBack () {
        Route green3_route = new Route ();
        green3_route.addNode ( n.getT () );
        green3_route.addNode ( n.getO () );
        green3_route.addNode ( n.getK () );
        green3_route.addNode ( n.getJ () );
        green3_route.addNode ( n.getI () );
        green3_route.addNode ( n.getG () );
        green3Back = new Train ( "Green Line 3 Back",this,green3_route );
        travelWay.put ( green3Back.getIdentifier (),green3Back );
    }

    private void greenLine2Route () {
        Route green2_route = new Route ();
        green2_route.addNode ( n.getF () );
        green2_route.addNode ( n.getG () );
        green2_route.addNode ( n.getI () );
        green2_route.addNode ( n.getJ () );
        green2_route.addNode ( n.getK () );
        green2_route.addNode ( n.getO () );
        green2_route.addNode ( n.getS () );
        green2 = new Train ( "Green Line 2",this,green2_route );
        travelWay.put ( green2.getIdentifier (),blue2 );
    }

    private void greenLine2RouteBack () {
        Route green2_route = new Route ();
        green2_route.addNode ( n.getS () );
        green2_route.addNode ( n.getO () );
        green2_route.addNode ( n.getK () );
        green2_route.addNode ( n.getJ () );
        green2_route.addNode ( n.getI () );
        green2_route.addNode ( n.getG () );
        green2_route.addNode ( n.getF () );
        green2Back = new Train ( "Green Line 2 back",this,green2_route );
        travelWay.put ( green2Back.getIdentifier (),green2Back );
    }


    private void greenLine1Route () {
        Route green1_route = new Route ();
        green1_route.addNode ( n.getE () );
        green1_route.addNode ( n.getF () );
        green1_route.addNode ( n.getG () );
        green1_route.addNode ( n.getI () );
        green1_route.addNode ( n.getJ () );
        green1_route.addNode ( n.getK () );
        green1_route.addNode ( n.getO () );
        green1_route.addNode ( n.getR () );
        green1 = new Train ( "Green Line 1",this,green1_route );
        travelWay.put ( green1.getIdentifier (),green1 );
    }

    private void greenLine1RouteBack () {
        Route green1_route = new Route ();
        green1_route.addNode ( n.getR () );
        green1_route.addNode ( n.getO () );
        green1_route.addNode ( n.getK () );
        green1_route.addNode ( n.getJ () );
        green1_route.addNode ( n.getI () );
        green1_route.addNode ( n.getG () );
        green1_route.addNode ( n.getF () );
        green1_route.addNode ( n.getE () );
        green1Back = new Train ( "Green Line 1 Back",this,green1_route );
        travelWay.put ( green1Back.getIdentifier (),green1Back );
    }

    private void blueLine1Route () {
        Route blue1_route = new Route ();
        blue1_route.addNode ( n.getA () );
        blue1_route.addNode ( n.getH () );
        blue1_route.addNode ( n.getI () );
        blue1_route.addNode ( n.getK () );
        blue1_route.addNode ( n.getL () );
        blue1 = new Train ( "Blue line 1",this,blue1_route );
        travelWay.put ( blue1.getIdentifier (),blue1 );
    }
    private void blueLine1RouteBack () {
        Route blue1_route = new Route ();
        blue1_route.addNode ( n.getL () );
        blue1_route.addNode ( n.getK () );
        blue1_route.addNode ( n.getI () );
        blue1_route.addNode ( n.getH () );
        blue1_route.addNode ( n.getA () );
        blue1back = new Train ( "Blue line 1 Back",this,blue1_route );
        travelWay.put ( blue1back.getIdentifier (),blue1back );
    }


    private void blueLine2Route () {
        Route blue2_route = new Route ();
        blue2_route.addNode ( n.getB () );
        blue2_route.addNode ( n.getH () );
        blue2_route.addNode ( n.getI () );
        blue2_route.addNode ( n.getK () );
        blue2_route.addNode ( n.getL () );
        blue2 = new Train ( "Blue line 2",this,blue2_route );
        travelWay.put ( blue2.getIdentifier (),blue2 );
    }

    private void blueLine2RouteBack () {
        Route blue2_route = new Route ();
        blue2_route.addNode ( n.getL () );
        blue2_route.addNode ( n.getK () );
        blue2_route.addNode ( n.getI () );
        blue2_route.addNode ( n.getH () );
        blue2_route.addNode ( n.getB () );
        blue2Back = new Train ( "Blue line 2 back",this,blue2_route );
        travelWay.put ( blue2Back.getIdentifier (),blue2Back );
    }

    public NodeList getN () {
        return n;
    }

    public Map<String, Train> getTravelWay () {
        return travelWay;
    }

    public Train getBlue1 () {
        return blue1;
    }

    public void setBlue1 (Train blue1) {
        this.blue1 = blue1;
    }

    public Train getBlue2 () {
        return blue2;
    }

    public void setBlue2 (Train blue2) {
        this.blue2 = blue2;
    }

    public Train getGreen1 () {
        return green1;
    }

    public void setGreen1 (Train green1) {
        this.green1 = green1;
    }

    public Train getGreen2 () {
        return green2;
    }

    public void setGreen2 (Train green2) {
        this.green2 = green2;
    }

    public Train getGreen3 () {
        return green3;
    }

    public void setGreen3 (Train green3) {
        this.green3 = green3;
    }

    public Train getRed1 () {
        return red1;
    }

    public void setRed1 (Train red1) {
        this.red1 = red1;
    }

    public Train getRed2 () {
        return red2;
    }

    public void setRed2 (Train red2) {
        this.red2 = red2;
    }
}
