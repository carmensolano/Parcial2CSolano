package com.example.carme.parcial2csolano.Activities;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.carme.parcial2csolano.Fragments.ContenedorFragment;
import com.example.carme.parcial2csolano.Fragments.FavoritesFragment;
import com.example.carme.parcial2csolano.Fragments.GamesFragment;
import com.example.carme.parcial2csolano.Fragments.GeneralFragment;
import com.example.carme.parcial2csolano.Fragments.ImagesFragment;
import com.example.carme.parcial2csolano.Fragments.NewsFragment;
import com.example.carme.parcial2csolano.Fragments.SettingsFragment;
import com.example.carme.parcial2csolano.Fragments.TopPlayersFragment;
import com.example.carme.parcial2csolano.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        GeneralFragment.OnFragmentInteractionListener, ImagesFragment.OnFragmentInteractionListener,
        TopPlayersFragment.OnFragmentInteractionListener, ContenedorFragment.OnFragmentInteractionListener,
        NewsFragment.OnFragmentInteractionListener{

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar= findViewById(R.id.toolBar);
        //setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close );
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        NavigationView nvDrawer = (NavigationView )findViewById(R.id.nav_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupDrawerContent(nvDrawer);

      /*  DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.open, R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);*/


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("Not Valid Statement")
    @Override
    public boolean onNavigationItemSelected(MenuItem item){

        int id = item.getItemId();
        Fragment myFragment=null;
        boolean selectedFragment = false;
        if (id == R.id.menuNews) {
            myFragment = new NewsFragment();
            selectedFragment=true;
        } else if (id == R.id.menuLol) {
            myFragment= new ContenedorFragment();
            selectedFragment=true;
        } else if (id == R.id.menuDota) {
            myFragment= new ContenedorFragment();
            selectedFragment=true;
        } else if (id == R.id.menuOverwatch) {
            myFragment= new ContenedorFragment();
            selectedFragment=true;
        }else if (id == R.id.menuFavorites) {
            myFragment= new FavoritesFragment();
        }else if (id == R.id.menuSettings) {
            myFragment = new SettingsFragment();
        }

        if(selectedFragment== true){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main, myFragment).commit();

        }

        DrawerLayout drawerLayout= (DrawerLayout)findViewById(R.id.drawerLayout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;

        }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    private void setupDrawerContent(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                onNavigationItemSelected(item);
                return true;
            }
        });
    }

}
