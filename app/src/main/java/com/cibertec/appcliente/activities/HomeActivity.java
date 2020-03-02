package com.cibertec.appcliente.activities;

import android.content.Context;
import android.os.Bundle;

import com.cibertec.appcliente.R;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class HomeActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tabLayout = findViewById(R.id.tabLayout_id);
        viewPager = findViewById(R.id.viewPager_id);
        adapter = new ViewPagerAdapter(this, getSupportFragmentManager());

        //Agregar Fragment aqui
        adapter.AddFragment(new FragmentCursos());
        adapter.AddFragment(new FragmentEventos());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);



    }
}
