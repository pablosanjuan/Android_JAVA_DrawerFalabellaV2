package com.example.seratic.drawerfalabella.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.seratic.drawerfalabella.Adapters.ListViewAdapter2;
import com.example.seratic.drawerfalabella.R;


public class ResumenConsultas extends Fragment {

    String[] estado = new String[]{
            "Prod: Ahorros",
            "Venta: NO, Motivo A",
            "Venta: NO",
            "Prod: Ahorros",
    };

    String[] descripcion = new String[]{
            "Jose Luis Ceron",
            "Marcela Martinez",
            "David Meneses",
            "Marcela Martinez",
    };

    String[] hora = new String[]{
            "3 min",
            "5 hr",
            "4 oct",
            "23 sep",
    };

    String[] titulo = new String[]{
            "Aprobado",
            "No Encontrado",
            "Denegado",
            "No Encontrado",
    };

    int[] imagenes = {
            R.drawable.ic_verified_user_black_24dp,
            R.drawable.ic_visibility_off_black_24dp,
            R.drawable.ic_warning_black_24dp,
            R.drawable.ic_visibility_off_black_24dp,
    };

    Button aceptar;
    ListViewAdapter2 adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_bandeja_clientes, container, false);

        final ListView lista = (ListView) view.findViewById(R.id.listView1);
        adapter = new ListViewAdapter2(getContext(), titulo, descripcion, estado, hora, imagenes);
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
