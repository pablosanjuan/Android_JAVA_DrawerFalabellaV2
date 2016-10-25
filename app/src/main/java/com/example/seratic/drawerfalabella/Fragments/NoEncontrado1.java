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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.seratic.drawerfalabella.R;


public class NoEncontrado1 extends Fragment implements View.OnClickListener {

    Button aceptar;
    RadioButton si,no;
    TextView pregunta,estado, nombre, doc;
    private SharedPreferences prefs;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.edt_una_preg_2rtas, container, false);

        aceptar = (Button) view.findViewById(R.id.aceptar_una_preg);
        si = (RadioButton) view.findViewById(R.id.rb_si_1p_2r);
        no = (RadioButton) view.findViewById(R.id.rb_no_1p_2r);
        pregunta = (TextView) view.findViewById(R.id.preg_una_preg_2r);
        nombre = (TextView) view.findViewById(R.id.tvNombre_1p_2r);
        doc = (TextView) view.findViewById(R.id.tvDocumento_1p_2r);
        estado = (TextView) view.findViewById(R.id.tvEstado_1p_2r);
        prefs = getActivity().getSharedPreferences("dato", getContext().MODE_PRIVATE);
        doc.setText(prefs.getString("dni", ""));
        estado.setText("NO ENCONTRADO");
        estado.setTextColor(Color.parseColor("#2196F3"));
        pregunta.setText("Se Ofrece producto?");
        aceptar.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.aceptar_una_preg:
                SharedPreferences preferencias=getActivity().getSharedPreferences("no_encontrado", getContext().MODE_PRIVATE);
                if (si.isChecked()){
                    SharedPreferences.Editor editor=preferencias.edit();
                    editor.putInt("ofrece", 1);
                    editor.commit();

                    FragmentManager fragmentManager;
                    FragmentTransaction fragmentTransaction;
                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    NoEncontrado2 noEncontrado2 = new NoEncontrado2();
                    fragmentTransaction.replace(R.id.fragment, noEncontrado2);
                    fragmentTransaction.commit();
                }else if(no.isChecked()){
                    SharedPreferences.Editor editor=preferencias.edit();
                    editor.putInt("ofrece", 2);
                    editor.commit();

                    FragmentManager fragmentManager;
                    FragmentTransaction fragmentTransaction;
                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    NoEncontrado3 noEncontrado3= new NoEncontrado3();
                    fragmentTransaction.replace(R.id.fragment, noEncontrado3);
                    fragmentTransaction.commit();
            }else {
                    Toast.makeText(getContext(),"Debe seleccionar",Toast.LENGTH_LONG).show();
                }
        }
    }
}
