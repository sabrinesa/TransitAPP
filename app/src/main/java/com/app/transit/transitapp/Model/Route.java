package com.app.transit.transitapp.Model;

import java.util.ArrayList;

/**
 * Created by Sabrine on 08/11/2017.
 */

public class Route {

    String type;
    String provider;
    Price price;


    ArrayList<Segement> segements = new ArrayList<>();
    public Route(){
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public ArrayList<Segement> getSegements() {
        return segements;
    }

    public void setSegements(ArrayList<Segement> segements) {
        this.segements = segements;
    }

    public Route(String type, String provider) {
        this.type = type;
        this.provider = provider;
    }

    public String getType() {
        return type;
    }

    public String getProvider() {
        return provider;
    }

    public void setType(String type) {

        this.type = type;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public Route parseJson(){
        Route route = new Route();
        return  route;

    }
}
