package com.tomtom.workshop.workshopapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


/**
 * Add to app build gradle
 *
 * compile 'com.android.support:cardview-v7:21.0.+'
 *compile 'com.android.support:recyclerview-v7:21.0.+'
 *
 */

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView rv;
    private List<Car> carList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        initializeData();
        initializeComponents();

    }

    private void initializeData() {
        carList = new ArrayList<>();

        carList.add(new Car(R.drawable.bmw1small, "BMW E30", "1988"));
        carList.add(new Car(R.drawable.bmw2small, "BMW E36", "1993"));
        carList.add(new Car(R.drawable.bmw3small, "BMW E46", "2001"));
        carList.add(new Car(R.drawable.bmw4small, "BMW E92", "2008"));
        carList.add(new Car(R.drawable.bmw5small, "BMW F32", "2014"));
        carList.add(new Car(R.drawable.bmw1small, "BMW E30", "1988"));
        carList.add(new Car(R.drawable.bmw2small, "BMW E36", "1993"));
        carList.add(new Car(R.drawable.bmw3small, "BMW E46", "2001"));
        carList.add(new Car(R.drawable.bmw4small, "BMW E92", "2008"));
        carList.add(new Car(R.drawable.bmw5small, "BMW F32", "2014"));
    }

    private void initializeComponents() {
        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(carList);
        rv.setAdapter(adapter);
    }
}
