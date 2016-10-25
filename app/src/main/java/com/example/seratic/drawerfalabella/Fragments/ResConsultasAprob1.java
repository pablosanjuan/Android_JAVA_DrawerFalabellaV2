package com.example.seratic.drawerfalabella.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.seratic.drawerfalabella.Adapters.ListViewAdapter;
import com.example.seratic.drawerfalabella.R;

import java.util.Calendar;


public class ResConsultasAprob1 extends Fragment implements View.OnClickListener {

    String[] estado = new String[]{
            "Venta: SI, Pord: Ahorros",
            "Venta: SI, Pord: Ahorros",
            "Venta: SI, Pord: Ahorros",
            "Venta: SI, Pord: Ahorros",
            "Venta: SI, Pord: Ahorros",
            "Venta: SI, Pord: Ahorros",
            "Venta: SI, Pord: Ahorros",
            "Venta: SI, Pord: Ahorros",
    };

    String[] descripcion = new String[]{
            "Jose Luis Ceron",
            "Marcela Lopez",
            "Pablo Sanjuan",
            "Fredy Camacho",
            "Claudia Paz",
            "Victor Rivera",
            "Julio Cesar Lopez",
            "Hugo Muñoz",
    };

    String[] titulo = new String[]{
            "Aprobado",
            "Aprobado",
            "Aprobado",
            "Aprobado",
            "Aprobado",
            "Aprobado",
            "Aprobado",
            "Aprobado",
    };

    int[] imagenes = {
            R.drawable.ic_verified_user_black_24dp,
            R.drawable.ic_verified_user_black_24dp,
            R.drawable.ic_verified_user_black_24dp,
            R.drawable.ic_verified_user_black_24dp,
            R.drawable.ic_verified_user_black_24dp,
            R.drawable.ic_verified_user_black_24dp,
            R.drawable.ic_verified_user_black_24dp,
            R.drawable.ic_verified_user_black_24dp,
    };

    Button aceptar;
    ListViewAdapter adapter;
    ImageButton buscar_btn;
    EditText buscar_edt;
    int valor;
    private SharedPreferences prefs;
    private int aprobado;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_bandeja_clientes, container, false);

        prefs = getActivity().getSharedPreferences("aprobado", getContext().MODE_PRIVATE);
        String num_llamdas = "("+prefs.getInt("num_llamdas", 0)+")";

        String[] llamadas = new String[]{
                num_llamdas,
                "(2)",
                "(3)",
                "(1)",
                "(0)",
                "(7)",
                "(0)",
                "(11)",
        };
        int llamada_numero = Integer.parseInt(String.valueOf(prefs.getInt("num_llamdas", 0)));
        if (llamada_numero>0){
            valor = R.drawable.ic_phone_green_24dp;
        }else {
            valor = R.drawable.ic_phone_black_24dp;
        }
        int[] tel = {
                valor,
                R.drawable.ic_phone_black_24dp,
                R.drawable.ic_phone_black_24dp,
                R.drawable.ic_phone_black_24dp,
                R.drawable.ic_phone_black_24dp,
                R.drawable.ic_phone_black_24dp,
                R.drawable.ic_phone_black_24dp,
                R.drawable.ic_phone_black_24dp,
        };

        prefs = getActivity().getSharedPreferences("canto", getContext().MODE_PRIVATE);
        if (prefs.getInt("estado", 0)==1){
            aprobado = R.drawable.ic_check_green_24dp;
        }else {
            aprobado = R.drawable.ic_check_black_24dp;
        }

        int[] chaeck = {
                aprobado,
                R.drawable.ic_check_black_24dp,
                R.drawable.ic_check_black_24dp,
                R.drawable.ic_check_black_24dp,
                R.drawable.ic_check_black_24dp,
                R.drawable.ic_check_black_24dp,
                R.drawable.ic_check_black_24dp,
                R.drawable.ic_check_black_24dp,
        };

        Calendar cal = Calendar.getInstance();

        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH)+1;
        int dayofmonth = cal.get(Calendar.DAY_OF_MONTH);

        String hoy = dayofmonth+"/"+month+"/"+year;


        String[] hora = new String[]{
                hoy+" - 8:30 am",
                hoy+" - 9:55 am",
                hoy+" - 11:00 am",
                hoy+" - 12:11 pm",
                hoy+" - 1:30 pm",
                hoy+" - 2:40 pm",
                hoy+" - 3:12 pm",
                hoy+" - 3:30 pm",
        };


        prefs = getActivity().getSharedPreferences("estado", getContext().MODE_PRIVATE);
        int est = prefs.getInt("estado", 0);

        final ListView lista = (ListView) view.findViewById(R.id.listView1);
        adapter = new ListViewAdapter(getContext(), titulo, descripcion, estado, hora, imagenes, tel, chaeck, llamadas);
        lista.setAdapter(adapter);
        buscar_btn = (ImageButton) view.findViewById(R.id.btnbuscar);
        buscar_btn.setOnClickListener(this);
        buscar_edt = (EditText) view.findViewById(R.id.edt_buscar);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                FragmentManager fragmentManager;
                FragmentTransaction fragmentTransaction;
                switch (i){
                    case 0:
                        fragmentManager = getActivity().getSupportFragmentManager();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        ResConsulHoy resConsulHoy = new ResConsulHoy();
                        fragmentTransaction.replace(R.id.fragment, resConsulHoy);
                        fragmentTransaction.commit();
                        break;
                    default:
                        Toast.makeText(getContext(),"Intenta con otro",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnbuscar:
                String txtbusc = buscar_edt.getText().toString();
                FragmentManager fragmentManager;
                FragmentTransaction fragmentTransaction;
                if (checklogindata(txtbusc) == true) {
                    switch (txtbusc){
                        case "jose":
                            fragmentManager = getActivity().getSupportFragmentManager();
                            fragmentTransaction = fragmentManager.beginTransaction();
                            ResConsulHoy resConsulHoy = new ResConsulHoy();
                            fragmentTransaction.replace(R.id.fragment, resConsulHoy);
                            fragmentTransaction.commit();
                            break;
                        default:
                            Toast.makeText(getContext(),"Intenta con otro",Toast.LENGTH_SHORT).show();
                            break;
                    }
                } else {
                    err();
                }
                break;
        }
    }

    public void err() {
        Toast toast1 = Toast.makeText(getContext(), "Ingrese DNI para realizar una busqueda", Toast.LENGTH_SHORT);
        toast1.show();
    }

    public boolean checklogindata(String buscar) {
        if (buscar.equals("")) {
            return false;
        } else {
            return true;
        }
    }
}
