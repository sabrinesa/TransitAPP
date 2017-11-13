package com.app.transit.transitapp.Model;

import java.util.ArrayList;

/**
 * Created by Sabrine on 08/11/2017.
 */

public class Segement {

    String name;
    int numStops;
    String travelMode;
    String  description;
    String color;
    String  iconUrl;
    String polyline;

    ArrayList<Stop> stops = new ArrayList<>();

    public ArrayList<Stop> getStops() {
        return stops;
    }

    public void setStops(ArrayList<Stop> stops) {
        this.stops = stops;
    }

    public Segement(String travelMode, String description, String color, String iconUrl, String polyline) {
        this.travelMode = travelMode;
        this.description = description;
        this.color = color;
        this.iconUrl = iconUrl;
        this.polyline = polyline;
    }

    public String getTravelMode() {
        return travelMode;
    }

    public void setTravelMode(String travelMode) {
        this.travelMode = travelMode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getPolyline() {
        return polyline;
    }

    public void setPolyline(String polyline) {
        this.polyline = polyline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumStops() {
        return numStops;
    }

    public void setNumStops(int numStops) {
        this.numStops = numStops;
    }
}
