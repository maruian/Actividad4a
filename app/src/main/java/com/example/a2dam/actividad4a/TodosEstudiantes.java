package com.example.a2dam.actividad4a;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TodosEstudiantes.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TodosEstudiantes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TodosEstudiantes extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // Definim les variables necesaries
    ListView alumnos;
    ArrayAdapter<String> adapterAlumnos;

    private OnFragmentInteractionListener mListener;

    public TodosEstudiantes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EstudiantesPorCiclo.
     */
    // TODO: Rename and change types and number of parameters
    public static TodosEstudiantes newInstance(String param1, String param2) {
        TodosEstudiantes fragment = new TodosEstudiantes();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.estudiantestodos, container, false);

        alumnos = (ListView)v.findViewById(R.id.listaEstudiantes);
        adapterAlumnos = new ArrayAdapter<>(getActivity(), R.layout.listview_alumnes,idAlumnos());
        alumnos.setAdapter(adapterAlumnos);

        return v;
    }

    public String[] idAlumnos(){
        MainActivity.adaptadorBBDD.open();
        ArrayList<Alumno> alAlumnos = MainActivity.adaptadorBBDD.devuelveTablaAlumnos();
        ArrayList<String> strAlumnos = new ArrayList<>();
        Iterator it = alAlumnos.iterator();
        String alumnoStr;
        while (it.hasNext()){
            Alumno a = (Alumno)it.next();
            alumnoStr = "Id: "+a.getId()+" Nombre: "+a.getNombre()+ " Curso: "+a.getCurso()+ " Edad: "+ a.getEdad()+" Nota: "+a.getNota();
            strAlumnos.add(alumnoStr);
        }
        String[] resultado = new String[strAlumnos.size()];
        resultado = strAlumnos.toArray(resultado);
        return resultado;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
