package com.example.seratic.drawerfalabella.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.seratic.drawerfalabella.Index;
import com.example.seratic.drawerfalabella.Adapters.ListViewAdapter2;
import com.example.seratic.drawerfalabella.R;


public class ResumenConsultas extends Fragment {

    String[] estado = new String[]{
            "No Concretados: 2",
            "Aceptados: 2 - No Aceptados: 2",
            "Crédito: 2",
    };

    String[] descripcion = new String[]{
            "Concretados: 6",
            "Ofrece Prod: 4",
            "Ahorros: 2",
    };

    String[] hora = new String[]{
            "Cant: 8",
            "Cant: 4",
            "Cant: 2",
    };

    String[] titulo = new String[]{
            "VENTAS",
            "DENEGADOS",
            "NO ENCONTRADO",
    };

    int[] imagenes = {
            R.drawable.ic_verified_user_black_24dp,
            R.drawable.ic_visibility_off_black_24dp,
            R.drawable.ic_warning_black_24dp,
    };

    Button aceptar;
    ListViewAdapter2 adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_resumen_consultas, container, false);
        ((Index) getActivity()).getSupportActionBar().setTitle("Resumen de Consultas");

        final ListView lista = (ListView) view.findViewById(R.id.listView1);
        adapter = new ListViewAdapter2(getContext(), titulo, descripcion, estado, hora, imagenes);
        lista.setAdapter(adapter);


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                FragmentManager fragmentManager;
                FragmentTransaction fragmentTransaction;
                switch (i){
                    case 0:
                        fragmentManager = getActivity().getSupportFragmentManager();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        ResConsultasAprob1 resConsultasAprob = new ResConsultasAprob1();
                        fragmentTransaction.replace(R.id.fragment, resConsultasAprob);
                        fragmentTransaction.commit();
                        break;
                }
            }
        });
        return view;
    }
}
