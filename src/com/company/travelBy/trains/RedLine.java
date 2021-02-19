package com.company.travelBy.trains;

import com.company.Node;
import com.company.NodeList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RedLine extends Train{
    private final int[] TIMEBETWEENSTATIONS = {5,1,5,1,5,1,3};
    private Map<Node, Integer> timeSchedule = new HashMap<> ();
    private final String identifier = "Red line";
    private Random rnd;
    private Node direction;




    public RedLine () {
        addRoute ();

    }

    @Override
    public void addRoute () {
        NodeList nodeList = new NodeList ();
        int i = 0;
        timeSchedule.put ( nodeList.getP (), TIMEBETWEENSTATIONS[i]);
        i++;
        timeSchedule.put ( nodeList.getM (),TIMEBETWEENSTATIONS[i] );
        i++;
        timeSchedule.put ( nodeList.getN (),TIMEBETWEENSTATIONS[i] );
        i++;
        timeSchedule.put ( nodeList.getO (),TIMEBETWEENSTATIONS[i] );
        i++;
        timeSchedule.put ( nodeList.getK (),TIMEBETWEENSTATIONS[i] );
        i++;
        timeSchedule.put ( nodeList.getJ (),TIMEBETWEENSTATIONS[i] );
        i++;
        timeSchedule.put ( nodeList.getD (), TIMEBETWEENSTATIONS[i]);
        i++;
        timeSchedule.put ( nodeList.getJ (), TIMEBETWEENSTATIONS[i]);
        i++;
        timeSchedule.put ( nodeList.getK (), TIMEBETWEENSTATIONS[i]);
        i++;
        timeSchedule.put ( nodeList.getO (),TIMEBETWEENSTATIONS[i] );
        i++;
        timeSchedule.put ( nodeList.getN (),TIMEBETWEENSTATIONS[i] );
        i++;
        timeSchedule.put ( nodeList.getM (),TIMEBETWEENSTATIONS[i] );
        i++;
        timeSchedule.put ( nodeList.getP (),TIMEBETWEENSTATIONS[i] );
    }

    @Override
    public int getDepartureTimes (Node from, Node to) {
        return 0;
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
