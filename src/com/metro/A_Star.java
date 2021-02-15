package com.metro;

import java.util.ArrayList;
import java.util.Stack;

public class A_Star {
    private final ArrayList<Routes> routes = new ArrayList<> ();
    private Double heuristicMinLength;
    //private Queue visitedList = new Queue ();
    private Stack<Node> stack = new Stack<> ();

    protected Routes findShortestPath (Node start,Node end) {//Nod start = A & Nod end = S
        Node current = start;
        ArrayList<Node> children = new ArrayList<> ();
        boolean isFound = false;
        if (start.equals ( end )) {
            isFound = true;
        }

        //Add start node to the visited list.
        stack.add ( current );

        setHeuristicMinLength ( start.getxValue () - end.getxValue (),start.getyValue () - end.getyValue () );
        findShortestPath ( end,current,isFound );
        return convertStackToRoute();
    }

    private Routes convertStackToRoute () {
        Routes route = new Routes ();
        for(int i = 0 ;i < stack.size (); i++){
            Node n = stack.remove ( 0 );
            route.addToRoute ( n );
        }
        return route;
    }

    private Routes findShortestPath (Node end,Node current,boolean isFound) {
        ArrayList<Node> children;
        // getTheChildNodes
        children = current.getConnectedNodes ();
        //Get the cost to each children and select the lowest cost.

        //Checks if any of the children are the node we are searching for
        for (Node n : children) {
            if(n.equals ( end )){
                stack.push ( n );
                isFound = true;
                return convertStackToRoute ();
            }
        }

        if (children.size () == 0) {
            //End point
            stack.pop ();
        }
        Node n = getCheapestNode ( children );
        stack.push ( n );
        // Current.
        //  Sum up the cost to the children and continue on the one with the lowest cost
        //
        if (end.equals ( current ))
            isFound = true;
        else
           return findShortestPath ( n,end );
        return null;
    }

    private Node getCheapestNode (ArrayList<Node> children) {
        int i = 0;
        Node nodeToReturn = null;
        for (Node n : children) {
            int lCost = 100;
            if (n.timeToChildNode ( i ) < lCost && !n.isVisited ()) {
                nodeToReturn = n.getBow ( i ).getNodeTo ();
                n.setVisited ( true );
            }
            i++;
        }
        return nodeToReturn;
    }

    private void setHeuristicMinLength (int xDiff,int yDiff) {
        final int SQUARED = 2;
        Double x = Math.pow ( xDiff,SQUARED );
        Double y = Math.pow ( yDiff,SQUARED );
        heuristicMinLength = Math.sqrt ( x + y );
    }
}
