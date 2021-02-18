package com.company.travelBy.trains;
import com.company.Node;
import java.util.ArrayList;
import java.util.Random;

public class BlueLine extends Train{
    private String identifier = "Blue line";
    private ArrayList<Node> route = new ArrayList<> ();
    private Random rnd;

    public BlueLine (ArrayList<Node> route) {
        super ( route );
    }


    @Override
    public int getDepartureTimes (Node n) {
        return 0;
    }

    @Override
    public ArrayList<Node> route () {
        return null;
    }

    @Override
    public boolean isOnTime () {
        int isLate = rnd.nextInt (100);
        return isLate<10;
    }

    @Override
    public String identifier () {
        return identifier;
    }
}
