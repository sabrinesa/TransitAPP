package com.app.transit.transitapp.Controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.app.transit.transitapp.GlobaleManager.GlobaleManager;
import com.app.transit.transitapp.Model.Price;
import com.app.transit.transitapp.Model.Route;
import com.app.transit.transitapp.Model.Segement;
import com.app.transit.transitapp.Model.Stop;
import com.app.transit.transitapp.R;
import com.skyfishjy.library.RippleBackground;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class SplashScreenActivity extends Activity {


    private static int SPLASH_TIME_OUT = 10000;
    public ArrayList<Route> availableRoutes = new ArrayList<Route>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        final RippleBackground rippleBackground=(RippleBackground)findViewById(R.id.content);
        ImageView imageView=(ImageView)findViewById(R.id.centerImage);
        rippleBackground.startRippleAnimation();
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                try {
                    readJSONFromAsset();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                finish();
                startActivity(new Intent(SplashScreenActivity.this, MapActivity.class));
            }
        }, SPLASH_TIME_OUT);
    }
    public String readJSONFromAsset() throws JSONException {
        String json = null;
        try {

            InputStream is = getAssets().open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            JSONObject jObject = new JSONObject(json);
            JSONArray jsonarray = jObject.getJSONArray("routes");
            for (int i = 0; i < jsonarray.length(); i++) {
                Route currentRoute = new Route();
                JSONObject jsonobject = jsonarray.getJSONObject(i);
                String type = jsonobject.getString("type");
                String provider = jsonobject.getString("provider");
                JSONObject jsonPrice = jsonobject.getJSONObject("price");
                String currency = jsonPrice.getString("currency");
                int amount = jsonPrice.getInt("amount");
                Route interRoute = new  Route(type,provider);
                Price price = new Price(currency,amount);
                interRoute.setPrice(price);
                availableRoutes.add(interRoute);
                ArrayList<Segement> segements = new ArrayList<>();
                JSONArray segementArray = jsonobject.getJSONArray("segments");
                for(int j = 0; j < segementArray.length(); j++){
                    JSONObject segmentObject = segementArray.getJSONObject(j);
                    String name =  segmentObject.getString("name");
                    int numStops = segmentObject.getInt("num_stops");
                    String travelMode = segmentObject.getString("travel_mode");
                    String  description = segmentObject.getString("description");
                    String color = segmentObject.getString("color");
                    String  iconUrl = segmentObject.getString("icon_url");
                    String polyline = segmentObject.getString("polyline");
                    Segement segement = new Segement(travelMode,description, color,iconUrl,polyline);

                    ArrayList<Stop> stops = new ArrayList<Stop>();
                    JSONArray stopsArrayJson  = segmentObject.getJSONArray("stops");
                    for(int k =0; k < stopsArrayJson.length();k++){
                        JSONObject stopsJson = stopsArrayJson.getJSONObject(k);
                        Double lat = stopsJson.getDouble("lat");
                        Double lng = stopsJson.getDouble("lng");
                        String datetime = stopsJson.getString("datetime");
                        String stopName = stopsJson.getString("name");
                        Stop stop = new Stop(lat,lng,datetime,stopName);
                        stops.add(stop);
                    }
                    segement.setStops(stops);
                    segements.add(segement);

                }
                interRoute.setSegements(segements);
                GlobaleManager.setAvailableRoutes(availableRoutes);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
