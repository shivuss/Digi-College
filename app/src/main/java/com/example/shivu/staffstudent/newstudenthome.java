package com.example.shivu.staffstudent;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class newstudenthome extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newstudenthome);

        Bundle bun=getIntent().getExtras();
        user=bun.getString("username");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        getMenuInflater().inflate(R.menu.newstudenthome, menu);
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
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent i1=new Intent(getApplicationContext(),querydetails.class);
            startActivity(i1);
        } else if (id == R.id.nav_gallery) {

            Intent i1=new Intent(getApplicationContext(),viewstaffdetails.class);
            startActivity(i1);
        } else if (id == R.id.nav_manage) {
            Intent i1=new Intent(getApplicationContext(),viewquerydetails.class);
            startActivity(i1);

        }
        else if (id == R.id.nav_rep) {
            Intent i1=new Intent(getApplicationContext(),viewreplydetails.class);
            startActivity(i1);

        }
        else if (id == R.id.nav_coment) {
            Intent i1=new Intent(getApplicationContext(),viewcommentreply.class);
            startActivity(i1);

        }
        else if (id == R.id.nav_vrating) {
            Intent i1=new Intent(getApplicationContext(),viewrating.class);
            startActivity(i1);

        }
        else if (id == R.id.nav_cmp) {
            Intent i1=new Intent(getApplicationContext(),addcomplaint.class);
            startActivity(i1);

        }
        else if (id == R.id.nav_rem) {
            Intent i1=new Intent(getApplicationContext(),rating.class);
            startActivity(i1);

        }
        else if (id == R.id.nav_notice) {
            Intent i1=new Intent(getApplicationContext(),viewnotice.class);
            startActivity(i1);

        }
        else if (id == R.id.nav_share) {
            Intent i1=new Intent(getApplicationContext(),changepassword.class);
            Bundle bb=new Bundle();
            bb.putString("username",user);
            i1.putExtras(bb);
            startActivity(i1);

        } else if (id == R.id.nav_send) {
            Intent i1=new Intent(getApplicationContext(),login.class);
            startActivity(i1);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
