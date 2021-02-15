package com.metro;

import java.util.ArrayList;

// En route består av flera bågar
public class Routes {
    private ArrayList<Node> route = new ArrayList<> ();
    private int totalRouteTime;

    public Routes () {
    }

    public Routes (ArrayList<Node> route) {
        this.route = route;
    }

    public void addToRoute (Node in) {
        route.add ( in );
    }

//    public int routeTime () {
//        int routeTime = 0;
//        for (int i = 0; i < route.size (); i++) {
//            if (i != route.size () - 1)
//                routeTime += route.get ( i ).timeToNextNode ( route.get ( i + 1 ) );
//        }
//        return routeTime;
//    }

    @Override
    public String toString () {
        return "Routes{" + "route=" + route + ", totalRouteTime=" + /*routeTime () +*/ '}';
    }
}
