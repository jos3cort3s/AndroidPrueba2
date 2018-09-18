package com.agrotic.sena.www.androidsenasoft2018prueba1.Adaptadores;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.agrotic.sena.www.androidsenasoft2018prueba1.POJOs.PlanaCardViewInforme;
import com.agrotic.sena.www.androidsenasoft2018prueba1.R;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorLista_Informe extends BaseAdapter {

    Context contextAdapter;
    ArrayList<PlanaCardViewInforme> miListaPlana;


    public AdaptadorLista_Informe(Context contextAdapter, ArrayList<PlanaCardViewInforme> miPlana) {
        this.contextAdapter = contextAdapter;
        this.miListaPlana = miPlana;
    }


    @Override
    public int getCount() {
        return miListaPlana.size();
    }

    @Override
    public Object getItem(int position) {
        return miListaPlana.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public static class Holder{
        TextView numCiclos, fecha;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder miHolder =  new Holder();

        if (convertView== null){

            convertView =  View.inflate(contextAdapter, R.layout.view_lista_informes, null);
            miHolder.numCiclos = convertView.findViewById(R.id.tvCiclosInforme);
            miHolder.fecha = convertView.findViewById(R.id.tvFechaInforme);
            convertView.setTag(miHolder);
        }else {
            miHolder = (Holder)convertView.getTag();
        }
        miHolder.numCiclos.setText(miListaPlana.get(position).getCiclos());
        miHolder.fecha.setText(miListaPlana.get(position).getFecha());
        return convertView;
    }
}
