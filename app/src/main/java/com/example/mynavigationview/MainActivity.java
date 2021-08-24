package com.example.mynavigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavigationView myMenu = findViewById(R.id.myMenu);

        View header = myMenu.getHeaderView(0);
        TextView date = header.findViewById(R.id.date);

        Calendar calendar = Calendar.getInstance();
        String day = Integer.toString(calendar.get(Calendar.DATE));
        String month = Integer.toString(calendar.get(Calendar.MONTH) + 1);
        String year = Integer.toString(calendar.get(Calendar.YEAR));

        date.setText(day + "/" + month + "/" + year);

        drawerLayout = findViewById(R.id.drawerLayout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigateToFragment(R.id.nav_home);
        myMenu.setCheckedItem(R.id.nav_home);

        NavigationView navigationView = findViewById(R.id.myMenu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                navigateToFragment(id);
                //item.setChecked(true);
                return true;
            }
        });
    }

    private void navigateToFragment(int itemId) {
        Fragment fragment;
        String title;

        switch (itemId) {
            case R.id.nav_home:
                fragment = new Home();
                title = "Home";
                break;

            case R.id.nav_savePasswd:
                fragment = new SavePasswd();
                title = "Guardar contraseña";
                break;

            case R.id.nav_loadPasswd:
                fragment = new LoadPasswd();
                title = "Mostrar contraseña";
                break;
            default:
                fragment = new Home();
                title = "Home";
                break;
        }

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.myFrameLayout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

        setTitle(title);
        drawerLayout.closeDrawer(GravityCompat.START);


    }
}