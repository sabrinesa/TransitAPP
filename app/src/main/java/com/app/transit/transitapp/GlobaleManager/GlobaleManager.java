package com.app.transit.transitapp.GlobaleManager;

import com.app.transit.transitapp.Model.Route;

import java.util.ArrayList;

/**
 * Created by Sabrine on 11/11/2017.
 */

public class GlobaleManager {
    private static ArrayList<Route> availableRoutes = new ArrayList<Route>();

    public static ArrayList<Route> getAvailableRoutes() {
        return availableRoutes;
    }

    public static   void setAvailableRoutes(ArrayList<Route> availableRoutes) {
        GlobaleManager.availableRoutes = availableRoutes;
    }

}
