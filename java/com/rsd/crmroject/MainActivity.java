package com.rsd.crmroject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottom_navigation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottom_navigation = findViewById(R.id.bottom_navigation);

     getSupportFragmentManager().beginTransaction().replace(R.id.main_layout,new HomeFragment()).commit();
     bottom_navigation.setSelectedItemId(R.id.home);

        bottom_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;

                switch (item.getItemId()){
                    case R.id.home:
                        fragment = new HomeFragment();
                        //  Toast.makeText(MainActivity.this,"Home",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.meetings:
                        fragment = new MeetingFragment();

                        Toast.makeText(MainActivity.this,"Meetings",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.deals:
                        fragment = new DealsFragment();

                        Toast.makeText(MainActivity.this,"Deals",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.task:
                        fragment = new TasksFragment();

                        Toast.makeText(MainActivity.this,"Task", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.contacts:
                        fragment = new ContactFragment();

                        Toast.makeText(MainActivity.this,"Contacts",Toast.LENGTH_LONG).show();
                        break;

                }

               getSupportFragmentManager().beginTransaction().replace(R.id.main_layout,fragment).commit();



                return true;


            }
        });

    }
}
