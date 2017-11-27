package com.example.a2dam.actividad4a;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements Fragment_barra.OnFragmentInteractionListener,
        AltaAlumno.OnFragmentInteractionListener, AltaProfesor.OnFragmentInteractionListener {

    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public boolean estaFragmentDinamic() {
        Fragment f = fm.findFragmentById(R.id.fragment_dinamic);
        if (f == null) {
            return false;
        } else
            return true;
    }

}

