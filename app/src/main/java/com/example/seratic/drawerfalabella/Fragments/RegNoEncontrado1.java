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

import com.example.seratic.drawerfalabella.R;


public class RegNoEncontrado1 extends Fragment implements View.OnClickListener {

    Button aceptar;
    RadioButton si,no,si1,no2;
    TextView pregunta1,pregunta2,estado, nombre, doc,desc;
    EditText tel;
    private SharedPreferences prefs;
    private ImageButton atras;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.dos_preg_telefono, container, false);

        aceptar = (Button) view.findViewById(R.id.aceptar_2p_t);
        nombre = (TextView) view.findViewById(R.id.tvNombre_1p_tlelfono_canto);
        doc = (TextView) view.findViewById(R.id.tvDocumento_1p_telefono_cnato);
        estado = (TextView) view.findViewById(R.id.tvEstado_1p_telefono_canto);
        pregunta1 = (TextView) view.findViewById(R.id.preg_una_2p_t);
        pregunta2 = (TextView) view.findViewById(R.id.preg_dos_2p_t);
        tel = (EditText) view.findViewById(R.id.txt_2p_telefono);
        si = (RadioButton) view.findViewById(R.id.rb_si_1p_2p_t);
        no = (RadioButton) view.findViewById(R.id.rb_no_1p_2p_t);
        si1 = (RadioButton) view.findViewById(R.id.rb_si_2p_2p_t);
        no2 = (RadioButton) view.findViewById(R.id.rb_no_2p_2p_t);
        pregunta1.setText("Se Ofrece producto?");
        pregunta2.setText("Producto??");
        si1.setText("Ahorros");
        no2.setText("Crédito");
        prefs = getActivity().getSharedPreferences("no_encontrado", getContext().MODE_PRIVATE);
        String nombre_shp = prefs.getString("nombre", "");
        String doc_shpdoc = prefs.getString("dni", "");
        nombre.setText(nombre_shp);
        doc.setText(doc_shpdoc);
        estado.setText("NO ENCONTRADO");
        estado.setTextColor(Color.parseColor("#2196F3"));
        aceptar.setOnClickListener(this);
        atras = (ImageButton) view.findViewById(R.id.btn_atras);
        atras.setOnClickListener(this);

        prefs = getActivity().getSharedPreferences("no_encontrado", getContext().MODE_PRIVATE);
        tel.setText(prefs.getString("telefono", ""));
        int conc = prefs.getInt("ofrece", 0);
        if (conc==1){
            si.setChecked(true);
        }else if (conc==2){
            no.setChecked(true);
        }else {
            si.setChecked(false);
            no.setChecked(false);
        }

        int prod = prefs.getInt("producto", 0);
        if (prod==1){
            si1.setChecked(true);
        }else if (prod==2){
            no2.setChecked(true);
        }else {
            si1.setChecked(false);
            no2.setChecked(false);
        }

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
                RegistroLlamadas registroLlamadas1= new RegistroLlamadas();
                fragmentTransaction.replace(R.id.fragment, registroLlamadas1);
                fragmentTransaction.commit();
                break;
            case R.id.aceptar_2p_t:
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                RegistroLlamadas registroLlamadas= new RegistroLlamadas();
                fragmentTransaction.replace(R.id.fragment, registroLlamadas);
                fragmentTransaction.commit();
        }
    }
}
