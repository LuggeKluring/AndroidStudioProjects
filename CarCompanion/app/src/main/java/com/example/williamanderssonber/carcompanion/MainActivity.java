package com.example.williamanderssonber.carcompanion;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TabLayout tabs;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.navigation_reset) {
            App databasen = new App();
            databasen.onCreate(this);
            App.get().getDB().refuelsDao().deleteAll();
            recreate();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        //****** Lägger till tabb-samlingen och lägger till tabbar till denna ******
        //
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_local_gas_station_black_24dp).setText(R.string.tab2));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_directions_car_black_24dp).setText(R.string.tab1));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_build_black_24dp).setText(R.string.tab3));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        //
        final ViewPager viewPager = (ViewPager) findViewById(R.id.tabPager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
