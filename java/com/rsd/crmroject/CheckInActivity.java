package com.rsd.crmroject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class CheckInActivity extends AppCompatActivity {

    private ArrayList<Model> list = new ArrayList<Model>();
    RecyclerView recyclerView;

   // private ArrayList<Data> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);





        recyclerView = findViewById(R.id.recyclerView);
        CheckinAdapter adapter = new CheckinAdapter(this,list,CheckInActivity.class);
        recyclerView.setAdapter(adapter);
    }
}
