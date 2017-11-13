package com.app.transit.transitapp.Model;

/**
 * Created by Sabrine on 08/11/2017.
 */

public class Stop {
    Double lat;
    Double lng;
    String datetime;
    String name;
    String  properties;

    public Stop(Double lat, Double lng, String datetime, String name) {
        this.lat = lat;
        this.lng = lng;
        this.datetime = datetime;
        this.name = name;
    }

    public Stop(Double lat, Double lng, String datetime, String name, String properties) {
        this.lat = lat;
        this.lng = lng;
        this.datetime = datetime;
        this.name = name;
        this.properties = properties;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }
}
