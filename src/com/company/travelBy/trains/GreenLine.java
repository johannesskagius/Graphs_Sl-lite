package com.company.travelBy.trains;

import com.company.Node;
import com.company.NodeList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GreenLine extends Train {
    private final int[] TIMEBETWEENSTATIONS = {3,1,1,4,1,1,3};
    private Map<Node, Integer> timeSchedule = new HashMap<> ();
    private final String identifier = "Green line";
    private Random rnd;
    private Node direction;



    public GreenLine () {
        addRoute ();
    }

    @Override
    public void addRoute () {
        NodeList nodeList = new NodeList ();
        int i = 0;
        timeSchedule.put ( nodeList.getE (), TIMEBETWEENSTATIONS[i]);
        i++;
        timeSchedule.put ( nodeList.getF (),TIMEBETWEENSTATIONS[i] );
        i++;
        timeSchedule.put ( nodeList.getG (),TIMEBETWEENSTATIONS[i] );
        i++;
        timeSchedule.put ( nodeList.getI (),TIMEBETWEENSTATIONS[i] );
        i++;
        timeSchedule.put ( nodeList.getJ (),TIMEBETWEENSTATIONS[i] );
        i++;
        timeSchedule.put ( nodeList.getK (),TIMEBETWEENSTATIONS[i] );
        i++;
        timeSchedule.put ( nodeList.getO (), TIMEBETWEENSTATIONS[i]);
        i++;
        timeSchedule.put ( nodeList.getR (), TIMEBETWEENSTATIONS[i]);
        i++;
        timeSchedule.put ( nodeList.getO (), TIMEBETWEENSTATIONS[i]);
        i++;
        timeSchedule.put ( nodeList.getK (),TIMEBETWEENSTATIONS[i] );
        i++;
        timeSchedule.put ( nodeList.getJ (),TIMEBETWEENSTATIONS[i] );
        i++;
        timeSchedule.put ( nodeList.getI (),TIMEBETWEENSTATIONS[i] );
        i++;
        timeSchedule.put ( nodeList.getG (),TIMEBETWEENSTATIONS[i] );
        i++;
        timeSchedule.put ( nodeList.getF (),TIMEBETWEENSTATIONS[i] );
        i++;
        timeSchedule.put ( nodeList.getE (), TIMEBETWEENSTATIONS[i]);
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
        int isLate = rnd.nextInt ( 100 );
        delayed = rnd.nextInt ( 10 );
        return isLate < 10;
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
