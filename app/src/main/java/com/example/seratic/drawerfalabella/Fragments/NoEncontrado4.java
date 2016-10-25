package com.example.seratic.drawerfalabella.Fragments;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.seratic.drawerfalabella.R;


public class NoEncontrado4 extends Fragment implements View.OnClickListener {

    Button aceptar;
    TextView nombre,doc,estado;
    private EditText edt_descripcion;
    private SharedPreferences prefs;
    private ImageButton atras;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.solo_descripcion, container, false);

        aceptar = (Button) view.findViewById(R.id.aceptar_solo_descripcion);
        aceptar.setOnClickListener(this);
        nombre = (TextView) view.findViewById(R.id.tvNombre_descripcion);
        doc = (TextView) view.findViewById(R.id.tvDocumento_descripcion);
        estado = (TextView) view.findViewById(R.id.tvEstado_descripcion);
        edt_descripcion = (EditText) view.findViewById(R.id.edt_descripcion);
        prefs = getActivity().getSharedPreferences("no_encontrado", getContext().MODE_PRIVATE);
        String nombre_shp = prefs.getString("nombre", "");
        String doc_shpdoc = prefs.getString("dni", "");
        nombre.setText(nombre_shp);
        doc.setText(doc_shpdoc);
        estado.setText("NO ENCONTRADO");
        estado.setTextColor(Color.parseColor("#2196F3"));
        atras = (ImageButton) view.findViewById(R.id.btn_atras);
        atras.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        switch (view.getId()){
            case R.id.btn_atras:
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                NoEncontrado3 noEncontrado3= new NoEncontrado3();
                fragmentTransaction.replace(R.id.fragment, noEncontrado3);
                fragmentTransaction.commit();
                break;
            case R.id.aceptar_solo_descripcion:
                SharedPreferences preferencias=getActivity().getSharedPreferences("no_encontrado", getContext().MODE_PRIVATE);
                SharedPreferences.Editor editor=preferencias.edit();
                editor.putString("descripcion", edt_descripcion.getText().toString());
                editor.commit();

                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                BandejaClientes bandejaClientes = new BandejaClientes();
                fragmentTransaction.replace(R.id.fragment, bandejaClientes);
                fragmentTransaction.commit();
                break;
        }
    }
}
