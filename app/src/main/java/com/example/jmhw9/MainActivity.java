package com.example.jmhw9;

import android.app.ActivityManager;
import android.content.ClipData;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentController;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

        TabLayout tabLayout;
        ViewPager view;
        ViewPagerAdapter viewad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setContentView(R.layout.leg_content);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        view = (ViewPager)findViewById(R.id.viewpager);
        viewad = new ViewPagerAdapter(getSupportFragmentManager());
        viewad.addFrag(new Leg_state(),"By_state");
        viewad.addFrag(new Leg_house(),"House");
        viewad.addFrag(new Leg_senate(),"Senate");
        view.setAdapter(viewad);
//        TabLayout.Tab state = tabLayout.newTab();
//        state.setText("By State");
//
//        TabLayout.Tab house = tabLayout.newTab();
//        state.setText("dsa");
//
//        TabLayout.Tab senate = tabLayout.newTab();
//        senate.setText("Senate");

//        for (int i = 0; i < tabLayout.getTabCount(); i++) {
//            TabLayout.Tab tab = tabLayout.getTabAt(i);
//            if (tab != null) {
//                tab.setCustomView(viewad.getTabView(i));
//                if (tab.getCustomView() != null) {
//                    View tabView = (View) tab.getCustomView().getParent();
//                    tabView.setTag(i);
//                    tabView.setOnClickListener(mTabOnClickListener);
//                }
//            }
//        }
//        viewPager.setCurrentItem(1);
//        tabLayout.addTab(state,0);
//        tabLayout.addTab(house,1);
//        tabLayout.addTab(senate,2);
        tabLayout.setupWithViewPager(view);

//        tabLayout = (TabLayout) findViewById(R.id.tab_view);
        view.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
//        android.app.ActionBar ac = getActionBar();
//        FragmentManager mycontrol = getSupportFragmentManager();

        int id = item.getItemId();

        if (id == R.id.nav_leg) {
            // Handle the camera action
            setTitle("Legislators");
//            FragmentTransaction mytran = mycontrol.beginTransaction();
//            Fragment my_leg = new Leg();
//            mytran.replace(R.id.fra_container,my_leg);
//            mytran.commit();
        } else if (id == R.id.nav_bil) {
            setTitle("Bills");
//            FragmentTransaction mytran1 = mycontrol.beginTransaction();
//            Fragment my_leg = new Bil();
//            mytran1.replace(R.id.fra_container,my_leg);
//            mytran1.commit();
        } else if (id == R.id.nav_com) {
            setTitle("Committees");
//            FragmentTransaction mytran2 = mycontrol.beginTransaction();
//            Fragment my_leg = new Com();
//            mytran2.replace(R.id.fra_container,my_leg);
//            mytran2.commit();
        } else if (id == R.id.nav_fav) {
            setTitle("Favorites");
//            FragmentTransaction mytran3 = mycontrol.beginTransaction();
//            Fragment my_leg = new Fav();
//            mytran3.replace(R.id.fra_container,my_leg);
//            mytran3.commit();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
