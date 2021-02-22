package com.company;

import com.company.travelBy.Train;
import com.company.travelBy.TransportationWay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Travel_Request {
    private TransportationWay transportationWay;
    private Route r;
    private TravelWays_Support travelWays_support = new TravelWays_Support ();


    public Travel_Request (Node start,Node end) {
        r = new Route ().getRoute ( start,end ); // Gets the route
        //TODO CREATE THE TRANSPORT WAY
        //Can we go by one train?
        Node current = start;
        Map<Node, ArrayList<Train>> trains = travelWays_support.getPassingTrains ( current );
        Train train = trains.get ( current ).get ( 0 );
        ArrayList<Route_Info> nodes = new ArrayList<> ();
        int i = 1;
        while (current != end){
            current = r.getRouteArray ().get ( i );
            if(!travelWays_support.isTrainPassing ( current, train )){
                train = travelWays_support.getPassingTrains ( current ).get ( current ).get ( 0 );
            }else{
                nodes.add ( new Route_Info ( train.toString (), current.toString () ) );
                i++;
            }
        }
        nodes.add ( new Route_Info ( train.toString (), current.toString () ) );

        nodes.get ( 0 );
        //TODO DECIDE if by train
        //TODO
    }


}
