package com.company;

import com.company.travelBy.Train;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TravelWays_Support {
    private NodeList n = Main.nodeList;
    private final Map<String, Train> travelWay = new HashMap<> ();
    private final Map<Node, ArrayList<Train>> stations = new HashMap<> ();
    private Train blue1;
    private Train blue2;
    private Train green1;
    private Train green2;
    private Train green3;
    private Train red1;
    private Train red2;

    public TravelWays_Support () {
        blueLine1Route ();
        blueLine2Route ();
        greenLine1Route ();
        greenLine2Route ();
        greenLine3Route ();
        red1Line1Route ();
        red1Line2Route ();
        addStations(blue1);
        addStations(blue2);
        addStations(green1);
        addStations(green2);
        addStations(green3);
        addStations(red1);
        addStations(red2);
    }

    private void addStations (Train t) {
        ArrayList<Node> route = t.getTrainRoute ().getRouteArray ();
        for(Node n : route){
            stations.computeIfAbsent ( n, v->new ArrayList<> () ).add ( t );
        }
    }

    public ArrayList<Train> getPassingTrains(Node n){
        ArrayList<Train> x = stations.get ( n );
        return x;
    }

    public Map<Node, ArrayList<Train>> getStations () {
        return stations;
    }

    public ArrayList<Train> getPossibleTrains(Node start,Node end){
        return null;
    }

    private void red1Line2Route () {
        Route red2_route = new Route ();
        red2_route.addNode ( n.getD () );
        red2_route.addNode ( n.getJ () );
        red2_route.addNode ( n.getK () );
        red2_route.addNode ( n.getO () );
        red2_route.addNode ( n.getN () );
        red2_route.addNode ( n.getQ () );
        red2_route.addNode ( n.getN () );
        red2_route.addNode ( n.getO () );
        red2_route.addNode ( n.getK () );
        red2_route.addNode ( n.getJ () );
        red2_route.addNode ( n.getD () );
        red2 = new Train ( "Red line 2",red2_route );
        travelWay.put ( red2.getIdentifier (), red2 );
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
        red1_route.addNode ( n.getM () );
        red1_route.addNode ( n.getN () );
        red1_route.addNode ( n.getO () );
        red1_route.addNode ( n.getK () );
        red1_route.addNode ( n.getJ () );
        red1_route.addNode ( n.getC () );
        red1 = new Train ( "Red line 1",red1_route );
        travelWay.put ( red1.getIdentifier (), red1 );
    }

    private void greenLine3Route () {
        Route green3_route = new Route ();
        green3_route.addNode ( n.getG () );
        green3_route.addNode ( n.getI () );
        green3_route.addNode ( n.getJ () );
        green3_route.addNode ( n.getK () );
        green3_route.addNode ( n.getO () );
        green3_route.addNode ( n.getT () );
        green3_route.addNode ( n.getO () );
        green3_route.addNode ( n.getK () );
        green3_route.addNode ( n.getJ () );
        green3_route.addNode ( n.getI () );
        green3_route.addNode ( n.getG () );
        green3 = new Train ( "Green Line 3",green3_route );

        travelWay.put ( green3.getIdentifier (), green3 );

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
        green2_route.addNode ( n.getO () );
        green2_route.addNode ( n.getK () );
        green2_route.addNode ( n.getJ () );
        green2_route.addNode ( n.getI () );
        green2_route.addNode ( n.getG () );
        green2_route.addNode ( n.getF () );

        green2 = new Train ( "Green Line 2",green2_route );
        travelWay.put ( green2.getIdentifier (), blue2 );
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
        green1_route.addNode ( n.getO () );
        green1_route.addNode ( n.getK () );
        green1_route.addNode ( n.getJ () );
        green1_route.addNode ( n.getI () );
        green1_route.addNode ( n.getG () );
        green1_route.addNode ( n.getF () );
        green1_route.addNode ( n.getE () );
        green1 = new Train ( "Green Line 1",green1_route );
        travelWay.put ( green1.getIdentifier (), green1 );
    }

    private void blueLine1Route () {
        Route blue1_route = new Route ();
        blue1_route.addNode ( n.getA () );
        blue1_route.addNode ( n.getH () );
        blue1_route.addNode ( n.getI () );
        blue1_route.addNode ( n.getK () );
        blue1_route.addNode ( n.getL () );
        blue1_route.addNode ( n.getK () );
        blue1_route.addNode ( n.getI () );
        blue1_route.addNode ( n.getH () );
        blue1_route.addNode ( n.getA () );
        blue1 = new Train ( "Blue line 1",blue1_route );
        travelWay.put ( blue1.getIdentifier (), blue1 );
    }

    private void blueLine2Route () {
        Route blue2_route = new Route ();
        blue2_route.addNode ( n.getB () );
        blue2_route.addNode ( n.getH () );
        blue2_route.addNode ( n.getI () );
        blue2_route.addNode ( n.getK () );
        blue2_route.addNode ( n.getL () );
        blue2_route.addNode ( n.getK () );
        blue2_route.addNode ( n.getI () );
        blue2_route.addNode ( n.getH () );
        blue2_route.addNode ( n.getB () );
        blue2 = new Train ( "Blue line 2",blue2_route );
        travelWay.put ( blue2.getIdentifier (), blue2 );
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
