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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.seratic.drawerfalabella.R;


public class NoEncontrado2 extends Fragment implements View.OnClickListener {

    Button aceptar;
    RadioButton si,no;
    TextView pregunta,estado,nombre,doc;
    EditText telefono;
    private SharedPreferences prefs;
    private ImageButton atras;
    TextView numero_preg;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.una_preg_telefono, container, false);

        numero_preg = (TextView) view.findViewById(R.id.numero_preg);
        aceptar = (Button) view.findViewById(R.id.aceptar_1p_telfono);
        si = (RadioButton) view.findViewById(R.id.rb_si_1p_telefono);
        no = (RadioButton) view.findViewById(R.id.rb_no_1p_telefono);
        telefono = (EditText) view.findViewById(R.id.tvPhone_1p_telefono);
        pregunta = (TextView) view.findViewById(R.id.preg_una_preg_telefono);
        nombre = (TextView) view.findViewById(R.id.tvNombre_1p_tlelfono);
        doc = (TextView) view.findViewById(R.id.tvDocumento_1p_telefono);
        estado = (TextView) view.findViewById(R.id.tvEstado_1p_telefono);
        prefs = getActivity().getSharedPreferences("no_encontrado", getContext().MODE_PRIVATE);
        String nombre_shp = prefs.getString("nombre", "");
        String doc_shpdoc = prefs.getString("dni", "");
        nombre.setText(nombre_shp);
        doc.setText(doc_shpdoc);
        estado.setText("NO ENCONTRADO");
        estado.setTextColor(Color.parseColor("#2196F3"));
        pregunta.setText("Producto?");
        si.setText("Ahorros");
        no.setText("Crédito");
        aceptar.setOnClickListener(this);
        atras = (ImageButton) view.findViewById(R.id.btn_atras);
        atras.setOnClickListener(this);
        numero_preg.setText("2 de 2");
        aceptar.setText("Finalizar");
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
                NoEncontrado1 noEncontrado1= new NoEncontrado1();
                fragmentTransaction.replace(R.id.fragment, noEncontrado1);
                fragmentTransaction.commit();
                break;
            case R.id.aceptar_1p_telfono:
                SharedPreferences preferencias=getActivity().getSharedPreferences("no_encontrado", getContext().MODE_PRIVATE);
                if (si.isChecked()){
                    SharedPreferences.Editor editor=preferencias.edit();
                    editor.putInt("producto", 1);
                    editor.putString("telefono", telefono.getText().toString());
                    editor.commit();

                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    BandejaClientes bandejaClientes= new BandejaClientes();
                    fragmentTransaction.replace(R.id.fragment, bandejaClientes);
                    fragmentTransaction.commit();
                }else if(no.isChecked()){
                    SharedPreferences.Editor editor=preferencias.edit();
                    editor.putInt("producto", 2);
                    editor.putString("telefono", telefono.getText().toString());
                    editor.commit();

                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    BandejaClientes bandejaClientes= new BandejaClientes();
                    fragmentTransaction.replace(R.id.fragment, bandejaClientes);
                    fragmentTransaction.commit();
            }else {
                    Toast.makeText(getContext(),"Debe seleccionar",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.rb_si_1p_telefono:
                numero_preg.setText("1 de 2");
                aceptar.setText("Siguiente");
                break;
            case R.id.rb_no_1p_telefono:
                numero_preg.setText("1 de 2");
                aceptar.setText("Siguiente");
                break;
        }
    }
}
