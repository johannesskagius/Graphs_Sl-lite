package com.company.travelBy.trains;
import com.company.Node;
import com.company.NodeList;

import java.util.*;

public class BlueLine extends Train{
    private final int[] TIMEBETWEENSTATIONS = {5,1,5,1,5,1,3,1,5,1,5,1,3};
    private Map<Node, Integer> timeSchedule = new HashMap<> ();
    private final String identifier = "Blue line";
    private Random rnd;
    private int delayed;
    private Node direction;

    public BlueLine () {
        addRoute ();
    }

    @Override
    public void addRoute () {
        NodeList nodeList = new NodeList ();
        int i = 0;
        timeSchedule.put ( nodeList.getA (), TIMEBETWEENSTATIONS[i]);
        i++;
        timeSchedule.put ( nodeList.getH (),TIMEBETWEENSTATIONS[i] );
        i++;
        timeSchedule.put ( nodeList.getI (),TIMEBETWEENSTATIONS[i] );
        i++;
        timeSchedule.put ( nodeList.getK (),TIMEBETWEENSTATIONS[i] );
        i++;
        timeSchedule.put ( nodeList.getL (),TIMEBETWEENSTATIONS[i] );
        i++;
        timeSchedule.put ( nodeList.getK (),TIMEBETWEENSTATIONS[i] );
        i++;
        timeSchedule.put ( nodeList.getI (), TIMEBETWEENSTATIONS[i]);
        i++;
        timeSchedule.put ( nodeList.getH (), TIMEBETWEENSTATIONS[i]);
        i++;
        timeSchedule.put ( nodeList.getB (), TIMEBETWEENSTATIONS[i]);
    }

    @Override
    public int getDepartureTimes (Node from, Node to) {
        //Check which way we are going
        //Check if Node to.x is between Node from and Trains direction
        //if(from.getPosition ().getxCoordinate () < to.getPosition ().getxCoordinate () < end)
        //Check if Node to.y is between Node from and Trains direction
        return timeSchedule.get ( from );//timeSchedule[];
    }

    @Override
    public ArrayList<Node> route () {
        return null;
    }

    @Override
    public boolean isOnTime () {
        int isLate = rnd.nextInt (100);
        delayed = rnd.nextInt (10);
        return isLate<10;
    }

    @Override
    public String identifier () {
        return identifier;
    }

    @Override
    public String lateBy () {
        return identifier +" is late by "+delayed+"min";
    }

    @Override
    public Node Direction () {
        return direction;
    }
}
