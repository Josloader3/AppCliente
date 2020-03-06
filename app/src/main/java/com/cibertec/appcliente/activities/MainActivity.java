package com.cibertec.appcliente.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
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

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }

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
