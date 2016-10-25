package com.example.seratic.drawerfalabella.Fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
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


public class ResConsultasAprob3 extends Fragment implements View.OnClickListener {

    ImageButton telefono_btn;
    Button aceptar;
    RadioButton si,no,otro_canto,si_canto,no_canto;
    TextView nombre,doc,estado,num_llamds;
    EditText tlefono;
    private SharedPreferences prefs;
    private int posted_by;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.una_preg_telefono_canto, container, false);

        aceptar = (Button) view.findViewById(R.id.aceptar_1p_telfono_canto);
        si = (RadioButton) view.findViewById(R.id.rb_si_1p_telefono_canto);
        no = (RadioButton) view.findViewById(R.id.rb_no_1p_telefono_canto);
        tlefono = (EditText) view.findViewById(R.id.tvPhone_canto);
        nombre = (TextView) view.findViewById(R.id.tvNombre_1p_tlelfono_canto);
        doc = (TextView) view.findViewById(R.id.tvDocumento_1p_telefono_cnato);
        estado = (TextView) view.findViewById(R.id.tvEstado_1p_telefono_canto);
        num_llamds = (TextView) view.findViewById(R.id.txt_num_llamdas);
        nombre.setText("JOSE LUIS CERÓN");
        doc.setText("001342032");
        estado.setText("APROBADO");
        estado.setTextColor(Color.parseColor("#81c784"));
        telefono_btn = (ImageButton) view.findViewById(R.id.ivPhone_canto);
        telefono_btn.setOnClickListener(this);
        aceptar.setOnClickListener(this);
        prefs = getActivity().getSharedPreferences("aprobado", getContext().MODE_PRIVATE);
        num_llamds.setText("("+prefs.getInt("num_llamdas", 0)+")");
        String tel = prefs.getString("telefono", "");
        tlefono.setText(tel);
        int conc = prefs.getInt("concreto", 0);
        if (conc==1){
            si.setChecked(true);
        }else {
            no.setChecked(true);
        }
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.aceptar_1p_telfono_canto:
                    FragmentManager fragmentManager;
                    FragmentTransaction fragmentTransaction;
                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    ResConsultasAprob4 resConsultasAprob4= new ResConsultasAprob4();
                    fragmentTransaction.replace(R.id.fragment, resConsultasAprob4);
                    fragmentTransaction.commit();
                break;
            case R.id.ivPhone_canto:
                int num = (prefs.getInt("num_llamdas", 0))+1 ;

                SharedPreferences preferencias=getActivity().getSharedPreferences("aprobado", getContext().MODE_PRIVATE);
                SharedPreferences.Editor editor=preferencias.edit();
                editor.putInt("num_llamdas", num);
                editor.commit();

                int a1 = 21323;
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + a1));
                startActivity(intent);
                break;
        }
    }
}
