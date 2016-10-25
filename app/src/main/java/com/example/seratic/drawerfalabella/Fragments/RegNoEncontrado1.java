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
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.seratic.drawerfalabella.R;


public class RegNoEncontrado1 extends Fragment implements View.OnClickListener {

    Button aceptar;
    RadioButton si,no,si1,no2;
    TextView pregunta1,pregunta2,estado, nombre, doc,desc;
    EditText tel;
    private SharedPreferences prefs;

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
        pregunta1.setText("Se Ofrece?");
        pregunta2.setText("Producto??");
        si1.setText("Ahorros");
        no2.setText("Crédito");
        nombre.setText("Marcela Martinez");
        doc.setText("16328136");
        estado.setText("NO ENCONTRADO");
        estado.setTextColor(Color.parseColor("#2196F3"));
        aceptar.setOnClickListener(this);

        prefs = getActivity().getSharedPreferences("no_encontrado", getContext().MODE_PRIVATE);
        tel.setText(prefs.getString("telefono", ""));
        int conc = prefs.getInt("ofrece", 0);
        if (conc==1){
            si.setChecked(true);
        }else {
            no.setChecked(true);
        }

        int prod = prefs.getInt("producto", 0);
        if (prod==1){
            si1.setChecked(true);
        }else {
            no2.setChecked(true);
        }

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.aceptar_2p_t:
                FragmentManager fragmentManager;
                FragmentTransaction fragmentTransaction;
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                RegistroLlamadas registroLlamadas= new RegistroLlamadas();
                fragmentTransaction.replace(R.id.fragment, registroLlamadas);
                fragmentTransaction.commit();
        }
    }
}
