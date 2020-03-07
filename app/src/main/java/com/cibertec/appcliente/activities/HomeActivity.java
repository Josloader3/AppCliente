package com.cibertec.appcliente.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.cibertec.appcliente.R;
import com.cibertec.appcliente.adapter.ViewPagerAdapter;
import com.cibertec.appcliente.fragment.FragmentCursos;
import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity {


    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tabLayout = findViewById(R.id.tabLayout_id);
        viewPager = findViewById(R.id.viewPager_id);
        adapter = new ViewPagerAdapter(this, getSupportFragmentManager());

        //Agregar Fragment aqui
        adapter.AddFragment(new FragmentCursos());
        //adapter.AddFragment(new FragmentEventos());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


    }


}
