package com.company;

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

        //TODO if multiple travel_ways check which is the best
        //checkStops()
    }
}
