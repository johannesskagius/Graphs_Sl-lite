package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class AStar {
    private Route route = new Route ();
    private Stack<Node> visitedNodes = new Stack<> ();

    //A* fungerar med
    public Route getPath (Node start,Node end) {
        visitedNodes.push ( start );
        Node current = start;
        //Kolla om startnode
        while (!checkIfFinish ( end,current )) {
            if (!checkIfFinish ( end,current )) {
                if(!visitedNodes.peek ().equals ( current ))
                    visitedNodes.push ( current );
                //Kolla om node har barn
                if (current.gotChilds ()) { // Om det finns barn gå till det billigaste, ej besökta bar
                    //ArrayList<Node> r = getPath ( findCheapestChild ( current,end ),end ).getRouteArray ();
                    Node cheapestChild = findCheapestChild ( current,end );
                    current = cheapestChild;
                }
            }
        }
        convertToRoute(current);
        resetAllNodes();
        return route.getRoute ();
    }

    private void convertToRoute (Node current) {
        visitedNodes.push ( current );
        for (Node n : visitedNodes) {
            route.addNode ( n );
            visitedNodes.peek ();
        }
    }

    private boolean checkIfFinish (Node end,Node current) {
        return current.equals ( end );
    }

    private Node findCheapestChild (Node current,Node end) {//Här vet vi att noden har barn,
        double HEURISTICMAX = 1000000; //Should be infinity;
        Node cheapestConnectedNode = null; // new Node (  );
        //TODO get the cheapest child if not visited.
        ArrayList<Node> connectedNodes = current.getConnectedNodes ();
        //Get the cheapest unvisitedNode
        double heuristicCost = 0;
        for (int i = 0; i < connectedNodes.size (); i++) {
            heuristicCost = current.getCost ( i ) + connectedNodes.get ( i ).calcHeuristicLength ( end );
            Node n = connectedNodes.get ( i );
            if (heuristicCost < HEURISTICMAX && !n.isVisited () || end.equals ( connectedNodes.get ( i ) )) {
                HEURISTICMAX = heuristicCost;
                cheapestConnectedNode = n;
            }
        }
        if (cheapestConnectedNode == null) {
            visitedNodes.pop ();
            cheapestConnectedNode = visitedNodes.peek ();
        }
        cheapestConnectedNode.setVisited ( true );
        return cheapestConnectedNode;
    }

    private void resetAllNodes () {
        ArrayList<Node> xArr = route.getRouteArray ();
        for(Node x : xArr){
            x.setVisited ( false );
        }
    }
}
