package com.company;

import com.company.travelBy.Train;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class Travel_Route {
    private final AStar aStar = new AStar ();
    private final TravelWays_Support travelWays_support = new TravelWays_Support ();
    private Route r;

    public Travel_Route () {
    }

    public void getTravel_Route (Node startDestination,Node endDestination) {
        Route routeToEnd = aStar.getPath ( startDestination, endDestination );
        routeToEnd.toString ();
        //TODO get start and finish position
        ArrayList<Train> startStations = travelWays_support.getPassingTrains ( startDestination ).get ( startDestination );
        Map<Train, ArrayList<Node>> endStation = travelWays_support.getTrains ();
        ArrayList<Train> possibleDirectRoutes = new ArrayList<> ();
        for(Train train : startStations){
            if(endStation.containsKey ( endDestination )){
                possibleDirectRoutes.add ( train );
            }
        }

        System.out.println (possibleDirectRoutes);


        //TODO if multiple travel_ways check which is the best
        //checkStops()
    }
}
