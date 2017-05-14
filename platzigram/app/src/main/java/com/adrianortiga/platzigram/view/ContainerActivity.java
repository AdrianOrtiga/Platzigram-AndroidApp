package com.adrianortiga.platzigram.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.adrianortiga.platzigram.LoginActivity;
import com.adrianortiga.platzigram.R;
import com.adrianortiga.platzigram.view.fragments.HomeFragment;
import com.adrianortiga.platzigram.view.fragments.ProfileFragment;
import com.adrianortiga.platzigram.view.fragments.SearchFragment;

public class ContainerActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private int indexItemSelected;
    private String itemSelected;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.home:
                    HomeFragment homeFragment = new HomeFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, homeFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .addToBackStack(null).commit();
                    return true;
                case R.id.search:
                    SearchFragment searchFragment = new SearchFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, searchFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .addToBackStack(null).commit();
                    return true;
                case R.id.profile:
                    ProfileFragment profileFragment = new ProfileFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, profileFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .addToBackStack(null).commit();
                    return true;
            }
            return false;
        }
    };

    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        // Abro el home y lo selecciono
        mOnNavigationItemSelectedListener.onNavigationItemSelected(navigation.getMenu().getItem(1));
        navigation.getMenu().getItem(1).setChecked(true);
        // Creo el listener de la barra de navegación
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void goPictureDetail(View view){
        Intent intent = new Intent(this, PictureDetailActivity.class);
        startActivity(intent);
    }
}
