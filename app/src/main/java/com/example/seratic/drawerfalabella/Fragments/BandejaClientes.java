package com.example.seratic.drawerfalabella.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.seratic.drawerfalabella.Adapters.ListViewAdapter;
import com.example.seratic.drawerfalabella.R;


public class BandejaClientes extends Fragment {

    String[] estado = new String[]{
            "Mensaje 1 ...",
            "Mensaje 2 ...",
            "Mensaje 3 ...",
            "Mensaje 4 ...",
    };

    String[] descripcion = new String[]{
            "Remitente del Mensaje 1",
            "Remitente del Mensaje 2",
            "Remitente del Mensaje 3",
            "Remitente del Mensaje 4",
    };

    String[] hora = new String[]{
            "8 min",
            "2 hr",
            "1 oct",
            "20 sep",
    };

    String[] titulo = new String[]{
            "Titulo Mesnaje 1",
            "Titulo Mesnaje 2",
            "Titulo Mesnaje 3",
            "Titulo Mesnaje 4",
    };

    int[] imagenes = {
            R.drawable.ic_star_border_black_18dp,
            R.drawable.ic_star_border_black_18dp,
            R.drawable.ic_star_border_black_18dp,
            R.drawable.ic_star_border_black_18dp,
    };

    Fragment fragment;
    ListViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_bandeja_clientes, container, false);

        final ListView lista = (ListView) view.findViewById(R.id.listView1);
        adapter = new ListViewAdapter(getContext(), titulo, descripcion, estado, hora, imagenes);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                Toast.makeText(getContext(), "presiono " + i, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
