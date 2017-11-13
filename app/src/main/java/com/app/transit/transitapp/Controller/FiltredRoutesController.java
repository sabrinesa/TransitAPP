package com.app.transit.transitapp.Controller;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.app.transit.transitapp.Adapter.RouteAdapter;
import com.app.transit.transitapp.Adapter.StopAdapter;
import com.app.transit.transitapp.GlobaleManager.DividerItemDecoration;
import com.app.transit.transitapp.GlobaleManager.GlobaleManager;
import com.app.transit.transitapp.Holders.ItemEntity;
import com.app.transit.transitapp.Model.Route;
import com.app.transit.transitapp.R;

import java.util.ArrayList;
import java.util.List;

public class FiltredRoutesController extends AppCompatActivity {
    private List<Route> selectedRoute = new ArrayList<Route>();
    private RecyclerView recyclerView;
    private StopAdapter stopAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtred_routes_controller);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.routes_recycler_view);
        stopAdapter = new StopAdapter(selectedRoute);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(stopAdapter);
        setFiltredRoute();
    }
    void setFiltredRoute(){

selectedRoute = GlobaleManager.getAvailableRoutes();

    }
}
