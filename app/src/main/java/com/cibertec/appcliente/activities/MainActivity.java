package com.cibertec.appcliente.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//import android.widget.Toolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.cibertec.appcliente.Fragments.CursosFragment;
import com.cibertec.appcliente.Fragments.EventosFragment;
import com.cibertec.appcliente.R;
import com.google.android.material.tabs.TabLayout;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;
import com.cibertec.appcliente.fragments.CursosFragment;
import com.cibertec.appcliente.fragments.EventosFragment;
import com.cibertec.appcliente.fragments.UbicanosFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Toolbar toolbar;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private BottomNavigationView bottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //FRANKLIN JUAREZ
      
        //TOOLBAR
        //Toolbar mainToolBar = findViewById(R.id.toolbarMain);
        //setSupportActionBar(mainToolBar);

        //AÑADIMOS EL PAGER ADAPTER
        SectionsPagerAdapter pageAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        ViewPager pagerContenedor = findViewById(R.id.pagerContenedor);
        pagerContenedor.setAdapter(pageAdapter);

        //ADJUNTAMOS EL VIEWPAGER TO THE TABLAYOUT
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pagerContenedor);
        
      //JOSE RAMIREZ

        toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.evento);

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new EventosFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_eventos);
        }

        //Button Navigation View
        bottomNav = findViewById(R.id.bottom_navigation_main);
        bottomNav.setOnNavigationItemSelectedListener(navBotonListener);
    }
    //onBackPressed() => Metodo para el Menu Navigation view
    public void onBackPressed(){
        if( drawer.isDrawerOpen(GravityCompat.START) ){
            drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_eventos:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new EventosFragment()).commit();
                toolbar.setTitle(R.string.evento);
                break;
            case R.id.nav_cursos:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CursosFragment()).commit();
                toolbar.setTitle(R.string.cursos);
                break;
            case R.id.nav_mapa:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new UbicanosFragment()).commit();
                toolbar.setTitle(R.string.ubicanos);
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    //Creamos el Bottom Navigation Listener:
    private BottomNavigationView.OnNavigationItemSelectedListener navBotonListener=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()){
                        case R.id.btn_nav_eventos:
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                    new EventosFragment()).commit();
                            toolbar.setTitle(R.string.evento);
                            break;
                        case R.id.btn_nav_cursos:
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                    new CursosFragment()).commit();
                            toolbar.setTitle(R.string.cursos);
                            break;
                        case R.id.btn_nav_mapa:
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                    new UbicanosFragment()).commit();
                            toolbar.setTitle(R.string.ubicanos);
                            break;
                    }
                    return true;
                }
            };

    private class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager supportFragmentManager, int behaviorResumeOnlyCurrentFragment) {
            super(supportFragmentManager,behaviorResumeOnlyCurrentFragment);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch ( position ){
                case 0:
                    return new CursosFragment();
                case 1:
                    return new EventosFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return getResources().getText(R.string.cursos_tab);
                case 1:
                    return getResources().getText(R.string.eventos_tab);
            }
            return null;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return false;
        }
    }
}
