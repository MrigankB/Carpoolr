package edu.cs.carpoolr.carpoolr;

import java.util.Date;

/**
 * Created by Mrigank on 5/31/2015.
 */

public class Carpool
{
    private String host;

    private String startLocation;
    private String startTime;

    private String endTime;
    private String endLocation;

    public Carpool(String host, String startLocation, String startTime, String endTime, String endLocation)
    {
        this.host = host;

        this.startLocation = startLocation;
        this.startTime = startTime;

        this.endLocation = endLocation;
        this.endTime = endTime;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }
}
