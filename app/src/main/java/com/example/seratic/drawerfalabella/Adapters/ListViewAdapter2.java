package com.example.seratic.drawerfalabella.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.seratic.drawerfalabella.R;

public class ListViewAdapter2 extends BaseAdapter {
    // Declare Variables
    Context context;
    String[] hora;
    String[] estado;
    String[] descripcion;
    String[] titulos;
    int[] imagenes;
    LayoutInflater inflater;

    public ListViewAdapter2(Context context, String[] titulos, String[] descripcion, String[] estado, String[] hora, int[] imagenes) {
        this.context = context;
        this.hora = hora;
        this.titulos = titulos;
        this.imagenes = imagenes;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    @Override
    public int getCount() {
        return titulos.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        // Declare Variables
        TextView txtTitle,txtDesc,txtEst, txthora;
        ImageView imgImg;

        //http://developer.android.com/intl/es/reference/android/view/LayoutInflater.html
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.list_row2, parent, false);

        // Locate the TextViews in listview_item.xml
        txthora = (TextView) itemView.findViewById(R.id.list_row_hora);
        txtDesc = (TextView) itemView.findViewById(R.id.list_row_description);
        txtEst = (TextView) itemView.findViewById(R.id.list_row_esatdo);
        txtTitle = (TextView) itemView.findViewById(R.id.list_row_title);
        imgImg = (ImageView) itemView.findViewById(R.id.list_row_image);

        // Capture position and set to the TextViews
        txthora.setText(hora[position]);
        txtDesc.setText(descripcion[position]);
        txtEst.setText(estado[position]);
        txtTitle.setText(titulos[position]);
        imgImg.setImageResource(imagenes[position]);

        return itemView;
    }
}