package com.example.donationapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ViewDonations extends AppCompatActivity {
    //defining our array list variable
    ArrayList<Donation> ArrayList;

    private RecyclerView my_recycler_view;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_donations);

        my_recycler_view = findViewById(R.id.my_recycler_view);

        Bundle b = this.getIntent().getExtras();
        ArrayList = b.getParcelableArrayList("myKey");

//        ArrayList = new ArrayList<>();
//        ArrayList.add(1);
//        ArrayList.add(2);
//        ArrayList.add(3);
//        ArrayList.add(4);
//        ArrayList.add(5);
//        //only for setting size

       //my_recycler_view.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        //specify an adapter
        myAdapter = new MyAdapter(ArrayList);

        //set our layout manager and our adapter
        my_recycler_view.setLayoutManager(layoutManager);
        my_recycler_view.setAdapter(myAdapter);
    }
}
