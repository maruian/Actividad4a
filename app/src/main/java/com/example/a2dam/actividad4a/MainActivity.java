package com.example.a2dam.actividad4a;

import android.app.Fragment;
import android.app.FragmentManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment_barra.OnFragmentInteractionListener,
        AltaAlumno.OnFragmentInteractionListener, AltaProfesor.OnFragmentInteractionListener{

    FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public boolean estaFragmentDinamic() {
        Fragment f = (Fragment)getFragmentManager().findFragmentById(R.id.alta_alumno);
        if (f==null)
            return false;
        else
            return true;
    }
}
