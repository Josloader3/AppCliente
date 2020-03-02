package com.cibertec.appcliente.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cibertec.appcliente.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentCursos extends Fragment {

    View v;

    public FragmentCursos() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v  = inflater.inflate(R.layout.cursos_fragment, container,false);
        return v;
    }
}
