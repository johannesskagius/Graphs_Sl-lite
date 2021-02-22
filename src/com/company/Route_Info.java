package com.company;

public class Route_Info {
    private String train;
    private String position;

    public Route_Info (String train,String position) {
        this.train = train;
        this.position = position;
    }

    @Override
    public String toString () {
        return train + " " + position;
    }
}
