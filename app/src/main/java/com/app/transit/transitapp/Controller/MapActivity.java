package com.app.transit.transitapp.Controller;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.app.transit.transitapp.GlobaleManager.GlobaleManager;
import com.app.transit.transitapp.Model.Route;
import com.app.transit.transitapp.Model.Segement;
import com.app.transit.transitapp.Model.Stop;
import com.app.transit.transitapp.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {


    private GoogleMap stopsMap;
    private FloatingActionButton showlist;

    Bitmap result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        showlist = findViewById(R.id.show_filtred_contoller);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        showlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MapActivity.this,RoutesController.class));
            }
        });

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        stopsMap = googleMap;
        CameraUpdate center=
                CameraUpdateFactory.newLatLng(new LatLng(52.5065133, 13.1445545));
        CameraUpdate zoom=CameraUpdateFactory.zoomTo(9);
        stopsMap.moveCamera(center);
        stopsMap.animateCamera(zoom);
        ArrayList<Route> routes = GlobaleManager.getAvailableRoutes();
        for (int i = 0; i < routes.size(); i++) {
            String travlingMode = routes.get(i).getType();

            int idDrawable;

            switch (travlingMode) {
                case "public_transport":
                    idDrawable = R.drawable.public_marker;
                    break;
                case "car_sharing":
                    idDrawable = R.drawable.car_marker;
                    break;
                case "private_bike":
                    idDrawable = R.drawable.bike_marker;
                    break;
                case "taxi":
                    idDrawable = R.drawable.taxi_marker;
                    break;
                case "bike_sharing":
                    idDrawable = R.drawable.bike_marker;
                    break;

                default:
                    idDrawable = R.drawable.icon_door2door;
                    break;
            }

            ArrayList<Segement> segements = routes.get(i).getSegements();
            for (int j = 0; j < segements.size(); j++) {
                ArrayList<Stop> stops = segements.get(j).getStops();

                    for (int k = 0; k < stops.size(); k++) {
                        Marker marker = stopsMap.addMarker(new MarkerOptions()
                                .position(new LatLng(stops.get(k).getLat(), stops.get(k).getLng()))
                                .title(segements.get(j).getTravelMode())
                                .snippet(stops.get(k).getDatetime())
                                .icon(BitmapDescriptorFactory.fromResource(idDrawable)));
                    }
                }
            }
        }
    }
